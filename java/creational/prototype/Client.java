package creational.prototype;

/**
 * 原型模式 (Prototype)
 *
 * 目的:
 * 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 *
 * 关键点: 深拷贝 vs 浅拷贝
 * - **浅拷贝 (Shallow Copy)**:
 *   - 只复制对象本身和其中的基本类型字段。
 *   - 对象内的引用类型字段只复制引用（内存地址），不复制引用的对象。
 *   - 结果：原对象和克隆对象共享同一个引用类型的实例。修改其中一个会影响另一个。
 *   - 实现：直接调用 `Object.clone()` 即可。
 *
 * - **深拷贝 (Deep Copy)**:
 *   - 复制对象本身和其中的基本类型字段。
 *   - 递归地复制对象内的所有引用类型字段所引用的对象。
 *   - 结果：原对象和克隆对象完全独立，互不影响。
 *   - 实现：在调用 `super.clone()` 后，需要手动对每个引用类型字段也调用 `clone()`。
 *
 * 使用场景:
 * 1.  **动态配置**: 当要实例化的类是在运行时动态指定时。
 * 2.  **性能优化**: 当创建对象的成本非常大（例如，从数据库加载大量数据或进行复杂计算），
 *     而我们有一个已创建的对象作为模板时，通过克隆来创建新对象会快得多。
 *     例如，游戏开发中复制一个复杂的敌人对象。
 * 3.  **避免与工厂模式并行的类层次**: 如果有一系列产品类，并且需要对应的工厂类来创建它们，
 *     使用原型模式，每个产品类自己实现 `clone()` 方法，就可以避免创建平行的工厂类层次。
 * 4.  **状态快照**: 需要保存对象的某个特定状态，之后可能需要恢复。原型模式可以创建一个状态快照。
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address initialAddress = new Address("123 Main St");
        ConcretePrototype original = new ConcretePrototype("Original", initialAddress);

        System.out.println("--- Original Object ---");
        System.out.println(original);

        // --- 演示浅拷贝 ---
        System.out.println("\n--- Shallow Clone Demonstration ---");
        ConcretePrototype shallowClone = original.shallowClone();
        System.out.println("Shallow Clone: " + shallowClone);

        // 修改浅拷贝对象的地址
        shallowClone.getAddress().setStreet("456 Side St");
        System.out.println("After modifying shallow clone's address:");
        System.out.println("Original Object: " + original);
        System.out.println("Shallow Clone:   " + shallowClone);
        System.out.println("Conclusion: Original object's address was also changed. They share the same Address instance.");

        // --- 演示深拷贝 ---
        // 恢复原对象的地址
        original.getAddress().setStreet("123 Main St");
        System.out.println("\n--- Deep Clone Demonstration ---");
        ConcretePrototype deepClone = original.deepClone();
        System.out.println("Deep Clone: " + deepClone);

        // 修改深拷贝对象的地址
        deepClone.getAddress().setStreet("789 Back St");
        System.out.println("After modifying deep clone's address:");
        System.out.println("Original Object: " + original);
        System.out.println("Deep Clone:      " + deepClone);
        System.out.println("Conclusion: Original object remains unchanged. They have independent Address instances.");
    }
}
