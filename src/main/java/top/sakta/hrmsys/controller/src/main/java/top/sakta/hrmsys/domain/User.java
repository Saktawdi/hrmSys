package top.sakta.hrmsys.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author sakta
 * @Date 2023年12月21日
 * @Version 1.0
 */

@Data
@ToString
@Schema(name = "User",description = "用户实体类")
public class User {

    @Schema(description = "用户工号")
    private String uID;

    @Schema(description = "用户名称")
    private String uName;

    @Schema(description = "用户密码")
    private String uPassword;
}
