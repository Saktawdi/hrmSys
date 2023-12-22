package top.sakta.hrmsys.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName MenuRole
 * @Description 菜单角色实体类
 * @Author sakta
 * @Date 2023年12月22日
 * @Version 1.0
 */

@Data
@ToString
public class MenuRole {
    private Integer id;
    private Integer mId;
    private Integer rId;
}
