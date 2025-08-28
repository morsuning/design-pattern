package structural.adapter.classadapter;

// 被适配的类
public class Adaptee {
    public void specificRequest() {
        System.out.println("Called Adaptee's specificRequest() in Class Adapter context.");
    }
}
