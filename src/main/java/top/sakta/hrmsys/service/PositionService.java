package top.sakta.hrmsys.service;

import top.sakta.hrmsys.domain.Position;

import java.util.List;

/**
 * Mapper 职位Service
 * @author Quescc
 * @version 1.0
 * @data 2023年12月23日
 */

public interface PositionService {
    Position getPositionByID(Integer pID);

    List<Position> getAllPositions();

    int insertPosition(Position position);

    int updatePosition(Position position);

    int deletePosition(Integer ID);
}
