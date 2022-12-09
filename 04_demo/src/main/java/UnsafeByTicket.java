/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-12-01 21:10
 **/

public class UnsafeByTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"小明").start();
        new Thread(buyTicket,"小红").start();
        new Thread(buyTicket,"小王").start();
    }
}

class BuyTicket implements Runnable {
    //票
    private int ticketNumbers = 10;
    boolean flag = true;//外部停止方式



    @Override
    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {

        //判断是否邮票
        if (ticketNumbers <= 0) {
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(100);


        //买票
        System.out.println(Thread.currentThread().getName() + "拿到了票-->" + ticketNumbers--);
    }
}



