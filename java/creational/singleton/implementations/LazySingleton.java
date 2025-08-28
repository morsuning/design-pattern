package creational.singleton.implementations;

/**
 * 单例模式 - 懒汉式 (线程安全)
 * <p>
 * 优点:
 * 1. 实现了懒加载，只在第一次调用时才创建实例。
 * 2. 通过 synchronized 关键字保证了线程安全。
 * <p>
 * 缺点:
 * 1. 性能开销大。无论实例是否已创建，每次调用 getInstance() 都会触发同步，
 *    这在多线程高并发环境下会导致性能瓶颈。
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {}

    /**
     * 提供全局访问点。
     * 使用 synchronized 关键字确保在多线程环境下只有一个线程能进入此方法。
     *
     * @return 单例的唯一实例
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from LazySingleton!");
    }
}
