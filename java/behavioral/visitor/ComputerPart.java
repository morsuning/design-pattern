package behavioral.visitor;

/**
 * 元素接口 (Element)
 * <p>
 * 定义一个 accept 操作，它以一个访问者为参数。
 * 这是对象结构中所有具体元素都需要实现的接口。
 */
public interface ComputerPart {
    /**
     * 接受一个访问者。
     * 这个方法通常的实现是调用访问者的 visit 方法，并将自身（`this`）作为参数。
     *
     * @param computerPartVisitor 访问者对象。
     */
    void accept(ComputerPartVisitor computerPartVisitor);
}