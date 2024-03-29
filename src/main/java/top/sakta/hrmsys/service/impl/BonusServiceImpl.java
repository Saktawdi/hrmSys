package top.sakta.hrmsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakta.hrmsys.domain.Bonus;
import top.sakta.hrmsys.mapper.BonusMapper;
import top.sakta.hrmsys.service.BonusService;

import java.util.List;

@Service
public class BonusServiceImpl implements BonusService {

    @Autowired
    private BonusMapper bonusMapper;

    @Override
    public int insertBonus(Bonus bonus) {
        return bonusMapper.insertBonus(bonus);
    }

    @Override
    public int updateBonus(Bonus bonus) {
        return bonusMapper.updateBonus(bonus);
    }

    @Override
    public List<Bonus> getAllBonuses() {
        return bonusMapper.getAllBonuses();
    }
}
