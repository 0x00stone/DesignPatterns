package behavioral.visitor;

/**
 * @author Revers.
 * @date 2024/02/24 23:17
 **/
public class visitor {
    // 数据结构接口
    interface Element {
        void accept(Visitor visitor);
    }

    // 具体数据结构1：具体元素1
    class ConcreteElement1 implements Element {
        @Override
        public void accept(Visitor visitor) {
            visitor.visitConcreteElement1(this);
        }

        public void operation1() {
            System.out.println("ConcreteElement1: Operation 1");
        }
    }

    // 具体数据结构2：具体元素2
    class ConcreteElement2 implements Element {
        @Override
        public void accept(Visitor visitor) {
            visitor.visitConcreteElement2(this);
        }

        public void operation2() {
            System.out.println("ConcreteElement2: Operation 2");
        }
    }

    // 访问者接口
    interface Visitor {
        void visitConcreteElement1(ConcreteElement1 concreteElement1);

        void visitConcreteElement2(ConcreteElement2 concreteElement2);
    }

    // 具体访问者1：具体访问者1
    class ConcreteVisitor1 implements Visitor {
        @Override
        public void visitConcreteElement1(ConcreteElement1 concreteElement1) {
            System.out.println("ConcreteVisitor1: Visiting ConcreteElement1");
            concreteElement1.operation1();
        }

        @Override
        public void visitConcreteElement2(ConcreteElement2 concreteElement2) {
            System.out.println("ConcreteVisitor1: Visiting ConcreteElement2");
            concreteElement2.operation2();
        }
    }

    // 具体访问者2：具体访问者2
    class ConcreteVisitor2 implements Visitor {
        @Override
        public void visitConcreteElement1(ConcreteElement1 concreteElement1) {
            System.out.println("ConcreteVisitor2: Visiting ConcreteElement1");
            concreteElement1.operation1();
        }

        @Override
        public void visitConcreteElement2(ConcreteElement2 concreteElement2) {
            System.out.println("ConcreteVisitor2: Visiting ConcreteElement2");
            concreteElement2.operation2();
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        Element element1 = new visitor().new ConcreteElement1();
        Element element2 = new visitor().new ConcreteElement2();

        Visitor visitor1 = new visitor().new ConcreteVisitor1();
        Visitor visitor2 = new visitor().new ConcreteVisitor2();

        element1.accept(visitor1);
        element2.accept(visitor1);

        element1.accept(visitor2);
        element2.accept(visitor2);

        //ConcreteVisitor1: Visiting ConcreteElement1
        //ConcreteElement1: Operation 1
        //ConcreteVisitor1: Visiting ConcreteElement2
        //ConcreteElement2: Operation 2
        //ConcreteVisitor2: Visiting ConcreteElement1
        //ConcreteElement1: Operation 1
        //ConcreteVisitor2: Visiting ConcreteElement2
        //ConcreteElement2: Operation 2
    }
}
