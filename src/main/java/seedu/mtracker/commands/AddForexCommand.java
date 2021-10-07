package seedu.mtracker.commands;

public class AddForexCommand extends AddInstrumentCommand {

    public static final String COMMAND_WORD = "forex";

    @Override
    public String execute() {
        return COMMAND_WORD;
    }
}
