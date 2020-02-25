package com.fred.learning.jdk8.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @Author: xxx
 * @Date: 2020/2/23 下午6:57
 * @Description: todo
 */
public class ForkJoinTest {

    private static final long end = 10_0000_0000;
    public static void main(String[] args) {
//        sum:500000000500000000,time: 566
//        forkjoin. sum:500000000500000000,time: 838
//        stream. sum:500000000500000000,time: 762
        test();
        test_forkjoin();
        test_stream();
    }

    //正常测试
    public static void test() {
        long start = System.currentTimeMillis();

        long sum = 0;
        for (long j = 0; j <= end; j++) {
            sum += j;
        }

        System.out.println("sum:" + sum + ",time: " + (System.currentTimeMillis()-start));
    }


    //forkjoin test
    public static void test_forkjoin() {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0, end);
        Long sum = forkJoinPool.invoke(forkJoinDemo);

        System.out.println("forkjoin. sum:" + sum + ",time: " + (System.currentTimeMillis()-start));

    }

    //stream 测试
    public static void test_stream() {
        long start = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0, end).parallel().reduce(0, Long::sum);
        System.out.println("stream. sum:" + sum + ",time: " + (System.currentTimeMillis()-start));
    }
}
