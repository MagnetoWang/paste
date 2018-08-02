package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * @program: paste
 * @description: 启动类
 * @author: MagnetoWang
 * @create: 2018-08-02 14:50
 **/
@SpringBootApplication
@EnableSpringConfigured
public class ApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationTest.class, args);
    }
}
