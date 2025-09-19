package structural.composite.transparent;

/**
 * 组件 (Component)
 * <p>
 * 1. 为组合中的对象声明接口。
 * 2. 在适当的情况下，实现所有类共有的缺省行为。
 * 3. 声明一个接口用于访问和管理 Component 的子组件。
 * 4. (可选)在递归结构中定义一个接口，用于访问一个父部件，并在合适的情况下实现它。
 */
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    /**
     * 组合中对象都应实现的操作。
     */
    public abstract void operation();

    /**
     * 添加子组件。
     * 对于叶子节点，此操作通常是无意义的，可以抛出异常或空实现。
     *
     * @param component 待添加的子组件。
     */
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to a leaf component.");
    }

    /**
     * 移除子组件。
     *
     * @param component 待移除的子组件。
     */
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf component.");
    }

    /**
     * 获取子组件。
     *
     * @param index 子组件的索引。
     * @return 指定索引的子组件。
     */
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Cannot get child from a leaf component.");
    }

    public String getName() {
        return name;
    }
}
