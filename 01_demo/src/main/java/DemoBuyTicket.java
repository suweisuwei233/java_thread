/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-11-30 15:03
 **/

public class DemoBuyTicket implements  Runnable{
    private int ticketCount = 10;
    @Override
    public void run() {
        while(true){
            if(ticketCount<0){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketCount--+"张票");
        }
    }

    public static void main(String[] args) {
        DemoBuyTicket demoBuyTicket = new DemoBuyTicket();
        new Thread(demoBuyTicket,"学生").start();
        new Thread(demoBuyTicket,"老师").start();
        new Thread(demoBuyTicket,"黄牛").start();
    }
}




