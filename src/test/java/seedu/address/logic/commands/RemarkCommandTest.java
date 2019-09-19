package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.tag.Tag;


class RemarkCommandTest {
    private static final String REMARK_STUB = "nomnom";
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_addRemarkUnfilteredList_success() {
        Person testPerson = new Person(
                new Name("John"),
                new Phone("12345678"),
                new Email("john@gmail.com"),
                new Address("123 Orchard Road, Singapore"),
                new HashSet<Tag>(),
                new Remark(""));

        Remark testRemark = new Remark(REMARK_STUB);

        RemarkCommand remarkCommand = new RemarkCommand(
                Index.fromOneBased(1),
                testRemark);

        AddressBook testAddressBook = new AddressBook();
        testAddressBook.addPerson(testPerson);
        Model testModel = new ModelManager(testAddressBook, new UserPrefs());

        Person expectedPerson = new Person(
                new Name("John"),
                new Phone("12345678"),
                new Email("john@gmail.com"),
                new Address("123 Orchard Road, Singapore"),
                new HashSet<Tag>(),
                new Remark(REMARK_STUB));

        AddressBook expectedAddressBook = new AddressBook();
        expectedAddressBook.addPerson(expectedPerson);

        Model expectedModel = new ModelManager(expectedAddressBook, new UserPrefs());

        assertCommandSuccess(remarkCommand, testModel,
                String.format(RemarkCommand.MESSAGE_ADD_REMARK_SUCCESS, expectedPerson), expectedModel);
    }
}
