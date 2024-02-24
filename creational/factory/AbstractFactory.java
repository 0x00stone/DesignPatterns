package creational.factory;

/**
 * @author Revers.
 * @date 2024/02/24 18:26
 **/
public class AbstractFactory {

    // 抽象工厂接口
    interface Factory {
        ProductA createProductA();
        ProductB createProductB();
    }

    // 具体工厂1
    class ConcreteFactory1 implements Factory {
        @Override
        public ProductA createProductA() {
            return new ProductA1();
        }

        @Override
        public ProductB createProductB() {
            return new ProductB1();
        }
    }

    // 具体工厂2
    class ConcreteFactory2 implements Factory {
        @Override
        public ProductA createProductA() {
            return new ProductA2();
        }

        @Override
        public ProductB createProductB() {
            return new ProductB2();
        }
    }

    // 抽象产品A
    interface ProductA {
        void doSomething();
    }

    // 具体产品A1
    class ProductA1 implements ProductA {
        @Override
        public void doSomething() {
            System.out.println("ProductA1 do something");
        }
    }

    // 具体产品A2
    class ProductA2 implements ProductA {
        @Override
        public void doSomething() {
            System.out.println("ProductA2 do something");
        }
    }

    // 抽象产品B
    interface ProductB {
        void doSomething();
    }

    // 具体产品B1
    class ProductB1 implements ProductB {
        @Override
        public void doSomething() {
            System.out.println("ProductB1 do something");
        }
    }

    // 具体产品B2
    class ProductB2 implements ProductB {
        @Override
        public void doSomething() {
            System.out.println("ProductB2 do something");
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        // 创建具体工厂1
        Factory factory1 = new AbstractFactory().new ConcreteFactory1();
        // 使用具体工厂1创建产品A1和产品B1
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();
        // 调用产品A1和产品B1的方法
        productA1.doSomething();
        productB1.doSomething();

        // 创建具体工厂2
        Factory factory2 = new AbstractFactory().new ConcreteFactory2();
        // 使用具体工厂2创建产品A2和产品B2
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();
        // 调用产品A2和产品B2的方法
        productA2.doSomething();
        productB2.doSomething();

/*
        out put:
        ProductA1 do something
        ProductB1 do something
        ProductA2 do something
        ProductB2 do something
*/
    }
}
