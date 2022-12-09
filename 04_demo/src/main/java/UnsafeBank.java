/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-12-01 21:22
 **/

public class UnsafeBank {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100, "结婚基金");
        Drawing you = new Drawing(account,50, "你");
        Drawing  youGirlFriend= new Drawing(account,100, "你的女朋友");
        //启动线程
        you.start();
        youGirlFriend.start();

    }
}

class  Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;
    public Drawing(Account account,int drawingMoney, String name){
        //调用父类的name属性
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    //取钱
    @Override
    //synchronized -> this 该关键字加载这里没有效果
    public  void run() {
        synchronized(account){
            //判断有没有钱
            if(account.money - drawingMoney < 0){
                System.out.println(Thread.currentThread().getName() + "钱不够取不到");
                return;
            }

            try {
                //模拟网络延时
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额等于 余额 - 你取出来的钱
            account.money = account.money - drawingMoney;
            //你手里的钱
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name + "余额为" + account.money);
//        System.out.println(this.getName() + Thread.currentThread().getName());//这个地方是继承 this就指当前这个Thread
            System.out.println(this.getName() + "手里的钱" + nowMoney);
        }
    }
}
