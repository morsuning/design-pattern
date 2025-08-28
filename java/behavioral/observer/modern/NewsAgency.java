package behavioral.observer.modern;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// ConcreteSubject
public class NewsAgency {
    private String news;
    private PropertyChangeSupport support;

    public NewsAgency() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setNews(String news) {
        String oldNews = this.news;
        this.news = news;
        // Fire a property change event
        support.firePropertyChange("news", oldNews, news);
    }
}
