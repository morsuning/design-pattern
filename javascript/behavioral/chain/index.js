/**
 * 责任链模式 (Chain of Responsibility)
 *
 * 目的:
 * 使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。
 * 将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
 *
 * 使用场景:
 * 1. 当你有多个对象可以处理一个请求，而哪个对象处理该请求运行时刻自动确定。
 * 2. 当你想在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。
 */

// --- 抽象处理者 (Handler) ---
class Handler {
    constructor() {
        this.successor = null;
    }

    setSuccessor(successor) {
        this.successor = successor;
    }

    handleRequest(request) {
        throw new Error("Method 'handleRequest()' must be implemented.");
    }
}

// --- 具体处理者 1 ---
class ConcreteHandler1 extends Handler {
    handleRequest(request) {
        if (request >= 0 && request < 10) {
            console.log(`ConcreteHandler1 handled the request: ${request}`);
        } else if (this.successor) {
            console.log("ConcreteHandler1 cannot handle, passing to successor.");
            this.successor.handleRequest(request);
        }
    }
}

// --- 具体处理者 2 ---
class ConcreteHandler2 extends Handler {
    handleRequest(request) {
        if (request >= 10 && request < 20) {
            console.log(`ConcreteHandler2 handled the request: ${request}`);
        } else if (this.successor) {
            console.log("ConcreteHandler2 cannot handle, passing to successor.");
            this.successor.handleRequest(request);
        }
    }
}

// --- 客户端 ---
function client() {
    const handler1 = new ConcreteHandler1();
    const handler2 = new ConcreteHandler2();
    handler1.setSuccessor(handler2);

    const requests = [2, 5, 14, 22, 18];
    requests.forEach(request => {
        console.log(`
Client: Sending request -> ${request}`);
        handler1.handleRequest(request);
    });
}

client();
