package top.sakta.hrmsys.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName Bonus
 * @Description 奖金实体类
 * @Author Quescc
 * @Date 2023年12月23日
 * @Version 1.0
 */

@Data
@ToString
@Schema(name = "Bonus",description = "奖金实体类")
public class Bonus {
    @Schema(description = "奖金数目编号")
    private Integer bID;

    @Schema(description = "奖励奖金")
    private double bReward;

    @Schema(description = "应扣奖金")
    private double bReduce;

    @Schema(description = "档案编号eID")
    private String eID;
}
