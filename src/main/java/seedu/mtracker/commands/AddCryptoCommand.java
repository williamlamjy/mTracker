package seedu.mtracker.commands;

import seedu.mtracker.model.subinstrument.Crypto;
import seedu.mtracker.ui.TextUi;

import java.time.LocalDate;

//@@author williamlamjy
/**
 * Responsible for adding Crypto to the list.
 */
public class AddCryptoCommand extends AddInstrumentCommand {

    public static final String COMMAND_WORD = "crypto";

    public static final int EXPIRY_INDEX = 3;
    public static final int REMARK_INDEX = 4;

    protected LocalDate expiryParameter;
    protected String remarkParameter;

    public void setCryptoParameters() {
        expiryParameter = LocalDate.parse(inputParameters.get(EXPIRY_INDEX));
        remarkParameter = inputParameters.get(REMARK_INDEX);
    }

    public void createNewCrypto() {
        newInstrument = new Crypto(nameParameter, currentPriceParameter,
                sentimentParameter, expiryParameter, remarkParameter);
    }

    /**
     * Handles the execution of adding Crypto to the list.
     *
     * @return The name of the command.
     */
    @Override
    public String execute() {
        setAddGeneralParameters();
        setCryptoParameters();
        createNewCrypto();
        instrumentManager.addInstrument(newInstrument);
        TextUi.displayInstrumentAdded(newInstrument);
        return COMMAND_WORD;
    }
}
