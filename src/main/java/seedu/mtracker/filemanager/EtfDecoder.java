package seedu.mtracker.filemanager;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Etf;

public class EtfDecoder extends InstrumentDecoder {

    public static final int PAST_RETURNS_INDEX = 4;
    public static final int ETF_REMARKS_INDEX = 5;

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
