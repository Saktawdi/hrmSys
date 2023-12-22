package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.Institution;

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
public class InstitutionController {

    @Autowired
    private InstitutionService institutionService;

    @SaCheckPermission("position.list")
    @Operation(summary = "获取机构列表接口", description = "json数据，看机构实体类")
    @GetMapping("/list")
    public SaResult list() {
        List<Institution> institutions = institutionService.getAllInstitutions();
        return SaResult.ok("获取成功").setData(institutions);
    }

    @SaCheckPermission("position.query")
    @Operation(summary = "根据机构编号获取详细信息接口", description = "json数据，接收字符串数据")
    @GetMapping("/{iID}")
    public SaResult getInfo(@PathVariable String iID) {
        Institution institution = institutionService.getInstitutionByID(iID);
        if(institution == null) return SaResult.error("机构不存在");
        return SaResult.ok("获取成功").setData(institution);
    }

    @SaCheckPermission("position.add")
    @Operation(summary = "新增机构接口", description = "json数据，看机构实体类，全属性必须")
    @PostMapping
    public SaResult add(@Validated @RequestBody Institution institution) {
        if(institutionService.getInstitutionByID(institution.getIID()) != null) {
            return SaResult.error("机构已存在");
        }
        institutionService.insertInstitution(institution);
        return SaResult.ok("添加成功");
    }

    @SaCheckPermission("position.edit")
    @Operation(summary = "修改机构接口", description = "json数据，看机构实体类，全属性必须")
    @PutMapping
    public SaResult edit(@Validated @RequestBody Institution institution) {
        if(institutionService.getInstitutionByID(institution.getIID()) == null){
            return SaResult.error("修改失败，查无此机构");
        }
        institutionService.updateInstitution(institution);
        return SaResult.ok("修改成功");
    }

    @SaCheckPermission("position.remove")
    @Operation(summary = "删除机构接口", description = "json数据，接收字符串数据")
    @DeleteMapping("/{iID}")
    public SaResult remove(@PathVariable String iID){
        if(institutionService.getInstitutionByID(iID) == null){
            return SaResult.error("删除失败，查无此机构");
        }
        institutionService.deleteInstitution(iID);
        return SaResult.ok("删除成功");
    }
}
