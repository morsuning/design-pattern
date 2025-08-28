package behavioral.visitor;

/**
 * 对象结构 (ObjectStructure) - Computer
 * <p>
 * 1. 可以枚举它的元素。
 * 2. 可以提供一个高层的接口以允许访问者访问它的元素。
 * 3. 可以是一个复合（参见 Composite 模式）或一个集合，如一个列表或一个无序集合。
 * <p>
 * 在这个例子中，Computer 既是一个对象结构，也是一个复合元素。
 */
public class Computer implements ComputerPart {

    // 计算机由多个部件组成
    private final ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[]{new Mouse(), new Keyboard(), new Monitor()};
    }

    /**
     * Computer 作为一个复合元素，实现了 accept 方法。
     * 它会遍历其所有子部件，并让访问者访问它们。
     *
     * @param computerPartVisitor 访问者对象。
     */
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        System.out.println("Computer is accepting a visitor.");
        // 遍历所有部件
        for (ComputerPart part : parts) {
            part.accept(computerPartVisitor);
        }
        // 最后，让访问者访问自身
        computerPartVisitor.visit(this);
    }
}