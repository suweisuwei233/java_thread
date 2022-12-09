/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-12-01 20:06
 **/

public class TestDaemon {
    public static void main(String[] args) {
        You you = new You();
        God god = new God();
        Thread youThread = new Thread(you);
        Thread godThread = new Thread(god);
        godThread.setDaemon(true);//Daemon默认是false表示用户线程 正常的线程都是用户线程


        //启动守护线程
        godThread.start();
        //启动用户线程
        youThread.start();
    }
}

class God implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 65535; i++) {
            System.out.println("上帝保佑着你");
        }

    }
}

class You implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("这个是你或者的第" + i + "天");
        }
        System.out.println("goodbye");
    }
}

