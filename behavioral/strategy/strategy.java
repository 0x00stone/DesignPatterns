package behavioral.strategy;

/**
 * @author Revers.
 * @date 2024/02/24 23:11
 **/
public class strategy {
    // 策略接口
    interface Strategy {
        int doOperation(int num1, int num2);
    }

    // 具体策略1：加法
    class ConcreteStrategyAdd implements Strategy {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 + num2;
        }
    }

    // 具体策略2：减法
    class ConcreteStrategySubtract implements Strategy {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 - num2;
        }
    }

    // 具体策略3：乘法
    class ConcreteStrategyMultiply implements Strategy {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 * num2;
        }
    }

    // 上下文类
    class Context {
        private Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public int executeStrategy(int num1, int num2) {
            return strategy.doOperation(num1, num2);
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        Context context = new strategy().new Context(new strategy().new ConcreteStrategyAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new strategy().new Context(new strategy().new ConcreteStrategySubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new strategy().new Context(new strategy().new ConcreteStrategyMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

        //10 + 5 = 15
        //10 - 5 = 5
        //10 * 5 = 50
    }

}
