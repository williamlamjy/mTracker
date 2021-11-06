package seedu.mtracker.commands;

import seedu.mtracker.model.subinstrument.Forex;
import seedu.mtracker.ui.TextUi;

import java.time.LocalDate;

/**
 * Responsible for adding Forex to the list.
 */
public class AddForexCommand extends AddInstrumentCommand {
    public static final String COMMAND_WORD = "forex";

    public static final int ENTRY_INDEX = 3;
    public static final int EXIT_INDEX = 4;
    public static final int EXPIRY_INDEX = 5;
    public static final int REMARK_INDEX = 6;

    protected double entryPriceParameter;
    protected double exitPriceParameter;
    protected LocalDate expiryParameter;
    protected String remarkParameter;

    public void setForexParameters() {
        entryPriceParameter = Double.parseDouble(inputParameters.get(ENTRY_INDEX));
        exitPriceParameter = Double.parseDouble(inputParameters.get(EXIT_INDEX));
        expiryParameter = LocalDate.parse(inputParameters.get(EXPIRY_INDEX));
        remarkParameter = inputParameters.get(REMARK_INDEX);
    }

    public void createNewFxPair() {
        newInstrument = new Forex(
                nameParameter,
                currentPriceParameter,
                sentimentParameter,
                entryPriceParameter,
                exitPriceParameter,
                expiryParameter,
                remarkParameter
        );
    }

    /**
     * Handles the execution of adding Forex to the list.
     *
     * @return The name of the command.
     */
    @Override
    public String execute() {
        setAddGeneralParameters();
        setForexParameters();
        createNewFxPair();
        instrumentManager.addInstrument(newInstrument);
        TextUi.displayInstrumentAdded(newInstrument);
        return COMMAND_WORD;
    }
}
