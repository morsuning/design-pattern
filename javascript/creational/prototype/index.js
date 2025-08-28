/**
 * 原型模式 (Prototype) 
 *
 * 目的:
 * 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 *
 * 使用场景:
 * 1. 当一个系统应该独立于它的产品创建、构成和表示时。
 * 2. 当要实例化的类是在运行时指定时。
 * 3. 当创建对象的成本很大时，通过克隆现有对象可以提高性能。
 */

// --- 原型类 ---
// JavaScript 的原型继承机制天然地支持此模式。
class Prototype {
    constructor(name) {
        this.name = name;
    }

    clone() {
        // 创建当前对象的浅拷贝
        return Object.assign(Object.create(Object.getPrototypeOf(this)), this);
    }

    display() {
        console.log(`This is Prototype: ${this.name}`);
    }
}

// --- 客户端 ---
function client() {
    const original = new Prototype("Original");
    console.log("--- Original Instance ---");
    original.display();

    const clone1 = original.clone();
    clone1.name = "Clone 1";
    console.log("\n--- Cloned Instance 1 ---");
    clone1.display();

    const clone2 = original.clone();
    clone2.name = "Clone 2";
    console.log("\n--- Cloned Instance 2 ---");
    clone2.display();

    console.log("\n--- Verifying Instances ---");
    console.log(`Is 'original' the same instance as 'clone1'? ${original === clone1}`);
}

client();
