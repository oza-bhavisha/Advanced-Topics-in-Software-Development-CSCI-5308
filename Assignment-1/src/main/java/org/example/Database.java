package org.example;

import java.util.*;

public interface Database {
    /**
     * Connects to the database
     *
     * @return true if the connection is successful, false otherwise
     */
    boolean connect();

    /**
     * Disconnects from the database
     *
     * @return true if disconnected successfully, false otherwise
     */
    boolean disconnect();

    /**
     * Saves a task
     *
     * @param task which needs to be saved
     */
    void saveTask(Task task);

    /**
     * Deletes a task
     *
     * @param task which needs to be deleted
     */
    void deleteTask(Task task);

    /**
     * Retrieves all the tasks
     *
     * @return entire list of the task
     */
    List<Task> getAllTasks();
}
