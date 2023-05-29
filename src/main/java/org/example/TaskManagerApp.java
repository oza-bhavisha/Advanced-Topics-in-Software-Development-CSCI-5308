package org.example;

import java.util.Scanner;

// A command line Task Manager Application.
public class TaskManagerApp {

    private final TaskManager taskManager;
    private Scanner scanner;
    private Database database;
    private String taskName;
    private String manager;
    private String createDate;

    private String description;
    Task task = new Task(taskName, description, manager, createDate);

    public TaskManagerApp(){
        database = new MockDatabase();
        this.taskManager = new TaskManager(database);
        this.scanner = new Scanner(System.in);
    }

    public void AppRun(){
        boolean isRunning = true;

        while (isRunning) {
            displayMenu();
            int choice = readChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    setPriority();
                    break;
                case 5:
                    setDeadline();
                    break;
                case 6:
                    setCompleted();
                    break;
                case 7:
                    filterByPriority();
                    break;
                case 8:
                    filterByDeadline();
                    break;
                case 9:
                    filterByStatus();
                    break;
                case 10:
                    displayAllTasks();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("You have entered wrong choice... Please select from the given options only");
            }
        }

        System.out.println("Task Manager application closed.");
    }

    private void displayMenu(){
        System.out.println("####################################");
        System.out.println("------------------------------------");
        System.out.println("--- Welcome to the Task Manager  ---");
        System.out.println("-------   Task Manager Menu  -------");
        System.out.println("------------------------------------");
        System.out.println("####################################");
        System.out.println("1. Add Task");
        System.out.println("-----------");
        System.out.println("2. Edit Task");
        System.out.println("-----------");
        System.out.println("3. Delete Task");
        System.out.println("--------------");
        System.out.println("4. Set Priority");
        System.out.println("---------------");
        System.out.println("5. Set Deadline");
        System.out.println("---------------");
        System.out.println("6. Set Completed");
        System.out.println("----------------");
        System.out.println("7. Filter Tasks by Priority");
        System.out.println("---------------------------");
        System.out.println("8. Filter Tasks by Deadline");
        System.out.println("---------------------------");
        System.out.println("9. Filter Tasks by Status");
        System.out.println("-------------------------");
        System.out.println("10. Display All Tasks");
        System.out.println("---------------------");
        System.out.println("0. Exit");
        System.out.println("-------");
        System.out.print("Enter your choice from above options: ");
    }

    // reads the choice from the user input
    private int readChoice() {
        int choice = -1;

        try {
            choice = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            System.out.println("Invalid choice selected. Please choose number from the list");
        }

        return choice;
    }

    // Adds a new task to the task manager based on the user input
    public void addTask() {
        System.out.println("Enter task name");
        String addName = scanner.nextLine();
        System.out.println("Enter task description");
        String description = scanner.nextLine();
        System.out.println("Enter the person name who is adding the task");
        String manager = scanner.nextLine();
        System.out.println("Enter the date on which the task is created");
        String createDate = scanner.nextLine();

        //Task task = new Task(addName, description, manager, createDate);
        taskManager.addTask(task);
        System.out.println("Your task has been added successfully.");
    }

    // Edits the existing task based on the user input
    public void editTask() {
        System.out.print("Enter the name of the task which you want to edit: ");
        String editName = scanner.nextLine();

        Task task = taskManager.getTaskByName(editName);
        if (task != null) {
            System.out.print("Enter new task description: ");
            String description = scanner.nextLine();
            System.out.print("Enter the person name who is adding the task: ");
            String manager = scanner.nextLine();
            System.out.print("Enter the date on which the task is created: ");
            String editDate = scanner.nextLine();
            taskManager.editTask(editName, description, manager, editDate);
            System.out.println("Your task has been edited successfully.");
        } else {
            System.out.println("Oops...!!! Task not found.");
        }
    }

    // Deletes the task based on the user input
    public void deleteTask() {
        System.out.print("Enter the name of the task which you want to delete: ");
        String deleteName = scanner.nextLine();

        Task task = taskManager.getTaskByName(deleteName);
        if (task != null) {
            taskManager.deleteTask(deleteName);
            System.out.println("Your task has been deleted successfully.");
        } else {
            System.out.println("Oops...!!! Task not found.");
        }
    }

    // Sets the task priority based on the user input
    public void setPriority() {
        System.out.print("Enter the name of the task: ");
        String priorityName = scanner.nextLine();

        Task task = taskManager.getTaskByName(priorityName);
        if (task != null) {
            System.out.print("Enter priority (LOW, MEDIUM, HIGH) you want to set: ");
            String priorityInput = scanner.nextLine();

            try {
                Priority priority = Priority.valueOf(priorityInput.toUpperCase());
                taskManager.setPriority(priorityName, priority);
                System.out.println("Priority set successfully.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority value.");
            }
        } else {
            System.out.println("Task not found.");
        }
    }

    // Sets the task deadline based on the user input
    public void setDeadline() {
        System.out.print("Enter the name of the task: ");
        String deadlineTaskName = scanner.nextLine();

        Task task = taskManager.getTaskByName(deadlineTaskName);
        if (task != null) {
            System.out.print("Enter deadline (NONE, TODAY, TOMORROW, NEXT_WEEK): ");
            String deadlineInput = scanner.nextLine();

            try {
                Deadline deadline = Deadline.valueOf(deadlineInput.toUpperCase());
                taskManager.setDeadline(deadlineTaskName, deadline);
                System.out.println("Deadline set successfully.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid deadline value.");
            }
        } else {
            System.out.println("Task not found.");
        }
    }

    // Sets the task completion status based on the user input
    public void setCompleted() {
        System.out.print("Enter the name of the task: ");
        String completedName = scanner.nextLine();

        Task task = taskManager.getTaskByName(completedName);
        if (task != null) {
            System.out.print("Enter completion status (true/false): ");
            String completedInput = scanner.nextLine();

            try {
                boolean completed = Boolean.parseBoolean(completedInput);
                taskManager.setCompleted(completedName, completed);
                System.out.println("Completion status set successfully.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid completion status value.");
            }
        } else {
            System.out.println("Task not found.");
        }
    }

    // Filters the task by priority
    public void filterByPriority() {
        System.out.print("Enter priority to filter by (LOW, MEDIUM, HIGH): ");
        String inputForPriority = scanner.nextLine();

        try {
            Priority priority = Priority.valueOf(inputForPriority.toUpperCase());
            System.out.println("Filtered tasks by priority: ");
            taskManager.getTasksByPriority(priority).forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid priority value.");
        }
    }

    // Filters the task by deadline
    public void filterByDeadline() {
        System.out.print("Enter deadline to filter by (NONE, TODAY, TOMORROW, NEXT_WEEK): ");
        String inputForDeadline = scanner.nextLine();

        try {
            Deadline deadline = Deadline.valueOf(inputForDeadline.toUpperCase());
            System.out.println("Filtered tasks by deadline: ");
            taskManager.getTasksByDeadline(deadline).forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid deadline value.");
        }
    }

    // Filters the task by status
    public void filterByStatus() {
        System.out.print("Enter completion status to filter by (true/false): ");
        String inoutForStatus = scanner.nextLine();

        try {
            boolean completed = Boolean.parseBoolean(inoutForStatus);
            System.out.println("Filtered tasks by completion status: ");
            taskManager.getTasksByStatus(completed).forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid completion status value.");
        }
    }
    // Show all tasks
    public void displayAllTasks() {
        System.out.println("All tasks: ");
        taskManager.getAllTasks().forEach(System.out::println);
    }
}
