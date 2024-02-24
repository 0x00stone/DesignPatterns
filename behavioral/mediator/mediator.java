package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Revers.
 * @date 2024/02/24 22:34
 **/
public class mediator {
    // 中介者接口
    interface Mediator {
        void send(String message, Colleague colleague);
    }

    // 具体中介者
    class ConcreteMediator implements Mediator {
        private Colleague colleague1;
        private Colleague colleague2;

        public void setColleague1(Colleague colleague) {
            this.colleague1 = colleague;
        }

        public void setColleague2(Colleague colleague) {
            this.colleague2 = colleague;
        }

        @Override
        public void send(String message, Colleague originator) {
            if (originator.equals(colleague1)) {
                colleague2.receive(message);
            } else if (originator.equals(colleague2)) {
                colleague1.receive(message);
            }
        }
    }

    // 抽象同事类
    abstract class Colleague {
        protected Mediator mediator;

        public Colleague(Mediator m) {
            mediator = m;
        }

        public abstract void send(String message);
        public abstract void receive(String message);
    }

    // 具体同事类1
    class ConcreteColleague1 extends Colleague {
        public ConcreteColleague1(Mediator mediator) {
            super(mediator);
        }

        public void send(String message) {
            mediator.send(message, this);
        }

        public void receive(String message) {
            System.out.println("Colleague1 received message: " + message);
        }
    }

    // 具体同事类2
    class ConcreteColleague2 extends Colleague {
        public ConcreteColleague2(Mediator mediator) {
            super(mediator);
        }

        public void send(String message) {
            mediator.send(message, this);
        }

        public void receive(String message) {
            System.out.println("Colleague2 received message: " + message);
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        // 创建中介者
        ConcreteMediator mediator = new mediator().new ConcreteMediator();

        // 创建同事对象
        ConcreteColleague1 colleague1 = new mediator().new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new mediator().new ConcreteColleague2(mediator);

        // 让中介者知道所有的同事
        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        // 通过中介者发送消息
        colleague1.send("Hello, World!");
        colleague2.send("Hi, there!");

        //Colleague2 received message: Hello, World!
        //Colleague1 received message: Hi, there!
    }


}
