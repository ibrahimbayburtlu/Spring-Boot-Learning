package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//  It is a class-level annotation.
//  The class annotated with @Configuration used by Spring Containers as a source of bean definitions.
@Configuration
public class StudentConfig {
//  It is a method-level annotation. It is an alternative of XML <bean> tag.
//  It tells the method to produce a bean to be managed by Spring Container.

    // Beanler resuable(yeniden kullanılabilir) yazılım bileşinidir.
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000,Month.JANUARY,5)
            );
            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004,Month.JANUARY,5)
            );

            repository.saveAll(
                    List.of(mariam,alex)
            );
        };
    }
}
