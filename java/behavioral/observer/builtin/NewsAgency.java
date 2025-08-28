package behavioral.observer.builtin;

import java.util.Observable;

// ConcreteSubject
@SuppressWarnings("deprecation")
public class NewsAgency extends Observable {
    public void setNews(String news) {
        setChanged(); // Mark the state as changed
        notifyObservers(news); // Notify observers
    }
}
