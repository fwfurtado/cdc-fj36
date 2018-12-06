package br.com.caelum.author;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AuthorBoot {

    public static void main(String[] args) {
        SpringApplication.run(AuthorBoot.class, args);
    }
}
