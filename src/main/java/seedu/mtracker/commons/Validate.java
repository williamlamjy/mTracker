package seedu.mtracker.commons;


import seedu.mtracker.LogHelper;
import seedu.mtracker.commands.AddCryptoCommand;
import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commands.AddForexCommand;
import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.commons.error.AlreadyDoneError;
import seedu.mtracker.commons.error.InvalidBoundsError;
import seedu.mtracker.commons.error.InvalidDateFormatError;
import seedu.mtracker.commons.error.InvalidEmptyExpiryDateError;
import seedu.mtracker.commons.error.InvalidEmptyPriceError;
import seedu.mtracker.commons.error.InvalidEmptySentimentError;
import seedu.mtracker.commons.error.InvalidEmptyStatusError;
import seedu.mtracker.commons.error.InvalidInstrumentError;
import seedu.mtracker.commons.error.InvalidNameError;
import seedu.mtracker.commons.error.InvalidNegativePriceError;
import seedu.mtracker.commons.error.InvalidPastDateError;
import seedu.mtracker.commons.error.InvalidPastReturnsError;
import seedu.mtracker.commons.error.InvalidPastReturnsTypeError;
import seedu.mtracker.commons.error.InvalidPriceError;
import seedu.mtracker.commons.error.InvalidSentimentError;
import seedu.mtracker.commons.error.InvalidStatusError;
import seedu.mtracker.console.AddForexParser;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Validates parameters of instruments to ensure they are of the right format.
 */
public class Validate {

    public static final double MINIMUM_PRICE = 0;
    public static final double MINIMUM_RETURN = -100;

    public static final String POSITIVE_SENTIMENT = "positive";
    public static final String NEUTRAL_SENTIMENT = "neutral";
    public static final String NEGATIVE_SENTIMENT = "negative";
    public static final String DONE_INDICATOR = "done";
    public static final String NOT_DONE_INDICATOR = "undone";

    public static final String STATUS_DONE = "true";
    public static final String STATUS_NOT_DONE = "false";

    protected static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static final String FOREX_VALID_NAME_REGEX = "^[a-zA-Z]{3}/?[a-zA-Z]{3}$";

    /**
     * Checks if the instrument's name is empty.
     * If the instrument is of type forex, it checks that the name is 6 letters.
     *
     * @param name Instrument's name
     * @param instrumentType Instrument's type
     * @return True if name is invalid.
     */
    public static boolean isInvalidNameCondition(String name, String instrumentType) {
        if (instrumentType.equals(AddForexParser.INSTRUMENT_TYPE)) {
            return (!name.matches(FOREX_VALID_NAME_REGEX));
        }
        return name.isEmpty();
    }

    /**
     * Checks if the instrument name is valid.
     *
     * @param name Instrument's name
     * @param instrumentType Instrument's type
     * @throws InvalidNameError When name is invalid.
     */
    public static void checkName(String name, String instrumentType) throws InvalidNameError {
        if (isInvalidNameCondition(name, instrumentType)) {
            throw new InvalidNameError(instrumentType);
        }
    }

    /**
     * Checks if instrument type is one of the 4 valid types.
     *
     * @param instrument Instrument that is being validated.
     * @return True if instrument is invalid.
     */
    public static boolean isInvalidInstrument(String instrument) {
        switch (instrument) {
        case AddStockCommand.COMMAND_WORD:
            // Fallthrough
        case AddCryptoCommand.COMMAND_WORD:
            // Fallthrough
        case AddForexCommand.COMMAND_WORD:
            // Fallthrough
        case AddEtfCommand.COMMAND_WORD:
            return false;
        default:
            return true;
        }
    }

    /**
     * Checks if instrument is valid.
     *
     * @param instrument Instrument that is being validated.
     * @throws InvalidInstrumentError When instrument is of invalid type.
     */
    public static void checkInstrument(String instrument) throws InvalidInstrumentError {
        if (isInvalidInstrument(instrument)) {
            throw new InvalidInstrumentError();
        }
    }

    /**
     * Validates the instrument.
     * Catches and displays any errors if instrument is invalid.
     *
     * @param instrument Instrument that is being validated.
     * @return True if instrument is valid.
     */
    public static boolean isValidInstrument(String instrument) {
        try {
            checkInstrument(instrument);
        } catch (Exception e) {
            logger.info(LogHelper.LOG_INVALID_INSTRUMENT);
            TextUi.showErrorMessage(e);
            return false;
        }
        return true;
    }

    /**
     * Validates instrument name.
     * Catches and displays any errors if instrument is invalid.
     *
     * @param name Instrument's name.
     * @param instrumentType Instrument's type.
     * @return True if name is valid.
     */
    public static boolean isValidName(String name, String instrumentType) {
        try {
            checkName(name, instrumentType);
        } catch (Exception e) {
            logger.info(LogHelper.LOG_INVALID_NAME);
            TextUi.showErrorMessage(e);
            return false;
        }
        return true;
    }

