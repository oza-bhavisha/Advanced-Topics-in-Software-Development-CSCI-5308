package org.example;

import java.util.*;

/**
 * This class represents a mock database implementation
 * Provides methods to connect, disconnect, save, delete, and retrieve the tasks.
 */
public class MockDatabase implements Database {
    private final List<Task> tasks;

    public MockDatabase(){
        this.tasks = new ArrayList<>();
    }

    /**
     * Connects to the database
     *
     * @return true if the connection is successful, false otherwise
     */
    @Override
    public boolean connect(){
        System.out.println("Database connected");
        return true;
    }

    /**
     * Disconnects from the database
     *
     * @return true if disconnected successfully, false otherwise
     */
    @Override
    public boolean disconnect(){
        System.out.println("Database disconnected");
        return true;
    }

    /**
     * Saves a task
     *
     * @param saveTask which needs to be saved
     */
    @Override
    public void saveTask(Task saveTask){
        tasks.add(saveTask);
    }

    /**
     * Deletes a task
     *
     * @param deleteTask which needs to be deleted
     */
    @Override
    public void deleteTask(Task deleteTask){
        tasks.remove(deleteTask);
    }

    /**
     * Retrieves all the tasks
     *
     * @return entire list of the task
     */
    @Override
    public List<Task> getAllTasks(){
        return new ArrayList<>(tasks);
    }
}
