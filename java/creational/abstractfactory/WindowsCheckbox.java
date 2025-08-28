package creational.abstractfactory;

// 具体产品 B1
public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Painting a Windows style checkbox.");
    }
}
