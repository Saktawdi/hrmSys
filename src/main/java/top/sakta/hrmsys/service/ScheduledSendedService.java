package top.sakta.hrmsys.service;


import top.sakta.hrmsys.domain.ScheduledSended;

import java.util.List;

public interface ScheduledSendedService {
    ScheduledSended getScheduledSendedByID(Integer pID);

    int insertScheduledSended(ScheduledSended scheduledSended);

    int updateScheduledSended(ScheduledSended scheduledSended);

    List<ScheduledSended> getAllScheduledSendeds();
}
