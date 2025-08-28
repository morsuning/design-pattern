package behavioral.chain;

/**
 * 责任链模式 (Chain of Responsibility)
 *
 * 目的:
 * 使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。
 * 将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
 *
 * 使用场景 (更具体的例子):
 * 1.  **Java Servlet Filters**: Web 应用中的 Filter 链是责任链模式的经典应用。
 *     每个 Filter 处理请求的一部分（如认证、日志、压缩），然后可以选择将请求传递给链中的下一个 Filter。
 * 2.  **异常处理机制**: Java 的 `try-catch` 块在概念上类似责任链。
 *     一个异常被抛出，会沿着方法调用栈向上传递，直到找到一个可以处理该类型异常的 `catch` 块。
 * 3.  **日志系统**: 如本例所示，不同级别的日志消息可以由不同的处理器处理。
 *     一个 `INFO` 消息可能只想打印到控制台，而一个 `ERROR` 消息可能需要打印到控制台、写入文件并发送邮件。
 * 4.  **UI事件冒泡**: 在图形用户界面中，一个事件（如点击）可以由最内层的组件处理，
 *     如果它不处理，事件会“冒泡”到其父容器，形成一条处理链。
 */
public class Client {

    private static Logger getChainOfLoggers() {
        Logger emailLogger = new EmailLogger(Logger.ERROR);
        Logger fileLogger = new FileLogger(Logger.DEBUG);
        Logger consoleLogger = new ConsoleLogger(Logger.INFO);

        emailLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return emailLogger;
    }

    public static void main(String[] args) {
        Logger loggerChain = getChainOfLoggers();

        System.out.println("--- Sending INFO level message ---");
        loggerChain.logMessage(Logger.INFO, "This is an information.");

        System.out.println("\n--- Sending DEBUG level message ---");
        loggerChain.logMessage(Logger.DEBUG, "This is a debug level information.");

        System.out.println("\n--- Sending ERROR level message ---");
        loggerChain.logMessage(Logger.ERROR, "This is an error information.");
    }
}