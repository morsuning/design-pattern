package structural.decorator;

// Decorator
public abstract class CondimentDecorator extends Beverage {
    // 持有被装饰者的引用
    protected Beverage beverage;

    // 强制子类实现 getDescription
    public abstract String getDescription();
}
