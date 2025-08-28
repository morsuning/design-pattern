package behavioral.visitor;

/**
 * 具体访问者 (ConcreteVisitor) - ComputerPartDisplayVisitor
 * <p>
 * 1. 实现了 Visitor 接口声明的每一个操作。
 * 2. 每一个操作实现了算法的一部分，而该算法乃是对应于结构中对象的类。
 * 3. ConcreteVisitor 为该算法提供了上下文并存储它的局部状态。
 *    这一状态常常在遍历该结构的过程中累积结果。
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}