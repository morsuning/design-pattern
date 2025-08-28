package behavioral.templatemethod;

/**
 * 模板方法模式 (Template Method)
 *
 * 目的:
 * 在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 *
 * 关键点 - 钩子 (Hooks):
 * - 钩子是在抽象类中声明的、具有默认（通常为空）实现的方法。
 * - 它们为子类提供了可选的“挂钩点”，用于在算法的特定步骤中插入自定义代码。
 * - 这使得子类在保持算法结构不变的前提下，拥有了更高的灵活性。
 *
 * 使用场景 (更具体的例子):
 * 1.  **Java Web框架**: `javax.servlet.http.HttpServlet` 类中的 `service()` 方法是一个模板方法。
 *     它根据HTTP请求的类型（GET, POST等）调用 `doGet()`, `doPost()` 等基本操作。
 *     开发者通过继承 `HttpServlet` 并重写 `doGet()` 或 `doPost()` 来实现具体的业务逻辑。
 * 2.  **单元测试框架**: JUnit 和 TestNG 等框架中的测试生命周期就是一个模板方法。
 *     `runTest()` (模板方法) 会依次调用 `setUp()` (基本操作), `testMethod()` (基本操作), `tearDown()` (基本操作)。
 *     开发者通过重写 `setUp` 和 `tearDown` 来准备和清理测试环境。
 * 3.  **应用程序框架**: 一个通用的应用程序框架可以定义一个 `run()` 模板方法，
 *     它规定了程序启动的通用步骤：`initConfig()`, `createUI()`, `startEventLoop()`。
 *     具体的应用程序继承框架类并实现这些抽象的步骤。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- Playing Cricket Game (with hook) ---");
        Game cricket = new Cricket();
        cricket.play();

        System.out.println("\n--- Playing Football Game (without hook) ---");
        Game football = new Football();
        football.play(); // Football 类没有重写钩子，所以不会有额外输出
    }
}
