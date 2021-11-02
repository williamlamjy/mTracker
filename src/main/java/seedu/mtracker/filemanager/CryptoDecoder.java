package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.FileLoadError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Crypto;
import seedu.mtracker.ui.TextUi;

import java.time.LocalDate;

public class CryptoDecoder extends InstrumentDecoder {

    public static final int CRYPTO_EXPIRY_INDEX = 5;
    public static final int CRYPTO_REMARKS_INDEX = 6;
    protected static LocalDate decodedExpiry;
    protected static String decodedRemarks;

    public static boolean isValidExpiry(String[] textSegment) {
        return Validate.isValidExpiry(textSegment[CRYPTO_EXPIRY_INDEX]);
    }

    public static void validateAndDecodeSpecificAttributes(String[] textSegment) throws FileLoadError {
        if (isValidExpiry(textSegment)) {
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
        decodedExpiry = LocalDate.parse(textSegment[CRYPTO_EXPIRY_INDEX]);
        decodedRemarks = textSegment[CRYPTO_REMARKS_INDEX];
    }

    public static void addCryptoToList(String[] textSegment, InstrumentManager instrumentManager) {
        tryValidateAndDecodeGeneralAttributes(textSegment);
        tryValidateAndDecodeSpecificAttributes(textSegment);
        Instrument crypto = createDecodedInstrument();
        setDoneStatus(decodedIsDone, crypto);
        instrumentManager.addInstrument(crypto);
    }

    private static Instrument createDecodedInstrument() {
        Instrument crypto = new Crypto(decodedName, decodedCurrPrice, decodedSentiment,
                decodedExpiry, decodedRemarks);
        return crypto;
    }

}
