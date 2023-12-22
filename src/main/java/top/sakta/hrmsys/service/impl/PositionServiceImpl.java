package top.sakta.hrmsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakta.hrmsys.domain.Position;
import top.sakta.hrmsys.mapper.PositionMapper;
import top.sakta.hrmsys.service.PositionService;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public Position getPositionByID(Integer pID) {
        return positionMapper.getPositionByID(pID);
    }

    @Override
    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    @Override
    public int insertPosition(Position position) {
        return positionMapper.insertPosition(position);
    }

    @Override
    public int updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }

    @Override
    public int deletePosition(Integer ID) {
        return positionMapper.deletePosition(ID);
    }
}
