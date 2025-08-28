package creational.singleton.implementations;

/**
 * 单例模式 - 静态内部类 (Initialization-on-demand holder idiom)
 * <p>
 * 优点:
 * 1. 实现了懒加载。实例只在第一次调用 getInstance() 时创建。
 * 2. 线程安全。JVM 保证了当一个类被初始化时，是线程安全的。
 * 3. 实现简单，代码清晰。
 * <p>
 * 这是目前推荐的懒加载单例实现方式。
 */
public class BillPughSingleton {

    private BillPughSingleton() {}

    /**
     * 静态内部类 SingletonHolder。
     * 这个类只有在 getInstance() 方法被第一次调用时才会被加载和初始化。
     */
    private static class SingletonHolder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello from BillPughSingleton!");
    }
}
