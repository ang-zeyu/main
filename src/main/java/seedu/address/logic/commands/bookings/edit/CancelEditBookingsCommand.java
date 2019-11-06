package seedu.address.logic.commands.bookings.edit;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.appstatus.PageType;
import seedu.address.model.expenditure.Expenditure;

/**
 * Command that cancels editing the expenditure, bringing the user back to the expenses manager screen.
 */
public class CancelEditBookingsCommand extends Command {
    public static final String COMMAND_WORD = "cancel";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Cancels editing or creating a new bookings.";

    public static final String MESSAGE_CANCEL_CREATE_SUCCESS = "Cancelled creating the bookings!";
    public static final String MESSAGE_CANCEL_EDIT_SUCCESS = "Cancelled editing the bookings: %1$s";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        Expenditure currentlyEditingExpenditure = model.getPageStatus().getExpenditure();
        model.setPageStatus(model.getPageStatus()
                .withResetEditExpenditureDescriptor()
                .withNewPageType(PageType.BOOKINGS)
                .withResetExpenditure());

        if (currentlyEditingExpenditure == null) {
            return new CommandResult(MESSAGE_CANCEL_CREATE_SUCCESS, true);
        } else {
            return new CommandResult(
                    String.format(MESSAGE_CANCEL_EDIT_SUCCESS, currentlyEditingExpenditure), true);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof CancelEditBookingsCommand;
    }
}
