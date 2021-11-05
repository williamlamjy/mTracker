package seedu.mtracker.filemanager;

import seedu.mtracker.commons.error.fileerror.InvalidCurrPriceSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyCurrPriceInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyNameInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptySentimentInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyStatusInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidNameSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidRemarksInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidSentimentSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidStatusSavedInFileError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Stock;

/**
 * Decodes and adds stock instruments into the InstrumentManager.
 */
public class StockDecoder extends InstrumentDecoder {

    public static final int STOCK_REMARKS_INDEX = 5;
    protected static String decodedRemarks;

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
            remarks = textSegment[STOCK_REMARKS_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidRemarksInFileError();
        }
        return remarks;
    }

    private static void decodeSpecificAttributes(String remarks) {
        decodedRemarks = remarks;
    }

    /**
     * Validates and decodes the specific attributes of the stock.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @throws InvalidRemarksInFileError When the remarks parameter is of invalid format.
     */
    public static void validateAndDecodeSpecificAttributes(String[] textSegment) throws InvalidRemarksInFileError {
        String remarks = getRemarksFromFile(textSegment);
        decodeSpecificAttributes(remarks);
    }

    /**
     * Adds the validated and decoded stock to the InstrumentManager.
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
     */
    public static void addStockToList(String[] textSegment, InstrumentManager instrumentManager)
            throws InvalidNameSavedInFileError, InvalidSentimentSavedInFileError, InvalidCurrPriceSavedInFileError,
            InvalidEmptyNameInFileError, InvalidEmptySentimentInFileError, InvalidEmptyStatusInFileError,
            InvalidStatusSavedInFileError, InvalidEmptyCurrPriceInFileError, InvalidRemarksInFileError {
        validateAndDecodeGeneralAttributes(textSegment);
        validateAndDecodeSpecificAttributes(textSegment);
        Instrument stock = createDecodedInstrument();
        setDoneStatus(decodedIsDone, stock);
        instrumentManager.addInstrument(stock);
    }

    private static Instrument createDecodedInstrument() {
        return new Stock(decodedName, decodedCurrPrice, decodedSentiment, decodedRemarks);
    }

}
