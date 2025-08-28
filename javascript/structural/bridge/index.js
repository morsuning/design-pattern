/**
 * 桥接模式 (Bridge)
 *
 * 目的:
 * 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 *
 * 使用场景:
 * 1. 当你不想在抽象和它的实现之间形成一个固定的绑定时。
 * 2. 当类的抽象以及它的实现都应该可以通过生成子类的方法加以扩充时。
 * 3. 如果一个类有多个维度的变化，希望避免使用多层继承导致子类数量爆炸性增长。
 */

// --- 实现者接口 (Implementor) ---
class Implementor {
    operationImpl() {
        throw new Error("Method 'operationImpl()' must be implemented.");
    }
}

// --- 具体实现者 A ---
class ConcreteImplementorA extends Implementor {
    operationImpl() {
        console.log("Executing operation in ConcreteImplementorA.");
    }
}

// --- 具体实现者 B ---
class ConcreteImplementorB extends Implementor {
    operationImpl() {
        console.log("Executing operation in ConcreteImplementorB.");
    }
}

// --- 抽象部分 (Abstraction) ---
class Abstraction {
    constructor(implementor) {
        if (!(implementor instanceof Implementor)) {
            throw new Error("implementor must be an instance of Implementor");
        }
        this.implementor = implementor;
    }

    operation() {
        throw new Error("Method 'operation()' must be implemented.");
    }
}

// --- 扩充抽象类 (RefinedAbstraction) ---
class RefinedAbstraction extends Abstraction {
    operation() {
        console.log("RefinedAbstraction is performing an operation.");
        this.implementor.operationImpl();
    }
}

// --- 客户端 ---
function client() {
    console.log("--- Bridge Pattern Demonstration ---");

    const implementorA = new ConcreteImplementorA();
    const abstractionA = new RefinedAbstraction(implementorA);
    console.log("\nConfiguring Abstraction with ConcreteImplementorA...");
    abstractionA.operation();

    console.log("-------------------------------------");

    const implementorB = new ConcreteImplementorB();
    const abstractionB = new RefinedAbstraction(implementorB);
    console.log("\nConfiguring Abstraction with ConcreteImplementorB...");
    abstractionB.operation();
}

client();
