package com.vidin.inventory.others;

public class LearnThread {
    public static void main(String[] args) throws InterruptedException {
        Worker w = new Worker();
//        for (int i=0;i<3;i++) {
//            Thread wt = new Thread(w);
//            wt.start();
//        }
        Thread wt = new Thread(w);
        wt.start();
        Thread.sleep(1000);
        w.stopCouter();
    }
}
