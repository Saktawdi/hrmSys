package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.Employee;
import top.sakta.hrmsys.domain.Institution;

import top.sakta.hrmsys.service.EmployeeService;
import top.sakta.hrmsys.service.InstitutionService;

import java.util.List;

/**
 * 机构控制器
 * @author  Quescc
 * @version 0.0.1
 * @date 2023年12月23日
 */

@RestController
@RequestMapping("/api/v1/institution")
@Tag(name = "机构接口模块")
public class InstitutionController {

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private EmployeeService employeeService;

    @SaCheckPermission("institution.all")
    @Operation(summary = "获取机构列表接口", description = "无参数")
    @GetMapping("/getAll")
    public SaResult getAllInstitutions() {
        List<Institution> institutions = institutionService.getAllInstitutions();
        return SaResult.ok("获取成功").setData(institutions);
    }

    @SaCheckPermission("institution.get")
    @Operation(summary = "根据机构编号获取详细信息接口", description = "根据机构编号iID获取机构，参数为iID")
    @GetMapping("/get/{iID}")
    public SaResult getInstitution(@PathVariable String iID) {
        Institution institution = institutionService.getInstitutionByID(iID);
        if(institution == null) return SaResult.error("机构不存在");
        return SaResult.ok("获取成功").setData(institution);
    }

    @SaCheckPermission("institution.add")
    @Operation(summary = "新增机构接口", description = "json数据，看机构实体类，全属性必须")
    @PostMapping("/add")
    public SaResult addInstitution(@Validated @RequestBody Institution institution) {
        if(institutionService.getInstitutionByID(institution.getIID()) != null) {
            return SaResult.error("机构已存在");
        }
        institutionService.insertInstitution(institution);
        return SaResult.ok("添加成功");
    }

    @SaCheckPermission("institution.update")
    @Operation(summary = "修改机构接口", description = "json数据，看机构实体类，全属性必须")
    @PutMapping("/update")
    public SaResult updateInstitution(@Validated @RequestBody Institution institution) {
        if(institutionService.getInstitutionByID(institution.getIID()) == null){
            return SaResult.error("修改失败，查无此机构");
        }
        institutionService.updateInstitution(institution);
        return SaResult.ok("修改成功");
    }

    @SaCheckPermission("institution.delete")
    @Operation(summary = "删除机构接口", description = "根据机构编号iID删除机构，参数为iID")
    @DeleteMapping("/delete/{iID}")
    public SaResult deleteInstitution(@PathVariable String iID){
        Institution institution = institutionService.getInstitutionByID(iID);
        if(institution == null){
            return SaResult.error("删除失败，查无此机构");
        }
        if(!institutionService.getInstitutionsByParent(institution.getIID()).isEmpty()){
            return SaResult.error("删除失败，该机构有下级部门");
        }
        List<Employee> employees = employeeService.getEmployeesByInstitution(institution.getIID());
        if(!employees.isEmpty()){
            if(institution.getILevel() == 3){
                for(Employee employee:employees){
                    employeeService.updateEmployeeInstitutions(employee.getEID(),null,null,"N/A");
                }
            }else if(institution.getILevel() == 2){
                for(Employee employee:employees) {
                    employeeService.updateEmployeeInstitutions(employee.getEID(), null, "N/A", null);
                }
            }else if(institution.getILevel() == 1){
                    for(Employee employee:employees){
                        employeeService.updateEmployeeInstitutions(employee.getEID(),"N/A",null,null);
                    }
            }
        }
        institutionService.deleteInstitution(iID);
        return SaResult.ok("删除成功");
    }

    @SaCheckPermission("institution.get")
    @Operation(summary = "根据iLevel等级获取详细信息接口", description = "根据level等级获取机构，参数为iLevel")
    @GetMapping("/getByLevel/{iLevel}")
    public SaResult getInstitutionByLevel(@PathVariable Integer iLevel) {
        List<Institution> institutions = institutionService.getInstitutionsByLevel(iLevel);
        return SaResult.ok("获取成功").setData(institutions);
    }

    @SaCheckPermission("institution.get")
    @Operation(summary = "根据iLevel等级和iParent父类ID获取详细信息接口", description = "根据iLevel等级和iParent父类ID获取机构，参数为iLevel,iParent")
    @GetMapping("/getByLevelAndParent/{iLevel}/{iParent}")
    public SaResult getInstitutionByLevelAndParent(@PathVariable Integer iLevel,@PathVariable String iParent) {
        List<Institution> institutions = institutionService.getInstitutionsByLevelAndParent(iLevel,iParent);
        return SaResult.ok("获取成功").setData(institutions);
    }

    @SaCheckPermission("institution.get")
    @Operation(summary = "根据根据iParent父类ID获取详细信息接口", description = "根据iParent父类ID获取机构，参数为iParent")
    @GetMapping("/getByParent/{iParent}")
    public SaResult getInstitutionByiParent(@PathVariable String iParent) {
        List<Institution> institutions = institutionService.getInstitutionsByParent(iParent);
        return SaResult.ok("获取成功").setData(institutions);
    }

    @SaCheckPermission("institution.get")
    @Operation(summary = "根据机构编号iID判断是否为父类接口", description = "根据机构编号iID判断是否为父类接口，参数为iID")
    @GetMapping("/isParent/{iID}")
    public SaResult isParent(@PathVariable String iID) {
        List<Institution> institutions = institutionService.getInstitutionsByParent(iID);
        if(institutions.isEmpty()) return SaResult.ok("目标ID不为父类").setData(false);
        return SaResult.ok("目标ID为父类").setData(true);
    }
}
