package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.InvalidInstrumentInFileError;
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
    protected static final char FILE_SEPARATOR = (char)ASCII_CODE;


    public static boolean isValidPrice(String[] textSegment) {
        if(Validate.isValidPrice(textSegment[CURR_PRICE_INDEX])) {
            return true;
        }
        return false;
    }

    public static boolean isValidSentiment(String[] textSegment) {
        if(Validate.isValidSentiment(textSegment[SENTIMENT_INDEX])) {
            return true;
        }
        return false;
    }

    public static boolean isValidName(String[] textSegment) {
        if(Validate.isValidName(textSegment[NAME_INDEX], textSegment[TYPE_INDEX])){
            return true;
        }
        return false;
    }

    public static void validateAndDecodeGeneralAttributes(String[] textSegment) {
        if(isValidGeneralAttributes(textSegment)) {
            decodeGeneralAttributes(textSegment);
        }
    }

    private static boolean isValidGeneralAttributes(String[] textSegment) {
        return isValidName(textSegment) && isValidPrice(textSegment) && isValidSentiment(textSegment);
    }

    public static void decodeGeneralAttributes(String[] textSegment) {
            decodedName = textSegment[NAME_INDEX];
            decodedSentiment = textSegment[SENTIMENT_INDEX];
            decodedCurrPrice = Double.parseDouble(textSegment[CURR_PRICE_INDEX]);
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



    private static void addSavedInstrumentToList(InstrumentManager instrumentManager, String[] textSegment)
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
