package org.evobyte.fullstackproject.subject;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SubjectConfig {
    @Bean
    CommandLineRunner commandLineRunner(SubjectRepository subjectRepository){
        return args -> {
            Subject math = new Subject(1L, "Mathematics", "Andrei Aleonte", 100L,
                    "written", new ArrayList<>());

            subjectRepository.saveAll(List.of(math));
        };

    }
}

