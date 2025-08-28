package structural.bridge;

// 具体实现者 A
public class RedColor implements Color {
    @Override
    public String applyColor() {
        return "red";
    }
}
