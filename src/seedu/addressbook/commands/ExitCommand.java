package seedu.addressbook.commands;

import java.util.Iterator;

import seedu.addressbook.data.tag.Tagging;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Exits the program.\n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_EXIT_ACKNOWEDGEMENT = "Exiting Address Book as requested ...";

    @Override
    public CommandResult execute() {
        return new CommandResult(getTaggings() + MESSAGE_EXIT_ACKNOWEDGEMENT);
    }
    
    /**
     * Gets the list of taggings from the address book and formats it into a string for printing
     * @return Formatted string representation for printing
     */
    private String getTaggings() {
        StringBuilder sb = new StringBuilder();
        Iterator<Tagging> itr = addressBook.getAllTaggings().iterator();
        final String LINE_SEPERATOR = System.lineSeparator();
        while (itr.hasNext()) {
            sb.append(itr.next().toString());
            if (itr.hasNext()) {
                sb.append(LINE_SEPERATOR);
            }
        }
        sb.append(LINE_SEPERATOR);
        return sb.toString();
    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand; // instanceof returns false if it is null
    }
}
