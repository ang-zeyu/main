package seedu.address.logic.parser.trips;

import seedu.address.logic.commands.trips.EnterCreateTripCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

public class EnterCreateTripParser implements Parser<EnterCreateTripCommand> {
    @Override
    public EnterCreateTripCommand parse(String args) throws ParseException {
        return new EnterCreateTripCommand();
    }
}