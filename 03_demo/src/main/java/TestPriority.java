/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-12-01 18:37
 **/

public class TestPriority {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "------->" + Thread.currentThread().getPriority());
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        Thread thread3 = new Thread(myThread);
        Thread thread4 = new Thread(myThread);
        Thread thread5 = new Thread(myThread);
        Thread thread6 = new Thread(myThread);

        //先设置优先级
//        thread1.start();

        thread2.setPriority(1);
//        thread2.start();

        thread3.setPriority(4);
//        thread3.start();

        //MAX_PRIORITY = 10
        thread4.setPriority(Thread.MAX_PRIORITY);
//        thread4.start();

        thread1.start();//5
        thread2.start();//1
        thread3.start();//4
        thread4.start();//10

//        thread5.setPriority(-1);
//        thread5.start();
//
//        thread6.setPriority(11);
//        thread5.start();

    }

}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "------->" + Thread.currentThread().getPriority());
    }
}

