package creational.abstractfactory;

/**
 * 抽象工厂模式 (Abstract Factory)
 *
 * 目的:
 * 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 * 这个模式的核心是“产品族”（Product Family）。
 *
 * 产品族:
 * 在本例中，一个产品族就是一套特定操作系统风格的UI元素。
 * - 产品族1 (Windows): WindowsButton, WindowsCheckbox
 * - 产品族2 (macOS): MacOSButton, MacOSCheckbox
 * 每个具体工厂负责创建属于同一个产品族的所有产品。
 *
 * 使用场景 (更具体的例子):
 * 1.  **UI工具包**: 如本例所示，根据不同的操作系统（Windows, macOS, Linux）创建风格一致的UI组件。
 * 2.  **数据库访问**: 定义一个抽象的 `DBFactory`，它可以创建 `Connection`, `Command`, `DataReader` 等对象。
 *     `SQLServerFactory` 会创建所有与SQL Server相关的对象，而 `OracleFactory` 则创建与Oracle相关的对象。
 *     这样，更换数据库只需要更换具体的工厂实例。
 * 3.  **文档生成器**: 一个 `DocumentFactory` 可以创建 `Header`, `Body`, `Footer` 对象。
 *     `PDFDocumentFactory` 创建PDF格式的各个部分，而 `HTMLDocumentFactory` 创建HTML格式的部分。
 * 4.  **游戏开发**: 一个 `EnemyFactory` 可以根据游戏难度（Easy, Hard）创建一整套敌人，
 *     包括小兵（Minion）、头目（Boss）等，不同难度下的敌人具有不同的属性但属于同一族。
 */
public class Client {

    private Button button;
    private Checkbox checkbox;

    public Client(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {
        // 根据配置或环境决定使用哪个工厂
        String osName = System.getProperty("os.name").toLowerCase();
        GUIFactory factory;

        if (osName.contains("win")) {
            factory = new WindowsFactory();
        } else {
            // 默认为 macOS
            factory = new MacOSFactory();
        }

        System.out.println("--- Creating UI for " + osName + " ---");
        Client app = new Client(factory);
        app.paint();
    }
}
