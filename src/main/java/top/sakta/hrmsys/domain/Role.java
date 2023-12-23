package top.sakta.hrmsys.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName Role
 * @Description 角色实体类
 * @Author sakta
 * @Date 2023年12月21日
 * @Version 1.0
 */

@Data
@ToString
@Schema(name = "Role",description = "角色实体类")
public class Role {
    @Schema(name = "rID",description = "角色ID")
    private Integer rID;
    @Schema(name = "rCode",description = "角色代码")
    private String rCode;
    @Schema(name = "rName",description = "角色名称")
    private String rName;
}
