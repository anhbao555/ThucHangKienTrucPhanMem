package Task_Observer;

public class TaskMain {
    public static void main(String[] args) {
        // Task Manager Example
        TaskManager taskManager = new TaskManager();
        TeamMember member1 = new TeamMember("Charlie");
        TeamMember member2 = new TeamMember("David");

        taskManager.register(member1);
        taskManager.register(member2);

        taskManager.setStatus("In Progress");
        taskManager.setStatus("Completed");
    }
}
