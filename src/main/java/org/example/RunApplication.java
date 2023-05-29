package org.example;

import org.example.*;

/**
 * Class responsible for running the TaskManager application.
 *
 */
public class RunApplication {
    public static void main(String[] args) {
        // Creating a mock database object
        Database database = new MockDatabase();

        try{
            // Connect to the database
            database.connect();
        } catch (Exception e){
            System.out.println("Couldn't establish database connection...");
        }

        TaskManagerApp taskManagerApp = new TaskManagerApp();
        taskManagerApp.AppRun();

        try {
            // Disconnect from the database
            database.disconnect();
        } catch (Exception e){
            System.out.println("Couldn't disconnect the database connection...");
        }
    }
}