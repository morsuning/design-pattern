package creational.abstractfactory;

// 具体产品 A1
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a Windows style button.");
    }
}
