package behavioral.iterator;

import java.util.Iterator;

/**
 * 迭代器模式 (Iterator)
 *
 * 目的:
 * 提供一种方法顺序访问一个聚合对象中各个元素, 而又不需暴露该对象的内部表示。
 *
 * Java中的实现:
 * - `java.lang.Iterable`: 任何实现了此接口的类都可以成为 `for-each` 循环的目标。
 *   它只有一个方法 `iterator()`，该方法返回一个 `Iterator`。
 * - `java.util.Iterator`: 这是迭代器接口，定义了 `hasNext()`, `next()`, 和可选的 `remove()` 方法。
 *
 * 最佳实践:
 * - 优先使用Java内置的接口，这能让你的集合类与Java生态系统无缝集成。
 * - 将具体的迭代器实现为聚合类的私有内部类，这样它可以直接访问聚合的内部数据，同时又对外部隐藏了实现细节。
 *
 * 使用场景 (更具体的例子):
 * 1.  **Java集合框架**: 所有 `java.util.Collection` 的子类（如 `ArrayList`, `HashSet`）都实现了 `Iterable`，
 *     允许你使用 `for-each` 循环或显式获取 `Iterator` 来遍历它们。
 * 2.  **数据库结果集**: `java.sql.ResultSet` 提供了 `next()` 方法来遍历查询结果，这是一种迭代器的变体。
 * 3.  **流处理**: Java 8 的 Stream API 中的 `spliterator()` 方法返回一个可分割的迭代器，用于并行处理。
 * 4.  **自定义数据结构**: 当你创建了自己的数据结构（如树、图、自定义列表）时，
 *     提供一个迭代器可以让该数据结构的用户更容易地遍历其中的元素。
 */
public class Client {
    public static void main(String[] args) {
        BookCollection library = new BookCollection();
        library.addBook(new Book("The Lord of the Rings"));
        library.addBook(new Book("Dune"));
        library.addBook(new Book("1984"));

        // 1. 使用 for-each 循环 (因为 BookCollection 实现了 Iterable)
        System.out.println("--- Traversing with for-each loop ---");
        for (Book book : library) {
            System.out.println("Book: " + book.getName());
        }

        // 2. 显式使用 Iterator 并演示 remove()
        System.out.println("\n--- Traversing with explicit iterator and removing 'Dune' ---");
        Iterator<Book> iterator = library.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getName().equals("Dune")) {
                iterator.remove();
                System.out.println("Removed 'Dune'");
            }
        }

        // 3. 再次遍历以确认移除成功
        System.out.println("\n--- Traversing again to confirm removal ---");
        for (Book book : library) {
            System.out.println("Book: " + book.getName());
        }
    }
}
