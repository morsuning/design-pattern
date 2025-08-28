package creational.factorymethod;

/**
 * 抽象创建者 (Creator)
 * <p>
 * 声明了工厂方法 factoryMethod()，该方法返回一个 Product 类型的对象。
 * Creator 也可以定义一个 factoryMethod() 的默认实现，它返回一个默认的 ConcreteProduct 对象。
 * Creator 还可以调用工厂方法以创建一个 Product 对象。
 */
public abstract class Creator {

    /**
     * 抽象的工厂方法。
     * 子类将重写此方法以创建特定类型的产品。
     *
     * @return 一个 Product 实例。
     */
    public abstract Product factoryMethod();

    /**
     * 这是一个依赖于工厂方法的操作。
     * Creator 类中的代码不关心具体的产品实现，只依赖于抽象的 Product 接口。
     */
    public void anOperation() {
        // 调用工厂方法创建产品对象
        Product product = factoryMethod();
        // 使用产品
        System.out.print("Creator's operation is using a product: ");
        product.use();
    }
}
