package com.shsxt.crm.task.schedule;

import com.shsxt.crm.task.service.SystemJudgeCustomerLossTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 系统自动判定流失客户
 */
@Component
public class SystemJudgeCustomerLossTaskSchedule {

    @Autowired
    private  SystemJudgeCustomerLossTaskService systemJudgeCustomerLossTaskService;

    @Scheduled(cron = "0 0 0 1/7 * ?")
    public  void systemJudgeCustomerjobTask () {
        systemJudgeCustomerLossTaskService.SystemJudgeCustomerLossHasOrder();
    }

}
