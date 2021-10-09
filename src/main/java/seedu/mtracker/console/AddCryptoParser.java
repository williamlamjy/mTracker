package seedu.mtracker.console;

import seedu.mtracker.commands.AddCryptoCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.ui.TextUi;

public class AddCryptoParser extends AddInstrumentParser {

    public static String INSTRUMENT_TYPE = "crypto";

    public String getCryptoRemarksFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput();
    }

    public String getCryptoExpiryFromUser() {
        TextUi.displayAddExpiryInstruction();
        return getUserInput();
    }

    public void addCryptoExpiryToParameters() {
        String expiry = getCryptoExpiryFromUser();
        if(isValidSpecificParameter(expiry)){
            parameters.add(expiry);
        }
    }

    public void addCryptoRemarksToParameters() {
        String remarks = getCryptoRemarksFromUser();
        if(isValidSpecificParameter(remarks)){
            parameters.add(remarks);
        }
    }

    public void getCryptoSpecificParameters() {
        addCryptoExpiryToParameters();
        addCryptoRemarksToParameters();
    }

    public static boolean isValidSpecificParameter(String userInput) {
        boolean isValid = true;
        try {
            if (userInput.isEmpty()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            ErrorMessage.displayAddEmptyParameterError();
            isValid = false;
        }
        return isValid;
    }

    @Override
    public AddInstrumentCommand getInstrumentParameters() {
        getGeneralParameters(INSTRUMENT_TYPE);
        getCryptoSpecificParameters();

        return new AddCryptoCommand();
    }
}
