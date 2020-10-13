package com.vidin.inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CardRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Card("HWIC-1VDSL", "Cisco")));
            log.info("Preloading " + repository.save(new Card("VDSLPlus", "Zte")));
        };
    }
}
