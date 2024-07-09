package com.jly.start;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.boot.CommandLineRunner;
import java.net.InetAddress;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;


//@EnableFeignClients(basePackages = {"com.jly.start.feign"})
//@EnableDiscoveryClient
//@ConfigurationPropertiesScan
//@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
//@ComponentScan(basePackages = {"com.jly.start.xx","com.jly.start.xx"})
//@MapperScan(basePackages = {"com.jly.infrastructure.dao"})
@SpringBootApplication
@Slf4j
public class RunnerAppBoostrap {

    public static void main(String[] args) {
        SpringApplication.run(RunnerAppBoostrap.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            Environment env = context.getEnvironment();
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            log.info("spring.application.hostAddress => {}", hostAddress);
            log.info("spring.application.name => {}", env.getProperty("spring.application.name"));
            log.info("server.port => {}", env.getProperty("server.port"));
            log.info("spring.datasource.url => {}", env.getProperty("spring.datasource.url"));
            log.info("logging.path => {}", env.getProperty("logging.path"));
            log.info("spring.redission.address => {}", env.getProperty("spring.redisson.address"));
        };
    }
}
