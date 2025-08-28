/**
 * 生成器模式 (Builder)
 *
 * 目的:
 * 将一个复杂对象的构建与其表示分离，使得同样的构建过程可以创建不同的表示。
 *
 * 使用场景:
 * 1. 当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时。
 * 2. 当构造过程必须允许被构造的对象有不同的表示时。
 * 3. 当你需要控制一个对象的创建过程，并且这个过程比较复杂时。
 */

// --- 产品类 (Product) ---
class Product {
    constructor() {
        this.parts = [];
    }

    addPart(part) {
        this.parts.push(part);
    }

    listParts() {
        console.log(`Product parts: ${this.parts.join(', ')}`);
    }
}

// --- 生成器接口 (Builder) ---
class Builder {
    constructor() {
        if (new.target === Builder) throw new Error("Abstract class");
    }
    buildPartA() {}
    buildPartB() {}
    buildPartC() {}
    getResult() {}
}

// --- 具体生成器 (ConcreteBuilder) ---
class ConcreteBuilder extends Builder {
    constructor() {
        super();
        this.product = new Product();
    }

    buildPartA() {
        this.product.addPart("PartA");
        console.log("Building Part A...");
    }

    buildPartB() {
        this.product.addPart("PartB");
        console.log("Building Part B...");
    }

    buildPartC() {
        this.product.addPart("PartC");
        console.log("Building Part C...");
    }

    getResult() {
        console.log("Product construction complete.");
        return this.product;
    }
}

// --- 指挥者 (Director) ---
class Director {
    construct(builder) {
        console.log("Director starts construction process...");
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}

// --- 客户端 (Client) ---
function client() {
    const director = new Director();
    const builder = new ConcreteBuilder();

    director.construct(builder);
    const product = builder.getResult();

    console.log("\nFinal Product Details:");
    product.listParts();
}

client();
