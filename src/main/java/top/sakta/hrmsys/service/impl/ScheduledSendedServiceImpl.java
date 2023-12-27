package top.sakta.hrmsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakta.hrmsys.domain.ScheduledSended;
import top.sakta.hrmsys.mapper.ScheduledSendedMapper;
import top.sakta.hrmsys.service.ScheduledSendedService;

import java.util.List;

@Service
public class ScheduledSendedServiceImpl implements ScheduledSendedService {

    @Autowired
    private ScheduledSendedMapper scheduledSendedMapper;

    @Override
    public ScheduledSended getScheduledSendedByID(Integer pID) {
        return scheduledSendedMapper.getScheduledSendedByID(pID);
    }

    @Override
    public int insertScheduledSended(ScheduledSended scheduledSended) {
        return scheduledSendedMapper.insertScheduledSended(scheduledSended);
    }

    @Override
    public int updateScheduledSended(ScheduledSended scheduledSended) {
        return scheduledSendedMapper.updateScheduledSended(scheduledSended);
    }

    @Override
    public List<ScheduledSended> getAllScheduledSendeds() {
        return scheduledSendedMapper.getAllScheduledSendeds();
    }
}
