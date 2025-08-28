package structural.proxy;

import structural.proxy.dynamicproxy.LoggingInvocationHandler;
import structural.proxy.staticproxy.Internet;
import structural.proxy.staticproxy.ProxyInternet;
import structural.proxy.staticproxy.RealInternet;

import java.lang.reflect.Proxy;

/**
 * 代理模式 (Proxy)
 *
 * 目的:
 * 为其他对象提供一种代理以控制对这个对象的访问。
 *
 * 两种主要实现对比:
 *
 * 1. 静态代理 (Static Proxy):
 *    - **结构**: 代理类在编译时就已经创建。代理类和真实主题类都实现同一个接口。
 *    - **优点**: 实现简单，易于理解。
 *    - **缺点**: 不灵活。如果接口增加一个方法，代理类和真实主题类都需要修改。
 *              对于每一个需要代理的真实主题类，都需要创建一个对应的代理类，导致类数量增多。
 *    - **适用**: 需要代理的类数量较少，且接口不经常变动。
 *
 * 2. 动态代理 (Dynamic Proxy):
 *    - **结构**: 代理类是在运行时动态生成的。通过 `java.lang.reflect.Proxy` 和 `InvocationHandler` 实现。
 *    - **优点**: 非常灵活。一个 `InvocationHandler` 可以代理实现了任意接口的多个对象，
 *              无需为每个真实主题类手动创建代理类。接口变动时，通常也无需修改代理逻辑。
 *    - **缺点**: 实现相对复杂，需要理解反射机制，且性能略低于静态代理。
 *    - **适用**:
 *      - 当需要代理的接口或类非常多时。
 *      - 需要为不同对象提供通用代理逻辑（如日志、事务、权限控制）时。
 *      - Spring AOP (Aspect-Oriented Programming) 和 RPC (Remote Procedure Call) 框架大量使用了动态代理。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- 1. Static Proxy Demonstration (Protection Proxy) ---");
        demonstrateStaticProxy();

        System.out.println("\n\n--- 2. Dynamic Proxy Demonstration (Logging Proxy) ---");
        demonstrateDynamicProxy();
    }

    private static void demonstrateStaticProxy() {
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("google.com");
            internet.connectTo("banned.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void demonstrateDynamicProxy() {
        // 1. 创建真实对象
        Internet realInternet = new RealInternet();

        // 2. 创建 InvocationHandler
        LoggingInvocationHandler handler = new LoggingInvocationHandler(realInternet);

        // 3. 使用 Proxy.newProxyInstance 创建动态代理对象
        Internet proxy = (Internet) Proxy.newProxyInstance(
                Internet.class.getClassLoader(),
                new Class<?>[]{Internet.class},
                handler
        );

        // 4. 通过代理调用方法
        try {
            proxy.connectTo("dynamic.google.com");
        } catch (Exception e) {
            // This dynamic proxy doesn't throw exceptions, but we keep the catch block for consistency
            System.out.println(e.getMessage());
        }
    }
}
