package structural.adapter;

/**
 * @author Revers.
 * @date 2024/02/24 20:07
 **/
public class adapter {
    // 目标接口
    interface Target {
        void request();
    }

    // 适配器类
    class Adapter implements Target {
        private Adaptee adaptee;

        public Adapter(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void request() {
            adaptee.specificRequest();
        }
    }

    // 被适配的类
    class Adaptee {
        public void specificRequest() {
            System.out.println("Specific request.");
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        // 创建被适配的类
        Adaptee adaptee = new adapter().new Adaptee();

        // 创建适配器类
        Target target = new adapter().new Adapter(adaptee);

        // 调用适配器类的方法
        target.request();

        //Specific request.
    }

}
