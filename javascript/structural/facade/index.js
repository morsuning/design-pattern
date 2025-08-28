/**
 * 外观模式 (Facade)
 *
 * 目的:
 * 为子系统中的一组接口提供一个一致的界面。
 * 外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 *
 * 使用场景:
 * 1. 当你要为一个复杂子系统提供一个简单接口时。
 * 2. 当客户程序与抽象类的实现部分之间存在着很大的依赖性时。
 */

// --- 子系统角色 A ---
class SubsystemA {
    operationA() {
        console.log("SubsystemA: Performing operation A.");
    }
}

// --- 子系统角色 B ---
class SubsystemB {
    operationB() {
        console.log("SubsystemB: Performing operation B.");
    }
}

// --- 子系统角色 C ---
class SubsystemC {
    operationC() {
        console.log("SubsystemC: Performing operation C.");
    }
}

// --- 外观 (Facade) ---
class Facade {
    constructor() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
        this.subsystemC = new SubsystemC();
    }

    performComplexOperation() {
        console.log("Facade: Starting complex operation...");
        this.subsystemA.operationA();
        this.subsystemB.operationB();
        this.subsystemC.operationC();
        console.log("Facade: Complex operation finished.");
    }
}

// --- 客户端 ---
function client() {
    const facade = new Facade();
    console.log("--- Client requests complex operation ---");
    facade.performComplexOperation();
}

client();
