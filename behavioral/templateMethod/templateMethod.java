package behavioral.templateMethod;

/**
 * @author Revers.
 * @date 2024/02/24 23:14
 **/
public class templateMethod {
    // 抽象类：算法骨架
    abstract class AbstractClass {
        public void templateMethod() {
            step1();
            step2();
            step3();
        }

        protected abstract void step1();

        protected abstract void step2();

        protected abstract void step3();
    }

    // 具体子类1：实现算法的具体步骤
    class ConcreteClass1 extends AbstractClass {
        @Override
        protected void step1() {
            System.out.println("ConcreteClass1: Step 1");
        }

        @Override
        protected void step2() {
            System.out.println("ConcreteClass1: Step 2");
        }

        @Override
        protected void step3() {
            System.out.println("ConcreteClass1: Step 3");
        }
    }

    // 具体子类2：实现算法的具体步骤
    class ConcreteClass2 extends AbstractClass {
        @Override
        protected void step1() {
            System.out.println("ConcreteClass2: Step 1");
        }

        @Override
        protected void step2() {
            System.out.println("ConcreteClass2: Step 2");
        }

        @Override
        protected void step3() {
            System.out.println("ConcreteClass2: Step 3");
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        AbstractClass abstractClass1 = new templateMethod().new ConcreteClass1();
        abstractClass1.templateMethod();

        AbstractClass abstractClass2 = new templateMethod().new ConcreteClass2();
        abstractClass2.templateMethod();

        //ConcreteClass1: Step 1
        //ConcreteClass1: Step 2
        //ConcreteClass1: Step 3
        //ConcreteClass2: Step 1
        //ConcreteClass2: Step 2
        //ConcreteClass2: Step 3
    }
}
