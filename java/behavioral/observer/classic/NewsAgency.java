package behavioral.observer.classic;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    private String news;
    private final List<Observer> observers = new ArrayList<>();

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(news);
        }
    }
}
