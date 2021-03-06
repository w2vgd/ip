package popo.commands;

import static popo.utils.Messages.MESSAGE_DONE_TASK;
import static popo.utils.Messages.MESSAGE_TASK_ALREADY_COMPLETED;

/**
 * Completes a task.
 */
public class DoneCommand extends Command {
    public static final String COMMAND_WORD = "done";
    public static final String MESSAGE_USAGE = "Command Word: " + COMMAND_WORD + "\n"
            + "Description: Mark a task as completed\n"
            + "Usage: done <task_number>"
            + "Example: done 2";

    private final int index;

    /**
     * Creates a {@code DoneCommand} object with the index of the task in the task list to be marked as done.
     *
     * @param index Index of the task to be marked as done.
     */
    public DoneCommand(int index) {
        this.index = index;
    }

    @Override
    public CommandResult execute() {
        assert taskList != null;
        if (taskList.isTaskDone(index)) {
            return new CommandResult(false, MESSAGE_TASK_ALREADY_COMPLETED);
        }
        taskList.completeTask(index);
        return new CommandResult(taskList, false,
                MESSAGE_DONE_TASK + "\n",
                taskList.getTask(index).toString());
    }
}
