package com.vidin.inventory.others;

public class LearnThread {

    public static void main(String[] args) throws InterruptedException {
        DeadLock dl = new DeadLock();
        Runnable r1 = () -> dl.getA();
        Runnable r2 = () -> dl.getB();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(100);
        t1.interrupt();

//        t1.join();
//        t2.join();
    }



//    public static void main(String[] args) throws InterruptedException {
//        Worker w = new Worker();
////        for (int i=0;i<3;i++) {
////            Thread wt = new Thread(w);
////            wt.start();
////        }
//        Thread wt = new Thread(w);
//        wt.start();
//        Thread.sleep(1000);
//        w.stopCouter();
//    }
//    public static void main(String[] args) {
//        Person p = new Person();
//        p.setName("Maheswara");
//        p.setLastName("Vidin");
//        Runnable r = () -> {
//            Person p2 = new Person();
//            System.out.println(p.clone(p2));
//        };
//        Thread t = new Thread(r);
//        t.start();
//        Thread t2 = new Thread(r);
//        t2.start();
//        Thread t3 = new Thread(r);
//        t3.start();
////        Person p3 = new Person();
////        System.out.println(p.clone(p3));
//    }
}
