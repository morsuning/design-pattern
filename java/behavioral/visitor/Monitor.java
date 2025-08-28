package behavioral.visitor;

/**
 * 具体元素 (ConcreteElement) - Monitor
 */
public class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}