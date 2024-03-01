package structural.proxy;

/**
 * @author Revers.
 * @date 2024/03/01 20:06
 **/
public class StaticProxy {
    // 定义接口
    public interface HelloService {
        void sayHello();
    }

    // 实现类
    public class HelloServiceImpl implements HelloService {
        public void sayHello() {
            System.out.println("Hello World");
        }
    }

    // 代理类
    public class HelloServiceProxy implements HelloService {
        private HelloService target;

        public HelloServiceProxy(HelloService target) {
            this.target = target;
        }

        @Override
        public void sayHello() {
            // 在目标方法执行前做一些自己想做的事情
            System.out.println("Before sayHello");

            // 调用目标对象的方法
            target.sayHello();

            // 在目标方法执行后做一些自己想做的事情
            System.out.println("After sayHello");
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        // 创建目标对象
        HelloService target = new StaticProxy().new HelloServiceImpl();

        // 创建代理对象，并将目标对象传入代理对象的构造函数中
        HelloService proxy = new StaticProxy().new HelloServiceProxy(target);

        // 调用代理对象的方法
        proxy.sayHello();
    }

}
