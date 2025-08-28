package behavioral.visitor;

/**
 * 访问者接口 (Visitor)
 * <p>
 * 为该对象结构中 ConcreteElement 的每一个类声明一个 Visit 操作。
 * 该操作的名字和特征标识了发送 Visit 请求给该访问者的那个类。
 * 这使得访问者可以确定正被访问元素的具体的类。
 */
public interface ComputerPartVisitor {
    // 为每一种具体元素提供一个 visit 方法
    void visit(Computer computer);
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}