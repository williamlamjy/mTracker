package seedu.mtracker.commands;

public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "bye";

    @Override
    public String execute() {
        return COMMAND_WORD;
    }
}
