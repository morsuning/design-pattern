package behavioral.state;

/**
 * 状态模式 (State)
 *
 * 目的:
 * 允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类。
 *
 * 使用场景 (更具体的例子):
 * 1.  **工作流引擎**: 一个订单或文档在其生命周期中会经历多种状态（如 `草稿`, `待审批`, `已批准`, `已拒绝`, `已完成`）。
 *     对象的行为（例如，`approve()` 方法）在不同状态下是完全不同的。
 *     `approve()` 在 `待审批` 状态下是有效的，但在 `草稿` 或 `已完成` 状态下则会抛出异常或无效。
 * 2.  **网络连接**: 一个TCP连接有 `Listening`, `Established`, `Closing`, `Closed` 等状态。
 *     根据当前状态，连接对象对 `open()`, `close()`, `send()` 等请求的响应也不同。
 * 3.  **GUI组件**: 一个按钮可以有 `Enabled`, `Disabled`, `Hovered` 等状态，
 *     它在不同状态下对点击事件的响应和外观都不同。
 * 4.  **自动售货机**: 如本例所示，售货机的行为（接受硬币、退回硬币、出货）完全取决于其当前状态
 *     （`无硬币`, `有硬币`, `售罄`）。
 */
public class Client {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(2); // Start with 2 items

        System.out.println("--- Test Case 1: Normal purchase ---");
        machine.insertCoin();
        machine.pressButton();

        System.out.println("\n--- Test Case 2: Trying to insert coin twice ---");
        machine.insertCoin();
        machine.insertCoin();
        machine.pressButton();

        System.out.println("\n--- Test Case 3: Buying the last item ---");
        machine.insertCoin();
        machine.pressButton();

        System.out.println("\n--- Test Case 4: Machine is sold out ---");
        machine.insertCoin();
        machine.pressButton();
    }
}
