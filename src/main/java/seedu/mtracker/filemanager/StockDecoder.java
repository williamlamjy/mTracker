package seedu.mtracker.filemanager;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Stock;

public class StockDecoder extends InstrumentDecoder {

    public static final int STOCK_REMARKS_INDEX = 5;
    protected static String decodedRemarks;

    private static void decodeSpecificAttributes(String[] textSegment) {
        decodedRemarks = textSegment[STOCK_REMARKS_INDEX];
    }

    public static void addStockToList(String[] textSegment, InstrumentManager instrumentManager) {
        validateAndDecodeGeneralAttributes(textSegment);
        decodeSpecificAttributes(textSegment);
        Instrument stock = createDecodedInstrument();
        setDoneStatus(decodedIsDone, stock);
        instrumentManager.addInstrument(stock);
    }

    private static Instrument createDecodedInstrument() {
        Instrument stock = new Stock(decodedName, decodedCurrPrice, decodedSentiment, decodedRemarks);
        return stock;
    }

}
