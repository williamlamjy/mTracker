package seedu.mtracker.filemanager;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Stock;

public class StockDecoder extends InstrumentDecoder {

    public static final int STOCK_REMARKS_INDEX = 4;

    public static void addStockToList(String[] textSegment, InstrumentManager instrumentManager) {
        decodeGeneralAttributes(textSegment);
        String decodedRemarks = textSegment[STOCK_REMARKS_INDEX];
        Instrument stock = new Stock(decodedName, decodedCurrPrice, decodedSentiment, decodedRemarks);
        instrumentManager.addInstrument(stock);
    }

}
