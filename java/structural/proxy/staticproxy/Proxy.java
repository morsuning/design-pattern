package structural.proxy.staticproxy;

/**
 * 代理 (Proxy)
 * <p>
 * 1. 保存一个引用使得代理可以访问实体，并提供一个与 Subject 的接口相同的接口，这样代理就可以用来替代实体。
 * 2. 控制对实体的存取，并可能负责创建和删除它。
 * 3. 其他功能依赖于代理的类型，例如：
 *    - 远程代理 (Remote Proxy) 负责对请求及其参数进行编码，并向不同地址空间中的实体发送已编码的请求。
 *    - 虚拟代理 (Virtual Proxy) 缓存实体的附加信息，以便延迟对它的访问。
 *    - 保护代理 (Protection Proxy) 检查调用者是否具有实现一个请求所必需的访问权限。
 */
public class Proxy implements Subject {

    private RealSubject realSubject;

    /**
     * 在代理的 request 方法中，可以执行一些额外的操作，
     * 例如权限检查、日志记录、缓存或延迟初始化。
     */
    @Override
    public void request() {
        // 延迟初始化：只在第一次调用 request 时才创建 RealSubject 实例。
        // 这对于创建成本高的对象很有用。
        if (realSubject == null) {
            System.out.println("Proxy: Creating a new RealSubject instance.");
            realSubject = new RealSubject();
        }

        // 执行请求前的操作
        if (checkAccess()) {
            System.out.println("Proxy: Access granted. Forwarding request to RealSubject.");
            // 将请求转发给真实主题
            realSubject.request();
            // 执行请求后的操作
            logAccess();
        }
    }

    /**
     * 示例：权限检查
     * @return 如果有权限则返回 true，否则返回 false。
     */
    private boolean checkAccess() {
        System.out.println("Proxy: Checking access permissions prior to firing a real request.");
        // 在实际应用中，这里会包含复杂的权限验证逻辑。
        return true;
    }

    /**
     * 示例：日志记录
     */
    private void logAccess() {
        System.out.println("Proxy: Logging the time of request.");
    }
}