/**
 * 代理模式 (Proxy)
 *
 * 目的:
 * 为其他对象提供一种代理以控制对这个对象的访问。
 *
 * 使用场景:
 * 1. 远程代理: 为一个对象在不同的地址空间提供局部代表。
 * 2. 虚拟代理: 根据需要创建开销很大的对象。
 * 3. 保护代理: 控制对原始对象的访问。
 * 4. ES6 提供了原生的 Proxy 对象，使得实现代理模式非常方便。
 */

// --- 真实主题 (RealSubject) ---
class RealSubject {
    request() {
        return "RealSubject: Handling request.";
    }
}

// --- 代理 (Proxy) ---
// 使用 ES6 Proxy 实现
const createProxy = (realSubject) => {
    return new Proxy(realSubject, {
        get(target, prop, receiver) {
            if (prop === 'request') {
                console.log("Proxy: Checking access permissions.");
                console.log("Proxy: Logging the request.");
                // 调用真实对象的方法
                const result = Reflect.get(target, prop, receiver).apply(target);
                console.log("Proxy: Request finished.");
                return result;
            }
            return Reflect.get(target, prop, receiver);
        }
    });
};

// --- 客户端 ---
function client() {
    console.log("--- Proxy Pattern Demonstration ---");
    const realSubject = new RealSubject();
    const proxy = createProxy(realSubject);

    console.log("\nClient: Making a request...");
    const result = proxy.request();
    console.log(`Client received: ${result}`);
}

client();
