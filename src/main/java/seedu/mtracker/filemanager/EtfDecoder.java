package seedu.mtracker.filemanager;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Etf;

import java.time.LocalDate;

public class EtfDecoder extends InstrumentDecoder {

    public static final int PAST_RETURNS_INDEX = 5;
    public static final int ETF_REMARKS_INDEX = 6;
    protected static double decodedPastReturns;
    protected static String decodedRemarks;

    private static void decodeSpecificAttributes(String[] textSegment) {
        decodedPastReturns = Double.parseDouble(textSegment[PAST_RETURNS_INDEX]);
        decodedRemarks = textSegment[ETF_REMARKS_INDEX];
    }

    public static void addEtfToList(String[] textSegment, InstrumentManager instrumentManager) {
        decodeGeneralAttributes(textSegment);
        decodeSpecificAttributes(textSegment);
        Instrument etf = new Etf(decodedName, decodedCurrPrice, decodedSentiment,
                decodedPastReturns, decodedRemarks);
        setDoneStatus(decodedIsDone, etf);
        instrumentManager.addInstrument(etf);
    }

}
