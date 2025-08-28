/**
 * 组合模式 (Composite)
 *
 * 目的:
 * 将对象组合成树形结构以表示“部分-整体”的层次结构。
 * 组合模式使得用户对单个对象和组合对象的使用具有一致性。
 *
 * 使用场景:
 * 1. 当你想表示对象的部分-整体层次结构时。
 * 2. 当你希望用户忽略组合对象与单个对象的不同，统一地使用组合结构中的所有对象。
 */

// --- 组件 (Component) ---
class Component {
    constructor(name) {
        this.name = name;
    }

    operation() {
        throw new Error("Method 'operation()' must be implemented.");
    }

    add(component) {
        throw new Error("Cannot add to a leaf component.");
    }

    remove(component) {
        throw new Error("Cannot remove from a leaf component.");
    }
}

// --- 叶子 (Leaf) ---
class Leaf extends Component {
    operation() {
        console.log(`Executing operation on Leaf: ${this.name}`);
    }
}

// --- 复合组件 (Composite) ---
class Composite extends Component {
    constructor(name) {
        super(name);
        this.children = [];
    }

    operation() {
        console.log(`Executing operation on Composite: ${this.name}`);
        this.children.forEach(child => child.operation());
    }

    add(component) {
        this.children.push(component);
        console.log(`Added ${component.name} to ${this.name}`);
    }

    remove(component) {
        const index = this.children.indexOf(component);
        if (index !== -1) {
            this.children.splice(index, 1);
            console.log(`Removed ${component.name} from ${this.name}`);
        }
    }
}

// --- 客户端 ---
function client() {
    const root = new Composite("Root");
    const leaf1 = new Leaf("Leaf-1");
    const leaf2 = new Leaf("Leaf-2");
    const subComposite = new Composite("SubComposite-A");
    const leaf3 = new Leaf("Leaf-3");

    console.log("--- Building the tree structure ---");
    root.add(leaf1);
    root.add(subComposite);
    subComposite.add(leaf2);
    subComposite.add(leaf3);

    console.log("\n--- Executing operation on the entire tree ---");
    root.operation();

    console.log("\n--- Removing a leaf ---");
    subComposite.remove(leaf2);
    root.operation();
}

client();
