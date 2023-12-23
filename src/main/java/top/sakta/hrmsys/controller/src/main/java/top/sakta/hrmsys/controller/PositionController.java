package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.Position;
import top.sakta.hrmsys.service.PositionService;

import java.util.List;

/**
 * 职能控制器
 * @author  Quescc
 * @version 0.0.1
 * @date 2023年12月23日
 */

@RestController
@RequestMapping("/api/v1/position")
@Tag(name = "职位接口模块")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @SaCheckPermission("position.list")
    @Operation(summary = "获取职位列表接口", description = "json数据，看职位实体类")
    @GetMapping("/list")
    public SaResult list() {
        List<Position> positions = positionService.getAllPositions();
        return SaResult.ok("获取成功").setData(positions);
    }

    @SaCheckPermission("position.query")
    @Operation(summary = "根据职位编号获取详细信息接口", description = "json数据，接收整型数据")
    @GetMapping("/{pID}")
    public SaResult getInfo(@PathVariable int pID) {
        Position position = positionService.getPositionByID(pID);
        if(position == null) {
            return SaResult.error("职位不存在");
        }
        return SaResult.ok("获取成功").setData(position);
    }

    @SaCheckPermission("position.add")
    @Operation(summary = "新增职位接口", description = "json数据，看职位实体类，uID可无")
    @PostMapping
    public SaResult add(@Validated @RequestBody Position position) {
        if(positionService.getPositionByID(position.getPID()) != null) {
            return SaResult.error("职位已存在");
        }
        positionService.insertPosition(position);
        return SaResult.ok("添加成功");
    }

    @SaCheckPermission("position.edit")
    @Operation(summary = "修改部门接口", description = "json数据，看职位实体类，全属性必须")
    @PutMapping
    public SaResult edit(@Validated @RequestBody Position position) {
        if(positionService.getPositionByID(position.getPID()) == null){
            return SaResult.error("修改失败，查无此职位");
        }
        positionService.updatePosition(position);
        return SaResult.ok("修改成功");
    }

    @SaCheckPermission("position.remove")
    @Operation(summary = "删除部门接口", description = "json数据，接收整型数据")
    @DeleteMapping("/{pID}")
    public SaResult remove(@PathVariable int pID){
        if(positionService.getPositionByID(pID) == null){
            return SaResult.error("删除失败，查无此职位");
        }
        positionService.deletePosition(pID);
        return SaResult.ok("删除成功");
    }
}