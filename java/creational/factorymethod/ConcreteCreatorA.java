package creational.factorymethod;

/**
 * 具体创建者 A (ConcreteCreatorA)
 * <p>
 * 重写 factoryMethod() 方法以返回一个 ConcreteProductA 的实例。
 */
public class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        System.out.println("ConcreteCreatorA is creating a ConcreteProductA.");
        return new ConcreteProductA();
    }
}
