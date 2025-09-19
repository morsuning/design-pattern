package structural.composite.transparent;

import java.util.ArrayList;
import java.util.List;

/**
 * 复合组件 (Composite)
 * <p>
 * 1. 定义有子部件的那些部件的行为。
 * 2. 存储子部件。
 * 3. 在 Component 接口中实现与子部件有关的操作。
 */
public class Composite extends Component {
    // 存储子组件的列表
    private final List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    /**
     * 复合组件的操作。
     * 它通常会将请求委托给它的子组件来处理。
     */
    @Override
    public void operation() {
        System.out.println("Executing operation on Composite: " + getName());
        // 递归地调用所有子组件的操作
        for (Component child : children) {
            child.operation();
        }
    }

    /**
     * 添加一个新的子组件。
     *
     * @param component 待添加的子组件。
     */
    @Override
    public void add(Component component) {
        children.add(component);
        System.out.println("Added " + component.getName() + " to " + this.getName());
    }

    /**
     * 移除一个子组件。
     *
     * @param component 待移除的子组件。
     */
    @Override
    public void remove(Component component) {
        children.remove(component);
        System.out.println("Removed " + component.getName() + " from " + this.getName());
    }

    /**
     * 获取指定的子组件。
     *
     * @param index 子组件的索引。
     * @return 子组件。
     */
    @Override
    public Component getChild(int index) {
        return children.get(index);
    }
}
