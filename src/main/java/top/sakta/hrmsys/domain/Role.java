package top.sakta.hrmsys.domain;


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
public class Role {
    private Integer rID;
    private String rCode;
    private String rName;
}
