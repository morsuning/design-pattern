package structural.composite.transparent;

// Component: 定义了叶子和容器的通用接口
public abstract class FileSystemNode {
    protected String name;

    public FileSystemNode(String name) {
        this.name = name;
    }

    public abstract long getSize();

    public void add(FileSystemNode node) {
        throw new UnsupportedOperationException("Cannot add to this node.");
    }

    public void remove(FileSystemNode node) {
        throw new UnsupportedOperationException("Cannot remove from this node.");
    }

    public String getName() {
        return name;
    }
}
