package com.vidin.inventory.card;

class CardNotFoundException extends RuntimeException {

    CardNotFoundException(Long id) {
        super("Could not find card " + id);
    }
}