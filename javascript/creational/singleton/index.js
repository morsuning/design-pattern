/**
 * 单例模式 (Singleton)
 *
 * 目的:
 * 保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 *
 * 使用场景:
 * 1. 当类只能有一个实例而且客户可以从一个众所周知访问点访问它时。
 * 2. 对于需要频繁创建和销毁的对象，单例可以提高性能。
 * 3. 当需要一个全局对象来协调系统中的行为时，例如日志、配置等。
 */

class Singleton {
    constructor(data) {
        if (Singleton.instance) {
            return Singleton.instance;
        }
        this.data = data;
        Singleton.instance = this;
        console.log("Singleton instance created.");
    }

    static getInstance(data) {
        if (!Singleton.instance) {
            Singleton.instance = new Singleton(data);
        }
        return Singleton.instance;
    }

    showMessage() {
        console.log(`Hello from the Singleton instance! Data: ${this.data}`);
    }
}

// --- 客户端 ---
function client() {
    console.log("--- Singleton Pattern Demonstration ---");

    const s1 = Singleton.getInstance("DATA_1");
    s1.showMessage();

    const s2 = Singleton.getInstance("DATA_2");
    s2.showMessage();

    console.log("\n--- Verifying Instances ---");
    console.log(`Is s1 the same instance as s2? ${s1 === s2}`);
}

client();
