package com.vidin.inventory.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    private static ExecutorService executorService = Executors.newFixedThreadPool(8);
    public static void CreateTask(Long id){
        for (int i = 0; i < id; i++) {
            executorService.execute(new Task((long) i));
        }
    }
}
