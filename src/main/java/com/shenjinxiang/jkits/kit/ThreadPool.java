package com.shenjinxiang.jkits.kit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(Config.THREADSIZE);

    private ThreadPool() {}


    public static ExecutorService getThread() {
        return threadPool;
    }
}
