package behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// ConcreteAggregate: 实现 Iterable 接口
public class BookCollection implements Iterable<Book> {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookIterator();
    }

    // 将 Iterator 作为内部类，可以方便地访问外部类的私有成员
    private class BookIterator implements Iterator<Book> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.size();
        }

        @Override
        public Book next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return books.get(index++);
        }

        @Override
        public void remove() {
            if (index <= 0) {
                throw new IllegalStateException("You can't call remove before you've called next()");
            }
            books.remove(--index);
        }
    }
}
