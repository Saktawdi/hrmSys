package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.Salary;
import top.sakta.hrmsys.domain.User;
import top.sakta.hrmsys.mapper.SalaryMapper;
import top.sakta.hrmsys.service.SalaryService;
import top.sakta.hrmsys.service.UserService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 薪资标准控制器
 * @author  Quescc
 * @version 0.0.1
 * @date 2023年12月23日
 */

@RestController
@RequestMapping("/api/v1/salary")
@Tag(name = "薪资标准接口模块")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private UserService userService;

    @SaCheckPermission("salary.all")
    @Operation(summary = "获取薪资标准列表接口", description = "无参数")
    @GetMapping("/getAll")
    public SaResult getAllSalaries() {
        List<Salary> salarys = salaryService.getAllSalaries();
        return SaResult.ok("获取成功").setData(salarys);
    }

    @SaCheckPermission("salary.get")
    @Operation(summary = "根据薪资标准编号获取详细信息接口", description = "根据薪资标准编号sID获取薪资标准，参数为sID")
    @GetMapping("/get/{sID}")
    public SaResult getSalary(@PathVariable Integer sID) {
        Salary salary = salaryService.getSalaryByID(sID);
        if(salary == null) return SaResult.error("薪资标准不存在");
        return SaResult.ok("获取成功").setData(salary);
    }

    @SaCheckPermission("salary.add")
    @Operation(summary = "新增薪资标准接口", description = "json数据，看薪资标准实体类，sID、sPension、sMedical、sUnemployment、sHouse、sStatus、sOpinion可无，sName、sRecorder、sMaker必须有")
    @PostMapping("/add")
    public SaResult addSalary(@Validated @RequestBody Salary salary) {
        if(salary.getSName() == null || salary.getSName().equals("") || salary.getSRecorder() == null || salary.getSRecorder().equals("") || salary.getSMaker() == null || salary.getSMaker().equals("")){
            return SaResult.error("添加失败：标准名称、制定人和登记人不能为空");
        }
        salary.setSID(null);
        salary.setSPension(salary.getSBasic() * 0.08);
        salary.setSMedical(salary.getSBasic() * 0.02 + 3);
        salary.setSUnemployment(salary.getSBasic() * 0.005);
        salary.setSHouse(salary.getSBasic() * 0.08);
        salary.setSRecordDate(new Date());
        salary.setSStatus(0);
        salary.setSOpinion(null);
        salary.setSChecker(null);
        salaryService.insertSalary(salary);
        return SaResult.ok("添加成功");
    }

    @SaCheckPermission("salary.update")
    @Operation(summary = "修改薪资标准接口", description = "json数据，看薪资标准实体类，sStatus可无")
    @PutMapping("/update")
    public SaResult updateSalary(@Validated @RequestBody Salary salary) {
        if(salaryService.getSalaryByID(salary.getSID()) == null){
            return SaResult.error("修改失败，查无此薪资标准");
        }
        salary.setSStatus(0);
        salary.setSOpinion(null);
        salary.setSChecker(null);
        salaryService.updateSalary(salary);
        return SaResult.ok("修改成功");
    }

    @SaCheckPermission("salary.approved")
    @Operation(summary = "薪资标准审核接口", description = "json数据，看薪资标准实体类，sStatus可无")
    @PutMapping("/approved")
    public SaResult approvedSalary(@Validated @RequestBody Salary salary) {
        Salary getSalary = salaryService.getSalaryByID(salary.getSID());
        if(getSalary == null){
            return SaResult.error("审核失败，查无此薪资标准");
        }
        salary.setSChecker(StpUtil.getLoginIdAsString());
        salary.setSStatus(1);
        salaryService.updateSalary(salary);
        return SaResult.ok("审核成功");
    }

    @SaCheckPermission("salary.approved")
    @Operation(summary = "根据薪资标准编号审核接口", description = "json数据，看薪资标准实体类，参数为sID")
    @PutMapping("/approvedByID/{sID}")
    public SaResult approvedSalaryByID(@PathVariable Integer sID) {
        if(salaryService.getSalaryByID(sID) == null){
            return SaResult.error("审核失败，查无此薪资标准");
        }
        salaryService.updateSalaryStatus(sID,1,StpUtil.getLoginIdAsString());
        return SaResult.ok("审核成功");
    }

    @SaCheckPermission("salary.delete")
    @Operation(summary = "删除薪资标准接口", description = "根据薪资标准编号sID删除薪资标准，参数为sID")
    @DeleteMapping("/delete/{sID}")
    public SaResult deleteSalary(@PathVariable Integer sID){
        if(salaryService.getSalaryByID(sID) == null){
            return SaResult.error("删除失败，查无此薪资标准");
        }
        salaryService.deleteSalary(sID);
        return SaResult.ok("删除成功");
    }

    @SaCheckPermission("salary.get")
    @Operation(summary = "根据薪酬状态获取薪资标准列表接口", description = "根据薪资薪酬状态sStatus获取薪资标准，参数为sStatus")
    @GetMapping("/getByStatus/{sStatus}")
    public SaResult getAllSalaries(@PathVariable int sStatus) {
        List<Salary> salaries = salaryService.getSalaryByStatus(sStatus);
        return SaResult.ok("获取成功").setData(salaries);
    }

    @SaCheckPermission("salary.get")
    @Operation(summary = "根据多个查询条件获取薪资标准列表接口", description = "根据多个条件获取薪资标准，参数为ID、KeyWord、StartRecodDate、EndRecodDate")
    @GetMapping("/getByConditions")
    public SaResult getSalariesByConditions(@RequestBody Map<String,Object> body) throws ParseException {
        Integer ID = (Integer) body.get("ID");
        String KeyWord = (String) body.get("KeyWord");
        List<User> users = null;
        if(KeyWord != null && KeyWord != ""){
           users = userService.getUserByName(KeyWord);
        }
        Date StartRecodDate = null;
        Date EndRecodDate = null;
        if(body.get("StartRecodDate") != null){
            StartRecodDate = DateUtils.parseDate((String) body.get("StartRecodDate"),"yyyy-MM-dd");
        }
        if(body.get("EndRecodDate") != null){
            EndRecodDate = DateUtils.parseDate((String) body.get("EndRecodDate"),"yyyy-MM-dd");
        }
        List<Salary> salaries = salaryService.getSalariesByConditions(ID,KeyWord,null,StartRecodDate,EndRecodDate);
        if(users != null) {
            for (User user : users) {
                List<Salary> newSalaries = salaryService.getSalariesByConditions(ID, null, user.getUID(), StartRecodDate, EndRecodDate);
                if (newSalaries != null) {
                    salaries.addAll(newSalaries);
                }
            }
        }
        salaries = salaries.stream().distinct().collect(Collectors.toList());
        return SaResult.ok("查询成功").setData(salaries);
    }

}
