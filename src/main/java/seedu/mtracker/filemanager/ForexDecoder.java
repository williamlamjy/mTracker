package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.FileLoadError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Forex;
import seedu.mtracker.ui.TextUi;

import java.time.LocalDate;

public class ForexDecoder extends InstrumentDecoder {

    public static final int ENTRY_PRICE_INDEX = 5;
    public static final int EXIT_PRICE_INDEX = 6;
    public static final int FOREX_EXPIRY_INDEX = 7;
    public static final int FOREX_REMARKS_INDEX = 8;
    protected static double decodedEntryPrice;
    protected static double decodedExitPrice;
    protected static LocalDate decodedExpiry;
    protected static String decodedRemarks;

    public static boolean isValidEntryAndExitPrice(String[] textSegment) {
        return Validate.isValidPrice(textSegment[ENTRY_PRICE_INDEX]) &&
                Validate.isValidPrice(textSegment[EXIT_PRICE_INDEX]);
    }

    public static boolean isValidExpiry(String[] textSegment) {
        return Validate.isValidExpiry(textSegment[FOREX_EXPIRY_INDEX]);
    }

    public static void validateAndDecodeSpecificAttributes(String[] textSegment) throws FileLoadError {
        if (isValidSpecificAttributes(textSegment)) {
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

    private static boolean isValidSpecificAttributes(String[] textSegment) {
        return isValidEntryAndExitPrice(textSegment) && isValidExpiry(textSegment);
    }

    private static void decodeSpecificAttributes(String[] textSegment) {
        decodedEntryPrice = Double.parseDouble(textSegment[ENTRY_PRICE_INDEX]);
        decodedExitPrice = Double.parseDouble(textSegment[EXIT_PRICE_INDEX]);
        decodedExpiry = LocalDate.parse(textSegment[FOREX_EXPIRY_INDEX]);
        decodedRemarks = textSegment[FOREX_REMARKS_INDEX];
    }

    public static void addForexToList(String[] textSegment, InstrumentManager instrumentManager) {
        tryValidateAndDecodeGeneralAttributes(textSegment);
        tryValidateAndDecodeSpecificAttributes(textSegment);
        Instrument forex = createDecodedInstrument();
        setDoneStatus(decodedIsDone, forex);
        instrumentManager.addInstrument(forex);
    }

    private static Instrument createDecodedInstrument() {
        Instrument forex = new Forex(decodedName, decodedCurrPrice, decodedSentiment,
                decodedEntryPrice, decodedExitPrice, decodedExpiry, decodedRemarks);
        return forex;
    }
}
