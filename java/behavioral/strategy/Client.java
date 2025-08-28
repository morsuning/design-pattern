package behavioral.strategy;

import behavioral.strategy.classic.CreditCardPayment;
import behavioral.strategy.classic.PaypalPayment;
import behavioral.strategy.classic.ShoppingCart;
import behavioral.strategy.functional.Stock;
import behavioral.strategy.functional.StockFilters;

import java.util.ArrayList;
import java.util.List;

/**
 * 策略模式 (Strategy)
 *
 * 目的:
 * 定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。
 * 本模式使得算法可独立于使用它的客户而变化。
 *
 * 两种主要实现对比:
 *
 * 1. 经典策略模式 (Classic Strategy):
 *    - **结构**: 定义一个策略接口，多个具体策略类实现该接口，上下文持有一个策略接口的引用。
 *    - **优点**: 结构清晰，符合传统的面向对象原则。
 *    - **缺点**: 当策略很简单时（例如只有一行代码），需要创建多个类，显得有些繁重。
 *
 * 2. 函数式策略模式 (Functional Strategy with Lambdas):
 *    - **结构**: 使用函数式接口（如 `Predicate`, `Function`, `Comparator`）代替策略接口。
 *      具体的策略直接通过 Lambda 表达式或方法引用在客户端代码中定义。
 *    - **优点**: 非常简洁，避免了为简单策略创建大量具体类。代码更紧凑，可读性更高。
 *    - **缺点**: 对于非常复杂的策略（包含多个方法或需要维护状态），经典策略模式可能更合适。
 *    - **结论**: **在Java 8+中，对于无状态的、功能单一的策略，应优先使用函数式实现**。
 *
 * 使用场景 (更具体的例子):
 * 1.  **排序**: `Collections.sort()` 或 `List.sort()` 方法接受一个 `Comparator` (策略接口)
 *     来决定排序算法。你可以传入不同的 `Comparator` (具体策略) 来实现升序、降序或自定义排序。
 * 2.  **GUI布局管理器**: Swing 中的布局管理器（`BorderLayout`, `FlowLayout`）是策略模式的应用。
 *     `JFrame` (上下文) 可以通过 `setLayoutManager()` 动态地改变其布局策略。
 * 3.  **验证**: 表单验证时，可以为不同的输入字段（如邮箱、密码、手机号）提供不同的 `ValidationStrategy`。
 * 4.  **数据压缩**: 一个文件处理程序可以使用不同的压缩算法（`ZipStrategy`, `GzipStrategy`）来保存文件。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- 1. Classic Strategy Demonstration (Payment) ---");
        demonstrateClassicStrategy();

        System.out.println("\n\n--- 2. Functional Strategy Demonstration (Stock Filter) ---");
        demonstrateFunctionalStrategy();
    }

    private static void demonstrateClassicStrategy() {
        ShoppingCart cart = new ShoppingCart();
        cart.setAmount(100);
        cart.pay(new CreditCardPayment("John Doe", "123456789"));

        cart.setAmount(50);
        cart.pay(new PaypalPayment("john.doe@example.com"));
    }

    private static void demonstrateFunctionalStrategy() {
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("AAPL", 150.0, 10));
        stocks.add(new Stock("GOOG", 2800.0, 5));
        stocks.add(new Stock("TSLA", 700.0, 8));

        // 使用 Lambda 表达式作为具体策略
        System.out.println("Stocks with price > 1000:");
        List<Stock> filtered = StockFilters.filter(stocks, s -> s.getPrice() > 1000);
        filtered.forEach(System.out::println);

        System.out.println("\nStocks with symbol 'AAPL':");
        List<Stock> filtered2 = StockFilters.filter(stocks, s -> s.getSymbol().equals("AAPL"));
        filtered2.forEach(System.out::println);
    }
}
