package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.fileerror.InvalidCurrPriceSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyCurrPriceInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyNameInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptySentimentInFileError;
import seedu.mtracker.error.fileerror.InvalidInstrumentInFileError;
import seedu.mtracker.error.fileerror.InvalidNameSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidSentimentSavedInFileError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.ui.TextUi;

import java.util.List;

public class InstrumentDecoder {

    public static final int SPLIT_FUNCTION_LIMIT_VALUE = -1;

    public static final String TYPE_CRYPTO = "crypto";
    public static final String TYPE_STOCK = "stock";
    public static final String TYPE_ETF = "etf";
    public static final String TYPE_FOREX = "forex";

    public static final int TYPE_INDEX = 0;
    public static final int NAME_INDEX = 1;
    public static final int CURR_PRICE_INDEX = 2;
    public static final int SENTIMENT_INDEX = 3;
    public static final int IS_DONE_INDEX = 4;

    public static String decodedSentiment;
    public static String decodedName;
    public static double decodedCurrPrice;
    public static boolean decodedIsDone;

    protected static final int ASCII_CODE = 127;
    protected static final char FILE_SEPARATOR = (char) ASCII_CODE;


    public static boolean isValidCurrPrice(String[] textSegment) {
        return Validate.isValidPrice(textSegment[CURR_PRICE_INDEX]);
    }

    public static boolean isValidSentiment(String[] textSegment) {
        return Validate.isValidSentiment(textSegment[SENTIMENT_INDEX]);
    }

    public static boolean isValidName(String[] textSegment) {
        return Validate.isValidName(textSegment[NAME_INDEX], textSegment[TYPE_INDEX]);
    }

    public static String getNameFromFile(String[] textSegment) throws InvalidEmptyNameInFileError {
        String name;
        try {
            name = textSegment[NAME_INDEX];
        } catch (IllegalArgumentException e) {
            throw new InvalidEmptyNameInFileError();
        }
        return name;
    }

    public static String getSentimentFromFile(String[] textSegment) throws InvalidEmptySentimentInFileError {
        String sentiment;
        try {
            sentiment = textSegment[SENTIMENT_INDEX];
        } catch (IllegalArgumentException e) {
            throw new InvalidEmptySentimentInFileError();
        }
        return sentiment;
    }

    public static String getCurrPriceFromFile(String[] textSegment) throws InvalidEmptyCurrPriceInFileError {
        String currPrice;
        try {
            currPrice = textSegment[CURR_PRICE_INDEX];
        } catch (IllegalArgumentException e) {
            throw new InvalidEmptyCurrPriceInFileError();
        }
        return currPrice;
    }

    public static void validateAndDecodeGeneralAttributes(String[] textSegment) throws InvalidEmptyNameInFileError,
            InvalidEmptyCurrPriceInFileError, InvalidEmptySentimentInFileError, InvalidSentimentSavedInFileError,
            InvalidNameSavedInFileError, InvalidCurrPriceSavedInFileError {
        String name = getNameFromFile(textSegment);
        String currPrice = getCurrPriceFromFile(textSegment);
        String sentiment = getSentimentFromFile(textSegment);
        validateGeneralAttributes(textSegment);
        decodeGeneralAttributes(name, currPrice, sentiment, textSegment);
    }

    private static void validateGeneralAttributes(String[] textSegment) throws InvalidSentimentSavedInFileError,
            InvalidNameSavedInFileError, InvalidCurrPriceSavedInFileError {
        if (!isValidSentiment(textSegment)) {
            throw new InvalidSentimentSavedInFileError();
        }
        if (!isValidName(textSegment)) {
            throw new InvalidNameSavedInFileError();
        }
        if (!isValidCurrPrice(textSegment)) {
            throw new InvalidCurrPriceSavedInFileError();
        }
    }

    public static void tryValidateAndDecodeGeneralAttributes(String[] textSegment) {
        try {
            validateAndDecodeGeneralAttributes(textSegment);
        } catch (Exception e) {
            TextUi.showErrorMessage(e);
        }
    }

    public static void decodeGeneralAttributes(String name, String currPrice, String sentiment, String[] textSegment) {
        decodedName = name;
        decodedCurrPrice = Double.parseDouble(currPrice);
        decodedSentiment = sentiment;
        decodedIsDone = Boolean.parseBoolean(textSegment[IS_DONE_INDEX]);
    }

    public static void setDoneStatus(boolean isDone, Instrument doneInstrument) {
        if (!isDone) {
            return;
        }
        doneInstrument.markAsDone();
    }

    public static void readFile(InstrumentManager instrumentManager, List<String> fileData) {
        fileData.stream()
                .forEach((line) -> {
                    String[] textSegment = line.split(String.valueOf(FILE_SEPARATOR), SPLIT_FUNCTION_LIMIT_VALUE);
                    try {
                        addSavedInstrumentToList(instrumentManager, textSegment);
                    } catch (InvalidInstrumentInFileError e) {
                        TextUi.showErrorMessage(e);
                    }
                });
    }

    public static void addSavedInstrumentToList(InstrumentManager instrumentManager, String[] textSegment)
            throws InvalidInstrumentInFileError {
        switch (textSegment[TYPE_INDEX]) {
        case TYPE_CRYPTO:
            CryptoDecoder.addCryptoToList(textSegment, instrumentManager);
            break;
        case TYPE_STOCK:
            StockDecoder.addStockToList(textSegment, instrumentManager);
            break;
        case TYPE_FOREX:
            ForexDecoder.addForexToList(textSegment, instrumentManager);
            break;
        case TYPE_ETF:
            EtfDecoder.addEtfToList(textSegment, instrumentManager);
            break;
        default:
            throw new InvalidInstrumentInFileError();
        }
    }
}
