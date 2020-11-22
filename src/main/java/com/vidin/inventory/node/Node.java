package com.vidin.inventory.node;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Node {

    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private String cpuType;
    private String ramMemory;

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpuType='" + cpuType + '\'' +
                ", ramMemory='" + ramMemory + '\'' +
                '}';
    }

    public Node(String name, String cpuType, String ramMemory) {
        this.cpuType = cpuType;
        this.name = name;
        this.ramMemory = ramMemory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public String getRamMemory() {
        return ramMemory;
    }

    public void setRamMemory(String ramMemory) {
        this.ramMemory = ramMemory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(id, node.id) &&
                Objects.equals(name, node.name) &&
                Objects.equals(cpuType, node.cpuType) &&
                Objects.equals(ramMemory, node.ramMemory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpuType, ramMemory);
    }
}
