package cn.howso.backendtraining;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.howso.backendtraining.mapper")
public class HowsoBackendTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HowsoBackendTrainingApplication.class, args);
    }

}
