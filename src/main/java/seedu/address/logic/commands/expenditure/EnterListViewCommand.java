package seedu.address.logic.commands.expenditure;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Enters the itinerary page of travel pal.
 */
public class EnterListViewCommand extends Command {
    public static final String COMMAND_WORD = "showlist";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Enters the list view of expense manager.";

    public static final String MESSAGE_SUCCESS = "Entered the list view of expense manager.";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult(MESSAGE_SUCCESS, true, COMMAND_WORD);
    }
}