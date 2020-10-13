package com.vidin.inventory;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {

    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String company;

    public Card() {}

    public Card(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCompany() {
        return this.company;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String role) {
        this.company = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Card))
            return false;
        Card Card = (Card) o;
        return Objects.equals(this.id, Card.id) && Objects.equals(this.name, Card.name)
                && Objects.equals(this.company, Card.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.company);
    }

    @Override
    public String toString() {
        return "Card{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.company + '\'' + '}';
    }
}

