/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-11-30 15:31
 **/

public class DemoRace implements  Runnable{
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //判断比赛是否结束
            boolean flag = gameOver(i);
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    //判断是否完成比赛

    private boolean gameOver(int step){
        if(winner!=null){
            return true;
        }else{
            if(step >= 100){
                winner = Thread.currentThread().getName();
                System.out.println(winner + " is Winner ");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DemoRace race = new DemoRace();
        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }
}

