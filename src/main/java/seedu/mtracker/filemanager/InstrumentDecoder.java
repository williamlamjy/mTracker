package seedu.mtracker.filemanager;

import seedu.mtracker.error.InvalidInstrumentInFileError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Crypto;
import seedu.mtracker.model.subinstrument.Etf;
import seedu.mtracker.model.subinstrument.Forex;
import seedu.mtracker.model.subinstrument.Stock;
import seedu.mtracker.ui.TextUi;

import java.util.List;

public class InstrumentDecoder {

    public static final String FILE_SEPARATOR = ";";
    public static final int TYPE_INDEX = 0;
    public static final int NAME_INDEX = 1;
    public static final int CURR_PRICE_INDEX = 2;
    public static final int SENTIMENT_INDEX = 3;

    public static final int CRYPTO_EXPIRY_INDEX = 4;
    public static final int CRYPTO_REMARKS_INDEX = 5;

    public static final int ENTRY_PRICE_INDEX = 4;
    public static final int EXIT_PRICE_INDEX = 5;
    public static final int FOREX_EXPIRY_INDEX = 6;
    public static final int FOREX_REMARKS_INDEX = 7;

    public static final int STOCK_REMARKS_INDEX = 4;

    public static final int PAST_RETURNS_INDEX = 4;
    public static final int ETF_REMARKS_INDEX = 5;


    public static void readFile(InstrumentManager instrumentManager, List<String> fileData) {
        fileData.stream()
                .forEach((line) -> {
                    String[] textSegment = line.split(FILE_SEPARATOR, -1);
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
        case ("Crypto"):
            addCryptoToList(textSegment, instrumentManager);
            break;
        case ("Stock"):
            addStockToList(textSegment, instrumentManager);
            break;
        case ("Forex"):
            addForexToList(textSegment, instrumentManager);
            break;
        case ("Etf"):
            addEtfToList(textSegment, instrumentManager);
            break;
        default:
            throw new InvalidInstrumentInFileError();
        }
    }

    public static void addCryptoToList(String[] textSegment, InstrumentManager instrumentManager) {
        String name = textSegment[NAME_INDEX];
        double currentPrice = Double.parseDouble(textSegment[CURR_PRICE_INDEX]);
        String sentiment = textSegment[SENTIMENT_INDEX];
        String expiry = textSegment[CRYPTO_EXPIRY_INDEX];
        String remarks = textSegment[CRYPTO_REMARKS_INDEX];
        Instrument crypto = new Crypto(name, currentPrice, sentiment, expiry, remarks);
        instrumentManager.addInstrument(crypto);
    }

    public static void addForexToList(String[] textSegment, InstrumentManager instrumentManager) {
        String name = textSegment[NAME_INDEX];
        double currentPrice = Double.parseDouble(textSegment[CURR_PRICE_INDEX]);
        String sentiment = textSegment[SENTIMENT_INDEX];
        double entryPrice = Double.parseDouble(textSegment[ENTRY_PRICE_INDEX]);
        double exitPrice = Double.parseDouble(textSegment[EXIT_PRICE_INDEX]);
        String expiry = textSegment[FOREX_EXPIRY_INDEX];
        String remarks = textSegment[FOREX_REMARKS_INDEX];
        Instrument forex = new Forex(name, currentPrice, sentiment,
                entryPrice, exitPrice, expiry, remarks);
        instrumentManager.addInstrument(forex);
    }

    public static void addStockToList(String[] textSegment, InstrumentManager instrumentManager) {
        String name = textSegment[NAME_INDEX];
        double currentPrice = Double.parseDouble(textSegment[CURR_PRICE_INDEX]);
        String sentiment = textSegment[SENTIMENT_INDEX];
        String remarks = textSegment[STOCK_REMARKS_INDEX];
        Instrument stock = new Stock(name, currentPrice, sentiment, remarks);
        instrumentManager.addInstrument(stock);
    }

    public static void addEtfToList(String[] textSegment, InstrumentManager instrumentManager) {
        String name = textSegment[NAME_INDEX];
        double currentPrice = Double.parseDouble(textSegment[CURR_PRICE_INDEX]);
        String sentiment = textSegment[SENTIMENT_INDEX];
        double pastReturns = Double.parseDouble(textSegment[PAST_RETURNS_INDEX]);
        String remarks = textSegment[ETF_REMARKS_INDEX];
        Instrument etf = new Etf(name, currentPrice, sentiment, pastReturns, remarks);
        instrumentManager.addInstrument(etf);
    }
}
