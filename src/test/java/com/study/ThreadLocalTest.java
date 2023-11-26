package com.study;

import org.junit.jupiter.api.Test;
/*
* ThreadLocal能做到线程隔离，如下方执行两个线程时，白色一直是谢怜，红色一直是花城
*/
public class ThreadLocalTest {
    @Test
    public void testThreadLocalSetAndGet() {
        // 提供一个ThreadLocal对象
        ThreadLocal tl = new ThreadLocal();

        // 开启两个线程
        new Thread(() -> {
            tl.set("谢怜");
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
        }, "白色").start();

        new Thread(() -> {
            tl.set("花城");
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
        }, "红色").start();
    }
}
