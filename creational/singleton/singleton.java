package creational.singleton;

/**
 * @author Revers.
 * @date 2024/02/24 20:06
 **/
public class singleton {
    // 单例类
    public class Singleton {
        private static Singleton instance;

        private Singleton() {}

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new singleton().new Singleton();
                    }
                }
            }
            return instance;
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        // 获取单例对象
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // 检查两个对象是否相等
        System.out.println(instance1 == instance2); // true
    }

}
