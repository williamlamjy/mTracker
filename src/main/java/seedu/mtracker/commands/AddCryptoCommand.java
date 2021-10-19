package seedu.mtracker.commands;

import seedu.mtracker.instrument.subinstrument.Crypto;
import seedu.mtracker.ui.TextUi;

import java.time.LocalDate;

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
