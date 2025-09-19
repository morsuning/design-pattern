package structural.proxy.staticproxy;

/**
 * 真实主题 (RealSubject)
 * <p>
 * 定义了 Proxy 所代表的真实实体。
 * 这是最终执行业务逻辑的类。
 */
public class RealSubject implements Subject {

    /**
     * 实现具体的业务逻辑。
     */
    @Override
    public void request() {
        System.out.println("RealSubject: Handling request.");
    }
}