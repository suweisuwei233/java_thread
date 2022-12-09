import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-12-09 12:04
 **/

public class TestJUC {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}

