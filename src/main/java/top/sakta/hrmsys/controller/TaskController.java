package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.task.ScheduledTask;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/task")
@Tag(name = "固定任务接口模块")
public class TaskController {

    @Autowired
    private ScheduledTask scheduledTask;

    @SaCheckPermission("bonus.update")
    @Operation(summary = "根据名称启动固定任务接口", description = "参数为key")
    @PutMapping("/start/{key}")
    public SaResult startTask(@PathVariable String key){
        if(key.equals("testFlag")){
            scheduledTask.testStart();
        }else if(key.equals("dayFlag")){
            scheduledTask.dayStart();
        }else if(key.equals("weekFlag")){
            scheduledTask.weekStart();
        }else if(key.equals("monthFlag")){
            scheduledTask.monthStart();
        }else{
            return SaResult.error("启动失败");
        }
        return SaResult.ok("启动成功");
    }

    @SaCheckPermission("bonus.update")
    @Operation(summary = "根据名称关闭固定任务接口", description = "参数为key")
    @PutMapping("/stop/{key}")
    public SaResult stopTask(@PathVariable String key){
        if(key.equals("testFlag")){
            scheduledTask.testStop();
        }else if(key.equals("dayFlag")){
            scheduledTask.dayStop();
        }else if(key.equals("weekFlag")){
            scheduledTask.weekStop();
        }else if(key.equals("monthFlag")){
            scheduledTask.monthStop();
        }else{
            return SaResult.error("关闭失败");
        }
        return SaResult.ok("关闭成功");
    }

    @SaCheckPermission("bonus.get")
    @Operation(summary = "获取固定任务开关状态接口", description = "无参数")
    @GetMapping("/getAll")
    public SaResult getAll(){
        Map<String,Boolean> booleans = scheduledTask.getAll();
        return SaResult.ok("获取固定任务开关状态成功").setData(booleans);
    }
}
