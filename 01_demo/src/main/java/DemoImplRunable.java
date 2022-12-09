/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-11-30 14:53
 **/

public class DemoImplRunable implements Runnable{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("我在看代码:"+i);
        }
    }

    public static void main(String[] args) {
        DemoImplRunable demoImplRunable = new DemoImplRunable();
        new Thread(demoImplRunable).start();
        for (int i = 0; i < 100; i++) {
            System.out.println("我在看书:"+i);
        }
    }
}

