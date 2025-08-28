package behavioral.observer.modern;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// ConcreteObserver
public class NewsChannel implements PropertyChangeListener {
    private String channelName;

    public NewsChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(channelName + " breaking news: " + evt.getNewValue());
    }
}
