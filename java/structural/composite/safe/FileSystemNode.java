package structural.composite.safe;

// Component: 只定义通用接口
public abstract class FileSystemNode {
    protected String name;

    public FileSystemNode(String name) {
        this.name = name;
    }

    public abstract long getSize();

    public String getName() {
        return name;
    }
}
