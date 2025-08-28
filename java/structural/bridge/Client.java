package structural.bridge;

/**
 * 桥接模式 (Bridge)
 *
 * 目的:
 * 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * 这里的“抽象”和“实现”不是指抽象类和接口，而是两个独立变化的维度。
 *
 * 两个变化维度:
 * 1. 抽象部分 (Abstraction): 在本例中是 `Shape` (形状)。形状可以有多种，如圆形、方形等。
 * 2. 实现部分 (Implementor): 在本例中是 `Color` (颜色)。颜色也可以有多种，如红色、蓝色等。
 *
 * 如果不使用桥接模式，我们可能需要创建 `RedCircle`, `BlueCircle`, `RedSquare`, `BlueSquare` 等大量的类，
 * 导致类爆炸。桥接模式通过组合关系，让 `Shape` 持有一个 `Color` 的引用，从而让两个维度可以独立扩展。
 *
 * 使用场景 (更具体的例子):
 * 1.  **GUI框架**: 一个 `Window` (抽象) 可以有不同的类型（如 `DialogWindow`, `PopupWindow`），
 *     同时它可以在不同的操作系统（`WindowImp`, `MacImp`）上实现 (实现)。
 *     `Window` 负责窗口的高层逻辑，而 `WindowImp` 负责底层的绘制和事件处理。
 * 2.  **数据库驱动**: 一个通用的数据库访问API (抽象) 可以与不同厂商的数据库驱动 (实现) 配合工作。
 *     JDBC (Java Database Connectivity) API 就是一个典型的桥接模式应用。`DriverManager` 负责桥接，
 *     而具体的驱动（MySQL, PostgreSQL等）是具体实现。
 * 3.  **设备与遥控器**: 一个 `RemoteControl` (抽象) 可以有不同的功能按钮（如 `AdvancedRemoteControl`），
 *     它可以控制不同的设备 `Device` (实现)，如 `TV`, `Radio`。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- Bridge Pattern Demonstration ---");

        // 创建不同的实现者（颜色）
        Color red = new RedColor();
        Color blue = new BlueColor();

        // 创建不同的抽象部分（形状），并用具体的实现者来配置它们
        Shape redCircle = new Circle(red);
        Shape blueSquare = new Square(blue);
        Shape blueCircle = new Circle(blue);

        // 调用操作
        System.out.println(redCircle.draw());
        System.out.println(blueSquare.draw());
        System.out.println(blueCircle.draw());
    }
}
