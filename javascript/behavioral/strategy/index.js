/**
 * 策略模式 (Strategy)
 *
 * 目的:
 * 定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。
 *
 * 使用场景:
 * 1. 当许多相关的类仅仅是行为有异时。
 * 2. 当需要使用一个算法的不同变体时。
 * 3. 当一个类定义了多种行为, 并且这些行为在这个类的操作中以多个条件语句的形式出现。
 */

// --- 策略接口 (Strategy) ---
class Strategy {
    doOperation(num1, num2) {}
}

// --- 具体策略 - 加法 ---
class ConcreteStrategyAdd extends Strategy {
    doOperation(num1, num2) {
        console.log(`Executing Add Strategy: ${num1} + ${num2}`);
        return num1 + num2;
    }
}

// --- 具体策略 - 减法 ---
class ConcreteStrategySubtract extends Strategy {
    doOperation(num1, num2) {
        console.log(`Executing Subtract Strategy: ${num1} - ${num2}`);
        return num1 - num2;
    }
}

// --- 上下文 (Context) ---
class Context {
    constructor(strategy) {
        this.strategy = strategy;
    }

    setStrategy(strategy) {
        console.log("\nContext: Changing strategy.");
        this.strategy = strategy;
    }

    executeStrategy(num1, num2) {
        return this.strategy.doOperation(num1, num2);
    }
}

// --- 客户端 ---
function client() {
    const context = new Context(new ConcreteStrategyAdd());
    console.log(`Result: ${context.executeStrategy(10, 5)}`);

    context.setStrategy(new ConcreteStrategySubtract());
    console.log(`Result: ${context.executeStrategy(10, 5)}`);
}

client();
