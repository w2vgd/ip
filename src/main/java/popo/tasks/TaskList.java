package popo.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a list of {@code Task}.
 */
public class TaskList {
    private final List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Checks if the list of tasks is empty.
     *
     * @return True if there are no tasks in the list, else false.
     */
    public boolean isEmpty() {
        return taskList.isEmpty();
    }

    /**
     * Returns the number of tasks in the list of tasks.
     *
     * @return Number of tasks in task list.
     */
    public int size() {
        return taskList.size();
    }

    /**
     * Adds a task to the list of tasks.
     *
     * @param task task to be added.
     */
    public void addTask(Task task) {
        taskList.add(task);
    }

    /**
     * Deletes a task from the list of tasks.
     *
     * @param index Index of the task to be removed in the list.
     */
    public void deleteTask(int index) {
        taskList.remove(index);
    }

    /**
     * Returns a task from the list of tasks according to the index specified.
     *
     * @param index Index of the task to be retrieved.
     * @return {@code Task}.
     */
    public Task getTask(int index) {
        return taskList.get(index);
    }

    /**
     * Checks if the specified task is completed.
     *
     * @param index Index of the task.
     * @return True if the task if completed, otherwise false.
     */
    public boolean isTaskDone(int index) {
        return taskList.get(index).isDone();
    }

    /**
     * Marks a task in the list of tasks as completed.
     *
     * @param index Index of the task to be marked as completed.
     */
    public void completeTask(int index) {
        taskList.get(index).completeTask();
    }

    /**
     * Returns an unmodifiable view of the task list.
     *
     * @return An unmodifiable {@code List} of tasks.
     */
    public List<Task> unmodifiableList() {
        return Collections.unmodifiableList(taskList);
    }
}
