package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.FileLoadError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Etf;
import seedu.mtracker.ui.TextUi;

public class EtfDecoder extends InstrumentDecoder {

    public static final int PAST_RETURNS_INDEX = 5;
    public static final int ETF_REMARKS_INDEX = 6;
    protected static double decodedPastReturns;
    protected static String decodedRemarks;

    public static boolean isValidPastReturns(String[] textSegment) {
        return Validate.isValidPastReturns(textSegment[PAST_RETURNS_INDEX]);
    }

    public static void validateAndDecodeSpecificAttributes(String[] textSegment) throws FileLoadError {
        if (isValidPastReturns(textSegment)) {
            decodeSpecificAttributes(textSegment);
        }
        throw new FileLoadError();
    }

    public static void tryValidateAndDecodeSpecificAttributes(String[] textSegment) {
        try {
            validateAndDecodeSpecificAttributes(textSegment);
        } catch (Exception e) {
            TextUi.showErrorMessage(e);
        }
    }

    private static void decodeSpecificAttributes(String[] textSegment) {
        decodedPastReturns = Double.parseDouble(textSegment[PAST_RETURNS_INDEX]);
        decodedRemarks = textSegment[ETF_REMARKS_INDEX];
    }

    public static void addEtfToList(String[] textSegment, InstrumentManager instrumentManager) {
        tryValidateAndDecodeGeneralAttributes(textSegment);
        tryValidateAndDecodeSpecificAttributes(textSegment);
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
