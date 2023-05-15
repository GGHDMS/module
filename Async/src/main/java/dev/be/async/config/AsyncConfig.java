package dev.be.async.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync // async 를 사용할 수 있게 해줌
public class AsyncConfig {
}
