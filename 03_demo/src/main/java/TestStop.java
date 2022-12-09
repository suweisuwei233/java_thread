/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-11-30 19:28
 **/

//1.建议线程正常停止 --> 利用次数，不建议死循环
//2.建议使用标签为 --> 设置一个标签位
//3.不要使用stop 或者 destroy 等过时或者JDK 不建议使用的方法0
public class TestStop implements Runnable {
    //设置一个标志位
    boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("run Thread" + i++);
        }
    }

    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            //调用stop方法 让线程停止
            testStop.stop();
            System.out.println("线程停止了");
        }
    }
}

