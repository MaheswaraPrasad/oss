package com.vidin.inventory.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(Task.class);
    private long repeats = 0;

    public Task(Long repeats) {
        this.repeats = repeats;
    }

    @Override
    public void run() {
        for (int i = 0; i < repeats; i++) {
            try {
                Thread.sleep(1000);
                log.info("Print {} times from thread:{}", repeats, Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
