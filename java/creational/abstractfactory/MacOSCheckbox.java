package creational.abstractfactory;

// 具体产品 B2
public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Painting a macOS style checkbox.");
    }
}
