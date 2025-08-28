package creational.factorymethod;

/**
 * 具体创建者 B (ConcreteCreatorB)
 * <p>
 * 重写 factoryMethod() 方法以返回一个 ConcreteProductB 的实例。
 */
public class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        System.out.println("ConcreteCreatorB is creating a ConcreteProductB.");
        return new ConcreteProductB();
    }
}
