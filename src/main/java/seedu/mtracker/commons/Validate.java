package seedu.mtracker.commons;

import seedu.mtracker.LogHelper;
import seedu.mtracker.commands.AddCryptoCommand;
import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commands.AddForexCommand;
import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.console.AddForexParser;
import seedu.mtracker.error.InvalidBoundsError;
import seedu.mtracker.error.InvalidDateFormatError;
import seedu.mtracker.error.InvalidEmptyExpiryDateError;
import seedu.mtracker.error.InvalidEmptyPriceError;
import seedu.mtracker.error.InvalidEmptySentimentError;
import seedu.mtracker.error.InvalidInstrumentError;
import seedu.mtracker.error.InvalidNameError;
import seedu.mtracker.error.InvalidNegativePriceError;
import seedu.mtracker.error.InvalidPastDateError;
import seedu.mtracker.error.InvalidPastReturnError;
import seedu.mtracker.error.InvalidPastReturnTypeError;
import seedu.mtracker.error.InvalidPriceError;
import seedu.mtracker.error.InvalidSentimentError;
import seedu.mtracker.error.AlreadyDoneError;
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

    protected static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static boolean isInvalidNameCondition(String name, String instrumentType) {
        if (instrumentType.equals(AddForexParser.INSTRUMENT_TYPE)) {
            return (!name.matches("^[a-zA-Z]{3}/?[a-zA-Z]{3}$"));
        }
        return name.isEmpty();
    }

    public static void checkName(String name, String instrumentType) throws InvalidNameError {
        if (isInvalidNameCondition(name, instrumentType)) {
            throw new InvalidNameError(instrumentType);
        }
    }

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

    public static void checkInstrument(String instrument) throws InvalidInstrumentError {
        if (isInvalidInstrument(instrument)) {
            throw new InvalidInstrumentError();
        }
    }

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

    public static void checkPriceIsEmpty(String price) throws InvalidEmptyPriceError {
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

    public static void checkPriceIsNonNegative(String price) throws InvalidNegativePriceError {
        double inputPrice = Double.parseDouble(price);
        if (inputPrice <= MINIMUM_PRICE) {
            throw new InvalidNegativePriceError();
        }
    }

    public static boolean isValidPrice(String currentPrice) {
        try {
            checkPriceIsEmpty(currentPrice);
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

    public static void checkIsNotDone(ArrayList<Instrument> instruments, int instrumentNumber)
            throws AlreadyDoneError {
        Instrument instrument = instruments.get(instrumentNumber);
        boolean isDoneStatus = instrument.getIsDone();
        if (isDoneStatus) {
            throw new AlreadyDoneError();
        }
    }

    public static void checkSentimentIsEmpty(String sentiment) throws InvalidEmptySentimentError {
        if (sentiment.isEmpty()) {
            throw new InvalidEmptySentimentError();
        }
    }

    public static void checkSentiment(String sentiment) throws InvalidSentimentError {
        boolean isValidPositiveSentiment = sentiment.equals(POSITIVE_SENTIMENT);
        boolean isValidNegativeSentiment = sentiment.equals(NEGATIVE_SENTIMENT);
        boolean isValidNeutralSentiment = sentiment.equals(NEUTRAL_SENTIMENT);
        if (!isValidPositiveSentiment && !isValidNeutralSentiment && !isValidNegativeSentiment) {
            throw new InvalidSentimentError();
        }
    }

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

    public static void checkDateIsEmpty(String expiryInput) throws InvalidEmptyExpiryDateError {
        if (expiryInput.isEmpty()) {
            throw new InvalidEmptyExpiryDateError();
        }
    }

    public static void checkDateIsValidFormat(String expiryInput) throws InvalidDateFormatError {
        try {
            LocalDate.parse(expiryInput);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatError();
        }
    }

    public static void checkDateIsInPast(String expiryInput) throws InvalidPastDateError {
        LocalDate givenDate = LocalDate.parse(expiryInput);
        if (givenDate.isBefore(LocalDate.now())) {
            throw new InvalidPastDateError();
        }
    }

    public static boolean isValidExpiry(String expiryInput) {
        try {
            checkDateIsEmpty(expiryInput);
            checkDateIsValidFormat(expiryInput);
            checkDateIsInPast(expiryInput);
        } catch (Exception e) {
            logger.info(LogHelper.LOG_INVALID_EXPIRY);
            TextUi.showErrorMessage(e);
            return false;
        }
        return true;
    }


}
