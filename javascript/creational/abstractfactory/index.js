/**
 * 抽象工厂模式 (Abstract Factory)
 *
 * 目的:
 * 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 *
 * 使用场景:
 * 1. 当一个系统需要独立于其产品的创建、组合和表示时。
 * 2. 当一个系统要由多个产品系列中的一个来配置时。
 * 3. 当你想要提供一个产品类库，而只想暴露它们的接口而不是实现时。
 */

// --- 抽象产品 A ---
class ProductA {
    constructor() {
        if (new.target === ProductA) throw new Error("Abstract class");
    }
    operationA() {
        throw new Error("Method 'operationA()' must be implemented.");
    }
}

// --- 具体产品 A1 ---
class ConcreteProductA1 extends ProductA {
    operationA() {
        console.log("ConcreteProductA1 operationA executed.");
    }
}

// --- 具体产品 A2 ---
class ConcreteProductA2 extends ProductA {
    operationA() {
        console.log("ConcreteProductA2 operationA executed.");
    }
}

// --- 抽象产品 B ---
class ProductB {
    constructor() {
        if (new.target === ProductB) throw new Error("Abstract class");
    }
    operationB() {
        throw new Error("Method 'operationB()' must be implemented.");
    }
}

// --- 具体产品 B1 ---
class ConcreteProductB1 extends ProductB {
    operationB() {
        console.log("ConcreteProductB1 operationB executed.");
    }
}

// --- 具体产品 B2 ---
class ConcreteProductB2 extends ProductB {
    operationB() {
        console.log("ConcreteProductB2 operationB executed.");
    }
}

// --- 抽象工厂 ---
class AbstractFactory {
    constructor() {
        if (new.target === AbstractFactory) throw new Error("Abstract class");
    }
    createProductA() {
        throw new Error("Method 'createProductA()' must be implemented.");
    }
    createProductB() {
        throw new Error("Method 'createProductB()' must be implemented.");
    }
}

// --- 具体工厂 1 ---
class ConcreteFactory1 extends AbstractFactory {
    createProductA() {
        return new ConcreteProductA1();
    }
    createProductB() {
        return new ConcreteProductB1();
    }
}

// --- 具体工厂 2 ---
class ConcreteFactory2 extends AbstractFactory {
    createProductA() {
        return new ConcreteProductA2();
    }
    createProductB() {
        return new ConcreteProductB2();
    }
}

// --- 客户端 ---
function client() {
    console.log("--- Using Factory 1 ---");
    const factory1 = new ConcreteFactory1();
    const productA1 = factory1.createProductA();
    const productB1 = factory1.createProductB();
    productA1.operationA();
    productB1.operationB();

    console.log("\n--- Using Factory 2 ---");
    const factory2 = new ConcreteFactory2();
    const productA2 = factory2.createProductA();
    const productB2 = factory2.createProductB();
    productA2.operationA();
    productB2.operationB();
}

client();
