package Weather.demo.service;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class ThreadConfiguration {
    @Bean(name = "taskExecutor")
    public Executor ThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(5);
        threadPool.setMaxPoolSize(30);
        threadPool.setQueueCapacity(25);
        threadPool.setThreadNamePrefix("AsyncTaskThread");
        threadPool.initialize();
        return threadPool;
}

    
}
