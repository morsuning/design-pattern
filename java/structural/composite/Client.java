package structural.composite;

/**
 * 组合模式 (Composite)
 *
 * 目的:
 * 将对象组合成树形结构以表示“部分-整体”的层次结构。
 * 组合模式使得用户对单个对象和组合对象的使用具有一致性。
 *
 * 两种主要实现对比:
 *
 * 1. 透明模式 (Transparent Composition):
 *    - **结构**: 在组件基类中声明所有管理子节点的方法（add, remove等）。
 *    - **优点**: 客户端代码可以完全统一地处理叶子和容器，无需区分。代码更简单。
 *    - **缺点**: 不安全。叶子节点继承了它不支持的方法，调用时会抛出异常（运行时错误）。
 *    - **适用**: 当你更看重透明性而非绝对安全时。
 *
 * 2. 安全模式 (Safe Composition):
 *    - **结构**: 只在容器类（Composite）中声明管理子节点的方法。组件基类只有通用方法。
 *    - **优点**: 安全。客户端代码在编译时就能发现错误，无法对叶子节点调用容器独有的方法。
 *    - **缺点**: 不透明。客户端需要在使用 `add` 等方法前，判断对象是否为容器类型（`instanceof`），代码相对复杂。
 *
 * 使用场景 (更具体的例子):
 * 1.  **GUI工具包**: 窗口(Window)可以包含面板(Panel)，面板又可以包含按钮(Button)、文本框(TextField)等。
 *     一个面板的 `draw()` 操作会递归调用其所有子组件的 `draw()`。
 * 2.  **文件系统**: 如本例所示，目录(Directory)可以包含文件(File)和其他目录。计算目录大小时，需要递归计算所有子项的大小。
 * 3.  **组织架构**: 公司(Company)下有部门(Department)，部门下有员工(Employee)。计算公司总薪水时，需要递归加总所有部门和员工的薪水。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- 1. Transparent Composition Demonstration ---");
        demonstrateTransparentComposition();

        System.out.println("\n\n--- 2. Safe Composition Demonstration ---");
        demonstrateSafeComposition();
    }

    private static void demonstrateTransparentComposition() {
        structural.composite.transparent.Directory root = new structural.composite.transparent.Directory("root");
        structural.composite.transparent.File file1 = new structural.composite.transparent.File("file1.txt", 100);
        structural.composite.transparent.Directory subDir = new structural.composite.transparent.Directory("subDir");
        structural.composite.transparent.File file2 = new structural.composite.transparent.File("file2.txt", 200);

        root.add(file1);
        root.add(subDir);
        subDir.add(file2);

        System.out.println("Total size: " + root.getSize());

        try {
            // 这将导致运行时错误
            file1.add(new structural.composite.transparent.File("another.txt", 50));
        } catch (UnsupportedOperationException e) {
            System.out.println("Error caught as expected: " + e.getMessage());
        }
    }

    private static void demonstrateSafeComposition() {
        structural.composite.safe.Directory root = new structural.composite.safe.Directory("root");
        structural.composite.safe.File file1 = new structural.composite.safe.File("file1.txt", 100);
        structural.composite.safe.Directory subDir = new structural.composite.safe.Directory("subDir");
        structural.composite.safe.File file2 = new structural.composite.safe.File("file2.txt", 200);

        root.add(file1);
        root.add(subDir);
        subDir.add(file2);

        System.out.println("Total size: " + root.getSize());

        // 下面的代码将导致编译时错误，因为 File 类没有 add 方法
        // file1.add(new structural.composite.safe.File("another.txt", 50));
        System.out.println("Compile-time safety prevents adding to a file.");
    }
}
