package Task_Observer;

public class TeamMember implements TaskObserver {
    private String name;
    private Task task;

    public TeamMember(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        if (this.task == null) {
            System.out.println(name + " has no task assigned.");
            return;
        }
        System.out.println(name + " received task update: " + task.getUpdate(this));
    }

    @Override
    public void setTask(Task task) {
        this.task = task;
    }
}
