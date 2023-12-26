package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.*;
import top.sakta.hrmsys.domain.Position;

import java.util.List;

/**
 * Mapper 职位Mapper
 * @author Quescc
 * @version 1.0
 * @data 2023年12月23日
 */

@Mapper
public interface PositionMapper {
    @Select("SELECT * FROM position WHERE pID = #{pID}")
    Position getPositionByID(Integer pID);

    @Select("SELECT * FROM position")
    List<Position> getAllPositions();

    @Insert("INSERT INTO position (pID, pName, pCategory) VALUES (#{pID}, #{pName}, #{pCategory})")
    int insertPosition(Position position);

    @Update("UPDATE position SET pName=#{pName},pCategory=#{pCategory} WHERE pID=#{pID}")
    int updatePosition(Position position);

    @Delete("DELETE FROM position WHERE pID=#{pID}")
    int deletePosition(Integer pID);

    @Select("SELECT * FROM position WHERE pCategory = #{pCategory}")
    List<Position> getPositionByCategory(String pCategory);
}
