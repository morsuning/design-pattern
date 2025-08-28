package behavioral.observer.builtin;

import java.util.Observable;
import java.util.Observer;

// ConcreteObserver
@SuppressWarnings("deprecation")
public class NewsChannel implements Observer {
    private String channelName;

    public NewsChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            System.out.println(channelName + " breaking news: " + arg);
        }
    }
}
