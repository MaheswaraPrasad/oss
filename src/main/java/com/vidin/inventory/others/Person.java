package com.vidin.inventory.others;

import org.springframework.ui.context.Theme;

public class Person {
    private String name;
    private String lastName;

    public synchronized String getName() {
        return name;
    }
    
    public synchronized Person clone(Person p) {
        p.setName(this.name);
        p.setLastName(this.lastName);
        System.out.println("cloned");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " " + this.getLastName());
        return p;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized String getLastName() {
        return lastName;
    }

    public synchronized void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
