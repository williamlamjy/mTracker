package seedu.mtracker.filemanager;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Stock;

public class StockDecoder extends InstrumentDecoder {

    public static final int STOCK_REMARKS_INDEX = 4;

    public static void addStockToList(String[] textSegment, InstrumentManager instrumentManager) {
        String name = textSegment[NAME_INDEX];
        double currentPrice = Double.parseDouble(textSegment[CURR_PRICE_INDEX]);
        String sentiment = textSegment[SENTIMENT_INDEX];
        String remarks = textSegment[STOCK_REMARKS_INDEX];
        Instrument stock = new Stock(name, currentPrice, sentiment, remarks);
        instrumentManager.addInstrument(stock);
    }

}
