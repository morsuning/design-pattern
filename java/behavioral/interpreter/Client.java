package behavioral.interpreter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 解释器模式 (Interpreter)
 *
 * 目的:
 * 给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。
 *
 * 优点:
 * - 易于改变和扩展文法。因为文法规则使用类来表示，所以可以通过继承来改变或扩展文法。
 *
 * 缺点:
 * - 复杂性高。对于每条文法规则，至少需要定义一个类，因此包含许多规则的文法可能难以管理和维护。
 * - 性能问题。解释执行通常比编译执行慢。
 * - 适用范围窄。主要用于处理简单的、文法不经常变化的语言。
 *
 * 使用场景 (更具体的例子):
 * 1.  **SQL解析**: 解释和执行SQL查询语句。`SELECT name FROM users WHERE age > 30` 可以被解析成一个表达式树。
 * 2.  **正则表达式**: 正则表达式引擎需要解析模式字符串，并将其转换为内部结构来匹配文本。
 * 3.  **领域特定语言 (DSL)**: 当你需要创建一个简单的、针对特定领域问题的语言时。例如，用于游戏脚本或配置文件。
 * 4.  **通讯协议解析**: 解析自定义的通讯协议。
 *
 * 现代替代方案:
 * 在现代Java开发中，很少会从头开始手动实现一个解释器。通常会使用更成熟的工具：
 * - **解析器生成器 (Parser Generators)**: 如 ANTLR, JavaCC。它们可以根据你定义的文法文件自动生成解析器代码。
 * - **脚本引擎 (Scripting Engines)**: Java通过 `javax.script` API (JSR 223) 支持嵌入式脚本。
 *   可以使用内置的JavaScript引擎（Nashorn，在Java 15后移除；或GraalVM）来执行动态表达式，如下所示。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- 1. Custom Interpreter Demonstration ---");
        demonstrateCustomInterpreter();

        System.out.println("\n\n--- 2. Modern Alternative using Java Scripting Engine ---");
        demonstrateScriptingEngine();
    }

    private static void demonstrateCustomInterpreter() {
        Context context = new Context();
        context.setVariable("a", 10);
        context.setVariable("b", 5);
        context.setVariable("c", 3);

        // 表达式: a + b - c
        Expression expression = new SubtractExpression(
                new AddExpression(
                        new TerminalExpression("a"),
                        new TerminalExpression("b")
                ),
                new TerminalExpression("c")
        );

        int result = expression.interpret(context);
        System.out.println("Result of 'a + b - c' is: " + result);
    }

    private static void demonstrateScriptingEngine() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        if (engine == null) {
            System.out.println("JavaScript engine not found. Please run with a compatible JDK (e.g., JDK 8-14 for Nashorn).");
            return;
        }

        try {
            // 将变量放入引擎
            engine.put("a", 10);
            engine.put("b", 5);
            engine.put("c", 3);

            // 定义表达式
            String expression = "a + b - c";
            System.out.println("Evaluating expression: " + expression);

            // 执行并获取结果
            Object result = engine.eval(expression);
            System.out.println("Result is: " + result);

        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}