package popo.commands;

import static popo.utils.Messages.MESSAGE_DELETED_TASK;
import static popo.utils.Messages.MESSAGE_TASKLIST_SIZE_FORMAT;

import popo.tasks.Task;

/**
 * Deletes a task.
 */
public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    public static final String MESSAGE_USAGE = "Command Word: " + COMMAND_WORD + "\n"
            + "Description: Delete a task\n"
            + "Usage: delete <task_number>\n"
            + "Example: delete 2";

    private final int index;

    /**
     * Creates a {@code DeleteCommand} object with the index of the task in the task list to be deleted.
     *
     * @param index Index of the task to be deleted.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public CommandResult execute() {
        assert taskList != null;
        Task task = taskList.getTask(index);
        taskList.deleteTask(index);
        return new CommandResult(taskList, false,
                MESSAGE_DELETED_TASK + "\n",
                task.toString() + "\n",
                String.format(MESSAGE_TASKLIST_SIZE_FORMAT, taskList.size()));
    }
}
