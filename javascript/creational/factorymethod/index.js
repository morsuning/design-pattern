/**
 * 工厂方法模式 (Factory Method)
 *
 * 目的:
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类。
 * 工厂方法使一个类的实例化延迟到其子类。
 *
 * 使用场景:
 * 1. 当一个类不知道它所必须创建的对象的类的时候。
 * 2. 当一个类希望由它的子类来指定它所创建的对象的时候。
 * 3. 当类将创建对象的职责委托给多个帮助子类中的某一个，并且你希望将哪一个帮助子类是代理者这一信息局部化的时候。
 */

// --- 抽象产品 (Product) ---
// 在 JavaScript 中，通常使用基类或鸭子类型（duck typing）来代替接口。
class Product {
    constructor() {
        if (new.target === Product) {
            throw new Error("Product is an abstract class and cannot be instantiated directly.");
        }
    }

    use() {
        throw new Error("Method 'use()' must be implemented.");
    }
}

// --- 具体产品 A (ConcreteProductA) ---
class ConcreteProductA extends Product {
    use() {
        console.log("Using ConcreteProductA.");
    }
}

// --- 具体产品 B (ConcreteProductB) ---
class ConcreteProductB extends Product {
    use() {
        console.log("Using ConcreteProductB.");
    }
}

// --- 抽象创建者 (Creator) ---
class Creator {
    constructor() {
        if (new.target === Creator) {
            throw new Error("Creator is an abstract class and cannot be instantiated directly.");
        }
    }

    /**
     * 抽象的工厂方法。
     * @returns {Product}
     */
    factoryMethod() {
        throw new Error("Method 'factoryMethod()' must be implemented.");
    }

    anOperation() {
        const product = this.factoryMethod();
        console.log("Creator's operation is using a product:");
        product.use();
    }
}

// --- 具体创建者 A (ConcreteCreatorA) ---
class ConcreteCreatorA extends Creator {
    factoryMethod() {
        console.log("ConcreteCreatorA is creating a ConcreteProductA.");
        return new ConcreteProductA();
    }
}

// --- 具体创建者 B (ConcreteCreatorB) ---
class ConcreteCreatorB extends Creator {
    factoryMethod() {
        console.log("ConcreteCreatorB is creating a ConcreteProductB.");
        return new ConcreteProductB();
    }
}

// --- 客户端 (Client) ---
function client() {
    console.log("--- Using Creator A ---");
    const creatorA = new ConcreteCreatorA();
    creatorA.anOperation();

    console.log("\n--- Using Creator B ---");
    const creatorB = new ConcreteCreatorB();
    creatorB.anOperation();
}

// 执行客户端代码
client();
