package com.vidin.inventory.card;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    private final CardRepository repository;

    CardController(CardRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/Cards")
    List<Card> all() {
        return repository.findAll();
    }

    @PostMapping("/Cards")
    Card newCard(@RequestBody Card newCard) {
        return repository.save(newCard);
    }

    // Single item

    @GetMapping("/Cards/{id}")
    Card one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CardNotFoundException(id));
    }

    @PutMapping("/Cards/{id}")
    Card replaceCard(@RequestBody Card newCard, @PathVariable Long id) {

        return repository.findById(id)
                .map(Card -> {
                    Card.setName(newCard.getName());
                    Card.setCompany(newCard.getCompany());
                    return repository.save(Card);
                })
                .orElseGet(() -> {
                    newCard.setId(id);
                    return repository.save(newCard);
                });
    }

    @DeleteMapping("/Cards/{id}")
    void deleteCard(@PathVariable Long id) {
        repository.deleteById(id);
    }
}