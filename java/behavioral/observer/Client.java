package behavioral.observer;

/**
 * 观察者模式 (Observer)
 *
 * 目的:
 * 定义对象间的一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 *
 * 三种实现对比:
 *
 * 1. 经典手动实现 (Classic):
 *    - **结构**: 手动创建 Subject 和 Observer 接口。
 *    - **优点**: 概念清晰，易于理解模式的核心思想。
 *    - **缺点**: 需要自己管理观察者列表和通知逻辑，容易出错。
 *
 * 2. Java内置实现 (Built-in - `java.util.Observer`):
 *    - **结构**: 主题继承 `java.util.Observable`，观察者实现 `java.util.Observer`。
 *    - **优点**: 无需自己管理观察者列表。
 *    - **缺点**:
 *      - `Observable` 是一个类而不是接口，限制了主题类不能再继承其他类。
 *      - `setChanged()` 方法是 protected 的，需要子类化才能调用，不够灵活。
 *      - 在 Java 9 中已被废弃 (deprecated)，不推荐在新代码中使用。
 *
 * 3. 现代Java实现 (Modern - `java.beans.PropertyChangeListener`):
 *    - **结构**: 主题使用 `PropertyChangeSupport` 辅助类来管理监听器和触发事件。观察者实现 `PropertyChangeListener`。
 *    - **优点**:
 *      - 遵循JavaBeans规范，是组件之间通信的标准方式。
 *      - `PropertyChangeSupport` 是一个辅助类（通过组合使用），不限制主题的继承结构。
 *      - 事件对象 `PropertyChangeEvent` 可以携带更丰富的信息（属性名、旧值、新值）。
 *    - **结论**: **推荐在现代Java应用中使用**，尤其是在GUI和JavaBeans环境中。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- 1. Classic Observer Demonstration ---");
        demonstrateClassicObserver();

        System.out.println("\n\n--- 2. Built-in Java Observer Demonstration ---");
        demonstrateBuiltInObserver();

        System.out.println("\n\n--- 3. Modern Java Observer (PropertyChangeListener) Demonstration ---");
        demonstrateModernObserver();
    }

    private static void demonstrateClassicObserver() {
        behavioral.observer.classic.NewsAgency agency = new behavioral.observer.classic.NewsAgency();
        behavioral.observer.classic.NewsChannel channel1 = new behavioral.observer.classic.NewsChannel("Channel 1 (Classic)");
        agency.register(channel1);
        agency.setNews("Classic news!");
    }

    @SuppressWarnings("deprecation")
    private static void demonstrateBuiltInObserver() {
        behavioral.observer.builtin.NewsAgency agency = new behavioral.observer.builtin.NewsAgency();
        behavioral.observer.builtin.NewsChannel channel1 = new behavioral.observer.builtin.NewsChannel("Channel 2 (Built-in)");
        agency.addObserver(channel1);
        agency.setNews("Built-in news!");
    }

    private static void demonstrateModernObserver() {
        behavioral.observer.modern.NewsAgency agency = new behavioral.observer.modern.NewsAgency();
        behavioral.observer.modern.NewsChannel channel1 = new behavioral.observer.modern.NewsChannel("Channel 3 (Modern)");
        agency.addPropertyChangeListener(channel1);
        agency.setNews("Modern news!");
    }
}
