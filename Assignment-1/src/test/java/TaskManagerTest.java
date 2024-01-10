import org.example.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class) // mockito extension reference: https://www.javadoc.io/static/org.mockito/mockito-junit-jupiter/5.3.1/org/mockito/junit/jupiter/MockitoExtension.html#:~:text=Class%20MockitoExtension&text=Use%20parameters%20for%20initialization%20of,)%20%2C%20use%20the%20method%20parameter.
@MockitoSettings(strictness = Strictness.LENIENT) // strictness reference taken from: https://www.davidvlijmincx.com/posts/setting_the_strictness_for_mockito_mocks/
public class TaskManagerTest {
    @Mock
    private Database mockDatabase;
    private static TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        taskManager = new TaskManager(mockDatabase);
    }

    @Test
    public void testAddTask_checkTaskIsSavedToDb() {
        Task task = new Task("Task 1", "Description 1", "Manager 1", "20 Feb 2023");
        taskManager.addTask(task);
        verify(mockDatabase, times(1)).saveTask(task);
    }

    @Test
    public void testDeleteTask_checkTaskIsDeletedFromDb() {
        Task task = new Task("Task 1", "Description 1", "Manager 1", "20 Feb 2023");
        taskManager.addTask(task);
        taskManager.deleteTask(task);
        verify(mockDatabase, times(1)).deleteTask(task);
    }

    @Test
    public void testGetAllTasks_checkAllTasksAreReturnedFromDatabase() {
        List<Task> mockTasks = new ArrayList<>();
        mockTasks.add(new Task("Task 1", "Description 1", "Manager 1", "20 Feb 2023"));
        mockTasks.add(new Task("Task 2", "Description 2", "Manager 2", "20 july 2023"));
        when(mockDatabase.getAllTasks()).thenReturn(mockTasks);

        taskManager.setAllTasks(mockTasks);
        List<Task> allTasks = taskManager.getAllTasks();
        assertEquals(mockTasks, allTasks);
    }

    @Test
    public void testEditTask_checkTaskDescriptionIsUpdated() {
        String taskName = "Task 1";
        String newDescription = "New Description";
        Task mockTask = new Task("Task 1", "Description 1", "Manager 1", "20 jun 2023");
        when(mockDatabase.getAllTasks()).thenReturn(new ArrayList<>(List.of(mockTask)));
        taskManager.setAllTasks(List.of(mockTask));

        taskManager.editTask(taskName, newDescription, "", "");
        assertEquals(newDescription, mockTask.getDescription());
    }

    @Test
    //issue
    public void testDeleteTaskByName_checkTaskIsRemovedFromList() {
        Task mockTask = new Task("Task 1", "Description 1", "Manager 1", "20 Feb 2023");
        List<Task> tasks = new ArrayList<>(List.of(mockTask));
        when(mockDatabase.getAllTasks()).thenReturn(tasks);
        taskManager.addTask(mockTask);

        taskManager.deleteTask("Task 1");
        assertFalse(taskManager.getAllTasks().contains(mockTask));
    }

    @Test
    public void testSetPriority_checkTaskPriorityIsUpdated() {
        String taskName = "Task 1";
        Task task = new Task("Task 1", "Description 1", "Manager 1", "20 Feb 2023");
        taskManager.addTask(task);
        Priority newPriority = Priority.HIGH;
        Task mockTask = new Task("Task 2", "Description 2", "Manager 2", "20 Jan 2023");
        when(mockDatabase.getAllTasks()).thenReturn(new ArrayList<>(List.of(mockTask)));
        //taskManager.setAllTasks(List.of(mockTask));

        taskManager.setPriority(taskName, newPriority);
        assertEquals(newPriority, taskManager.getTaskByName("Task 1").getPriority());
    }

    @Test
    public void testSetDeadline_checkTaskDeadlineIsUpdated() {
        String taskName = "Task 1";
        Deadline newDeadline = Deadline.TODAY;
        Task mockTask = new Task("Task 1", "Description 1", "Manager 1", "2 Feb 2023");
        when(mockDatabase.getAllTasks()).thenReturn(new ArrayList<>(List.of(mockTask)));
        taskManager.addTask(mockTask);

        taskManager.setDeadline(taskName, newDeadline);
        assertEquals(newDeadline, mockTask.getDeadline());
    }

    @Test
    public void testSetCompleted_checkTaskCompletionStatusIsUpdated() {
        String taskName = "Task 1";
        boolean completed = true;
        Task mockTask = new Task("Task 1", "Description 1", "Manager 1", "20 Feb 2023");
        when(mockDatabase.getAllTasks()).thenReturn(new ArrayList<>(List.of(mockTask)));
        taskManager.addTask(mockTask);
        taskManager.setCompleted(taskName, completed);
        assertEquals(completed, mockTask.isCompleted());
    }

    @Test
    public void testGetTasksByPriority_checkTasksWithMatchingPriorityIsReturned() {
        Priority priority = Priority.HIGH;
        Task highPriorityTask = new Task("Task 1", "Description 1", "Manager 1", "20 Jan 2023");
        highPriorityTask.setPriority(priority);
        Task lowPriorityTask = new Task("Task 2", "Description 2", "Manager 2", "29 Jan 2023");
        lowPriorityTask.setPriority(Priority.LOW);
        List<Task> tasks = new ArrayList<>(List.of(highPriorityTask, lowPriorityTask));
        when(mockDatabase.getAllTasks()).thenReturn(tasks);
        taskManager.addTask(highPriorityTask);
        taskManager.addTask(lowPriorityTask);

        List<Task> tasksByPriority = taskManager.getTasksByPriority(priority);
        assertEquals(1, tasksByPriority.size());
        assertEquals(highPriorityTask, tasksByPriority.get(0));
    }

    @Test
    public void testGetTasksByDeadline_checkTasksWithMatchingDeadlineIsReturned() {
        Deadline deadline = Deadline.TODAY;
        Task taskWithDeadline = new Task("Task 1", "Description 1", "Manager 1", "20 Jan 2023");
        taskWithDeadline.setDeadline(deadline);
        Task taskWithoutDeadline = new Task("Task 2", "Description 2", "Manager 2", "25 Jan 2023");
        List<Task> tasks = new ArrayList<>(List.of(taskWithDeadline, taskWithoutDeadline));
        when(mockDatabase.getAllTasks()).thenReturn(tasks);

        taskManager.addTask(taskWithDeadline);
        taskManager.addTask(taskWithoutDeadline);

        List<Task> tasksByDeadline = taskManager.getTasksByDeadline(deadline);
        assertEquals(1, tasksByDeadline.size());
        assertEquals(taskWithDeadline, tasksByDeadline.get(0));
    }

    @Test
    public void testGetTasksByStatus_checkTasksWithMatchingCompletionStatusIsReturned() {
        boolean completed = true;
        Task completedTask = new Task("Task 1", "Description 1", "Manager 1", "20 Jan 2023");
        completedTask.setCompleted(completed);
        Task incompleteTask = new Task("Task 2", "Description 2", "Manager 2", "26 Jan 2023");
        List<Task> tasks = new ArrayList<>(List.of(completedTask, incompleteTask));
        when(mockDatabase.getAllTasks()).thenReturn(tasks);

        taskManager.addTask(completedTask);
        taskManager.addTask(incompleteTask);

        List<Task> tasksByStatus = taskManager.getTasksByStatus(completed);
        assertEquals(1, tasksByStatus.size());
        assertEquals(completedTask, tasksByStatus.get(0));
    }
}
