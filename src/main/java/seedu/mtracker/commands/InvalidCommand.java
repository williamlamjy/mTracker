package seedu.mtracker.commands;

//@@author KVignesh122
public class InvalidCommand extends Command {

    public static final String COMMAND_WORD = "invalid";

    @Override
    public String execute() {
        return COMMAND_WORD;
    }
}
