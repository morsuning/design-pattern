package behavioral.visitor;

/**
 * 访问者模式 (Visitor)
 *
 * 目的:
 * 表示一个作用于某对象结构中的各元素的操作。
 * 它使你可以在不改变各元素的类的前提下，定义作用于这些元素的新操作。
 *
 * 优点:
 * - **增加新操作很容易**: 如果要增加一个新的操作，只需增加一个新的访问者类。
 * - **将相关操作集中**: 相关的行为都集中在一个访问者类中，而不是分散在各个元素类中。
 *
 * 缺点:
 * - **增加新的元素类很困难**: 每当增加一个新的具体元素类，就必须在所有访问者接口和所有具体访问者类中增加一个新的 `visit` 方法。
 * - **破坏封装**: 访问者需要访问元素的内部状态，这可能会暴露元素的实现细节。
 *
 * 使用场景 (更具体的例子):
 * 1.  **编译器**: 编译器中的抽象语法树（AST）是一个复杂的对象结构。
 *     可以使用访问者模式在AST上执行不同的操作，如类型检查（`TypeCheckingVisitor`）、
 *     代码生成（`CodeGenerationVisitor`）、优化（`OptimizationVisitor`），而无需修改AST节点类。
 * 2.  **代码静态分析工具**: 工具如 Checkstyle, PMD 需要遍历Java源代码的语法树，
 *     并对不同类型的节点（类声明、方法调用、循环语句等）应用不同的检查规则。
 *     每套规则可以实现为一个访问者。
 * 3.  **文档处理**: 一个文档对象模型（如XML DOM）可以被不同的访问者遍历，
 *     以实现不同的功能，如转换为HTML（`HtmlExportVisitor`）、提取纯文本（`PlainTextVisitor`）等。
 *
 * 现代替代方案:
 * 对于简单场景，可以使用 `instanceof` 模式匹配（Java 16+）和函数式接口来模拟访问者行为，
 * 这样可以避免创建大量的访问者类。但这种方式失去了双重分派的优雅性，
 * 并且将操作逻辑放回了客户端代码中。
 * `
 * void process(ComputerPart part) {
 *     if (part instanceof Keyboard k) {
 *         // logic for keyboard
 *     } else if (part instanceof Mouse m) {
 *         // logic for mouse
 *     }
 * }
 * `
 */
public class Client {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();

        System.out.println("--- Using Display Visitor ---");
        computer.accept(new ComputerPartDisplayVisitor());

        // 假设我们有另一个访问者来计算价格
        // System.out.println("\n--- Using Pricing Visitor ---");
        // computer.accept(new PricingVisitor());
    }
}
