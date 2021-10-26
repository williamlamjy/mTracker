package seedu.mtracker.commons;

import seedu.mtracker.LogHelper;
import seedu.mtracker.console.AddForexParser;
import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.error.InvalidBoundsError;
import seedu.mtracker.error.InvalidDateFormatError;
import seedu.mtracker.error.InvalidPastDateError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Validate {

    public static final double MINIMUM_PRICE = 0;
    public static final double MINIMUM_RETURN = -100;

    public static final String POSITIVE_SENTIMENT = "positive";
    public static final String NEUTRAL_SENTIMENT = "neutral";
    public static final String NEGATIVE_SENTIMENT = "negative";

    public static final int FX_PAIR_NAME_LENGTH = 6;
    public static final double UNDEFINED_PAST_RETURN_VALUE = -101;

    protected static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static boolean isInvalidNameCondition(String name, String instrumentType) {
        if (instrumentType.equals(AddForexParser.INSTRUMENT_TYPE)) {
            return (name.length() != FX_PAIR_NAME_LENGTH);
        }
        return name.isEmpty();
    }

    public static boolean isValidName(String name, String instrumentType) {
        boolean isValid = true;
        try {
            if (isInvalidNameCondition(name, instrumentType)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            logger.info(LogHelper.LOG_INVALID_NAME);
            if (instrumentType.equals(AddForexParser.INSTRUMENT_TYPE)) {
                ErrorMessage.displayAddForexNameError();
            } else {
                ErrorMessage.displayAddInstrumentNameError(instrumentType);
            }
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidPrice(String currentPrice) {
        boolean isValid = true;
        try {
            double inputPrice = Double.parseDouble(currentPrice);
            if (inputPrice < MINIMUM_PRICE) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            logger.info(LogHelper.LOG_INVALID_PRICE);
            ErrorMessage.displayAddInstrumentPriceError();
            isValid = false;
        }
        return isValid;
    }

    public static void validateIndexWithinBounds(ArrayList<Instrument> instruments, int instrumentNumber)
            throws InvalidBoundsError {
        boolean isNegative = instrumentNumber < 0;
        boolean isGreaterThanListSize = instrumentNumber >= instruments.size();
        if (isNegative || isGreaterThanListSize) {
            throw new InvalidBoundsError();
        }
    }

    public static boolean isValidSentiment(String sentiment) {
        boolean isValidPositiveSentiment = sentiment.equals(POSITIVE_SENTIMENT);
        boolean isValidNegativeSentiment = sentiment.equals(NEGATIVE_SENTIMENT);
        boolean isValidNeutralSentiment = sentiment.equals(NEUTRAL_SENTIMENT);
        if (!isValidPositiveSentiment && !isValidNeutralSentiment && !isValidNegativeSentiment) {
            logger.info(LogHelper.LOG_INVALID_SENTIMENT);
            ErrorMessage.displayAddInstrumentSentimentError();
            return false;
        }
        return true;
    }

    public static boolean isValidPastReturn(String userInput) {
        double pastReturn;
        try {
            pastReturn = Double.parseDouble(userInput);
            if (pastReturn < MINIMUM_RETURN) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            logger.info(LogHelper.LOG_EMPTY_PAST_RETURNS);
            pastReturn = UNDEFINED_PAST_RETURN_VALUE;
        } catch (IllegalArgumentException e) {
            logger.info(LogHelper.LOG_INVALID_PAST_RETURNS);
            ErrorMessage.displayPastReturnError();
            pastReturn = UNDEFINED_PAST_RETURN_VALUE;
        }
        return pastReturn != Validate.UNDEFINED_PAST_RETURN_VALUE;
    }

    public static void checkDateFormat(String expiryInput) throws InvalidDateFormatError {
        try {
            LocalDate.parse(expiryInput);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatError();
        }
    }

    public static void checkDateInPast(String expiryInput) throws InvalidPastDateError {
        LocalDate givenDate = LocalDate.parse(expiryInput);
        if (givenDate.isBefore(LocalDate.now())) {
            throw new InvalidPastDateError();
        }
    }

    public static boolean isValidExpiry(String expiryInput) {
        boolean isValid = true;
        try {
            if (expiryInput.isEmpty()) {
                // todo: replace the error with a custom exception so will have one catch block
                throw new IllegalArgumentException();
            }
            checkDateFormat(expiryInput);
            checkDateInPast(expiryInput);
        } catch (IllegalArgumentException e) {
            logger.info(LogHelper.LOG_EMPTY_EXPIRY);
            ErrorMessage.displayEmptyExpiryError();
            isValid = false;
        } catch (InvalidPastDateError | InvalidDateFormatError e) {
            logger.info(LogHelper.LOG_INVALID_EXPIRY);
            TextUi.showErrorMessage(e);
            isValid = false;
        }
        return isValid;
    }
}
