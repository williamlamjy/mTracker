package seedu.mtracker.commands;

import seedu.mtracker.ui.TextUi;

public class CheckOffInstrumentCommand extends Command{

    public int completedInstrumentIndex;
    public static final String COMMAND_WORD = "done";

    public CheckOffInstrumentCommand(int completedInstrumentIndex) {
        this.completedInstrumentIndex = completedInstrumentIndex;
    }

    @Override
    public String execute(){
        instrumentManager.checkOffInstrument(completedInstrumentIndex);
        TextUi.displayCheckOffInstrument(instrumentManager.getInstrument(completedInstrumentIndex));
        return COMMAND_WORD;
    }
}
