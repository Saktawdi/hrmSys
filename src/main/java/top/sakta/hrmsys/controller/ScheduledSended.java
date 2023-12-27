package top.sakta.hrmsys.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@Schema(name = "User",description = "工资条执行实体类")
public class ScheduledSended {
    @Schema(description = "工资条编号")
    private Integer pID;

    @Schema(description = "最近一次执行时间，记录定时任务的最后执行时间")
    private Date lastExecutionTime;
}
