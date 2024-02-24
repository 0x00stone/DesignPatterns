package creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Revers.
 * @date 2024/02/24 19:51
 **/
public class builder {
    // 抽象建造者接口
    interface Builder {
        void buildPartA();
        void buildPartB();
        void buildPartC();
        Product getResult();
    }

    // 具体建造者类1
    class ConcreteBuilder1 implements Builder {
        private Product product = new Product();

        @Override
        public void buildPartA() {
            product.add("PartA1");
        }

        @Override
        public void buildPartB() {
            product.add("PartB1");
        }

        @Override
        public void buildPartC() {
            product.add("PartC1");
        }

        @Override
        public Product getResult() {
            return product;
        }
    }

    // 具体建造者类2
    class ConcreteBuilder2 implements Builder {
        private Product product = new Product();

        @Override
        public void buildPartA() {
            product.add("PartA2");
        }

        @Override
        public void buildPartB() {
            product.add("PartB2");
        }

        @Override
        public void buildPartC() {
            product.add("PartC2");
        }

        @Override
        public Product getResult() {
            return product;
        }
    }

    // 指挥者类
    class Director {
        private Builder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        public Product construct() {
            builder.buildPartA();
            builder.buildPartB();
            builder.buildPartC();
            return builder.getResult();
        }
    }

    // 产品类
    class Product {
        private List<String> parts = new ArrayList<>();

        public void add(String part) {
            parts.add(part);
        }

        public String toString() {
            return "Product: " + String.join(", ", parts);
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        // 创建指挥者类和具体建造者类
        Director director = new builder().new Director(new builder().new ConcreteBuilder1());
        // 使用指挥者类来创建产品
        Product product1 = director.construct();
        // 打印产品信息
        System.out.println(product1);

        // 创建指挥者类和具体建造者类
        director = new builder().new Director(new builder().new ConcreteBuilder2());
        // 使用指挥者类来创建产品
        Product product2 = director.construct();
        // 打印产品信息
        System.out.println(product2);

//        Product: PartA1, PartB1, PartC1
//        Product: PartA2, PartB2, PartC2
    }

}
