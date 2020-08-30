package by.balashevich.shapeapp.observer;

import java.util.EventObject;

public interface Observer<T extends EventObject> {
    void actionPerformed(T eventObject);
}
