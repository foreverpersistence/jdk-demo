package com.fred.learning.jdk8.stream;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: xxx
 * @Date: 2020/2/23 下午6:49
 * @Description: todo
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private long start;
    private long end;
    private static final long temp = 100000L;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {

    }

    //计算
    @Override
    protected Long compute() {
        if (end - start <= temp) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum +=i;
            }
            return sum;
        } else {
            long min = (end + start) / 2;
            ForkJoinDemo left = new ForkJoinDemo(start, min);
            left.fork();
            ForkJoinDemo right = new ForkJoinDemo(min + 1, end);
            right.fork();

            //合并结果
            return left.join() + right.join();
        }
    }
}
