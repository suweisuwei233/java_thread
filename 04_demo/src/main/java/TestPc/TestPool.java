package TestPc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-12-09 14:23
 **/
//测试线程池
public class TestPool {
    public static void main(String[] args) {
        // 创建线程服务 创建线程池
        //参数为线程池的大小
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
    }
}
class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-> " + i);
        }
    }
}

