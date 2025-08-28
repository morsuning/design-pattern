package structural.bridge;

// 具体实现者 B
public class BlueColor implements Color {
    @Override
    public String applyColor() {
        return "blue";
    }
}
