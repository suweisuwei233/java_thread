/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-11-30 14:41
 **/

public class DemoThread extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码:"+i);
        }
    }
    public static void main(String [] args){
        /*使用start方法开启线程*/
        new DemoThread().start();
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习线程:"+i);
        }
    }
}

