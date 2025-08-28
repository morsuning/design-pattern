package structural.adapter.classadapter;

/**
 * 类适配器 (Class Adapter)
 * 通过继承 Adaptee 类并实现 Target 接口来进行适配。
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        // 调用继承自 Adaptee 的方法
        specificRequest();
    }
}
