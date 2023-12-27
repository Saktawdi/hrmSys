package top.sakta.hrmsys.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.sakta.hrmsys.domain.Payroll;
import top.sakta.hrmsys.domain.ScheduledSended;
import top.sakta.hrmsys.service.PayrollService;
import top.sakta.hrmsys.service.ScheduledSendedService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@EnableScheduling
public class ScheduledTask {
    private boolean dayFlag = false;
    private boolean weekFlag = false;
    private boolean monthFlag = false;
    private boolean testFlag = false;

    @Autowired
    private ScheduledSendedService scheduledSendedService;

    @Autowired
    private PayrollService payrollService;

    @Scheduled(cron = "0/10 * * * * ?")
    public void testExecute(){
        if(testFlag){
            List<Payroll> payrolls = payrollService.getPayrollsByStatus(0);
            Date date = new Date();
            if(!payrolls.isEmpty()){
                for(Payroll payroll:payrolls){
                    ScheduledSended scheduledSended = scheduledSendedService.getScheduledSendedByID(payroll.getPID());
                    if(scheduledSended == null){
                        scheduledSended = new ScheduledSended();
                        scheduledSended.setPID(payroll.getPID());
                        scheduledSended.setLastExecutionTime(date);
                        scheduledSendedService.insertScheduledSended(scheduledSended);
                    }else {
                        scheduledSendedService.updateScheduledSended(scheduledSended);
                    }
                    payrollService.updatePayrollStatus(payroll.getPID(),1);
                }
            }
        }
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void dayExecute(){
        if(dayFlag){
            List<Payroll> payrolls = payrollService.getPayrollsByStatus(0);
            Date date = new Date();
            if(!payrolls.isEmpty()){
                for(Payroll payroll:payrolls){
                    ScheduledSended scheduledSended = scheduledSendedService.getScheduledSendedByID(payroll.getPID());
                    if(scheduledSended == null){
                        scheduledSended = new ScheduledSended();
                        scheduledSended.setPID(payroll.getPID());
                        scheduledSended.setLastExecutionTime(date);
                        scheduledSendedService.insertScheduledSended(scheduledSended);
                    }else {
                        scheduledSendedService.updateScheduledSended(scheduledSended);
                    }
                    payrollService.updatePayrollStatus(payroll.getPID(),1);
                }
            }
        }
    }

    @Scheduled(cron = "0 0 0 ? * MON")
    public void weekExecute(){
        if(weekFlag) {
            List<Payroll> payrolls = payrollService.getPayrollsByStatus(0);
            Date date = new Date();
            if (!payrolls.isEmpty()) {
                for (Payroll payroll : payrolls) {
                    ScheduledSended scheduledSended = scheduledSendedService.getScheduledSendedByID(payroll.getPID());
                    if (scheduledSended == null) {
                        scheduledSended = new ScheduledSended();
                        scheduledSended.setPID(payroll.getPID());
                        scheduledSended.setLastExecutionTime(date);
                        scheduledSendedService.insertScheduledSended(scheduledSended);
                    } else {
                        scheduledSendedService.updateScheduledSended(scheduledSended);
                    }
                    payrollService.updatePayrollStatus(payroll.getPID(), 1);
                }
            }
        }
    }

    @Scheduled(cron = "0 0 0 1 * ?")
    public void monthExecute(){
        if(monthFlag) {
            List<Payroll> payrolls = payrollService.getPayrollsByStatus(0);
            Date date = new Date();
            if (!payrolls.isEmpty()) {
                for (Payroll payroll : payrolls) {
                    ScheduledSended scheduledSended = scheduledSendedService.getScheduledSendedByID(payroll.getPID());
                    if (scheduledSended == null) {
                        scheduledSended = new ScheduledSended();
                        scheduledSended.setPID(payroll.getPID());
                        scheduledSended.setLastExecutionTime(date);
                        scheduledSendedService.insertScheduledSended(scheduledSended);
                    } else {
                        scheduledSendedService.updateScheduledSended(scheduledSended);
                    }
                    payrollService.updatePayrollStatus(payroll.getPID(), 1);
                }
            }
        }
    }

    public void dayStart(){
        this.dayFlag = true;
    }

    public void dayStop(){
        this.dayFlag = false;
    }

    public void weekStart(){
        this.weekFlag = true;
    }

    public void weekStop(){
        this.weekFlag = false;
    }

    public void monthStart(){
        this.monthFlag = true;
    }

    public void monthStop(){
        this.monthFlag = false;
    }

    public void testStart(){
        this.testFlag = true;
    }

    public void testStop(){
        this.testFlag = false;
    }

    public Map<String,Boolean> getAll(){
        Map<String,Boolean> booleans = new HashMap<>();
        booleans.put("testFlag",testFlag);
        booleans.put("dayFlag",dayFlag);
        booleans.put("weekFlag",weekFlag);
        booleans.put("monthFlag",monthFlag);
        return booleans;
    }
}
