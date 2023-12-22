package top.sakta.hrmsys.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName Position
 * @Description 职位实体类
 * @Author Quescc
 * @Date 2023年12月23日
 * @Version 1.0
 */

@Data
@ToString
@Schema(name = "Position",description = "职位实体类")
public class Position {
    @Schema(description = "职位编号")
    private Integer pID;

    @Schema(description = "职位名")
    private String pName;

    @Schema(description = "职位分类")
    private String pCategory;

}
