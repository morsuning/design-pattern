/**
 * 享元模式 (Flyweight)
 *
 * 目的:
 * 运用共享技术有效地支持大量细粒度的对象。
 *
 * 使用场景:
 * 1. 当一个应用程序使用了大量的对象，造成很大的存储开销时。
 * 2. 对象的大多数状态都可变为外部状态。
 */

// --- 享元接口 (Flyweight) ---
class Flyweight {
    operation(extrinsicState) {
        throw new Error("Method 'operation()' must be implemented.");
    }
}

// --- 具体享元 (ConcreteFlyweight) ---
class ConcreteFlyweight extends Flyweight {
    constructor(intrinsicState) {
        super();
        this.intrinsicState = intrinsicState;
        console.log(`Creating ConcreteFlyweight with intrinsic state: ${intrinsicState}`);
    }

    operation(extrinsicState) {
        console.log(`ConcreteFlyweight -> Intrinsic: '${this.intrinsicState}', Extrinsic: '${extrinsicState}'`);
    }
}

// --- 享元工厂 (FlyweightFactory) ---
class FlyweightFactory {
    constructor() {
        this.flyweights = {};
    }

    getFlyweight(key) {
        if (!this.flyweights[key]) {
            console.log(`FlyweightFactory: Flyweight with key '${key}' not found, creating a new one.`);
            this.flyweights[key] = new ConcreteFlyweight(key);
        } else {
            console.log(`FlyweightFactory: Reusing existing Flyweight with key '${key}'.`);
        }
        return this.flyweights[key];
    }

    getFlyweightsCount() {
        return Object.keys(this.flyweights).length;
    }
}

// --- 客户端 ---
function client() {
    const factory = new FlyweightFactory();
    const colors = ["Red", "Green", "Blue"];

    console.log("--- Creating and using flyweights ---");
    for (let i = 0; i < 10; i++) {
        const color = colors[Math.floor(Math.random() * colors.length)];
        const flyweight = factory.getFlyweight(color);
        flyweight.operation(`Position(${i}, ${i * 2})`);
    }

    console.log(`\nTotal number of flyweight objects created: ${factory.getFlyweightsCount()}`);
}

client();
