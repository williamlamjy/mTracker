package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Etf;

public class EtfDecoder extends InstrumentDecoder {

    public static final int PAST_RETURNS_INDEX = 5;
    public static final int ETF_REMARKS_INDEX = 6;
    protected static double decodedPastReturns;
    protected static String decodedRemarks;

    public static boolean isValidPastReturns(String[] textSegment) {
        if(Validate.isValidPastReturns(textSegment[PAST_RETURNS_INDEX])) {
            return true;
        }
        return false;
    }

    public static void validateAndDecodeSpecificAttributes(String[] textSegment) {
        if(isValidPastReturns(textSegment)) {
            decodeSpecificAttributes(textSegment);
        }
    }

    private static void decodeSpecificAttributes(String[] textSegment) {
        decodedPastReturns = Double.parseDouble(textSegment[PAST_RETURNS_INDEX]);
        decodedRemarks = textSegment[ETF_REMARKS_INDEX];
    }

    public static void addEtfToList(String[] textSegment, InstrumentManager instrumentManager) {
        validateAndDecodeGeneralAttributes(textSegment);
        validateAndDecodeSpecificAttributes(textSegment);
        Instrument etf = createDecodedInstrument();
        setDoneStatus(decodedIsDone, etf);
        instrumentManager.addInstrument(etf);
    }

    private static Instrument createDecodedInstrument() {
        Instrument etf = new Etf(decodedName, decodedCurrPrice, decodedSentiment,
                decodedPastReturns, decodedRemarks);
        return etf;
    }

}
