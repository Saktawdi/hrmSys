package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.sakta.hrmsys.domain.Bonus;

public interface BonusMapper {
    @Select("SELECT * FROM bonus WHERE eID = #{eID}")
    Bonus getBonusByUID(String eID);

    @Insert("INSERT INTO bonus (bID,bReward,bReduce,eID) VALUES (#{bID},#{bReward},#{bReduce},#{eID})")
    int insertBonus(Bonus bonus);

    @Update("UPDATE bonus SET bReward = #{bReward}, bReduce = #{bReduce} WHERE eID = {eID}")
    int updateBonusByUID(Bonus bonus);
}
