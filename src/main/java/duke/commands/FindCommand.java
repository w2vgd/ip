package duke.commands;

import static duke.utils.Messages.MESSAGE_FOUND_TASKS;
import static duke.utils.Messages.MESSAGE_INDEX_TASK_FORMAT;
import static duke.utils.Messages.MESSAGE_NO_MATCHES;

import duke.tasks.Task;

/**
 * Finds tasks that contains specific keywords or phrases.
 */
public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    public static final String MESSAGE_USAGE = "Command Word: " + COMMAND_WORD + "\n"
            + "Description: Find tasks that contains specific keywords or phrases\n"
            + "Usage: find <keyword_or_phrase>"
            + "Example: find book";

    private final String searchWord;

    public FindCommand(String searchWord) {
        this.searchWord = searchWord;
    }

    @Override
    public CommandResult execute() {
        StringBuilder tasksWithSearchWord = new StringBuilder();
        for (int i = 1; i <= taskList.size(); i++) {
            Task task = taskList.getTask(i - 1);
            if (task.getName().contains(searchWord)) {
                tasksWithSearchWord.append(String.format(MESSAGE_INDEX_TASK_FORMAT, i, taskList.getTask(i - 1)));
                tasksWithSearchWord.append("\n");
            }
        }
        if (tasksWithSearchWord.length() == 0) {
            return new CommandResult(MESSAGE_NO_MATCHES, false);
        } else {
            tasksWithSearchWord.deleteCharAt(tasksWithSearchWord.length() - 1);
            return new CommandResult(MESSAGE_FOUND_TASKS + "\n" + tasksWithSearchWord.toString(), false);
        }
    }
}
