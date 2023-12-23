package top.sakta.hrmsys.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName Institution
 * @Description 机构实体类
 * @Author Quescc
 * @Date 2023年12月23日
 * @Version 1.0
 */

@Data
@ToString
@Schema(name = "Institution",description = "机构实体类")
public class Institution {
    @Schema(description = "机构编号")
    private String iID;

    @Schema(description = "机构名")
    private String iName;

    @Schema(description = "机构等级")
    private String iLevel;

    @Schema(description = "上级机构编号")
    private String iParent;

}
