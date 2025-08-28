package creational.builder;

import creational.builder.classic.ConcreteBuilder;
import creational.builder.classic.Director;
import creational.builder.classic.Product;
import creational.builder.fluent.User;

/**
 * 生成器模式 (Builder)
 *
 * 目的:
 * 将一个复杂对象的构建与其表示分离，使得同样的构建过程可以创建不同的表示。
 *
 * 两种主要实现对比:
 *
 * 1. 经典生成器 (Classic Builder):
 *    - **角色**: Builder, ConcreteBuilder, Director, Product。
 *    - **特点**: 使用一个 Director 类来封装构建步骤，客户端与 Director 交互。
 *    - **优点**: 构建过程被封装在 Director 中，客户端代码更简洁，易于更换构建算法。
 *    - **缺点**: 结构较复杂，需要定义更多的类。
 *    - **适用场景**:
 *      - 当构建过程非常复杂，包含固定的算法或顺序时。
 *      - 当需要根据不同配置创建同一产品的不同表示时（可以有多个 Director）。
 *      - 例如：解析一个复杂的XML/JSON文件并构建相应的对象模型。
 *
 * 2. 链式生成器 (Fluent Builder / Fluent Interface):
 *    - **角色**: 通常将 Builder 作为产品类的静态内部类。
 *    - **特点**: Builder 的设值方法返回自身 (`return this;`)，形成链式调用。
 *    - **优点**: API 可读性极高，代码流畅。特别适合处理有大量可选参数的对象。
 *    - **缺点**: 构建步骤由客户端直接调用，灵活性高但缺乏封装。
 *    - **适用场景**:
 *      - 当一个类的构造函数参数过多时（尤其是可选参数）。
 *      - 替代伸缩构造函数模式 (Telescoping Constructor Pattern) 和 JavaBean 模式。
 *      - 例如：构建SQL查询 (`QueryBuilder`)、HTTP请求 (`RequestBuilder`)、或复杂的配置对象。
 *      - Java 中的 `StringBuilder` 和 `Stream.Builder` 都是典型的例子。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- 1. Classic Builder Demonstration ---");
        demonstrateClassicBuilder();

        System.out.println("\n\n--- 2. Fluent Builder Demonstration ---");
        demonstrateFluentBuilder();
    }

    private static void demonstrateClassicBuilder() {
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.getResult();
        System.out.println("Classic builder created product: " + product);
    }

    private static void demonstrateFluentBuilder() {
        // 使用链式调用来构建一个复杂对象
        User user = new User.UserBuilder("John", "Doe")
                .age(30)
                .phone("123-456-7890")
                .address("123 Main St")
                .build();

        System.out.println("Fluent builder created user: " + user);

        // 也可以只用必选参数构建
        User simpleUser = new User.UserBuilder("Jane", "Smith").build();
        System.out.println("Fluent builder created another user: " + simpleUser);
    }
}