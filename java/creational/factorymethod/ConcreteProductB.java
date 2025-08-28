package creational.factorymethod;

/**
 * 具体产品 B (ConcreteProductB)
 * <p>
 * 实现了 Product 接口。
 */
public class ConcreteProductB extends Product {
    @Override
    public void use() {
        System.out.println("Using ConcreteProductB.");
    }
}
