package com.vidin.inventory.others;

public class DeadLock {
    Object key1 = new Object();
    Object key2 = new Object();

    public void getA(){
        synchronized (key1){
            System.out.println("Inside a"+ Thread.currentThread().getName());
            getB();
        }
    }
    public void getB(){
        synchronized (key2){
            System.out.println("Inside b"+ Thread.currentThread().getName());
            getC();
        }
    }
    public void getC(){
        synchronized (key1){
            System.out.println("Inside c"+ Thread.currentThread().getName());
        }
    }
}
