package Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-12-09 12:57
 **/
//测试我们Lock锁
public class TestLock {
    public static void main(String[] args) {

        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable {
    private int tickNums = 10;
    //定义lock
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try {
                lock.lock();
                if(tickNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tickNums--);
                }else{
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}
