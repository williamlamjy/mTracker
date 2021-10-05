package seedu.mtracker.commands;

public class AddInstrumentCommand extends Command {

    public static final String COMMAND_WORD = "add";

    @Override
    public String execute() {
        return COMMAND_WORD;
    }
}
