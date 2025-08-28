package structural.facade;

/**
 * 外观模式 (Facade)
 *
 * 目的:
 * 为子系统中的一组接口提供一个一致的界面。
 * 外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 *
 * 使用场景 (更具体的例子):
 * 1.  **封装第三方库**: 当你使用一个功能强大但接口复杂的第三方库时，可以创建一个外观类，
 *     封装你常用到的功能，为你的项目提供一个更简洁、更符合项目需求的接口。
 *     例如，封装一个复杂的图形库或HTTP客户端库。
 * 2.  **简化多层应用**: 在分层架构中（如 Controller-Service-DAO），Service层可以看作是DAO层的外观。
 *     Controller只需要调用Service提供的业务方法，而无需关心底层数据访问的复杂细节。
 * 3.  **启动和关闭复杂系统**: 如本例中的家庭影院，启动一个系统需要按特定顺序执行多个步骤，
 *     关闭时也一样。外观模式可以将这些复杂的流程封装成简单的 `startup()` 和 `shutdown()` 方法。
 * 4.  **Java中的应用**: `javax.faces.context.FacesContext` 类，它为底层的Servlet API
 *     （如 `HttpServletRequest`, `HttpServletResponse`）提供了一个简化的访问接口。
 */
public class Client {
    public static void main(String[] args) {
        // 实例化子系统组件
        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();

        // 实例化外观
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector);

        // 使用外观提供的简单接口来执行复杂操作
        homeTheater.watchMovie("Raiders of the Lost Ark");
        homeTheater.endMovie();
    }
}
