package creational.factory;

/**
 * @author Revers.
 * @date 2024/02/24 18:27
 **/
public class FactoryMethod {
    // 抽象产品接口
    interface Product {
        void doSomething();
    }

    // 具体产品A
    class ProductA implements Product {
        @Override
        public void doSomething() {
            System.out.println("ProductA do something");
        }
    }

    // 具体产品B
    class ProductB implements Product {
        @Override
        public void doSomething() {
            System.out.println("ProductB do something");
        }
    }

    // 抽象工厂接口
    interface Factory {
        Product createProduct();
    }

    // 具体工厂1
    class ConcreteFactory1 implements Factory {
        @Override
        public Product createProduct() {
            return new ProductA();
        }
    }

    // 具体工厂2
    class ConcreteFactory2 implements Factory {
        @Override
        public Product createProduct() {
            return new ProductB();
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        // 创建具体工厂1
        Factory factory1 = new FactoryMethod().new ConcreteFactory1();
        // 使用具体工厂1创建产品
        Product product1 = factory1.createProduct();
        // 调用产品的方法
        product1.doSomething();

        // 创建具体工厂2
        Factory factory2 = new FactoryMethod().new ConcreteFactory2();
        // 使用具体工厂2创建产品
        Product product2 = factory2.createProduct();
        // 调用产品的方法
        product2.doSomething();

//        ProductA do something
//        ProductB do something

    }
}
