package top.sakta.hrmsys.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Schema(name = "Payslip",description = "工资单实体类")
public class Payslip {
    @Schema(description = "档案编号eID")
    private String eID;

    @Schema(description = "档案编号eID")
    private String eName;

    @Schema(description = "交通补助")
    private double sTransport;

    @Schema(description = "午餐补助")
    private double sLunch;

    @Schema(description = "通讯补助")
    private double sCommunicate;

    @Schema(description = "养老保险")
    private double sPension;

    @Schema(description = "医疗保险")
    private double sMedical;

    @Schema(description = "失业保险")
    private double sUnemployment;

    @Schema(description = "住房公积金")
    private double sHouse;

    @Schema(description = "奖励奖金")
    private double bReward;

    @Schema(description = "应扣奖金")
    private double bReduce;
}
