package creational.builder.classic;

public interface Builder {
    void buildPartA();
    void buildPartB();
    void buildPartC();
    Product getResult();
}