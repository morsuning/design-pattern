package creational.prototype;

public class ConcretePrototype implements Cloneable {

    private String name;
    private Address address;

    public ConcretePrototype(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Getter and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * 浅拷贝 (Shallow Copy)
     * 只复制基本数据类型的值和引用类型变量的地址。
     * 克隆对象和原对象会共享同一个引用类型的对象。
     */
    public ConcretePrototype shallowClone() throws CloneNotSupportedException {
        System.out.println("Performing shallow clone...");
        return (ConcretePrototype) super.clone();
    }

    /**
     * 深拷贝 (Deep Copy)
     * 除了复制基本类型和引用地址外，还会递归地复制所有引用类型对象本身。
     * 克隆对象和原对象完全独立。
     */
    public ConcretePrototype deepClone() throws CloneNotSupportedException {
        System.out.println("Performing deep clone...");
        ConcretePrototype cloned = (ConcretePrototype) super.clone();
        // 对引用类型的字段进行单独的克隆
        cloned.address = this.address.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return "ConcretePrototype [name=" + name + ", address=" + address + ", addressHashCode=" + address.hashCode() + "]";
    }
}
