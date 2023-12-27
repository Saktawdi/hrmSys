package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.Bonus;
import top.sakta.hrmsys.service.BonusService;

import java.util.List;

@RequestMapping("/api/v1/bonus")
@RestController
@Tag(name = "奖金接口模块")
public class BonusController {
    @Autowired
    private BonusService bonusService;

    @SaCheckPermission("bonus.update")
    @Operation(summary = "根据奖金列表更新奖金接口", description = "json数据，奖金实体列表，看奖金实体类，bID参数可无")
    @PutMapping("/update")
    public SaResult updateBonuses(@Validated @RequestBody List<Bonus> bonuses){
        if(bonuses == null){
            return SaResult.error("登记失败，奖金列表为空");
        }
        for(Bonus bonus:bonuses){
            bonusService.updateBonus(bonus);
        }
        return SaResult.ok("登记成功");
    }

    @SaCheckPermission("bonus.update")
    @Operation(summary = "更新奖金接口", description = "json数据，看奖金实体类，bID参数可无")
    @PutMapping("/updateBonus")
    public SaResult updateBonus(@Validated @RequestBody Bonus bonus){
        if(bonus == null){
            return SaResult.error("登记失败，奖金实体为空");
        }
        bonusService.updateBonus(bonus);
        return SaResult.ok("登记成功");
    }

    @GetMapping("/get")
    public SaResult getAll(){
        List<Bonus> bonuses = bonusService.getAllBonuses();
        return SaResult.ok("登记成功").setData(bonuses);
    }
}
