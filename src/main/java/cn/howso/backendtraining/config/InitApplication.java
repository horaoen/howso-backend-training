package cn.howso.backendtraining.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Slf4j
@Component
public class InitApplication implements CommandLineRunner {
    @Value("${server.port}")
    private String port;
    
    @Value("${springdoc.swagger-ui.path}")
    private String swaggerPath;

    @Override
    @SuppressWarnings("all")
    public void run(String... args) throws Exception {
        String ip = InetAddress.getLocalHost().getHostAddress();
        log.info("=========================================================");
        log.info("local：http://localhost:{}", port);
        log.info("external：http://{}:{}", ip, port);
        log.info("swagger：http://localhost:{}{}", port, swaggerPath);
        log.info("=========================================================");
    }
}
