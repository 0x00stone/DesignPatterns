package behavioral.command;

/**
 * @author Revers.
 * @date 2024/02/24 20:24
 **/
public class command {
    // 命令接口
    interface Command {
        void execute();
    }

    // 具体命令1
    class ConcreteCommand1 implements Command {
        private Receiver receiver;

        public ConcreteCommand1(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void execute() {
            receiver.action1();
        }
    }

    // 具体命令2
    class ConcreteCommand2 implements Command {
        private Receiver receiver;

        public ConcreteCommand2(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void execute() {
            receiver.action2();
        }
    }

    // 请求发送者
    class Invoker {
        private Command command;

        public Invoker(Command command) {
            this.command = command;
        }

        public void executeCommand() {
            command.execute();
        }
    }

    // 请求接收者
    class Receiver {
        public void action1() {
            System.out.println("Receiver performed action 1.");
        }

        public void action2() {
            System.out.println("Receiver performed action 2.");
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        Receiver receiver = new command().new Receiver();

        Command command1 = new command().new ConcreteCommand1(receiver);
        Command command2 = new command().new ConcreteCommand2(receiver);

        Invoker invoker = new command().new Invoker(command1);
        invoker.executeCommand();

        invoker = new command().new Invoker(command2);
        invoker.executeCommand();

        //Receiver performed action 1.
        //Receiver performed action 2.
    }
}
