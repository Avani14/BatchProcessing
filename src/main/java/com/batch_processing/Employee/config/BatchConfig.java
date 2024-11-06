package com.batch_processing.Employee.config;


import com.batch_processing.Employee.model.Employee;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
@Profile(value = "production")
public class BatchConfig {

    @Bean
    public Job jobBean(JobRepository jobRepository, JobCompletionNotifyListener listener, Step steps){

        return new JobBuilder("EmployeeJob",jobRepository)
                .listener(listener)
                .start(steps)
                .build();

        //lister will execute will execute after or before the job
    }

    @Bean
    public Step getSteps(JobRepository jobRepository, PlatformTransactionManager transactionManager
                         , ItemReader<Employee> reader
                        , ItemProcessor<Employee,Employee> processor,
                         ItemWriter<Employee> writer){
        return new StepBuilder("Steps",jobRepository)
                .<Employee,Employee>chunk(100,transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

    }

    @Bean
    public FlatFileItemReader<Employee> reader(){
        return new FlatFileItemReaderBuilder<Employee>()
                .name("readerBuilder")
                .resource(new ClassPathResource("employees.csv"))
                .linesToSkip(1)
                .delimited()
                .names("FirstName","Gender","Salary","Bonus%","SeniorManagement","Team","Id")
                .fieldSetMapper(new EmployeeFieldSetMapper())
                .targetType(Employee.class)
                .build()
                ;
    }

    @Bean
    public ItemProcessor<Employee,Employee> employeeProcessor(){
        return new CustomEmployeeProcessor();
    }

    @Bean
    public ItemWriter<Employee> employeeItemWriter(EntityManagerFactory entityManagerFactory) {
        return new JpaItemWriterBuilder<Employee>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }


}
