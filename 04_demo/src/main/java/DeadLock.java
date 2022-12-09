/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-12-09 12:12
 **/
//死锁 多个线程互相通报对象需要的资源 然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Makeup makeup = new Makeup(0,"灰姑娘");
        Makeup makeup1 = new Makeup(1,"白雪公主");
        makeup.start();
        makeup1.start();
    }
}

class Lipstick {

}

class Mirror {

}

class Makeup extends Thread {

    //需要的资源只有一份 用static来保证只有一份资源
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;//使用化妆品的人

    Makeup(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }
    @Override
    public void run() {
       //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //化妆方法 互相持有对方的锁 需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if(choice == 0){
            synchronized (lipstick){
                //获得口红的锁
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(1000);

            }
            synchronized (mirror){
                System.out.println(this.girlName+ "获得镜子的锁");
                Thread.sleep(1000);
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girlName +"获得镜子的锁");
                Thread.sleep(2000);

            }
            synchronized (lipstick){
                System.out.println(this.girlName + "获得镜子的锁");
            }
        }
    }
}

