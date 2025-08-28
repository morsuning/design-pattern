package structural.decorator;

/**
 * 装饰器模式 (Decorator)
 *
 * 目的:
 * 动态地给一个对象添加一些额外的职责。
 * 就增加功能来说，装饰器模式相比生成子类更为灵活。
 *
 * 使用场景 (更具体的例子):
 * 1.  **Java I/O**: 这是最经典的例子。`FileInputStream` 是一个基础组件，
 *     `BufferedInputStream` 是一个装饰器，它增加了缓冲功能以提高性能；
 *     `GZIPInputStream` 是另一个装饰器，它增加了GZIP解压功能。
 *     我们可以这样嵌套使用：`new GZIPInputStream(new BufferedInputStream(new FileInputStream("file.gz")))`。
 * 2.  **GUI工具包**: 给一个窗口 `Window` (组件) 添加滚动条 `ScrollbarDecorator` 或边框 `BorderDecorator`。
 * 3.  **Web框架中的请求/响应处理**: 在一个HTTP请求到达控制器之前或之后，
 *     可以通过装饰器（通常称为中间件或过滤器）来添加日志、认证、压缩等功能。
 * 4.  **数据源加密**: 一个 `DataSource` (组件) 可以被 `EncryptionDecorator` 装饰，
 *     在写入数据时加密，在读取数据时解密，而对客户端代码完全透明。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- Decorator Pattern Demonstration (Coffee Shop) ---");

        // 1. 点一杯浓缩咖啡，不加任何调料
        Beverage beverage = new Espresso();
        System.out.println("Order 1: " + beverage.getDescription() + " $" + beverage.cost());

        // 2. 点一杯浓缩咖啡，加双份摩卡和一份牛奶
        Beverage beverage2 = new Espresso();
        beverage2 = new Mocha(beverage2); // 用摩卡装饰
        beverage2 = new Mocha(beverage2); // 再用摩卡装饰
        beverage2 = new Milk(beverage2);  // 最后用牛奶装饰
        System.out.println("Order 2: " + beverage2.getDescription() + " $" + String.format("%.2f", beverage2.cost()));
    }
}
