/**
 * 装饰器模式 (Decorator)
 *
 * 目的:
 * 动态地给一个对象添加一些额外的职责。
 * 就增加功能来说，装饰器模式相比生成子类更为灵活。
 *
 * 使用场景:
 * 1. 在不想增加很多子类的情况下，扩展一个类的功能。
 * 2. 动态地为一个对象增加功能，这些功能可以再动态地被撤销。
 */

// --- 组件接口 (Component) ---
class Component {
    operation() {
        throw new Error("Method 'operation()' must be implemented.");
    }
}

// --- 具体组件 (ConcreteComponent) ---
class ConcreteComponent extends Component {
    operation() {
        return "Executing operation in ConcreteComponent.";
    }
}

// --- 抽象装饰者 (Decorator) ---
class Decorator extends Component {
    constructor(component) {
        super();
        this.component = component;
    }

    operation() {
        return this.component.operation();
    }
}

// --- 具体装饰者 A ---
class ConcreteDecoratorA extends Decorator {
    operation() {
        const result = super.operation();
        return `${result} ...Behavior added by ConcreteDecoratorA.`;
    }
}

// --- 具体装饰者 B ---
class ConcreteDecoratorB extends Decorator {
    operation() {
        const result = super.operation();
        return `${result} ...Behavior added by ConcreteDecoratorB.`;
    }
}

// --- 客户端 ---
function client() {
    const component = new ConcreteComponent();
    console.log("--- Original Component ---");
    console.log(component.operation());

    const decoratorA = new ConcreteDecoratorA(component);
    console.log("\n--- Component decorated with DecoratorA ---");
    console.log(decoratorA.operation());

    const decoratorB = new ConcreteDecoratorB(decoratorA);
    console.log("\n--- Component decorated with DecoratorA and then DecoratorB ---");
    console.log(decoratorB.operation());
}

client();
