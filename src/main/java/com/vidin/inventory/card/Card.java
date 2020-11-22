package com.vidin.inventory.card;

import com.vidin.inventory.node.Node;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Card {

    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String company;

    @ManyToOne
    private Node node;

    public Card() {}

    public Card(String name, String company, Node node) {
        this.name = name;
        this.company = company;
        this.node = node;
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

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) &&
                Objects.equals(name, card.name) &&
                Objects.equals(company, card.company) &&
                Objects.equals(node, card.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, company, node);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", node=" + node +
                '}';
    }
}

