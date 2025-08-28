package behavioral.interpreter;

/**
 * 非终结符表达式 - 减法 (SubtractExpression)
 */
public class SubtractExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 解释减法操作。
     *
     * @param context 上下文环境。
     * @return 左右表达式解释结果之差。
     */
    @Override
    public int interpret(Context context) {
        System.out.println("Interpreting Subtract operation...");
        return left.interpret(context) - right.interpret(context);
    }
}
