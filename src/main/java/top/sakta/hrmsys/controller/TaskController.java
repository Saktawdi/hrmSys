package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sakta.hrmsys.task.ScheduledTask;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/task")
@Tag(name = "固定任务接口模块")
public class TaskController {

    @Autowired
    private ScheduledTask scheduledTask;

    @SaCheckPermission("bonus.update")
    @Operation(summary = "开启每日定时任务接口", description = "无参数")
    @PutMapping("/dayStart")
    public SaResult dayStart(){
        scheduledTask.dayStart();
        return SaResult.ok("每日定时任务开启成功");
    }

    @SaCheckPermission("bonus.update")
    @Operation(summary = "关闭每日定时任务接口", description = "无参数")
    @PutMapping("/dayStop")
    public SaResult dayStop(){
        scheduledTask.dayStop();
        return SaResult.ok("每日定时任务关闭成功");
    }

    @SaCheckPermission("bonus.update")
    @Operation(summary = "开启每周定时任务接口", description = "无参数")
    @PutMapping("/weekStart")
    public SaResult weekStart(){
        scheduledTask.weekStart();
        return SaResult.ok("每周定时任务开启成功");
    }

    @SaCheckPermission("bonus.update")
    @Operation(summary = "关闭每周定时任务接口", description = "无参数")
    @PutMapping("/weekStop")
    public SaResult weekStop(){
        scheduledTask.weekStop();
        return SaResult.ok("每周定时任务关闭成功");
    }

    @SaCheckPermission("bonus.update")
    @Operation(summary = "开启每月定时任务接口", description = "无参数")
    @PutMapping("/monthStart")
    public SaResult monthStart(){
        scheduledTask.monthStart();
        return SaResult.ok("每月定时任务开启成功");
    }

    @SaCheckPermission("bonus.update")
    @Operation(summary = "开启每月定时任务接口", description = "无参数")
    @PutMapping("/monthStop")
    public SaResult monthStop(){
        scheduledTask.monthStop();
        return SaResult.ok("每月定时任务关闭成功");
    }

    @SaCheckPermission("bonus.get")
    @Operation(summary = "获取固定任务开关状态接口", description = "无参数")
    @GetMapping("/getAll")
    public SaResult getAll(){
        Map<String,Boolean> booleans = scheduledTask.getAll();
        return SaResult.ok("获取固定任务开关状态成功").setData(booleans);
    }
}
