package TestPc;

/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-12-09 14:02
 **/
//测试生产者和消费者的问题 信号灯法 标志位解决
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watch(tv).start();

    }
}

//生产者 --> 演员
class Player extends Thread {
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.paly("快乐大本营播放中");
            } else {
                this.tv.paly("抖音记录美好生活");
            }
        }
    }
}

//消费者 --> 观众
class Watch extends Thread {
    TV tv;

    public Watch(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

class TV {
    //演员表演 观众等待
    //观众观看 演员等待
    String voice;
    //是否在表演节目
    boolean flag = true;//true表示演员

    //表演
    public synchronized void paly(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了" + voice);
        //通知观众 观看
        this.notifyAll();//通知唤醒
        this.voice = voice;
        this.flag = !this.flag;
    }

    //观看
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了" + voice);
        //观看了需要通知演员
        this.notifyAll();
        this.flag = !this.flag;
    }
}


