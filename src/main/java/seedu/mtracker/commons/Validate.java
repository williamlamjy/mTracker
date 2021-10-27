package seedu.mtracker.commons;

import seedu.mtracker.LogHelper;
import seedu.mtracker.console.AddForexParser;
import seedu.mtracker.error.InvalidBoundsError;
import seedu.mtracker.error.InvalidDateFormatError;
import seedu.mtracker.error.InvalidEmptyExpiryDateError;
import seedu.mtracker.error.InvalidEmptyPriceError;
import seedu.mtracker.error.InvalidEmptySentimentError;
import seedu.mtracker.error.InvalidNameError;
import seedu.mtracker.error.InvalidPastDateError;
import seedu.mtracker.error.InvalidPastReturnError;
import seedu.mtracker.error.InvalidPastReturnTypeError;
import seedu.mtracker.error.InvalidPriceError;
import seedu.mtracker.error.InvalidSentimentError;
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

    protected static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static boolean isInvalidNameCondition(String name, String instrumentType) {
        if (instrumentType.equals(AddForexParser.INSTRUMENT_TYPE)) {
            return (name.length() != FX_PAIR_NAME_LENGTH);
        }
        return name.isEmpty();
    }

    public static void checkName(String name, String instrumentType) throws InvalidNameError {
        if (isInvalidNameCondition(name, instrumentType)) {
            throw new InvalidNameError(instrumentType);
        }
    }

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

    public static void checkPriceEmpty(String price) throws InvalidEmptyPriceError {
        if (price.isEmpty()) {
            throw new InvalidEmptyPriceError();
        }
    }

    public static void checkPriceIsDouble(String price) throws InvalidPriceError {
        try {
            Double.parseDouble(price);
        } catch (IllegalArgumentException e) {
            throw new InvalidPriceError();
        }
    }

    public static void checkPriceIsNonNegative(String price) throws InvalidPriceError {
        double inputPrice = Double.parseDouble(price);
        if (inputPrice < MINIMUM_PRICE) {
            throw new InvalidPriceError();
        }
    }

    public static boolean isValidPrice(String currentPrice) {
        try {
            checkPriceEmpty(currentPrice);
            checkPriceIsDouble(currentPrice);
            checkPriceIsNonNegative(currentPrice);
        } catch (Exception e) {
            logger.info(LogHelper.LOG_INVALID_PRICE);
            TextUi.showErrorMessage(e);
            return false;
        }
        return true;
    }

    public static void validateIndexWithinBounds(ArrayList<Instrument> instruments, int instrumentNumber)
            throws InvalidBoundsError {
        boolean isNegative = instrumentNumber < 0;
        boolean isGreaterThanListSize = instrumentNumber >= instruments.size();
        if (isNegative || isGreaterThanListSize) {
            throw new InvalidBoundsError();
        }
    }

    public static void checkSentimentEmpty(String sentiment) throws InvalidEmptySentimentError {
        if (sentiment.isEmpty()) {
            throw new InvalidEmptySentimentError();
        }
    }

    public static void checkSentimentGiven(String sentiment) throws InvalidSentimentError {
        boolean isValidPositiveSentiment = sentiment.equals(POSITIVE_SENTIMENT);
        boolean isValidNegativeSentiment = sentiment.equals(NEGATIVE_SENTIMENT);
        boolean isValidNeutralSentiment = sentiment.equals(NEUTRAL_SENTIMENT);
        if (!isValidPositiveSentiment && !isValidNeutralSentiment && !isValidNegativeSentiment) {
            throw new InvalidSentimentError();
        }
    }

    public static boolean isValidSentiment(String sentiment) {
        try {
            checkSentimentEmpty(sentiment);
            checkSentimentGiven(sentiment);
        } catch (Exception e) {
            logger.info(LogHelper.LOG_INVALID_SENTIMENT);
            TextUi.showErrorMessage(e);
            return false;
        }
        return true;
    }

    public static void checkPastReturnIsDouble(String pastReturn) throws InvalidPastReturnTypeError {
        try {
            Double.parseDouble(pastReturn);
        } catch (IllegalArgumentException e) {
            throw new InvalidPastReturnTypeError();
        }
    }

    public static void checkPastReturnIsValid(String pastReturn) throws InvalidPastReturnError {
        double pastReturnValue = Double.parseDouble(pastReturn);
        if (pastReturnValue < MINIMUM_RETURN) {
            throw new InvalidPastReturnError();
        }
    }

    public static boolean isValidPastReturn(String pastReturn) {
        if (pastReturn.isEmpty()) {
            return false;
        }
        try {
            checkPastReturnIsDouble(pastReturn);
            checkPastReturnIsValid(pastReturn);
        } catch (Exception e) {
            logger.info(LogHelper.LOG_INVALID_PAST_RETURNS);
            TextUi.showErrorMessage(e);
            return false;
        }
        return true;
    }

    public static void checkDateExist(String expiryInput) throws InvalidEmptyExpiryDateError {
        if (expiryInput.isEmpty()) {
            throw new InvalidEmptyExpiryDateError();
        }
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
        try {
            checkDateExist(expiryInput);
            checkDateFormat(expiryInput);
            checkDateInPast(expiryInput);
        } catch (Exception e) {
            logger.info(LogHelper.LOG_INVALID_EXPIRY);
            TextUi.showErrorMessage(e);
            return false;
        }
        return true;
    }
}
