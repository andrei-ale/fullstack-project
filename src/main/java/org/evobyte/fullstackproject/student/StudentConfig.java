package org.evobyte.fullstackproject.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student andrei = new Student(1L, "Andrei Aleonte", "183xxxxx", "andrei@gmail.com",
                    "27021983", "Constanta", new ArrayList<>());
            Student vlad = new Student ( 1L, "Vlad Ionescu", "188xxxxx", "vlad@gmail.com",
                    "28031988", "Oradea", new ArrayList<>());

            repository.saveAll(List.of(andrei, vlad));
        };

    }
}
