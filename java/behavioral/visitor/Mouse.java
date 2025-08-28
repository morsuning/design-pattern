package behavioral.visitor;

/**
 * 具体元素 (ConcreteElement) - Mouse
 */
public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}