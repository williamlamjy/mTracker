package seedu.mtracker.filemanager;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Forex;

public class ForexDecoder extends InstrumentDecoder {

    public static final int ENTRY_PRICE_INDEX = 5;
    public static final int EXIT_PRICE_INDEX = 6;
    public static final int FOREX_EXPIRY_INDEX = 7;
    public static final int FOREX_REMARKS_INDEX = 8;

    public static void addForexToList(String[] textSegment, InstrumentManager instrumentManager) {
        decodeGeneralAttributes(textSegment);
        double decodedEntryPrice = Double.parseDouble(textSegment[ENTRY_PRICE_INDEX]);
        double decodedExitPrice = Double.parseDouble(textSegment[EXIT_PRICE_INDEX]);
        String decodedExpiry = textSegment[FOREX_EXPIRY_INDEX];
        String decodedRemarks = textSegment[FOREX_REMARKS_INDEX];
        Instrument forex = new Forex(decodedName, decodedCurrPrice, decodedSentiment,
                decodedEntryPrice, decodedExitPrice, decodedExpiry, decodedRemarks);
        instrumentManager.addInstrument(forex);
        setIsDone(decodedIsDone, instrumentManager);
    }
}
