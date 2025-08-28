/**
 * 命令模式 (Command)
 *
 * 目的:
 * 将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；
 * 对请求排队或记录请求日志，以及支持可撤销的操作。
 *
 * 使用场景:
 * 1. 当你想参数化对象以一个动作时。
 * 2. 当你想将请求存入队列中，在不同的时刻指定、排队和执行请求。
 * 3. 当你想要支持撤销(undo)操作时。
 */

// --- 接收者 (Receiver) ---
class Light {
    constructor(location) {
        this.location = location;
    }
    on() {
        console.log(`${this.location} light is ON`);
    }
    off() {
        console.log(`${this.location} light is OFF`);
    }
}

// --- 命令接口 (Command) ---
class Command {
    execute() {}
    undo() {}
}

// --- 具体命令 - 开灯 ---
class LightOnCommand extends Command {
    constructor(light) {
        super();
        this.light = light;
    }
    execute() {
        this.light.on();
    }
    undo() {
        this.light.off();
    }
}

// --- 具体命令 - 关灯 ---
class LightOffCommand extends Command {
    constructor(light) {
        super();
        this.light = light;
    }
    execute() {
        this.light.off();
    }
    undo() {
        this.light.on();
    }
}

// --- 调用者 (Invoker) ---
class RemoteControl {
    constructor() {
        this.history = [];
    }
    setCommand(command) {
        this.command = command;
    }
    pressButton() {
        console.log("Invoker: Pressing button...");
        this.command.execute();
        this.history.push(this.command);
    }
    pressUndo() {
        if (this.history.length > 0) {
            console.log("Invoker: Pressing undo...");
            const lastCommand = this.history.pop();
            lastCommand.undo();
        }
    }
}

// --- 客户端 ---
function client() {
    const remote = new RemoteControl();
    const livingRoomLight = new Light("Living Room");
    const lightOn = new LightOnCommand(livingRoomLight);
    const lightOff = new LightOffCommand(livingRoomLight);

    remote.setCommand(lightOn);
    remote.pressButton();
    remote.setCommand(lightOff);
    remote.pressButton();
    remote.pressUndo();
}

client();
