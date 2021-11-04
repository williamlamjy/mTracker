package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.commons.error.fileerror.InvalidCurrPriceSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyCurrPriceInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyNameInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptySentimentInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyStatusInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidNameSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidPastReturnsSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidRemarksInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidSentimentSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidStatusSavedInFileError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Etf;

public class EtfDecoder extends InstrumentDecoder {

    public static final int PAST_RETURNS_INDEX = 5;
    public static final int ETF_REMARKS_INDEX = 6;
    public static final double EMPTY_PAST_RETURNS = -101.0;
    protected static double decodedPastReturns;
    protected static String decodedRemarks;

    public static String getPastReturnsFromFile(String[] textSegment) throws InvalidPastReturnsSavedInFileError {
        String pastReturns;
        try {
            pastReturns = textSegment[PAST_RETURNS_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidPastReturnsSavedInFileError();
        }
        return pastReturns;
    }

    public static String getRemarksFromFile(String[] textSegment) throws InvalidRemarksInFileError {
        String remarks;
        try {
            remarks = textSegment[ETF_REMARKS_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidRemarksInFileError();
        }
        return remarks;
    }

    private static void decodeSpecificAttributes(String pastReturns, String remarks) {
        if (pastReturns.isEmpty()) {
            decodedPastReturns = EMPTY_PAST_RETURNS;
        } else {
            decodedPastReturns = Double.parseDouble(pastReturns);
        }
        decodedRemarks = remarks;
    }

    private static void validateSpecificAttributes(String[] textSegment, String pastReturns)
            throws InvalidPastReturnsSavedInFileError {
        if (!pastReturns.isEmpty() && !Validate.isValidPastReturns(textSegment[PAST_RETURNS_INDEX])) {
            throw new InvalidPastReturnsSavedInFileError();
        }
    }

    public static void validateAndDecodeSpecificAttributes(String[] textSegment) throws
            InvalidRemarksInFileError, InvalidPastReturnsSavedInFileError {
        String pastReturns = getPastReturnsFromFile(textSegment);
        String remarks = getRemarksFromFile(textSegment);
        validateSpecificAttributes(textSegment, pastReturns);
        decodeSpecificAttributes(pastReturns, remarks);
    }

    public static void addEtfToList(String[] textSegment, InstrumentManager instrumentManager)
            throws InvalidNameSavedInFileError, InvalidSentimentSavedInFileError, InvalidCurrPriceSavedInFileError,
            InvalidEmptyNameInFileError, InvalidEmptySentimentInFileError, InvalidEmptyStatusInFileError,
            InvalidStatusSavedInFileError, InvalidEmptyCurrPriceInFileError, InvalidPastReturnsSavedInFileError,
            InvalidRemarksInFileError {
        validateAndDecodeGeneralAttributes(textSegment);
        validateAndDecodeSpecificAttributes(textSegment);
        Instrument etf = createDecodedInstrument();
        setDoneStatus(decodedIsDone, etf);
        instrumentManager.addInstrument(etf);
    }

    private static Instrument createDecodedInstrument() {
        return new Etf(decodedName, decodedCurrPrice, decodedSentiment,
                decodedPastReturns, decodedRemarks);
    }

}
