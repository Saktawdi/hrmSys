package top.sakta.hrmsys.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName Employee
 * @Description 档案实体类
 * @Author Quescc
 * @Date 2023年12月23日
 * @Version 1.0
 */

@Data
@ToString
@Schema(name = "Employee",description = "档案实体类")
public class Employee {
    @Schema(description = "档案编号")
    private String eID;

    @Schema(description = "一级机构")
    private String eL1InstID;

    @Schema(description = "二级机构")
    private String eL2InstID;

    @Schema(description = "三级机构")
    private String eL3InstID;

    @Schema(description = "职位分类")
    private String ePositionCategory;

    @Schema(description = "职位名称")
    private String ePositionName;

    @Schema(description = "职称名称")
    private String eJobTitle;

    @Schema(description = "姓名")
    private String eName;

    @Schema(description = "性别")
    private String eGender;

    @Schema(description = "年龄")
    private Integer eAge;

    @Schema(description = "邮箱")
    private String eEmail;

    @Schema(description = "固定电话")
    private String eFixedPhone;

    @Schema(description = "手机号码")
    private String eCellPhone;

    @Schema(description = "QQ")
    private String eQQ;

    @Schema(description = "地址")
    private String eAddress;

    @Schema(description = "邮编")
    private String ePostcode;

    @Schema(description = "生日")
    private String eBirthday;

    @Schema(description = "出生地")
    private String eBirthplace;

    @Schema(description = "头像")
    private String eAvatar;

    @Schema(description = "身份证号码")
    private String eIDcard;

    @Schema(description = "社会保障号码")
    private String eSSC;

    @Schema(description = "国家")
    private String eCountry;

    @Schema(description = "民族")
    private String eEthnic;

    @Schema(description = "宗教信仰")
    private String eReligion;

    @Schema(description = "政治面貌")
    private String ePolitical;

    @Schema(description = "学历")
    private String eEducation;

    @Schema(description = "学历专业")
    private String eMajor;

    @Schema(description = "薪酬标准编号")
    private String eSalary;

    @Schema(description = "开户银行")
    private String eBankName;

    @Schema(description = "银行账号")
    private String eBankAccount;

    @Schema(description = "爱好")
    private String eHobby;

    @Schema(description = "特长")
    private String eSpecicalty;

    @Schema(description = "简历")
    private String eResume;

    @Schema(description = "家庭关系")
    private String eFamily;

    @Schema(description = "备注")
    private String eRemarks;

    @Schema(description = "登记人")
    private String eRecoders;

    @Schema(description = "登记时间")
    private Date eRecodDate;

    @Schema(description = "档案状态")
    private int eStatus;

}
