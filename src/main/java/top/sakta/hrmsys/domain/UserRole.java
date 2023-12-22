package top.sakta.hrmsys.domain;


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
public class UserRole {
    private Integer id;
    private String uID;
    private Integer rID;
}
