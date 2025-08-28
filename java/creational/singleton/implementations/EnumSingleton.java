package creational.singleton.implementations;

/**
 * 单例模式 - 枚举 (Enum Singleton)
 * <p>
 * 优点:
 * 1. 实现最简洁。
 * 2. 线程安全。由 JVM 从根本上保证。
 * 3. 能有效防止通过反射或序列化/反序列化创建新实例的攻击。
 * <p>
 * 缺点:
 * 1. 不支持懒加载。
 * <p>
 * 这是《Effective Java》作者 Joshua Bloch 推荐的最佳单例实现方式。
 */
public enum EnumSingleton {
    INSTANCE;

    public void showMessage() {
        System.out.println("Hello from EnumSingleton!");
    }
}
