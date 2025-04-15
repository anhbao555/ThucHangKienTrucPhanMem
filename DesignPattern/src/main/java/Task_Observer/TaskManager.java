package Task_Observer;

import java.util.ArrayList;
import java.util.List;

public class TaskManager implements Task {
    private List<TaskObserver> observers = new ArrayList<>();
    private String status;

    @Override
    public void register(TaskObserver observer) {
        observers.add(observer);
        observer.setTask(this);
    }

    @Override
    public void unregister(TaskObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (TaskObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public String getUpdate(TaskObserver observer) {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }
}
