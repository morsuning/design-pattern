/**
 * 中介者模式 (Mediator)
 *
 * 目的:
 * 用一个中介对象来封装一系列的对象交互。
 * 中介者使各个对象不需要显式地相互引用，从而使其耦合松散。
 *
 * 使用场景:
 * 1. 当一组对象以定义良好但复杂的方式进行通信时。
 * 2. 当一个对象引用其他很多对象并且直接与这些对象通信,导致难以复用该对象时。
 */

// --- 中介者 (Mediator) ---
// 在这个例子中，ChatRoom 是中介者
class ChatRoom {
    showMessage(user, message) {
        const time = new Date().toLocaleTimeString();
        console.log(`${time} [${user.name}]: ${message}`);
    }
}

// --- 同事类 (Colleague) ---
class User {
    constructor(name, chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    send(message) {
        this.chatRoom.showMessage(this, message);
    }
}

// --- 客户端 ---
function client() {
    const mediator = new ChatRoom();

    const john = new User("John", mediator);
    const jane = new User("Jane", mediator);

    console.log("--- Mediator Pattern Demonstration ---");
    john.send("Hi there!");
    jane.send("Hey!");
}

client();
