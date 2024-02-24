package structural.proxy;

/**
 * @author Revers.
 * @date 2024/02/24 20:19
 **/
public class proxy {
    // 主题接口
    interface Subject {
        void request();
    }

    // 代理类
    class Proxy implements Subject {
        private RealSubject realSubject;

        public Proxy() {
            realSubject = new RealSubject();
        }

        @Override
        public void request() {
            // 在这里可以做一些预处理或后处理工作
            realSubject.request();
        }
    }

    // 真实主题类
    class RealSubject implements Subject {
        @Override
        public void request() {
            System.out.println("RealSubject request.");
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        Subject proxy = new proxy().new Proxy();

        proxy.request();
    }
}
