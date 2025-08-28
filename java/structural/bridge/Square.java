package structural.bridge;

// 扩充抽象类 B
public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Drawing a " + color.applyColor() + " square.";
    }
}
