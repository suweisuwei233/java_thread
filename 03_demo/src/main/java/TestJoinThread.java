/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-12-01 18:12
 **/

public class TestJoinThread {
    public static void main(String[] args) {
        MainThread mainThread = new MainThread();
        Thread thread = new Thread(mainThread);
        thread.start();
    }



}
class MainThread implements Runnable{

    @Override
    public void run() {

        for (int i = 0; i < 210; i++) {
            if(i == 200){
                try {
                    OtherThread otherThread = new OtherThread();
                    Thread thread = new Thread(otherThread);
                    thread.start();
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("MainThread" + i );
        }
    }

}
class OtherThread implements  Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("OtherThread" + i );
        }
    }
}

