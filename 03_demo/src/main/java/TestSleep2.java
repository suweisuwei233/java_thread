import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-11-30 19:51
 **/

public class TestSleep2 {
    public static void main(String[] args) throws InterruptedException {
        //打印当前系统时间
        Date date = new Date(System.currentTimeMillis());
        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            date = new Date(System.currentTimeMillis());
        }
    }
    //模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if (num < 0) {
                break;
            }
        }
    }
}

