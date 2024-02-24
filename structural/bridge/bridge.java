package structural.bridge;

/**
 * @author Revers.
 * @date 2024/02/24 20:10
 **/
public class bridge {
    // 抽象类
    abstract class Abstraction {
        protected Implementor implementor;

        public Abstraction(Implementor implementor) {
            this.implementor = implementor;
        }

        public abstract void operation();
    }

    // 实现类
    interface Implementor {
        void operationImpl();
    }

    // 具体实现类1
    class ConcreteImplementor1 implements Implementor {
        @Override
        public void operationImpl() {
            System.out.println("ConcreteImplementor1 operationImpl.");
        }
    }

    // 具体实现类2
    class ConcreteImplementor2 implements Implementor {
        @Override
        public void operationImpl() {
            System.out.println("ConcreteImplementor2 operationImpl.");
        }
    }

    // 具体抽象类1
    class RefinedAbstraction1 extends Abstraction {
        public RefinedAbstraction1(Implementor implementor) {
            super(implementor);
        }

        @Override
        public void operation() {
            System.out.println("RefinedAbstraction1 operation.");
            implementor.operationImpl();
        }
    }

    // 具体抽象类2
    class RefinedAbstraction2 extends Abstraction {
        public RefinedAbstraction2(Implementor implementor) {
            super(implementor);
        }

        @Override
        public void operation() {
            System.out.println("RefinedAbstraction2 operation.");
            implementor.operationImpl();
        }
    }

    // 客户端代码
        public static void main(String[] args) {
            // 创建具体实现类
            Implementor implementor1 = new bridge().new ConcreteImplementor1();
            Implementor implementor2 = new bridge().new ConcreteImplementor2();

            // 创建具体抽象类
            Abstraction abstraction1 = new bridge().new RefinedAbstraction1(implementor1);
            Abstraction abstraction2 = new bridge().new RefinedAbstraction2(implementor2);

            // 调用具体抽象类的方法
            abstraction1.operation();
            abstraction2.operation();

//            RefinedAbstraction1 operation.
//            ConcreteImplementor1 operationImpl.
//            RefinedAbstraction2 operation.
//            ConcreteImplementor2 operationImpl.
        }
}
