package behavioral.interpreter;

/**
 * 抽象表达式 (AbstractExpression)
 * <p>
 * 声明一个抽象的解释操作，这个接口为抽象语法树中所有的节点所共享。
 * 在这里我们用 Java 接口来实现。
 */
public interface Expression {
    /**
     * 解释方法。
     *
     * @param context 上下文环境，包含了 global 信息，例如变量的值。
     * @return 解释执行后的结果。
     */
    int interpret(Context context);
}
