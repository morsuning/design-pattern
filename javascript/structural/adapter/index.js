/**
 * 适配器模式 (Adapter)
 *
 * 目的:
 * 将一个类的接口转换成客户希望的另外一个接口。
 * 适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 *
 * 使用场景:
 * 1. 当你想使用一个已经存在的类，而它的接口不符合你的需求时。
 * 2. 当你想创建一个可以复用的类，该类可以与其他不相关的类协同工作时。
 */

// --- 被适配者 (Adaptee) ---
// 这是一个拥有不兼容接口的类
class Adaptee {
    specificRequest() {
        return "Adaptee's specific request";
    }
}

// --- 目标接口 (Target) ---
// 这是客户端期望使用的接口
class Target {
    request() {
        return "Target's default request";
    }
}

// --- 适配器 (Adapter) ---
class Adapter extends Target {
    constructor(adaptee) {
        super();
        this.adaptee = adaptee;
    }

    request() {
        const result = this.adaptee.specificRequest();
        console.log("Adapter is converting the Adaptee's specific request.");
        return `Adapter: (TRANSLATED) ${result}`;
    }
}

// --- 客户端 ---
function client() {
    const adaptee = new Adaptee();
    console.log(`Adaptee has an incompatible interface: ${adaptee.specificRequest()}`);

    console.log("\nClient wants to use the Target interface.");
    const adapter = new Adapter(adaptee);
    const result = adapter.request();
    console.log(`Client received: ${result}`);
}

client();
