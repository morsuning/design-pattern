package creational.singleton.implementations;

/**
 * 单例模式 - 饿汉式 (Eager Initialization)
 * <p>
 * 优点:
 * 1. 实现简单。
 * 2. 线程安全。JVM在类加载时保证了实例的唯一性。
 * <p>
 * 缺点:
 * 1. 在类加载时就创建实例，即使从未使用过，也会占用内存。
 *    如果实例创建成本很高（例如，需要加载大量数据），这可能会导致启动缓慢。
 */
public class EagerSingleton {

    // 在类加载时就立即创建实例
    private static final EagerSingleton instance = new EagerSingleton();

    // 私有化构造函数
    private EagerSingleton() {}

    /**
     * 提供全局访问点
     * @return 单例的唯一实例
     */
    public static EagerSingleton getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from EagerSingleton!");
    }
}
