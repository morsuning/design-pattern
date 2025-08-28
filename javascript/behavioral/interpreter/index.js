/**
 * 解释器模式 (Interpreter)
 *
 * 目的:
 * 给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。
 *
 * 使用场景:
 * 1. 当有一个语言需要解释执行，并且你可将该语言中的句子表示为一个抽象语法树时。
 * 2. 文法简单。
 */

// --- 上下文 (Context) ---
class Context {
    constructor() {
        this.variables = {};
    }
    setVariable(name, value) {
        this.variables[name] = value;
    }
    getVariable(name) {
        return this.variables[name];
    }
}

// --- 抽象表达式 ---
class Expression {
    interpret(context) {}
}

// --- 终结符表达式 ---
class TerminalExpression extends Expression {
    constructor(variable) {
        super();
        this.variable = variable;
    }
    interpret(context) {
        return context.getVariable(this.variable);
    }
}

// --- 非终结符表达式 - 加法 ---
class AddExpression extends Expression {
    constructor(left, right) {
        super();
        this.left = left;
        this.right = right;
    }
    interpret(context) {
        return this.left.interpret(context) + this.right.interpret(context);
    }
}

// --- 非终结符表达式 - 减法 ---
class SubtractExpression extends Expression {
    constructor(left, right) {
        super();
        this.left = left;
        this.right = right;
    }
    interpret(context) {
        return this.left.interpret(context) - this.right.interpret(context);
    }
}

// --- 客户端 ---
function client() {
    const context = new Context();
    context.setVariable('a', 10);
    context.setVariable('b', 5);
    context.setVariable('c', 3);

    // a + b - c
    const expression = new SubtractExpression(
        new AddExpression(new TerminalExpression('a'), new TerminalExpression('b')),
        new TerminalExpression('c')
    );

    const result = expression.interpret(context);
    console.log(`Result of 'a + b - c' is: ${result}`);
}

client();
