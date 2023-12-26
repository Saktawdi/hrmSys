package top.sakta.hrmsys.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName Salary
 * @Description 薪资标准实体类
 * @Author Quescc
 * @Date 2023年12月23日
 * @Version 1.0
 */

@Data
@ToString
@Schema(name = "Salary",description = "薪资标准实体类")
public class Salary {
    @Schema(description = "标准编号")
    private Integer sID;

    @Schema(description = "标准名")
    private String sName;

    @Schema(description = "基本工资")
    private double sBasic;

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

    @Schema(description = "记录人")
    private String sRecorder;

    @Schema(description = "记录时间")
    private Date sRecordDate;

    @Schema(description = "制定人")
    private String sMaker;

    @Schema(description = "审核人")
    private String sChecker;

    @Schema(description = "标准状态")
    private int sStatus;

    @Schema(description = "复核意见")
    private String sOpinion;
}
