package structural.facade;

/**
 * @author Revers.
 * @date 2024/02/24 20:15
 **/
public class facade {
    // 外观类
    class Facade {
        private SubSystem1 subSystem1;
        private SubSystem2 subSystem2;

        public Facade() {
            subSystem1 = new SubSystem1();
            subSystem2 = new SubSystem2();
        }

        public void operation1() {
            subSystem1.operation1();
        }

        public void operation2() {
            subSystem2.operation2();
        }
    }

    // 子系统1
    class SubSystem1 {
        public void operation1() {
            System.out.println("SubSystem1 operation1.");
        }
    }

    // 子系统2
    class SubSystem2 {
        public void operation2() {
            System.out.println("SubSystem2 operation2.");
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        Facade facade = new facade().new Facade();

        facade.operation1();
        facade.operation2();

        //SubSystem1 operation1.
        //SubSystem2 operation2.
    }
}
