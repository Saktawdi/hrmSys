package top.sakta.hrmsys.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName Menu
 * @Description 菜单实体类
 * @Author sakta
 * @Date 2023年12月22日
 * @Version 1.0
 */

@Data
@ToString
@Schema(name = "Menu",description = "菜单实体类")
public class Menu {
    @Schema(description = "菜单id")
    private Integer id;
    @Schema(description = "父菜单id")
    private Integer parentId;
    @Schema(description = "菜单编号")
    private String mCode;
    @Schema(description = "菜单名称")
    private String mName;
    @Schema(description = "菜单排序")
    private int sort;
}
