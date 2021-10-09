package seedu.mtracker.commands;

public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    @Override
    public String execute() {
        return COMMAND_WORD;
    }
}
