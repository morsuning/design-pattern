/**
 * 迭代器模式 (Iterator)
 *
 * 目的:
 * 提供一种方法顺序访问一个聚合对象中各个元素, 而又不需暴露该对象的内部表示。
 *
 * 使用场景:
 * 1. 当你需要访问一个聚合对象的内容而无需暴露它的内部表示时。
 * 2. 当你需要支持对聚合对象的多种遍历时。
 * 3. JavaScript 的可迭代协议 (Iterable protocol) 和 for...of 循环是此模式的现代原生实现。
 */

// --- 具体聚合 (ConcreteAggregate) ---
// 实现 JavaScript 的可迭代协议
class ConcreteAggregate {
    constructor() {
        this.items = [];
    }

    addItem(item) {
        this.items.push(item);
    }

    // 实现 [Symbol.iterator] 方法使该类成为可迭代对象
    [Symbol.iterator]() {
        let index = 0;
        const items = this.items;

        return {
            next: () => {
                if (index < items.length) {
                    return { value: items[index++], done: false };
                } else {
                    return { done: true };
                }
            }
        };
    }
}

// --- 客户端 ---
function client() {
    const aggregate = new ConcreteAggregate();
    aggregate.addItem("Item 1");
    aggregate.addItem("Item 2");
    aggregate.addItem("Item 3");

    console.log("--- Traversing the aggregate using for...of ---");
    // 使用 for...of 循环直接遍历，因为 aggregate 是可迭代的
    for (const item of aggregate) {
        console.log(`Processing: ${item}`);
    }
}

client();
