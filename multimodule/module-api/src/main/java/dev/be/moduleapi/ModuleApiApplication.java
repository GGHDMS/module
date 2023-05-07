package dev.be.moduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = {"dev.be.moduleapi", "dev.be.modulecommon"}
)
@EntityScan("dev.be.modulecommon.domain") // entity 를 어디서 찾을지
@EnableJpaRepositories(basePackages = {"dev.be.modulecommon.repository"}) // 레포지토리를 어디서 찾을지
public class ModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApiApplication.class, args);
    }

}