    //@@author theodorekwok
    /**
     * Checks if price is empty.
     *
     * @param price Instrument's price.
     * @throws InvalidEmptyPriceError When price parameter is empty.
     */
    public static void checkPriceIsEmpty(String price) throws InvalidEmptyPriceError {
        if (price.isEmpty()) {
            throw new InvalidEmptyPriceError();
        }
    }

    /**
     * Checks if price is a valid numerical value.
     * @param price Instrument's price
     * @throws InvalidPriceError When price is an invalid numerical.
     */
    public static void checkPriceIsDouble(String price) throws InvalidPriceError {
        try {
            Double.parseDouble(price);
        } catch (IllegalArgumentException e) {
            throw new InvalidPriceError();
        }
    }

    /**
     * Checks if price is positive.
     *
     * @param price Instrument's price.
     * @throws InvalidNegativePriceError When price is negative
     */
    public static void checkPriceIsNonNegative(String price) throws InvalidNegativePriceError {
        double inputPrice = Double.parseDouble(price);
        if (inputPrice <= MINIMUM_PRICE) {
            throw new InvalidNegativePriceError();
        }
    }

    /**
     * Checks if price is valid.
     * Catches and displays any errors if price is invalid.
     *
     * @param price Instrument's price.
     * @return True if price is valid.
     */
    public static boolean isValidPrice(String price) {
        try {
            checkPriceIsEmpty(price);
            checkPriceIsDouble(price);
            checkPriceIsNonNegative(price);
        } catch (Exception e) {
            logger.info(LogHelper.LOG_INVALID_PRICE);
            TextUi.showErrorMessage(e);
            return false;
        }
        return true;
    }

    /**
     * Validates instrument index.
     *
     * @param instruments Instruments in current watchlist.
     * @param instrumentNumber Instrument index.
     * @throws InvalidBoundsError When index is negative or greater than size of watch list.
     */
    public static void validateIndexWithinBounds(ArrayList<Instrument> instruments, int instrumentNumber)
            throws InvalidBoundsError {
        boolean isNegative = instrumentNumber < 0;
        boolean isGreaterThanListSize = instrumentNumber >= instruments.size();
        if (isNegative || isGreaterThanListSize) {
            throw new InvalidBoundsError();
        }
    }

    //@@author
    /**
     * Checks if instrument is already done.
     *
     * @param instruments Instruments in current watchlist.
     * @param instrumentNumber Instrument index.
     * @throws AlreadyDoneError When instrument is already done.
     */
    public static void checkIsNotDone(ArrayList<Instrument> instruments, int instrumentNumber)
            throws AlreadyDoneError {
        Instrument instrument = instruments.get(instrumentNumber);
        boolean isDoneStatus = instrument.getIsDone();
        if (isDoneStatus) {
            throw new AlreadyDoneError();
        }
    }

    //@@author theodorekwok
    /**
     * Checks if sentiment is empty.
     *
     * @param sentiment Instrument's sentiment
     * @throws InvalidEmptySentimentError When sentiment parameter is empty.
     */
    public static void checkSentimentIsEmpty(String sentiment) throws InvalidEmptySentimentError {
        if (sentiment.isEmpty()) {
            throw new InvalidEmptySentimentError();
        }
    }

    /**
     * Checks if sentiment is of one of the 3 valid types.
     * @param sentiment Instrument's sentiment
     * @throws InvalidSentimentError When sentiment is of invalid type.
     */
    public static void checkSentiment(String sentiment) throws InvalidSentimentError {
        boolean isValidPositiveSentiment = sentiment.equals(POSITIVE_SENTIMENT);
        boolean isValidNegativeSentiment = sentiment.equals(NEGATIVE_SENTIMENT);
        boolean isValidNeutralSentiment = sentiment.equals(NEUTRAL_SENTIMENT);
        if (!isValidPositiveSentiment && !isValidNeutralSentiment && !isValidNegativeSentiment) {
            throw new InvalidSentimentError();
        }
    }

    //@@author
    /**
     * Checks if sentiment is valid.
     * Catches and displays any errors if sentiment is invalid.
     *
     * @param sentiment Instrument's sentiment
     * @return True if sentiment is valid.
     */
    public static boolean isValidSentiment(String sentiment) {
        try {
            checkSentimentIsEmpty(sentiment);
            checkSentiment(sentiment);
        } catch (Exception e) {
            logger.info(LogHelper.LOG_INVALID_SENTIMENT);
            TextUi.showErrorMessage(e);
            return false;
        }
        return true;
    }

    //@@author theodorekwok
    /**
     * Checks if past returns is a valid numerical.
     *
     * @param pastReturn Etf's past returns.
     * @throws InvalidPastReturnsTypeError When past returns is an invalid numerical.
     */
    public static void checkPastReturnsIsDouble(String pastReturn) throws InvalidPastReturnsTypeError {
        try {
            Double.parseDouble(pastReturn);
        } catch (IllegalArgumentException e) {
            throw new InvalidPastReturnsTypeError();
        }
    }

