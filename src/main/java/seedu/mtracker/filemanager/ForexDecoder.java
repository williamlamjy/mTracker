package seedu.mtracker.filemanager;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Forex;

public class ForexDecoder extends InstrumentDecoder {

    public static final int ENTRY_PRICE_INDEX = 4;
    public static final int EXIT_PRICE_INDEX = 5;
    public static final int FOREX_EXPIRY_INDEX = 6;
    public static final int FOREX_REMARKS_INDEX = 7;

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
}
