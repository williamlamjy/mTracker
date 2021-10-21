package seedu.mtracker.filemanager;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Etf;

public class EtfDecoder extends InstrumentDecoder {

    public static final int PAST_RETURNS_INDEX = 4;
    public static final int ETF_REMARKS_INDEX = 5;

    public static void addEtfToList(String[] textSegment, InstrumentManager instrumentManager) {
        decodeGeneralAttributes(textSegment);
        double decodedPastReturns = Double.parseDouble(textSegment[PAST_RETURNS_INDEX]);
        String decodedRemarks = textSegment[ETF_REMARKS_INDEX];
        Instrument etf = new Etf(decodedName, decodedCurrPrice, decodedSentiment,
                decodedPastReturns, decodedRemarks);
        instrumentManager.addInstrument(etf);
    }

}
