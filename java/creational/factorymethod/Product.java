package creational.factorymethod;

/**
 * 抽象产品 (Product)
 * <p>
 * 定义了工厂方法所创建的对象的接口。
 */
public abstract class Product {
    /**
     * 产品的抽象方法，具体实现由子类提供。
     */
    public abstract void use();
}
