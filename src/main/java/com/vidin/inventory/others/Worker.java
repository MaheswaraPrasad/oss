package com.vidin.inventory.others;

public class Worker implements Runnable {

    boolean flag = true;
    int counter = 0;

    @Override
    public void run() {
        while(flag){
            System.out.println(counter);
            counter++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stopCouter(){
        flag = false;
    }
}