    /**
     * Checks if past returns is less than the minimum value.
     *
     * @param pastReturn Etf's past returns.
     * @throws InvalidPastReturnsError When past returns is less than the minimum value.
     */
    public static void checkPastReturnsIsValid(String pastReturn) throws InvalidPastReturnsError {
        double pastReturnValue = Double.parseDouble(pastReturn);
        if (pastReturnValue < MINIMUM_RETURN) {
            throw new InvalidPastReturnsError();
        }
    }

    //@@author
    /**
     * Checks if past returns is valid.
     * Catches and displays any errors if past returns is invalid.
     *
     * @param pastReturn Etf's past returns.
     * @return True if past returns is valid.
     */
    public static boolean isValidPastReturns(String pastReturn) {
        if (pastReturn.isEmpty()) {
            return false;
        }
        try {
            checkPastReturnsIsDouble(pastReturn);
            checkPastReturnsIsValid(pastReturn);
        } catch (Exception e) {
            logger.info(LogHelper.LOG_INVALID_PAST_RETURNS);
            TextUi.showErrorMessage(e);
            return false;
        }
        return true;
    }

    //@@author theodorekwok
    /**
     * Checks if expiry is empty.
     *
     * @param expiryInput Instrument's expiry.
     * @throws InvalidEmptyExpiryDateError When expiry parameter is empty.
     */
    public static void checkExpiryIsEmpty(String expiryInput) throws InvalidEmptyExpiryDateError {
        if (expiryInput.isEmpty()) {
            throw new InvalidEmptyExpiryDateError();
        }
    }

    /**
     * Checks if expiry is of valid date format.
     *
     * @param expiryInput Instrument's expiry
     * @throws InvalidDateFormatError When expiry is of invalid date format.
     */
    public static void checkExpiryIsValidFormat(String expiryInput) throws InvalidDateFormatError {
        try {
            LocalDate.parse(expiryInput);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatError();
        }
    }

    /**
     * Checks if expiry is a future date.
     *
     * @param expiryInput Instrument's expiry
     * @throws InvalidPastDateError When expiry is in the past.
     */
    public static void checkExpiryIsInPast(String expiryInput) throws InvalidPastDateError {
        LocalDate givenDate = LocalDate.parse(expiryInput);
        if (givenDate.isBefore(LocalDate.now())) {
            throw new InvalidPastDateError();
        }
    }

    /**
     * Checks if expiry is valid.
     * Catches and displays any errors if expiry is invalid.
     *
     * @param expiryInput Instrument's expiry
     * @return True if expiry is invalid.
     */
    public static boolean isValidExpiry(String expiryInput) {
        try {
            checkExpiryIsEmpty(expiryInput);
            checkExpiryIsValidFormat(expiryInput);
            checkExpiryIsInPast(expiryInput);
        } catch (Exception e) {
            logger.info(LogHelper.LOG_INVALID_EXPIRY);
            TextUi.showErrorMessage(e);
            return false;
        }
        return true;
    }

    //@@author
    /**
     * Checks if done status is empty.
     *
     * @param doneStatus Instrument's done status.
     * @throws InvalidEmptyStatusError When done parameter is empty.
     */
    public static void checkStatusIsEmpty(String doneStatus) throws InvalidEmptyStatusError {
        if (doneStatus.isEmpty()) {
            throw new InvalidEmptyStatusError();
        }
    }

    /**
     * Checks if done status is valid.
     *
     * @param doneStatus Instrument's done status.
     * @throws InvalidStatusError When done status is of invalid format.
     */
    public static void checkStatus(String doneStatus) throws InvalidStatusError {
        boolean isValidCompletedStatus = doneStatus.equals(DONE_INDICATOR);
        boolean isValidNotCompletedStatus = doneStatus.equals(NOT_DONE_INDICATOR);
        if (!isValidCompletedStatus && !isValidNotCompletedStatus) {
            throw new InvalidStatusError();
        }
    }

    /**
     * Checks if done status is valid.
     * Catches and displays any errors if done status is invalid.
     *
     * @param doneStatus Instrument's done status.
     * @return True if done status is valid.
     */
    public static boolean isValidInputStatus(String doneStatus) {
        try {
            checkStatusIsEmpty(doneStatus);
            checkStatus(doneStatus);
        } catch (Exception e) {
            TextUi.showErrorMessage(e);
            return false;
        }
        return true;
    }

    /**
     * Checks if edit parameters is empty.
     *
     * @param input User input of parameters to edit.
     * @return True if edit parameters is not empty.
     */
    public static boolean isNonEmptyEditParameters(String input) {
        return !input.isEmpty();
    }

    //@@author theodorekwok
    /**
     * Checks if done status is of valid format in the mTracker file.
     *
     * @param savedStatusFromFile Done status parameter from the file.
     * @return True if done status is valid.
     */
    public static boolean isValidStatus(String savedStatusFromFile) {
        boolean isValidDoneStatus = savedStatusFromFile.equals(STATUS_DONE);
        boolean isValidNotDoneStatus = savedStatusFromFile.equals(STATUS_NOT_DONE);
        return isValidDoneStatus || isValidNotDoneStatus;
    }
}
