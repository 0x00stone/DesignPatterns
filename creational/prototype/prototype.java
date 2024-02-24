package creational.prototype;

/**
 * @author Revers.
 * @date 2024/02/24 19:56
 **/
public class prototype {
    // 抽象原型类
    interface Prototype {
        Prototype clone();
        String getName();
    }

    // 具体原型类1
    class ConcretePrototype1 implements Prototype {
        private String name;

        public ConcretePrototype1(String name) {
            this.name = name;
        }

        @Override
        public Prototype clone() {
            return new ConcretePrototype1(name);
        }

        @Override
        public String getName() {
            return name;
        }
    }

    // 具体原型类2
    class ConcretePrototype2 implements Prototype {
        private String name;

        public ConcretePrototype2(String name) {
            this.name = name;
        }

        @Override
        public Prototype clone() {
            return new ConcretePrototype2(name);
        }

        public String getName() {
            return name;
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        // 创建原型对象
        Prototype prototype1 = new prototype().new ConcretePrototype1("Prototype1");
        Prototype prototype2 = new prototype().new ConcretePrototype2("Prototype2");

        // 克隆原型对象
        Prototype clone1 = prototype1.clone();
        Prototype clone2 = prototype2.clone();

        // 打印克隆对象的名称
        System.out.println(clone1.getName());
        System.out.println(clone2.getName());

//        Prototype1
//        Prototype2
    }
}
