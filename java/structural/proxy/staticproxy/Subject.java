package structural.proxy;

/**
 * 主题接口 (Subject)
 * <p>
 * 定义了 RealSubject 和 Proxy 的共同接口。
 * 这样一来，在任何可以使用 RealSubject 的地方都可以使用 Proxy。
 */
public interface Subject {
    /**
     * 定义一个请求操作。
     */
    void request();
}