/**
 * 观察者模式 (Observer)
 *
 * 目的:
 * 定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 *
 * 使用场景:
 * 1. 当一个对象的改变需要同时改变其它对象，而不知道具体有多少对象有待改变。
 * 2. 当一个对象必须通知其它对象，而它又不能假定其它对象是谁。
 */

// --- 主题 (Subject / Publisher) ---
class Subject {
    constructor() {
        this.observers = [];
    }

    attach(observer) {
        this.observers.push(observer);
        console.log("Attached an observer.");
    }

    detach(observer) {
        this.observers = this.observers.filter(obs => obs !== observer);
        console.log("Detached an observer.");
    }

    notify(data) {
        console.log("Subject: Notifying observers...");
        this.observers.forEach(observer => observer.update(data));
    }
}

// --- 观察者 (Observer / Subscriber) ---
class Observer {
    constructor(name) {
        this.name = name;
    }
    update(data) {
        console.log(`Observer '${this.name}': Received update. New data is -> ${data}`);
    }
}

// --- 客户端 ---
function client() {
    const subject = new Subject();
    const observerA = new Observer("Observer-A");
    const observerB = new Observer("Observer-B");

    subject.attach(observerA);
    subject.attach(observerB);

    console.log("\n--- Subject's state is changing ---");
    subject.notify("NEW_DATA_1");

    subject.detach(observerA);
    console.log("\n--- Subject's state is changing again ---");
    subject.notify("NEW_DATA_2");
}

client();
