package behavioral.interpreter;

/**
 * 非终结符表达式 - 加法 (AddExpression)
 * <p>
 * 1. 对语法中的每一条规则都需要一个 NonterminalExpression 类。
 * 2. 为语法中的非终结符实现解释操作。
 * 3. 对每个非终结符，都维护一个对 AbstractExpression 类型实例的引用。
 */
public class AddExpression implements Expression {
    // 左操作数
    private final Expression left;
    // 右操作数
    private final Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 解释加法操作。
     * 它递归地调用其左右操作数的 interpret 方法，然后将结果相加。
     *
     * @param context 上下文环境。
     * @return 左右表达式解释结果之和。
     */
    @Override
    public int interpret(Context context) {
        System.out.println("Interpreting Add operation...");
        return left.interpret(context) + right.interpret(context);
    }
}
