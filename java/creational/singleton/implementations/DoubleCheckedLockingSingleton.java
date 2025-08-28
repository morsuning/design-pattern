package creational.singleton.implementations;

/**
 * 单例模式 - 双重检查锁定 (Double-Checked Locking)
 * <p>
 * 优点:
 * 1. 实现了懒加载。
 * 2. 线程安全。
 * 3. 性能较高。通过减少同步代码块的范围，避免了每次调用都进行同步。
 * <p>
 * 缺点:
 * 1. 实现相对复杂。需要正确使用 volatile 关键字防止指令重排。
 */
public class DoubleCheckedLockingSingleton {

    // volatile 关键字确保多线程环境下的可见性和禁止指令重排
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {}

    public static DoubleCheckedLockingSingleton getInstance() {
        // 第一次检查
        if (instance == null) {
            // 同步块
            synchronized (DoubleCheckedLockingSingleton.class) {
                // 第二次检查
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

     public void showMessage() {
        System.out.println("Hello from DoubleCheckedLockingSingleton!");
    }
}
