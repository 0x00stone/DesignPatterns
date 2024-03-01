package structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Revers.
 * @date 2024/03/01 20:08
 **/
public class DynamicProxy {
    // UserService 接口
    interface UserService {
        void addUser(String userId, String userName);
        void deleteUser(String userId);
    }

    // UserService 接口的实现类
    class UserServiceImpl implements UserService {
        @Override
        public void addUser(String userId, String userName) {
            System.out.println("添加用户成功，用户ID为" + userId + "，用户名为" + userName);
        }

        @Override
        public void deleteUser(String userId) {
            System.out.println("删除用户成功，用户ID为" + userId);
        }
    }

    // DebugInvocationHandler 类，实现 InvocationHandler 接口
    class DebugInvocationHandler implements InvocationHandler {
        private Object target;  // 目标对象

        // 构造方法，传入目标对象
        public DebugInvocationHandler(Object target) {
            this.target = target;
        }

        // 代理方法
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("调用方法：" + method.getName());  // 方法调用前的逻辑
            Object result = method.invoke(target, args);  // 调用目标方法
            System.out.println("方法调用结束");  // 方法调用后的逻辑
            return result;  // 返回方法调用结果
        }
    }
    //获取代理对象的工厂类
    class JdkProxyFactory {
        public static Object getProxy(Object target) {
            return Proxy.newProxyInstance(
                    target.getClass().getClassLoader(), // 目标类的类加载
                    target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                    new DynamicProxy().new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
            );
        }
    }
    // 主程序
    public static void main(String[] args) {
        UserService userService = (UserService)JdkProxyFactory.getProxy(new DynamicProxy().new UserServiceImpl());
        userService.addUser("001", "张三");  // 调用代理对象的方法

        //调用方法：addUser
        //添加用户成功，用户ID为001，用户名为张三
        //方法调用结束
    }
}
