import org.example.TaskManagerApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import java.io.InputStream;
import java.util.Scanner;
import org.example.Task;

import static org.junit.gen5.api.Assertions.assertEquals;
import static org.junit.gen5.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class TaskManagerAppTest {
    private TaskManagerApp taskManagerApp;
    private Scanner scanner;


    @BeforeEach
    void setUp() {
        taskManagerApp = new TaskManagerApp();
    }
    @Test
    public void testAddTask() {
        // Mocking user input
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.AppRun();
        verify(taskManagerApp).addTask();


//    Task task = new Task("Task 1", "Description 1", "Manager 1", "20 Feb 2023");
//        boolean taskAdded = taskManagerApp.addTask(task);
//        // Making sure the addTask method is invoked
//        Assertions.assertTrue(taskAdded);
    }

    @Test
    public void testEditTask() {
        // Mocking user input
        String input = "2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.AppRun();

        // Making sure the editTask method is invoked
        verify(taskManagerApp).editTask();
    }

    @Test
    public void testDeleteTask() {
        // Mocking user input
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.AppRun();

        // Making sure the deleteTask method is invoked
        verify(taskManagerApp).deleteTask();
    }

    @Test
    public void testSetPriority() {
        // Mocking user input
        String input = "4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.AppRun();

        // Making sure the setPriority method is invoked
        verify(taskManagerApp).setPriority();
    }

    @Test
    public void testSetDeadline() {
        // Mocking user input
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.AppRun();

        // Making sure the setDeadline method is invoked
        verify(taskManagerApp).setDeadline();
    }

    @Test
    public void testSetCompleted() {
        // Mocking user input
        String input = "6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.AppRun();

        // Making sure the setCompleted method is invoked
        verify(taskManagerApp).setCompleted();
    }

    @Test
    public void testFilterByPriority() {
        // Mocking user input
        String input = "7";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.AppRun();

        // Making sure the filterByPriority method is invoked
        verify(taskManagerApp).filterByPriority();
    }

    @Test
    public void testFilterByDeadline() {
        // Mocking user input
        String input = "8";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.AppRun();

        // Making sure the filterByDeadline method is invoked
        verify(taskManagerApp).filterByDeadline();
    }

    @Test
    public void testFilterByStatus() {
        // Mocking user input
        String input = "9";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.AppRun();

        // Making sure the filterByStatus method is invoked
        verify(taskManagerApp).filterByStatus();
    }

    @Test
    public void testDisplayAllTasks() {
        // Mocking user input
        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.AppRun();

        // Making sure the displayAllTasks method is invoked
        verify(taskManagerApp).displayAllTasks();
    }

//    @Test
//    void testAddTaskWithValidInput() {
//        when(scanner.nextLine()).thenReturn("Task 1", "Description 1", "Manager 1", "20 Feb 2023");
//
//        Task task = new Task("Task 1", "Description 1", "Manager 1", "20 Feb 2023");
//        taskManagerApp.addTask(task);
//
////        taskManagerApp.addTask();
//
//        String expectedOutput = "Your task has been added successfully.";
//        assertEquals(expectedOutput, task);
//    }


    @Test
    void testAddTask_ValidInput() {
        String input = "Task 1\nDescription 1\nManager 1\n20 Feb 2023\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.addTask();
    }

    @Test
    void testAddTask_EmptyInput() {
        String input = "\n\n\n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.addTask();
    }

    @Test
    void testAddTask_NullInput() {
        // Mock the Scanner object to simulate null input for all fields
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn(null);

       // taskManagerApp.setScanner(mockScanner);
        taskManagerApp.addTask();
    }

    @Test
    void testAddTask_SpecialCharacters() {
        String input = "Task#1\nDescription@1\nManager!1\n20*Feb&2023\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        taskManagerApp.addTask();
    }

}
