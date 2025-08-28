package behavioral.command;

/**
 * 命令模式 (Command)
 *
 * 目的:
 * 将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；
 * 对请求排队或记录请求日志，以及支持可撤销的操作。
 *
 * 使用场景 (更具体的例子):
 * 1.  **GUI按钮和菜单**: 每个菜单项或工具栏按钮都可以是一个命令对象。
 *     这使得添加新的按钮变得容易，并且可以实现宏录制（将一系列命令记录下来并回放）。
 * 2.  **任务队列**: 在一个网络应用中，可以将客户端的请求封装成命令对象，放入一个队列中，
 *     由工作线程池异步地从队列中取出并执行。这实现了请求发送者和处理者的解耦。
 * 3.  **事务性操作**: 在数据库操作中，可以将一系列操作（insert, update, delete）封装成命令。
 *     如果事务失败，可以方便地对所有已执行的命令调用 `undo()` 方法来进行回滚。
 * 4.  **文本编辑器的撤销/重做**: 用户在编辑器中的每一个操作（打字、删除、格式化）都可以是一个命令对象。
 *     编辑器维护一个命令历史栈，撤销就是弹出并执行上一个命令的 `undo()` 方法，重做则是再次执行。
 */
public class Client {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        // 创建接收者
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // 创建命令
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);

        // 设置命令到遥控器插槽
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);

        System.out.println(remote);

        // 按下按钮
        remote.onButtonWasPushed(0);
        remote.offButtonWasPushed(0);
        System.out.println(remote);
        remote.undoButtonWasPushed();
        System.out.println(remote);

        remote.onButtonWasPushed(1);
        remote.offButtonWasPushed(1);
        remote.undoButtonWasPushed();
    }
}
