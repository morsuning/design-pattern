package structural.composite;

/**
 * 叶子 (Leaf)
 * <p>
 * 1. 在组合中表示叶节点对象，叶节点没有子节点。
 * 2. 在组合中定义图元对象的行为。
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    /**
     * 叶子节点的具体操作。
     * 这是组合模式中真正执行工作的对象。
     */
    @Override
    public void operation() {
        System.out.println("Executing operation on Leaf: " + getName());
    }

    // 注意：Leaf 类继承了 add, remove, getChild 的默认实现（抛出异常），
    // 因为叶子节点不能有子节点。这被称为“透明组合模式”，客户端可以统一对待叶子和容器，
    // 但在运行时尝试对叶子进行容器操作会失败。
}
