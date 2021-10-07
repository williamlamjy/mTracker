package seedu.mtracker.commands;

public class AddEtfCommand extends AddInstrumentCommand {

    public static final String COMMAND_WORD = "etf";

    @Override
    public String execute() {
        return COMMAND_WORD;
    }
}
