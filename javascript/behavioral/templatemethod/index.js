/**
 * 模板方法模式 (Template Method)
 *
 * 目的:
 * 在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。
 *
 * 使用场景:
 * 1. 当你想一次性实现一个算法的不变的部分，并将可变的行为留给子类来实现时。
 * 2. 当各个子类中公共的行为应被提取出来并集中到一个公共父类中以避免代码重复时。
 */

// --- 抽象类 (AbstractClass) ---
class Game {
    constructor() {
        if (new.target === Game) throw new Error("Abstract class");
    }

    initialize() {}
    startPlay() {}
    endPlay() {}

    // 模板方法
    play() {
        this.initialize();
        this.startPlay();
        this.endPlay();
    }
}

// --- 具体类 - Cricket ---
class Cricket extends Game {
    initialize() {
        console.log("Cricket Game Initialized.");
    }
    startPlay() {
        console.log("Cricket Game Started.");
    }
    endPlay() {
        console.log("Cricket Game Finished.");
    }
}

// --- 具体类 - Football ---
class Football extends Game {
    initialize() {
        console.log("Football Game Initialized.");
    }
    startPlay() {
        console.log("Football Game Started.");
    }
    endPlay() {
        console.log("Football Game Finished.");
    }
}

// --- 客户端 ---
function client() {
    console.log("--- Playing Cricket Game ---");
    const cricket = new Cricket();
    cricket.play();

    console.log("\n--- Playing Football Game ---");
    const football = new Football();
    football.play();
}

client();
