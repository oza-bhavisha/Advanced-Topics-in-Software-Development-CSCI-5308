import org.example.MockDatabase;
import org.example.Task;
import org.example.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.gen5.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MockDatabaseTest {

    private List<Task> tasks;


    @BeforeEach
    void setUp() {
        tasks = new ArrayList<>();
    }

    @Test
    public void openConnectionTest() {

        MockDatabase dbConnect = null;
        try {
            dbConnect = new MockDatabase();
            Assertions.assertTrue(dbConnect.connect(),"Connection Successful" );
        } catch (Exception e) {
            Assertions.assertFalse(dbConnect.connect(),"Connection Failed");
        }

    }

    @Test
    public void closeConnectionTest() {

        MockDatabase dbConnect = null;
        try {
            dbConnect = new MockDatabase();
            Assertions.assertTrue(dbConnect.disconnect(),"Connection Closed" );
        } catch (Exception e) {
            Assertions.assertFalse(dbConnect.disconnect(),"Connection Failed");
        }

    }

    @Test
    public void saveTaskTest() {
        MockDatabase database = new MockDatabase();

        Task task = new Task("Task 1", "Description 1", "Manager 1", "20 Feb 2023");
        database.saveTask(task);
        assertFalse(tasks.contains(task));
    }

    @Test
    public void deleteTaskTest() {
        MockDatabase database = new MockDatabase();

        Task task1 = new Task("Task 1", "Description 1", "Manager 1", "20 Feb 2023");
        Task task2 = new Task("Task 2", "Description 2", "Manager 2", "20 July 2023");
        tasks.add(task1);
        tasks.add(task2);

        database.deleteTask(task1);
        assertFalse(database.getAllTasks().contains(task1));
    }

    @Test
    void getAllTasksTest() {
        MockDatabase database = new MockDatabase();
        List<Task> result = database.getAllTasks();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
