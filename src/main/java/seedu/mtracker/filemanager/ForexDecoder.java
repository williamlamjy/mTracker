package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.fileerror.InvalidCurrPriceSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyCurrPriceInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyEntryPriceInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyExitPriceInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyExpiryInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyNameInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptySentimentInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyStatusInFileError;
import seedu.mtracker.error.fileerror.InvalidEntryPriceSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidExitPriceSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidExpirySavedInFileError;
import seedu.mtracker.error.fileerror.InvalidNameSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidRemarksInFileError;
import seedu.mtracker.error.fileerror.InvalidSentimentSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidStatusSavedInFileError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Forex;

import java.time.LocalDate;

public class ForexDecoder extends InstrumentDecoder {

    public static final int ENTRY_PRICE_INDEX = 5;
    public static final int EXIT_PRICE_INDEX = 6;
    public static final int FOREX_EXPIRY_INDEX = 7;
    public static final int FOREX_REMARKS_INDEX = 8;
    protected static double decodedEntryPrice;
    protected static double decodedExitPrice;
    protected static LocalDate decodedExpiry;
    protected static String decodedRemarks;

    public static String getEntryPriceFromFile(String[] textSegment) throws InvalidEmptyEntryPriceInFileError {
        String entryPrice;
        try {
            entryPrice = textSegment[ENTRY_PRICE_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidEmptyEntryPriceInFileError();
        }
        return entryPrice;
    }

    public static String getExitPriceFromFile(String[] textSegment) throws InvalidEmptyExitPriceInFileError {
        String exitPrice;
        try {
            exitPrice = textSegment[EXIT_PRICE_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidEmptyExitPriceInFileError();
        }
        return exitPrice;
    }

    public static String getExpiryFromFile(String[] textSegment) throws InvalidEmptyExpiryInFileError {
        String expiry;
        try {
            expiry = textSegment[FOREX_EXPIRY_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidEmptyExpiryInFileError();
        }
        return expiry;
    }

    public static String getRemarksFromFile(String[] textSegment) throws InvalidRemarksInFileError {
        String remarks;
        try {
            remarks = textSegment[FOREX_REMARKS_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidRemarksInFileError();
        }
        return remarks;
    }

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

    public static void addForexToList(String[] textSegment, InstrumentManager instrumentManager)
            throws InvalidNameSavedInFileError, InvalidSentimentSavedInFileError, InvalidCurrPriceSavedInFileError,
            InvalidEmptyNameInFileError, InvalidEmptySentimentInFileError, InvalidEmptyStatusInFileError,
            InvalidStatusSavedInFileError, InvalidEmptyCurrPriceInFileError, InvalidEntryPriceSavedInFileError,
            InvalidExitPriceSavedInFileError, InvalidExpirySavedInFileError {
        validateAndDecodeGeneralAttributes(textSegment);
        validateSpecificAttributes(textSegment);
        Instrument forex = createDecodedInstrument();
        setDoneStatus(decodedIsDone, forex);
        instrumentManager.addInstrument(forex);
    }

    private static Instrument createDecodedInstrument() {
        return new Forex(decodedName, decodedCurrPrice, decodedSentiment,
                decodedEntryPrice, decodedExitPrice, decodedExpiry, decodedRemarks);
    }
}
