package Task_Observer;

public interface Task {
    void register(TaskObserver observer);
    void unregister(TaskObserver observer);
    void notifyObservers();
    String getUpdate(TaskObserver observer);
}
