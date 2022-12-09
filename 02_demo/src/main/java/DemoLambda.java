/**
 * @program: learning_java_thread
 * @description:
 * @author: sujiawei
 * @create: 2022-11-30 17:06
 **/

public class DemoLambda {

    //4.静态内部类调用
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I Like Lambda2");
        }
    }


    public static void main(String[] args) {
        //3.接口实现类 方式调用
        ILike like = new Like();
        like.lambda();

        like= new Like2();
        like.lambda();

        //5.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I Like Lambda3");
            }
        }
        like = new Like3();
        like.lambda();
        //6.匿名内部类  没有类的名称 必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I Like Lambda4");
            }
        };
        like.lambda();

        //7.使用lambda简化
        like = ()->{
            System.out.println("I Like Lambda5");
        };
        like.lambda();
    }
}

//1.定义一个函数是接口
interface ILike {
    void lambda();
}

//2.实现类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like Lambda");
    }
}

