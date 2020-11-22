package com.vidin.inventory;

import com.vidin.inventory.card.Card;
import com.vidin.inventory.card.CardRepository;
import com.vidin.inventory.node.Node;
import com.vidin.inventory.node.NodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CardRepository cardRepository, NodeRepository nodeRepository) {

        return args -> {
            Node node1 = nodeRepository.save(new Node("CiscoRouter", "Intel Core i9", "16"));
            Node node2 = nodeRepository.save(new Node("ZteDSLAM", "Intel Core i7", "8"));
            log.info("Preloading " + node1);
            log.info("Preloading " + node2);
            log.info("Preloading " + cardRepository.save(new Card("HWIC-1VDSL", "Cisco", node1)));
            log.info("Preloading " + cardRepository.save(new Card("VDSLPlus", "Zte", node2)));
        };
    }

}
