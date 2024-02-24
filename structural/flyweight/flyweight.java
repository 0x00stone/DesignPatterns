package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Revers.
 * @date 2024/02/24 20:17
 **/
public class flyweight {
    // 享元工厂类
    class FlyweightFactory {
        private Map<String, Flyweight> flyweights = new HashMap<>();

        public Flyweight getFlyweight(String key) {
            Flyweight flyweight = flyweights.get(key);

            if (flyweight == null) {
                flyweight = new ConcreteFlyweight(key);
                flyweights.put(key, flyweight);
            }

            return flyweight;
        }
    }

    // 享元类
    class Flyweight {
        private String key;

        public Flyweight(String key) {
            this.key = key;
        }

        public void operation() {
            System.out.println("Flyweight operation: " + key);
        }
    }

    // 具体享元类
    class ConcreteFlyweight extends Flyweight {
        public ConcreteFlyweight(String key) {
            super(key);
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new flyweight().new FlyweightFactory();

        Flyweight flyweight1 = flyweightFactory.getFlyweight("A");
        Flyweight flyweight2 = flyweightFactory.getFlyweight("B");
        Flyweight flyweight3 = flyweightFactory.getFlyweight("A");

        flyweight1.operation();
        flyweight2.operation();
        flyweight3.operation();

        //Flyweight operation: A
        //Flyweight operation: B
        //Flyweight operation: A
    }

}
