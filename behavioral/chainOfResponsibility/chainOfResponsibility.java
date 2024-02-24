package behavioral.chainOfResponsibility;

/**
 * @author Revers.
 * @date 2024/02/24 20:22
 **/
public class chainOfResponsibility {
    // 处理者接口
    interface Handler {
        void setNextHandler(Handler nextHandler);

        void handleRequest(Request request);
    }

    // 具体处理者1
    class ConcreteHandler1 implements Handler {
        private Handler nextHandler;

        @Override
        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        @Override
        public void handleRequest(Request request) {
            if (request.getType() == 1) {
                System.out.println("ConcreteHandler1 handled request.");
            } else {
                // 将请求传递给下一个处理者
                nextHandler.handleRequest(request);
            }
        }
    }

    // 具体处理者2
    class ConcreteHandler2 implements Handler {
        private Handler nextHandler;

        @Override
        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        @Override
        public void handleRequest(Request request) {
            if (request.getType() == 2) {
                System.out.println("ConcreteHandler2 handled request.");
            } else {
                // 将请求传递给下一个处理者
                nextHandler.handleRequest(request);
            }
        }
    }

    // 请求类
    class Request {
        private int type;

        public Request(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        Handler handler1 = new chainOfResponsibility().new ConcreteHandler1();
        Handler handler2 = new chainOfResponsibility().new ConcreteHandler2();

        handler1.setNextHandler(handler2);

        Request request1 = new chainOfResponsibility().new Request(1);
        Request request2 = new chainOfResponsibility().new Request(2);

        handler1.handleRequest(request1);
        handler1.handleRequest(request2);

        //ConcreteHandler1 handled request.
        //ConcreteHandler2 handled request.
    }
}
