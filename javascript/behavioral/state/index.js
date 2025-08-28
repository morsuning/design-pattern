/**
 * 状态模式 (State)
 *
 * 目的:
 * 允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类。
 *
 * 使用场景:
 * 1. 当一个对象的行为取决于它的状态，并且它必须在运行时刻根据状态改变它的行为时。
 * 2. 当一个操作中含有庞大的多分支的条件语句，且这些分支依赖于该对象的状态时。
 */

// --- 状态接口 (State) ---
class State {
    handle(context) {}
}

// --- 具体状态 A ---
class ConcreteStateA extends State {
    handle(context) {
        console.log("Handling request in ConcreteStateA.");
        context.setState(new ConcreteStateB());
    }
}

// --- 具体状态 B ---
class ConcreteStateB extends State {
    handle(context) {
        console.log("Handling request in ConcreteStateB.");
        context.setState(new ConcreteStateA());
    }
}

// --- 上下文 (Context) ---
class Context {
    constructor(initialState) {
        this.state = initialState;
        console.log(`Context created with initial state: ${initialState.constructor.name}`);
    }

    setState(state) {
        console.log(`Context: Transitioning to state -> ${state.constructor.name}`);
        this.state = state;
    }

    request() {
        console.log("\nContext: Handling request...");
        this.state.handle(this);
    }
}

// --- 客户端 ---
function client() {
    const context = new Context(new ConcreteStateA());
    context.request();
    context.request();
    context.request();
}

client();
