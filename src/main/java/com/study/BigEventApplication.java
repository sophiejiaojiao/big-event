package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class BigEventApplication {
    public static void main(String[] args) {
        /**
         * 该方法是应用的入口点，通过调用run()启动Spring应用的上下文；
         * BigEventApplication.class是应用的主类，Spring将从该类开始加载应用；
         * args是传递给应用的命令行参数，可在应用中使用它们。
         */
        SpringApplication.run(BigEventApplication.class, args);
    }
}
