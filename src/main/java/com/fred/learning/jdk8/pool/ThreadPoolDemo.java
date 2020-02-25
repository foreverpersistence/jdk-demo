package com.fred.learning.jdk8.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.common.util.concurrent.Uninterruptibles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  abcd
 * Time     :  2019-12-26
 * Desc     :  todo
 */
public class ThreadPoolDemo {


    private static final int DEFAULT_CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static final int DEFAULT_MAX_PO = DEFAULT_CORE_POOL_SIZE * 2;
    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolDemo.class);

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        for (int i = 0; i < 6; i++) {
//
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(">>>>>>>>" + Thread.currentThread().getName());
//                }
//            });
//        }


        ArrayBlockingQueue queue = new ArrayBlockingQueue(1000);
        ThreadPoolExecutor statisticsThreadPool = new ThreadPoolExecutor(
                DEFAULT_CORE_POOL_SIZE,
                DEFAULT_MAX_PO,
                60,
                TimeUnit.SECONDS,
                queue,
                new ThreadFactoryBuilder()
                        .setThreadFactory(new ThreadFactory() {
                            private int count = 0;
                            private String prefix = "XxxTask";

                            @Override
                            public Thread newThread(Runnable r) {
                                return new Thread(r, prefix + "-" + count++);
                            }
                        }).setUncaughtExceptionHandler((t, e) -> {
                    String threadName = t.getName();
//                    logger.error("statisticsThreadPool error occurred! threadName: {}, error", threadName);
                }).build(),
                (r, executor) -> {
                    if (!executor.isShutdown()) {
//                      logger.warn("statisticsThreadPool is too busy! waiting to insert task to queue{},{}", Uninterruptibles.putUninterruptibly(executor.getQueue(), r));
                        Uninterruptibles.putUninterruptibly(executor.getQueue(), r);
                    }
                }) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                if (t == null && r instanceof Future<?>) {
                    try {
                        Future<?> future = (Future<?>) r;
                        future.get();
                    } catch (CancellationException ce) {
                        t = ce;
                    } catch (ExecutionException ee) {
                        t = ee.getCause();
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt(); // ignore/reset
                    }
                }
                if (t != null) {
                    logger.error("error msg {}", t.getMessage());
                }
            }
        };

//        //
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
//
//        //Common Thread Pool
//         ExecutorService pool = new ThreadPoolExecutor(5, 200,
//                 0L, TimeUnit.MILLISECONDS,
//        new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//
//        pool.execute(()-> System.out.println(Thread.currentThread().getName()));

        for (int i = 0; i < 6; i++) {
//
            statisticsThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(">>>>>>>>" + Thread.currentThread().getName());
                }
            });
        }

    }
}
