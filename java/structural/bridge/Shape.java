package structural.bridge;

// 抽象部分 (Abstraction)
public abstract class Shape {
    // 持有实现者的引用
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract public String draw();
}
