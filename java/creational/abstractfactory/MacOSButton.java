package creational.abstractfactory;

// 具体产品 A2
public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a macOS style button.");
    }
}
