package org.example;

public class Task {
    private final String manager;
    private final String createDate;
    private final String taskName;
    private String description;
    private Priority priority;
    private Deadline deadline;
    private boolean completed;

    /**
     * Task constructor
     *
     * @param taskName to have the task name
     * @param description to have the details of the task
     * @param manager to have the manager assigned
     * @param createDate to know when the task is created
     */
    public Task(String taskName, String description, String manager, String createDate) {
        this.taskName = taskName;
        this.description = description;
        this.manager = manager;
        this.createDate = createDate;
        this.priority = Priority.LOW;
        this.deadline = Deadline.NONE;
        this.completed = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getManager() {
        return manager;
    }

    // getter method for created
    public String getCreateDate() {
        return createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description= String.valueOf(description);
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Deadline getDeadline() {
        return deadline;
    }

    public void setDeadline(Deadline deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // String conversion of the task
    @Override
    public String toString() {
        return "Task{" +
                "name='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", deadline=" + deadline +
                ", completed=" + completed +
                '}';
    }
}