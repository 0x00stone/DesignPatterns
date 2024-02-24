package behavioral.interpreter;

/**
 * @author Revers.
 * @date 2024/02/24 20:26
 **/
public class interpreter {
    // 抽象表达式接口
    interface Expression {
        int interpret(Context context);
    }

    // 具体表达式1
    class NumberExpression implements Expression {
        private int number;

        public NumberExpression(int number) {
            this.number = number;
        }

        @Override
        public int interpret(Context context) {
            return number;
        }
    }

    // 具体表达式2
    class PlusExpression implements Expression {
        private Expression leftExpression;
        private Expression rightExpression;

        public PlusExpression(Expression leftExpression, Expression rightExpression) {
            this.leftExpression = leftExpression;
            this.rightExpression = rightExpression;
        }

        @Override
        public int interpret(Context context) {
            return leftExpression.interpret(context) + rightExpression.interpret(context);
        }
    }

    // 具体表达式3
    class MinusExpression implements Expression {
        private Expression leftExpression;
        private Expression rightExpression;

        public MinusExpression(Expression leftExpression, Expression rightExpression) {
            this.leftExpression = leftExpression;
            this.rightExpression = rightExpression;
        }

        @Override
        public int interpret(Context context) {
            return leftExpression.interpret(context) - rightExpression.interpret(context);
        }
    }

    // 上下文类
    class Context {
        private int number1;
        private int number2;

        public Context(int number1, int number2) {
            this.number1 = number1;
            this.number2 = number2;
        }

        public int getNumber1() {
            return number1;
        }

        public int getNumber2() {
            return number2;
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        Context context = new interpreter().new Context(10, 5);

        Expression expression = new interpreter().new PlusExpression(
                new interpreter().new NumberExpression(context.getNumber1()),
                new interpreter().new NumberExpression(context.getNumber2())
        );

        System.out.println("Result: " + expression.interpret(context));
        //Result: 15
    }

}
