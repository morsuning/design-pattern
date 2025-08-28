package structural.bridge;

// 扩充抽象类 A
public class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Drawing a " + color.applyColor() + " circle.";
    }
}
