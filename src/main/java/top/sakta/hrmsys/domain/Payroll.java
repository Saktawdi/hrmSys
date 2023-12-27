package top.sakta.hrmsys.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName Menu
 * @Description 薪酬发放单实体类
 * @Author Quescc
 * @Date 2023年12月27日
 * @Version 1.0
 */

@Data
@ToString
@Schema(name = "Payroll",description = "薪酬发放单实体类")
public class Payroll {
    @Schema(description = "薪酬发放单编号")
    private Integer pID;

    @Schema(description = "三级机构编号")
    private String pL3InstID;

    @Schema(description = "一级机构名称")
    private String pL1InstName;

    @Schema(description = "二级机构名称")
    private String pL2InstName;

    @Schema(description = "三级机构名称")
    private String pL3InstName;

    @Schema(description = "人数")
    private int pCount;

    @Schema(description = "基本薪资总额")
    private double pSalarySum;

    @Schema(description = "薪酬发放单状态")
    private int pStatus;

    @Schema(description = "登记人")
    private String pMaker;

    @Schema(description = "工资单，json数据")
    private String pPayslips;
}
