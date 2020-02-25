package com.fred.learning.jdk8.ansyn;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: xxx
 * @Date: 2020/2/23 下午8:13
 * @Description: 异步回调， 对将来的结果进行 处理
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //对线程异步回调

        //no result
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            //
            System.out.println(Thread.currentThread().getName() + " run");
        });

        System.out.printf("", voidCompletableFuture.get());

        // has result
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 有返回值");
            int  i = 1/ 0;
            return 1024;
        });
        System.out.println(integerCompletableFuture.get());

        CompletableFuture<Integer> completableFuture = integerCompletableFuture.whenComplete((t, u) -> {//success
            System.out.println("success");
        }).exceptionally(e -> {//exception
            System.out.println("exception: " + e.getMessage());
            return 555;
        });
        System.out.println(completableFuture.get());
    }
}
