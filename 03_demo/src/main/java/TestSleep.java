/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-11-30 19:47
 **/
//模拟线程阻塞
public class TestSleep implements Runnable{
    private int ticketCount = 10;
    @Override
    public void run() {
        while(true){
            if(ticketCount<0){
                break;
            }
            //模拟网络延时 放大网络问题
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketCount--+"张票");
        }
    }

    public static void main(String[] args) {
        TestSleep demoBuyTicket = new TestSleep();
        new Thread(demoBuyTicket,"学生").start();
        new Thread(demoBuyTicket,"老师").start();
        new Thread(demoBuyTicket,"黄牛").start();
    }
}

