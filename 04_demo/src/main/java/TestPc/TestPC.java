package TestPc;

/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-12-09 13:25
 **/
//生产者消费者模型利用缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Producter(synContainer).start();
        new Consumer(synContainer).start();
    }
}

//生产者
class Producter extends Thread {
    SynContainer container;
    public Producter(SynContainer container){
        this.container = container;
    }
    //生产方法

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了1只鸡id ->"+ i);

        }
    }
}

//消费者
class Consumer extends Thread {
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }

    //消费

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("消费了1只鸡id->" + container.pop().id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//产品
class Chicken {
    int id;//产品编号

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

//缓冲区
class SynContainer {
    //需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int count = 0;

    public synchronized void push(Chicken chicken) {
        //如果容器满了就需要等待消费者消费
        if (count == chickens.length) {
            //通知消费者 生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有
        chickens[count] = chicken;
        count++;
        //可以通知消费者消费了
        this.notifyAll();

    }

    //消费者消费产品
    public synchronized Chicken pop() throws InterruptedException {
        if (count == 0) {
            //等待生产者生产 消费者等待
            this.wait();
        }
        //如果可以消费
        count--;
        Chicken chicken = chickens[count];
        //吃完了 通知生产者生产
        this.notifyAll();
        return chicken;
    }
}

