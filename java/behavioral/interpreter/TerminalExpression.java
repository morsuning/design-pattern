package behavioral.interpreter;

/**
 * 终结符表达式 (TerminalExpression)
 * <p>
 * 1. 实现了 AbstractExpression 接口中与终结符有关的解释操作。
 * 2. 一个句子中的每个终结符都需要一个 TerminalExpression 的实例。
 * <p>
 * 在这个例子中，变量（例如 "a", "b"）就是终结符。
 */
public class TerminalExpression implements Expression {
    // 存储变量名
    private final String variable;

    public TerminalExpression(String variable) {
        this.variable = variable;
    }

    /**
     * 解释终结符。
     * 它的实现很简单，就是从上下文中获取变量的值。
     *
     * @param context 上下文环境。
     * @return 变量对应的值。
     */
    @Override
    public int interpret(Context context) {
        System.out.println("Interpreting terminal: " + variable + " as " + context.getVariable(variable));
        return context.getVariable(variable);
    }
}
