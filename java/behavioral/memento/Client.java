package behavioral.memento;

/**
 * 备忘录模式 (Memento)
 *
 * 目的:
 * 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。
 * 这样以后就可将该对象恢复到原先保存的状态。
 *
 * 最佳实践 - 增强封装:
 * 将 Memento 实现为 Originator 的一个私有/保护静态内部类。
 * - **优点**: 只有 Originator 可以访问 Memento 的内部状态（`getText()`方法），
 *   Caretaker（本例中的`History`）只能持有对 Memento 对象的引用，无法读取或修改其内容，
 *   从而完美地保护了封装性。
 *
 * 使用场景 (更具体的例子):
 * 1.  **文本编辑器**: 如本例所示，实现撤销/重做功能。每次有意义的操作后，
 *     编辑器的当前状态被保存为一个备忘录，并存入管理者（如一个栈）中。
 * 2.  **游戏存档**: 在游戏的某个关键点（如通过一关），玩家角色的所有状态（生命值、装备、位置等）
 *     被封装在一个备忘录中并保存到磁盘。玩家之后可以从这个点恢复游戏。
 * 3.  **数据库事务**: 在一个事务开始前，可以为涉及的数据创建一个备忘录。
 *     如果事务中的任何操作失败，可以使用备忘录将数据恢复到事务开始前的状态，实现回滚。
 * 4.  **GUI组件状态**: 一个复杂的GUI组件（如一个可配置的对话框）的状态可以被保存，
 *     以便用户可以撤销他们的修改或将设置恢复到某个预设值。
 */
public class Client {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hello");
        history.save(editor);

        editor.write(" World");
        history.save(editor);

        editor.write("!");
        // 当前内容: "Hello World!"

        System.out.println("\n--- Performing Undo ---");
        history.undo(editor); // 恢复到 "Hello World"

        System.out.println("\n--- Performing Undo Again ---");
        history.undo(editor); // 恢复到 "Hello"
    }
}
