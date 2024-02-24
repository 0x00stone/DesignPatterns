package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Revers.
 * @date 2024/02/24 22:31
 **/
public class iterator {
    // 聚合接口
    interface Aggregate {
        Iterator createIterator();
    }

    // 具体聚合1
    class ConcreteAggregate1 implements Aggregate {
        private List<Integer> items;

        public ConcreteAggregate1() {
            items = new ArrayList<>();
            items.add(1);
            items.add(2);
            items.add(3);
        }

        @Override
        public Iterator createIterator() {
            return new ConcreteIterator1(this);
        }

        public List<Integer> getItems() {
            return items;
        }
    }

    // 具体聚合2
    class ConcreteAggregate2 implements Aggregate {
        private String[] items;

        public ConcreteAggregate2() {
            items = new String[]{"A", "B", "C"};
        }

        @Override
        public Iterator createIterator() {
            return new ConcreteIterator2(this);
        }

        public String[] getItems() {
            return items;
        }
    }

    // 迭代器接口
    interface Iterator {
        boolean hasNext();

        Object next();
    }

    // 具体迭代器1
    class ConcreteIterator1 implements Iterator {
        private ConcreteAggregate1 aggregate;
        private int currentPosition = 0;

        public ConcreteIterator1(ConcreteAggregate1 aggregate) {
            this.aggregate = aggregate;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < aggregate.getItems().size();
        }

        @Override
        public Object next() {
            return aggregate.getItems().get(currentPosition++);
        }
    }

    // 具体迭代器2
    class ConcreteIterator2 implements Iterator {
        private ConcreteAggregate2 aggregate;
        private int currentPosition = 0;

        public ConcreteIterator2(ConcreteAggregate2 aggregate) {
            this.aggregate = aggregate;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < aggregate.getItems().length;
        }

        @Override
        public Object next() {
            return aggregate.getItems()[currentPosition++];
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        Aggregate aggregate1 = new iterator().new ConcreteAggregate1();
        Iterator iterator1 = aggregate1.createIterator();

        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        Aggregate aggregate2 = new iterator().new ConcreteAggregate2();
        Iterator iterator2 = aggregate2.createIterator();

        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        //1
        //2
        //3
        //A
        //B
        //C
    }
}
