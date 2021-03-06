package popo.commands;

import static popo.utils.Messages.MESSAGE_ADDED_TASK;
import static popo.utils.Messages.MESSAGE_TASKLIST_SIZE_FORMAT;

import popo.tasks.ToDoTask;

/**
 * Creates a ToDo task.
 */
public class ToDoCommand extends Command {
    public static final String COMMAND_WORD = "todo";
    public static final String MESSAGE_USAGE = "Command Word: " + COMMAND_WORD + "\n"
            + "Description: Add a todo task\n"
            + "Usage: todo <task_description>\n"
            + "Example: todo Go CNY shopping";

    private final String taskName;

    /**
     * Creates a {@code ToDoCommand} with the given task name.
     *
     * @param taskName Name of the task.
     */
    public ToDoCommand(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public CommandResult execute() {
        assert taskList != null;
        ToDoTask task = new ToDoTask(taskName);
        taskList.addTask(task);
        return new CommandResult(taskList, false,
                MESSAGE_ADDED_TASK + "\n",
                task.toString() + "\n",
                String.format(MESSAGE_TASKLIST_SIZE_FORMAT, taskList.size()));
    }
}
