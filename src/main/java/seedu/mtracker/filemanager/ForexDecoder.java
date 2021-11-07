package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.commons.error.fileerror.InvalidCurrPriceSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyCurrPriceInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyEntryPriceInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyExitPriceInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyExpiryInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyNameInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptySentimentInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyStatusInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEntryPriceSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidExitPriceSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidExpirySavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidNameSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidRemarksInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidSentimentSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidStatusSavedInFileError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Forex;

import java.time.LocalDate;

//@@author williamlamjy
/**
 * Decodes and adds forex instruments into the InstrumentManager.
 */
public class ForexDecoder extends InstrumentDecoder {

    public static final int ENTRY_PRICE_INDEX = 5;
    public static final int EXIT_PRICE_INDEX = 6;
    public static final int FOREX_EXPIRY_INDEX = 7;
    public static final int FOREX_REMARKS_INDEX = 8;
    protected static double decodedEntryPrice;
    protected static double decodedExitPrice;
    protected static LocalDate decodedExpiry;
    protected static String decodedRemarks;

    /**
     * Gets entry price from the mTracker file.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @return Entry price of the forex
     * @throws InvalidEmptyEntryPriceInFileError When the entry price parameter is empty in the file.
     */
    public static String getEntryPriceFromFile(String[] textSegment) throws InvalidEmptyEntryPriceInFileError {
        String entryPrice;
        try {
            entryPrice = textSegment[ENTRY_PRICE_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidEmptyEntryPriceInFileError();
        }
        return entryPrice;
    }

    /**
     * Gets exit price from the mTracker file.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @return Exit price of the forex
     * @throws InvalidEmptyExitPriceInFileError When the exit price parameter is empty in the file.
     */
    public static String getExitPriceFromFile(String[] textSegment) throws InvalidEmptyExitPriceInFileError {
        String exitPrice;
        try {
            exitPrice = textSegment[EXIT_PRICE_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidEmptyExitPriceInFileError();
        }
        return exitPrice;
    }

    /**
     * Gets expiry from the mTracker file.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @return Expiry of the forex.
     * @throws InvalidEmptyExpiryInFileError When the expiry parameter is empty in the file.
     */
    public static String getExpiryFromFile(String[] textSegment) throws InvalidEmptyExpiryInFileError {
        String expiry;
        try {
            expiry = textSegment[FOREX_EXPIRY_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidEmptyExpiryInFileError();
        }
        return expiry;
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
            remarks = textSegment[FOREX_REMARKS_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidRemarksInFileError();
        }
        return remarks;
    }

    /**
     * Validates and decodes the specific attributes of the forex.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @throws InvalidEmptyEntryPriceInFileError When the entry price parameter is empty in the file.
     * @throws InvalidEmptyExitPriceInFileError When the exit price parameter is empty in the file.
     * @throws InvalidEmptyExpiryInFileError When the expiry parameter is empty in the file.
     * @throws InvalidRemarksInFileError When the remarks parameter is of invalid format.
     * @throws InvalidExpirySavedInFileError When the expiry parameter is of invalid format.
     * @throws InvalidEntryPriceSavedInFileError When the entry price parameter is of invalid format.
     * @throws InvalidExitPriceSavedInFileError When the exit price parameter is of invalid format.
     */
    public static void validateAndDecodeSpecificAttributes(String[] textSegment)
            throws InvalidEmptyEntryPriceInFileError, InvalidEmptyExitPriceInFileError, InvalidEmptyExpiryInFileError,
            InvalidRemarksInFileError, InvalidEntryPriceSavedInFileError, InvalidExitPriceSavedInFileError,
            InvalidExpirySavedInFileError {
        String entryPrice = getEntryPriceFromFile(textSegment);
        String exitPrice = getExitPriceFromFile(textSegment);
        String expiry = getExpiryFromFile(textSegment);
        String remarks = getRemarksFromFile(textSegment);
        validateSpecificAttributes(textSegment);
        decodeSpecificAttributes(entryPrice, exitPrice, expiry, remarks);
    }

    private static void validateSpecificAttributes(String[] textSegment) throws InvalidExpirySavedInFileError,
            InvalidExitPriceSavedInFileError, InvalidEntryPriceSavedInFileError {
        if (!Validate.isValidPrice(textSegment[ENTRY_PRICE_INDEX])) {
            throw new InvalidEntryPriceSavedInFileError();
        }
        if (!Validate.isValidPrice(textSegment[EXIT_PRICE_INDEX])) {
            throw new InvalidExitPriceSavedInFileError();
        }
        if (!Validate.isValidExpiry(textSegment[FOREX_EXPIRY_INDEX])) {
            throw new InvalidExpirySavedInFileError();
        }
    }

    private static void decodeSpecificAttributes(String entryPrice, String exitPrice, String expiry, String remarks) {
        decodedEntryPrice = Double.parseDouble(entryPrice);
        decodedExitPrice = Double.parseDouble(exitPrice);
        decodedExpiry = LocalDate.parse(expiry);
        decodedRemarks = remarks;
    }

    /**
     * Adds the validated and decoded forex to the InstrumentManager.
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
     * @throws InvalidEntryPriceSavedInFileError When the entry price parameter is of invalid format.
     * @throws InvalidExitPriceSavedInFileError When the exit price parameter is of invalid format.
     * @throws InvalidEmptyEntryPriceInFileError When the entry price parameter is empty in the file.
     * @throws InvalidEmptyExitPriceInFileError When the exit price parameter is empty in the file.
     * @throws InvalidEmptyExpiryInFileError When the expiry parameter is empty in the file.
     * @throws InvalidRemarksInFileError When the remarks parameter is of invalid format.
     * @throws InvalidExpirySavedInFileError When the expiry parameter is of invalid format.
     */
    public static void addForexToList(String[] textSegment, InstrumentManager instrumentManager)
            throws InvalidNameSavedInFileError, InvalidSentimentSavedInFileError, InvalidCurrPriceSavedInFileError,
            InvalidEmptyNameInFileError, InvalidEmptySentimentInFileError, InvalidEmptyStatusInFileError,
            InvalidStatusSavedInFileError, InvalidEmptyCurrPriceInFileError, InvalidEntryPriceSavedInFileError,
            InvalidExitPriceSavedInFileError, InvalidExpirySavedInFileError, InvalidEmptyExitPriceInFileError,
            InvalidEmptyExpiryInFileError, InvalidEmptyEntryPriceInFileError, InvalidRemarksInFileError {
        validateAndDecodeGeneralAttributes(textSegment);
        validateAndDecodeSpecificAttributes(textSegment);
        Instrument forex = createDecodedInstrument();
        setDoneStatus(decodedIsDone, forex);
        instrumentManager.addInstrument(forex);
    }

    private static Instrument createDecodedInstrument() {
        return new Forex(decodedName, decodedCurrPrice, decodedSentiment,
                decodedEntryPrice, decodedExitPrice, decodedExpiry, decodedRemarks);
    }
}
