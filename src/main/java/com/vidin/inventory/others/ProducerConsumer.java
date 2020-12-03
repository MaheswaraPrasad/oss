package com.vidin.inventory.others;

import org.opensaml.xml.signature.P;

public class ProducerConsumer {

    private static int[] buffer;
    private static int count;

    private static Object lock = new Object();


    static class Producer {
        public void produce() throws InterruptedException {
            synchronized (lock) {
                if (isFull(buffer)) {
                    lock.wait();
                }
                buffer[count++] = 1;
                lock.notify();
                System.out.println("Producer:");
                System.out.println(buffer);
                System.out.println("Producer:" + count);
            }
        }

        private boolean isFull(int[] buffer) {
            return buffer.length == count;
        }
    }

    static class Consumer {
        public void consume() throws InterruptedException {
            synchronized (lock) {
                if (isEmpty(buffer)) {
                    lock.wait();
                }
                buffer[--count] = 0;
                lock.notify();
            System.out.println("Consumer:");
            System.out.println(buffer);
            System.out.println("Consumer:" + count);
            }
        }

        private boolean isEmpty(int[] buffer) {
            return count == 0;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        buffer = new int[10];
        count = 0;
        Producer p = new Producer();
        Consumer c = new Consumer();
        Runnable prod = () -> {
            for (int i = 0; i < 45; i++) {
                try {
                    p.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable cons = () -> {
            for (int i = 0; i < 40; i++) {
                try {
                    c.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread prodT = new Thread(prod);
        Thread consT = new Thread(cons);
        consT.start();
        prodT.start();
        prodT.join();
        consT.join();
        System.out.println(count);
    }
}
