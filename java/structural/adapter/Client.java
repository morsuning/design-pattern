package structural.adapter;

import structural.adapter.classadapter.Adapter;
import structural.adapter.classadapter.Target;
import structural.adapter.objectadapter.Adaptee;

/**
 * 适配器模式 (Adapter)
 *
 * 目的:
 * 将一个类的接口转换成客户希望的另外一个接口。
 *
 * 两种实现对比:
 *
 * 1. 对象适配器 (Object Adapter):
 *    - **实现方式**: 使用组合。Adapter 持有一个 Adaptee 的实例。
 *    - **优点**:
 *      - 更灵活。可以适配 Adaptee 及其所有子类。
 *      - 可以动态地切换被适配的对象。
 *    - **缺点**: 需要额外编写代码来转发请求。
 *    - **结论**: **更常用，推荐使用**。
 *
 * 2. 类适配器 (Class Adapter):
 *    - **实现方式**: 使用继承。Adapter 继承 Adaptee 并实现 Target 接口。
 *    - **优点**:
 *      - 可以重写 Adaptee 的部分行为。
 *      - 不需要额外转发请求，因为直接继承了方法。
 *    - **缺点**:
 *      - 不灵活。由于Java不支持多重类继承，Adapter 无法再继承其他类。
 *      - 只能适配 Adaptee 本身，不能适配其子类。
 *
 * 使用场景 (更具体的例子):
 * 1.  **Java I/O**: `java.io.InputStreamReader` 将 `InputStream` (字节流) 适配成 `Reader` (字符流)。
 * 2.  **Java Swing**: `JTable` 的 `TableModel` 接口，允许将任意数据源适配成 `JTable` 可以显示的模型。
 * 3.  **日志框架 SLF4J**: SLF4J (Simple Logging Facade for Java) 提供了一套统一的日志接口，
 *     通过引入不同的适配器（如 `slf4j-log4j12`），可以将日志调用适配到底层的具体日志实现（如 Log4j）。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- 1. Object Adapter Demonstration ---");
        demonstrateObjectAdapter();

        System.out.println("\n\n--- 2. Class Adapter Demonstration ---");
        demonstrateClassAdapter();
    }

    private static void demonstrateObjectAdapter() {
        Adaptee adaptee = new Adaptee();
        structural.adapter.objectadapter.Target target = new structural.adapter.objectadapter.Adapter(adaptee);
        target.request();
    }

    private static void demonstrateClassAdapter() {
        Target target = new Adapter();
        target.request();
    }
}
