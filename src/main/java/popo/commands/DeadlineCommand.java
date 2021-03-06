package popo.commands;

import static popo.utils.Messages.MESSAGE_ADDED_TASK;
import static popo.utils.Messages.MESSAGE_TASKLIST_SIZE_FORMAT;

import java.time.LocalDate;
import java.time.LocalTime;

import popo.tasks.DeadlineTask;

/**
 * Creates a Deadline task.
 */
public class DeadlineCommand extends Command {
    public static final String COMMAND_WORD = "deadline";
    public static final String MESSAGE_USAGE = "Command Word: " + COMMAND_WORD + "\n"
            + "Description: Add a deadline task with a date component and an optional time component\n"
            + "Usage 1: deadline <task_description> /by dd/mm/yyyy\n"
            + "Example: deadline Assignment 1 /by 31/1/2021\n"
            + "Usage 2: deadline <task_description> /by dd/mm/yyyy HHMM\n"
            + "Example: deadline Assignment 1 /by 31/1/2021 1800\n"
            + "Example: deadline Assignment 2 /by 28/10/2021, 2359";

    private final String taskName;
    private final LocalDate deadlineDate;
    private final LocalTime deadlineTime;

    /**
     * Creates a {@code DeadlineCommand} object with a deadline date component only.
     *
     * @param taskName     Name of the task.
     * @param deadlineDate Date component of deadline.
     */
    public DeadlineCommand(String taskName, LocalDate deadlineDate) {
        this.taskName = taskName;
        this.deadlineDate = deadlineDate;
        deadlineTime = null;
    }

    /**
     * Creates a {@code DeadlineCommand} object with the given task name, deadline date and time components.
     *
     * @param taskName     Name of the task.
     * @param deadlineDate Date component of deadline.
     * @param deadlineTime Time component of deadline.
     */
    public DeadlineCommand(String taskName, LocalDate deadlineDate, LocalTime deadlineTime) {
        this.taskName = taskName;
        this.deadlineDate = deadlineDate;
        this.deadlineTime = deadlineTime;
    }

    @Override
    public CommandResult execute() {
        assert taskList != null;
        DeadlineTask task = new DeadlineTask(taskName, deadlineDate, deadlineTime);
        taskList.addTask(task);
        return new CommandResult(taskList, false,
                MESSAGE_ADDED_TASK + "\n",
                task.toString() + "\n",
                String.format(MESSAGE_TASKLIST_SIZE_FORMAT, taskList.size()));
    }
}
