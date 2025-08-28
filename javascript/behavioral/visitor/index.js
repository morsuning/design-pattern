/**
 * 访问者模式 (Visitor)
 *
 * 目的:
 * 表示一个作用于某对象结构中的各元素的操作。
 * 它使你可以在不改变各元素的类的前提下，定义作用于这些元素的新操作。
 *
 * 使用场景:
 * 1. 当一个对象结构包含许多类对象，它们有不同的接口，而你想对这些对象实施一些依赖于其具体类的操作时。
 * 2. 当需要对一个对象结构中的对象进行很多不同的并且不相关的操作时。
 */

// --- 访问者接口 (Visitor) ---
class Visitor {
    visit(element) {}
}

// --- 具体访问者 ---
class ConcreteVisitor extends Visitor {
    visit(element) {
        console.log(`Visitor is visiting ${element.constructor.name}: ${element.getName()}`);
    }
}

// --- 元素接口 (Element) ---
class Element {
    constructor(name) {
        this.name = name;
    }
    getName() {
        return this.name;
    }
    accept(visitor) {}
}

// --- 具体元素 A ---
class ConcreteElementA extends Element {
    accept(visitor) {
        visitor.visit(this);
    }
}

// --- 具体元素 B ---
class ConcreteElementB extends Element {
    accept(visitor) {
        visitor.visit(this);
    }
}

// --- 对象结构 ---
class ObjectStructure {
    constructor() {
        this.elements = [];
    }

    attach(element) {
        this.elements.push(element);
    }

    accept(visitor) {
        this.elements.forEach(element => element.accept(visitor));
    }
}

// --- 客户端 ---
function client() {
    const structure = new ObjectStructure();
    structure.attach(new ConcreteElementA("ElementA"));
    structure.attach(new ConcreteElementB("ElementB"));

    const visitor = new ConcreteVisitor();
    structure.accept(visitor);
}

client();
