package creational.builder.classic;

public class ConcreteBuilder implements Builder {
    private final Product product = new Product();

    @Override
    public void buildPartA() {
        product.setPartA("PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("PartC");
    }

    @Override
    public Product getResult() {
        return product;
    }
}