package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sakta.hrmsys.domain.ScheduledSended;
import top.sakta.hrmsys.service.impl.ScheduledSendedServiceImpl;

import java.util.List;

@RestController
@Tag(name = "固定任务接口模块")
@RequestMapping("/api/v1/sended")
public class ScheduledSendedController {

    @Autowired
    private ScheduledSendedServiceImpl scheduledSendedService;

    @SaCheckPermission("bonus.get")
    @Operation(summary = "获取所有定时任务执行记录", description = "无参数")
    @GetMapping("/all")
    public SaResult getAllScheduledSendeds() {
        List<ScheduledSended> allScheduledSendeds = scheduledSendedService.getAllScheduledSendeds();
        return SaResult.ok().setData(allScheduledSendeds);
    }

}
