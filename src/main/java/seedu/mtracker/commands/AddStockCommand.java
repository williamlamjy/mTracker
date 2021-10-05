package seedu.mtracker.commands;

public class AddStockCommand extends AddInstrumentCommand {

    public static final String COMMAND_WORD = "stock";

    @Override
    public String execute() {
        return COMMAND_WORD;
    }
}
