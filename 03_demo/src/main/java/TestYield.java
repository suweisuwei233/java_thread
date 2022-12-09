/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-12-01 18:01
 **/

public class TestYield {
    public static void main(String[] args) {
        DemoYield demoYield = new DemoYield();
        new Thread(demoYield, "a").start();
        new Thread(demoYield, "b").start();
    }

}

class DemoYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程执行结束");
    }
}

