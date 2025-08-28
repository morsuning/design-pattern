package creational.factorymethod;

/**
 * 工厂方法模式 (Factory Method)
 *
 * 目的:
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类。
 * 工厂方法使一类的实例化延迟到其子类。
 *
 * 使用场景 (更具体的例子):
 * 1.  **UI组件库**: 一个框架可以定义一个抽象的 `Window` 类和一个 `createButton()` 的工厂方法。
 *     `WindowsWindow` 子类将实现 `createButton()` 来返回 `WindowsButton`，而 `MacWindow`
 *     子类将返回 `MacButton`。
 * 2.  **文档编辑器**: 一个抽象的 `Application` 类可以有 `createDocument()` 工厂方法。
 *     `WordProcessorApp` 会创建 `WordDocument`，而 `SpreadsheetApp` 会创建 `SpreadsheetDocument`。
 * 3.  **日志框架**: 一个 `LoggerFactory` 可以有子类，根据配置（例如，写入文件、数据库或控制台）
 *     来创建不同类型的 `Logger` 实例。
 * 4.  **Java JDK中的应用**: `java.util.Calendar.getInstance()` 和 `java.sql.DriverManager.getConnection()`
 *     都是工厂方法的例子，它们根据不同的条件（地区、数据库URL）返回不同的具体实现。
 *
 * 与其他工厂模式的对比:
 * - **简单工厂 (Simple Factory)**:
 *   - **结构**: 一个工厂类，根据传入的参数（如字符串或枚举）在一个方法中通过 `if/else` 或 `switch` 来创建不同的产品。
 *   - **问题**: 不符合开闭原则。每次增加新产品都需要修改工厂类的代码。它不是23种GoF设计模式之一，而是一种编程习惯。
 *
 * - **工厂方法 (Factory Method)**:
 *   - **结构**: 定义一个创建对象的接口（工厂方法），但让实现这个接口的子类来决定实例化哪个类。
 *   - **优点**: 符合开闭原则。增加新产品只需增加一个新的具体工厂子类，无需修改现有代码。
 *   - **关注点**: 关注于单个产品的创建。
 *
 * - **抽象工厂 (Abstract Factory)**:
 *   - **结构**: 提供一个接口，用于创建一系列相关或相互依赖的对象（一个产品族），而无需指定它们的具体类。
 *   - **优点**: 同样符合开闭原则。可以轻松地切换整个产品族。
 *   - **关注点**: 关注于一系列产品（产品族）的创建。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- Using Creator A ---");
        // 创建具体创建者 A
        Creator creatorA = new ConcreteCreatorA();
        // 调用创建者的操作，该操作内部会使用工厂方法创建产品
        creatorA.anOperation();

        System.out.println("\n--- Using Creator B ---");
        // 创建具体创建者 B
        Creator creatorB = new ConcreteCreatorB();
        // 调用创建者的操作
        creatorB.anOperation();
    }
}