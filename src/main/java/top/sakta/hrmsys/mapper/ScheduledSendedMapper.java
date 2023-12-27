package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.sakta.hrmsys.domain.ScheduledSended;

import java.util.List;

@Mapper
public interface ScheduledSendedMapper {
    @Select("SELECT * FROM scheduled_sended WHERE pID = #{ID}")
    ScheduledSended getScheduledSendedByID(Integer pID);

    @Insert("INSERT INTO scheduled_sended (pID,lastExecutionTime) VALUES (#{pID},#{lastExecutionTime})")
    int insertScheduledSended(ScheduledSended scheduledSended);

    @Update("UPDATE scheduled_sended SET lastExecutionTime = #{lastExecutionTime} WHERE pID = #{pID}")
    int updateScheduledSended(ScheduledSended scheduledSended);

    @Select("SELECT * FROM scheduled_sended")
    List<ScheduledSended> getAllScheduledSendeds();
}
