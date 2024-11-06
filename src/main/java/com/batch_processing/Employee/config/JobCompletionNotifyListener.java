package com.batch_processing.Employee.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotifyListener implements JobExecutionListener {

    private Logger logger = LoggerFactory.getLogger(JobCompletionNotifyListener.class);
    @Override
    public void beforeJob(JobExecution jobExecution) {
        JobExecutionListener.super.beforeJob(jobExecution);
        logger.info("Before job execution");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        JobExecutionListener.super.afterJob(jobExecution);
        if(jobExecution.getStatus()== BatchStatus.COMPLETED){
            logger.info("Job execution completed");
        }
    }
}
