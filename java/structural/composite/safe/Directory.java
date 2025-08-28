package structural.composite.safe;

import java.util.ArrayList;
import java.util.List;

// Composite: 在这里定义子节点管理方法
public class Directory extends FileSystemNode {
    private List<FileSystemNode> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public long getSize() {
        System.out.println("Calculating size of directory: " + getName());
        long totalSize = 0;
        for (FileSystemNode child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    public void add(FileSystemNode node) {
        children.add(node);
    }

    public void remove(FileSystemNode node) {
        children.remove(node);
    }
}
