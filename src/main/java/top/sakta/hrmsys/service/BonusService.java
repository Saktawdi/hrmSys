package top.sakta.hrmsys.service;

import top.sakta.hrmsys.domain.Bonus;

import java.util.List;

public interface BonusService {

    int insertBonus(Bonus bonus);

    int updateBonus(Bonus bonus);

    List<Bonus> getAllBonuses();
}
