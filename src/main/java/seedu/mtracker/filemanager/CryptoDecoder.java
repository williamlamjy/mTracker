package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Crypto;

import java.time.LocalDate;

public class CryptoDecoder extends InstrumentDecoder {

    public static final int CRYPTO_EXPIRY_INDEX = 5;
    public static final int CRYPTO_REMARKS_INDEX = 6;
    protected static LocalDate decodedExpiry;
    protected static String decodedRemarks;

    public static boolean isValidExpiry(String[] textSegment) {
        if(Validate.isValidExpiry(textSegment[CRYPTO_EXPIRY_INDEX])) {
            return true;
        }
        return false;
    }

    public static void validateAndDecodeSpecificAttributes(String[] textSegment) {
        if(isValidExpiry(textSegment)) {
            decodeSpecificAttributes(textSegment);
        }
    }

    private static void decodeSpecificAttributes(String[] textSegment) {
        decodedExpiry = LocalDate.parse(textSegment[CRYPTO_EXPIRY_INDEX]);
        decodedRemarks = textSegment[CRYPTO_REMARKS_INDEX];
    }

    public static void addCryptoToList(String[] textSegment, InstrumentManager instrumentManager) {
        validateAndDecodeGeneralAttributes(textSegment);
        validateAndDecodeSpecificAttributes(textSegment);
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
