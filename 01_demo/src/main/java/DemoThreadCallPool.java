import java.util.concurrent.*;

/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-11-30 15:47
 **/

public class DemoThreadCallPool implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 200; i++) {
            System.out.println(i+"次执行");
        }
        return "success";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DemoThreadCallPool demoCallAble =  new DemoThreadCallPool();
        DemoThreadCallPool demoCallAble2 =  new DemoThreadCallPool();
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> r1 = service.submit(demoCallAble);
        Future<String> r2 = service.submit(demoCallAble2);
        String res1 = r1.get();
        String res2 = r2.get();
        System.out.println(res1);
        System.out.println(res2);
        service.shutdown();
    }
}

