package structural.decorator;

/**
 * @author Revers.
 * @date 2024/02/24 20:13
 **/
public class decorator {
    // 抽象组件类
    abstract class Component {
        public abstract void operation();
    }

    // 具体组件类
    class ConcreteComponent extends Component {
        @Override
        public void operation() {
            System.out.println("ConcreteComponent operation.");
        }
    }

    // 抽象装饰器类
    abstract class Decorator extends Component {
        protected Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public abstract void operation();
    }

    // 具体装饰器类1
    class ConcreteDecorator1 extends Decorator {
        public ConcreteDecorator1(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            component.operation();
            System.out.println("ConcreteDecorator1 operation.");
        }
    }

    // 具体装饰器类2
    class ConcreteDecorator2 extends Decorator {
        public ConcreteDecorator2(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            component.operation();
            System.out.println("ConcreteDecorator2 operation.");
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        // 创建具体组件
        Component component = new decorator().new ConcreteComponent();

        // 创建具体装饰器1
        Decorator decorator1 = new decorator().new ConcreteDecorator1(component);

        // 创建具体装饰器2
        Decorator decorator2 = new decorator().new ConcreteDecorator2(decorator1);

        // 调用装饰器的方法
        decorator2.operation();

//        ConcreteComponent operation.
//        ConcreteDecorator1 operation.
//        ConcreteDecorator2 operation.
    }
}
