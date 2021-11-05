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

    /**
     * Gets past returns from the mTracker file.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @return Past returns of the Etf.
     * @throws InvalidPastReturnsSavedInFileError When the past returns parameter is of invalid format.
     */
    public static String getPastReturnsFromFile(String[] textSegment) throws InvalidPastReturnsSavedInFileError {
        String pastReturns;
        try {
            pastReturns = textSegment[PAST_RETURNS_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidPastReturnsSavedInFileError();
        }
        return pastReturns;
    }

    /**
     * Gets remarks from the mTracker file.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @return Remarks of the instrument.
     * @throws InvalidRemarksInFileError When the remarks parameter is of invalid format.
     */
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

    /**
     * Validates and decodes the specific attributes of the Etf.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @throws InvalidRemarksInFileError When the remarks parameter is of invalid format.
     * @throws InvalidPastReturnsSavedInFileError When the past returns parameter is of invalid format.
     */
    public static void validateAndDecodeSpecificAttributes(String[] textSegment) throws
            InvalidRemarksInFileError, InvalidPastReturnsSavedInFileError {
        String pastReturns = getPastReturnsFromFile(textSegment);
        String remarks = getRemarksFromFile(textSegment);
        validateSpecificAttributes(textSegment, pastReturns);
        decodeSpecificAttributes(pastReturns, remarks);
    }

    /**
     * Adds the validated and decoded Etf to the InstrumentManager.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @param instrumentManager Current InstrumentManager.
     * @throws InvalidNameSavedInFileError When the name parameter is of invalid format.
     * @throws InvalidSentimentSavedInFileError When the sentiment parameter is of invalid format.
     * @throws InvalidCurrPriceSavedInFileError When the current price parameter is of invalid format.
     * @throws InvalidEmptyNameInFileError When the name parameter is empty in the file.
     * @throws InvalidEmptyCurrPriceInFileError When the current price parameter is empty in the file.
     * @throws InvalidEmptySentimentInFileError When the sentiment parameter is empty in the file.
     * @throws InvalidEmptyStatusInFileError When the done status parameter is empty in the file.
     * @throws InvalidStatusSavedInFileError When the done status parameter is of invalid format.
     * @throws InvalidRemarksInFileError When the remarks parameter is of invalid format.
     * @throws InvalidPastReturnsSavedInFileError When the past returns parameter is of invalid format.
     */
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
