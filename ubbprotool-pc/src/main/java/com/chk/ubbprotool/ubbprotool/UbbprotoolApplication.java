package com.chk.ubbprotool.ubbprotool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableJpaRepositories("com.chk.ubbprotool.ubbprotool.Repository")
@EntityScan("com.chk.ubbprotool.ubbprotool.Model.*")
public class UbbprotoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(UbbprotoolApplication.class, args);
    }

}
