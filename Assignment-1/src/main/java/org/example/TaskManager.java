package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private Database database = null;
    private List<Task> tasks;

    // Constructor creation
    public TaskManager(Database database) {
        this.database = database;
        tasks = new ArrayList<>();
    }

    // Adds a task to TaskManager and saves to database
    public void addTask(Task task) {
        database.saveTask(task);
        tasks.add(task);
    }

    // Deletes a task to TaskManager and removes from the database
    public void deleteTask(Task task) {
        database.deleteTask(task);
        tasks.remove(task);
    }

    // Retrieves all the tasks from TaskManager
    public List<Task> getAllTasks() {
        return tasks;
    }

    // Sets a list of tasks in the TaskManager
    public  void setAllTasks(List<Task> tasks){
        this.tasks = tasks;
    }

    // Edits a particular task
    public void editTask(String name, String description, String manager, String editDate) {
        Task task = getTaskByName(name);
        if (task != null) {
            task.setDescription(description);
        }
    }

    // Deletes a task with the specific name
    public void deleteTask(String name) {
        Task task = getTaskByName(name);
        if (task != null) {
            tasks.remove(task);
        }
        database.deleteTask(task);
    }

    // Sets the priority of a task with the specific name.
    public void setPriority(String name, Priority priority) {
        Task task = getTaskByName(name);
        if (task != null) {
            task.setPriority(priority);
        }
    }

    // Sets the task deadline with the specific name
    public void setDeadline(String name, Deadline deadline) {
        Task task = getTaskByName(name);
        if (task != null) {
            task.setDeadline(deadline);
        }
    }

    // Sets the task completion status with the specific name
    public void setCompleted(String name, boolean completed) {
        Task task = getTaskByName(name);
        if (task != null) {
            task.setCompleted(completed);
        }
    }

    // Get the tasks with the specific name
    public Task getTaskByName(String name) {

        return tasks.stream().filter(task -> task.getTaskName().equals(name)).findFirst().orElse(null);
    }

    // Get the tasks with the specific priority
    public List<Task> getTasksByPriority(Priority priority) {
        return tasks.stream().filter(task -> task.getPriority() == priority).collect(Collectors.toList());
    }

    // Get the tasks with the specific deadline
    public List<Task> getTasksByDeadline(Deadline deadline) {
        return tasks.stream().filter(task -> task.getDeadline() == deadline).collect(Collectors.toList());
    }

    // Get the tasks with the specific completion status
    public List<Task> getTasksByStatus(boolean completed) {
        return tasks.stream().filter(task -> task.isCompleted() == completed).collect(Collectors.toList());
    }
}
