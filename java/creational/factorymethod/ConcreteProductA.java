package creational.factorymethod;

/**
 * 具体产品 A (ConcreteProductA)
 * <p>
 * 实现了 Product 接口。
 */
public class ConcreteProductA extends Product {
    @Override
    public void use() {
        System.out.println("Using ConcreteProductA.");
    }
}
