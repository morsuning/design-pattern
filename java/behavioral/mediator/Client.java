package behavioral.mediator;

/**
 * 中介者模式 (Mediator)
 *
 * 目的:
 * 用一个中介对象来封装一系列的对象交互。
 * 中介者使各个对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 *
 * 使用场景 (更具体的例子):
 * 1.  **GUI开发**: 一个对话框（Dialog）对象可以作为其中所有UI控件（Button, TextField, Checkbox）的中介者。
 *     当一个控件的状态改变时（例如，用户在文本框输入内容），它通知对话框，
 *     对话框再根据业务逻辑决定是否需要启用/禁用其他控件（例如，启用“提交”按钮）。
 *     这避免了所有控件之间复杂的直接依赖。
 * 2.  **航空交通管制**: 塔台（中介者）协调多架飞机（同事）的起飞和降落，
 *     飞机之间不直接通信，只与塔台通信。
 * 3.  **多人聊天室**: 如本例所示，聊天室服务器是中介者，用户是同事。
 *     用户发送消息给服务器，服务器再广播给房间里的其他用户。
 * 4.  **MVC框架**: 在某些MVC实现中，控制器(Controller)扮演了模型(Model)和视图(View)之间的中介者角色，
 *     处理两者之间的所有交互。
 */
public class Client {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatRoom();

        User user1 = new ChatUser(mediator, "Alice");
        User user2 = new ChatUser(mediator, "Bob");
        User user3 = new ChatUser(mediator, "Charlie");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user1.send("Hi everyone!");
    }
}
