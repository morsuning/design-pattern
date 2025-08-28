package creational.prototype;

// 这是一个辅助类，用于演示深拷贝和浅拷贝的区别。
// 它也需要实现 Cloneable 接口以支持被克隆。
public class Address implements Cloneable {
    private String street;

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{street='" + street + "'}";
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }
}
