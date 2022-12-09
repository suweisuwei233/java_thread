/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-11-30 17:27
 **/

public class DemoLambda2 {
    public static void main(String[] args) {
        ILove love = (int a) -> {
            System.out.println("i love you -- >" + a);
        };
        love.love(1);
        //lambda表达式的简化
        //参数类型
        love = (a) -> {
            System.out.println("i love you -- >" + a);
        };
        love.love(2);
        //简化类型
        love = a -> {
            System.out.println("i love you -- >" + a);
        };
        love.love(3);
        love = a -> System.out.println("i love you -- >" + a);
        love.love(4);
        //只有一行代码的时候可以去掉花括号 才可以使用花括号包裹 前提是接口为函数式接口
        //多个参数也可以去掉参数类型 要去掉就都要去掉
    }
}

interface ILove {
    void love(int a);
}

