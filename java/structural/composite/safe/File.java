package structural.composite.safe;

// Leaf
public class File extends FileSystemNode {
    private long size;

    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public long getSize() {
        System.out.println("Calculating size of file: " + getName());
        return this.size;
    }
}
