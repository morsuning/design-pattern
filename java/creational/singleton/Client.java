package creational.singleton;

import creational.singleton.implementations.*;

/**
 * 单例模式 (Singleton)
 *
 * 目的:
 * 保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 *
 * 使用场景 (更具体的例子):
 * 1.  **日志记录器 (Logger)**: 在一个应用中，通常只需要一个日志记录器实例来集中管理所有日志的写入。
 * 2.  **配置管理器 (Configuration Manager)**: 读取和存储应用配置的类，在整个应用生命周期中只需要一个实例来确保配置的一致性。
 * 3.  **数据库连接池 (Database Connection Pool)**: 管理数据库连接的池，创建和销毁连接的成本很高，因此通常设计为单例以复用连接。
 * 4.  **线程池 (Thread Pool)**: 类似于连接池，用于管理和复用线程。
 * 5.  **硬件访问**: 访问打印机、图形卡等硬件资源的类，因为硬件本身是单一的，所以通常用单例模式来管理。
 * 6.  **Spring框架中的Bean**: Spring容器默认将Bean创建为单例作用域（Singleton Scope）。
 *
 * 实现方式对比:
 * - **饿汉式 (EagerSingleton)**:
 *   - **优点**: 简单、线程安全。
 *   - **缺点**: 不支持懒加载，可能造成资源浪费。
 *   - **适用**: 实例创建成本不高，且一定会被使用。
 *
 * - **懒汉式 (LazySingleton)**:
 *   - **优点**: 支持懒加载。
 *   - **缺点**: 使用 synchronized 关键字导致性能开销大，不推荐在高并发下使用。
 *
 * - **双重检查锁定 (DoubleCheckedLockingSingleton)**:
 *   - **优点**: 懒加载、线程安全且性能较高。
 *   - **缺点**: 实现复杂，需要理解 volatile 的作用。
 *   - **适用**: 在需要懒加载且关注性能的场景。
 *
 * - **静态内部类 (BillPughSingleton)**:
 *   - **优点**: 懒加载、线程安全、实现简单。利用了类加载机制来保证线程安全。
 *   - **结论**: **推荐的懒加载实现方式**。
 *
 * - **枚举 (EnumSingleton)**:
 *   - **优点**: 最简洁、线程安全，并且能天然防止反射和序列化攻击。
 *   - **缺点**: 不支持懒加载。
 *   - **结论**: **推荐的非懒加载实现方式**，尤其是在需要序列化或防止反射攻击时。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- Singleton Pattern Demonstration ---");

        System.out.println("\n--- Eager Singleton ---");
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println("Are instances the same? " + (eager1 == eager2));
        eager1.showMessage();

        System.out.println("\n--- Lazy Singleton (Thread-Safe) ---");
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println("Are instances the same? " + (lazy1 == lazy2));
        lazy1.showMessage();

        System.out.println("\n--- Double-Checked Locking Singleton ---");
        DoubleCheckedLockingSingleton dcl1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton dcl2 = DoubleCheckedLockingSingleton.getInstance();
        System.out.println("Are instances the same? " + (dcl1 == dcl2));
        dcl1.showMessage();

        System.out.println("\n--- Bill Pugh (Static Inner Class) Singleton ---");
        BillPughSingleton bp1 = BillPughSingleton.getInstance();
        BillPughSingleton bp2 = BillPughSingleton.getInstance();
        System.out.println("Are instances the same? " + (bp1 == bp2));
        bp1.showMessage();

        System.out.println("\n--- Enum Singleton ---");
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;
        System.out.println("Are instances the same? " + (enum1 == enum2));
        enum1.showMessage();
    }
}
