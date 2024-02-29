package creational.singleton;

/**
 * @author Revers.
 * @date 2024/02/24 20:06
 **/
public class singleton {

    //懒汉式（不推荐）
    public class Singleton1 {
        private static Singleton1 INSTANCE = null;
        //其实只有首次创建单例对象时才需要同步，但该代码实际上每次调用都会同步
        public static synchronized Singleton1 getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new singleton().new Singleton1();
            }
            return INSTANCE;
        }
    }

    //双检锁懒汉式(懒汉式改)
    public class Singleton2   {
        private static volatile Singleton2 INSTANCE = null; // 可见性，有序性
        public static Singleton2 getInstance() {
            if (INSTANCE == null) {  //INSTANCE = new Singleton2() 不是原子的
                synchronized (Singleton2.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new singleton().new Singleton2();
                    }
                }
            }
            return INSTANCE;
        }
    }

    //静态内部类懒汉式（要求懒加载）
    public class Singleton3 {
        private static class Holder {
            static Singleton3 INSTANCE = new singleton().new Singleton3();
        }

        public static Singleton3 getInstance() {
            return Holder.INSTANCE;
        }
    }

    //饿汉式 : 在类初始化时，已经自行实例化。（一般情况下）
    public class Singleton4 {
        private static final Singleton4 INSTANCE = new singleton().new Singleton4();
        private Singleton4() {
            if (INSTANCE != null) {
                throw new RuntimeException("单例对象不能重复创建"); //防止反射破坏单例
            }
        }
    }

    //枚举饿汉式（涉及到反序列化创建对象时）
    public enum Singleton5 { // 能天然防止反射、反序列化破坏单例
        INSTANCE;
        public static Singleton5 getInstance() { return INSTANCE; }
    }
}
