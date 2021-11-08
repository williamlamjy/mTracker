package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.commons.error.fileerror.InvalidCurrPriceSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyCurrPriceInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyNameInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptySentimentInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyStatusInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidNameSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidPastReturnSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidRemarkInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidSentimentSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidStatusSavedInFileError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Etf;

//@@author williamlamjy
public class EtfDecoder extends InstrumentDecoder {

    public static final int PAST_RETURN_INDEX = 5;
    public static final int ETF_REMARK_INDEX = 6;
    public static final double EMPTY_PAST_RETURN = -101.0;
    protected static double decodedPastReturn;
    protected static String decodedRemark;

    /**
     * Gets past return from the mTracker file.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @return Past return of the Etf.
     * @throws InvalidPastReturnSavedInFileError When the past return parameter is of invalid format.
     */
    public static String getPastReturnFromFile(String[] textSegment) throws InvalidPastReturnSavedInFileError {
        String pastReturn;
        try {
            pastReturn = textSegment[PAST_RETURN_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidPastReturnSavedInFileError();
        }
        return pastReturn;
    }

    /**
     * Gets remark from the mTracker file.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @return Remark of the instrument.
     * @throws InvalidRemarkInFileError When the remark parameter is of invalid format.
     */
    public static String getRemarkFromFile(String[] textSegment) throws InvalidRemarkInFileError {
        String remark;
        try {
            remark = textSegment[ETF_REMARK_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidRemarkInFileError();
        }
        return remark;
    }

    private static void decodeSpecificAttributes(String pastReturn, String remark) {
        if (pastReturn.isEmpty()) {
            decodedPastReturn = EMPTY_PAST_RETURN;
        } else {
            decodedPastReturn = Double.parseDouble(pastReturn);
        }
        decodedRemark = remark;
    }

    private static void validateSpecificAttributes(String[] textSegment, String pastReturn)
            throws InvalidPastReturnSavedInFileError {
        if (!pastReturn.isEmpty() && !Validate.isValidPastReturn(textSegment[PAST_RETURN_INDEX])) {
            throw new InvalidPastReturnSavedInFileError();
        }
    }

    /**
     * Validates and decodes the specific attributes of the Etf.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @throws InvalidRemarkInFileError When the remark parameter is of invalid format.
     * @throws InvalidPastReturnSavedInFileError When the past return parameter is of invalid format.
     */
    public static void validateAndDecodeSpecificAttributes(String[] textSegment) throws
            InvalidRemarkInFileError, InvalidPastReturnSavedInFileError {
        String pastReturn = getPastReturnFromFile(textSegment);
        String remark = getRemarkFromFile(textSegment);
        validateSpecificAttributes(textSegment, pastReturn);
        decodeSpecificAttributes(pastReturn, remark);
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
     * @throws InvalidRemarkInFileError When the remark parameter is of invalid format.
     * @throws InvalidPastReturnSavedInFileError When the past return parameter is of invalid format.
     */
    public static void addEtfToList(String[] textSegment, InstrumentManager instrumentManager)
            throws InvalidNameSavedInFileError, InvalidSentimentSavedInFileError, InvalidCurrPriceSavedInFileError,
            InvalidEmptyNameInFileError, InvalidEmptySentimentInFileError, InvalidEmptyStatusInFileError,
            InvalidStatusSavedInFileError, InvalidEmptyCurrPriceInFileError, InvalidPastReturnSavedInFileError,
            InvalidRemarkInFileError {
        validateAndDecodeGeneralAttributes(textSegment);
        validateAndDecodeSpecificAttributes(textSegment);
        Instrument etf = createDecodedInstrument();
        setDoneStatus(decodedIsDone, etf);
        instrumentManager.addInstrument(etf);
    }

    private static Instrument createDecodedInstrument() {
        return new Etf(decodedName, decodedCurrPrice, decodedSentiment,
                decodedPastReturn, decodedRemark);
    }

}
