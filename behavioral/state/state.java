package behavioral.state;

/**
 * @author Revers.
 * @date 2024/02/24 23:08
 **/
public class state {
    // 状态接口
    interface State {
        void handle();
    }

    // 具体状态1
    class ConcreteState1 implements State {
        @Override
        public void handle() {
            System.out.println("ConcreteState1: Handling request.");
        }
    }

    // 具体状态2
    class ConcreteState2 implements State {
        @Override
        public void handle() {
            System.out.println("ConcreteState2: Handling request.");
        }
    }

    // 上下文类
    class Context {
        private State state;

        public Context() {
            this.state = new ConcreteState1();
        }

        public void setState(State state) {
            this.state = state;
        }

        public void request() {
            state.handle();
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        Context context = new state().new Context();

        context.request();

        context.setState(new state().new ConcreteState2());

        context.request();

        //ConcreteState1: Handling request.
        //ConcreteState2: Handling request.
    }

}
