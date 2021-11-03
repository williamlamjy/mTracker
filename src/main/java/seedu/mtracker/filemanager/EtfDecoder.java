package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.fileerror.InvalidEmptyPastReturnsInFileError;
import seedu.mtracker.error.fileerror.InvalidPastReturnsSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidRemarksInFileError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Etf;
import seedu.mtracker.ui.TextUi;

public class EtfDecoder extends InstrumentDecoder {

    public static final int PAST_RETURNS_INDEX = 5;
    public static final int ETF_REMARKS_INDEX = 6;
    protected static double decodedPastReturns;
    protected static String decodedRemarks;

    public static boolean isValidPastReturns(String[] textSegment) {
        return Validate.isValidPastReturns(textSegment[PAST_RETURNS_INDEX]);
    }

    public static String getRemarksFromFile(String[] textSegment) throws InvalidRemarksInFileError {
        String remarks;
        try {
            remarks = textSegment[ETF_REMARKS_INDEX];
        } catch (IllegalArgumentException e) {
            throw new InvalidRemarksInFileError();
        }
        return remarks;
    }

    public static String getPastReturnsFromFile(String[] textSegment) throws InvalidEmptyPastReturnsInFileError {
        String pastReturns;
        try {
            pastReturns = textSegment[PAST_RETURNS_INDEX];
        } catch (IllegalArgumentException e) {
            throw new InvalidEmptyPastReturnsInFileError();
        }
        return pastReturns;
    }

    public static void validateAndDecodeSpecificAttributes(String[] textSegment) throws
            InvalidEmptyPastReturnsInFileError, InvalidRemarksInFileError, InvalidPastReturnsSavedInFileError {
        String pastReturns = getPastReturnsFromFile(textSegment);
        String remarks = getRemarksFromFile(textSegment);
        if (!pastReturns.isEmpty() && !isValidPastReturns(textSegment)) {
            throw new InvalidPastReturnsSavedInFileError();
        }
        decodeSpecificAttributes(pastReturns, remarks);
    }

    public static void tryValidateAndDecodeSpecificAttributes(String[] textSegment) {
        try {
            validateAndDecodeSpecificAttributes(textSegment);
        } catch (Exception e) {
            TextUi.showErrorMessage(e);
        }
    }

    private static void decodeSpecificAttributes(String pastReturns, String remarks) {
        decodedPastReturns = Double.parseDouble(pastReturns);
        decodedRemarks = remarks;
    }

    public static void addEtfToList(String[] textSegment, InstrumentManager instrumentManager) {
        tryValidateAndDecodeGeneralAttributes(textSegment);
        tryValidateAndDecodeSpecificAttributes(textSegment);
        Instrument etf = createDecodedInstrument();
        setDoneStatus(decodedIsDone, etf);
        instrumentManager.addInstrument(etf);
    }

    private static Instrument createDecodedInstrument() {
        return new Etf(decodedName, decodedCurrPrice, decodedSentiment,
                decodedPastReturns, decodedRemarks);
    }

}
