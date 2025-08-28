package behavioral.visitor;

/**
 * 具体元素 (ConcreteElement) - Keyboard
 * <p>
 * 实现了 Element 接口的 accept 操作。
 */
public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        // 双重分派：第一次分派在 accept 方法，第二次在 visit 方法
        computerPartVisitor.visit(this);
    }
}