package br.com.caelum.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class BookBoot {
    public static void main(String[] args) {
        SpringApplication.run(BookBoot.class, args);
    }
}
