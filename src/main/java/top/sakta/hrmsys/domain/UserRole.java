package top.sakta.hrmsys.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName UserRole
 * @Description 用户角色实体类
 * @Author sakta
 * @Date 2023年12月21日
 * @Version 1.0
 */

@Data
@ToString
@Schema(name = "UserRole",description = "用户角色实体类")
public class UserRole {
    @Schema(name = "id",description = "行id")
    private Integer id;
    @Schema(name = "uID",description = "用户id")
    private String uID;
    @Schema(name = "rID",description = "角色id")
    private Integer rID;
}
