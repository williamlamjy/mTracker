package seedu.mtracker.filemanager;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Crypto;

import java.time.LocalDate;

public class CryptoDecoder extends InstrumentDecoder {

    public static final int CRYPTO_EXPIRY_INDEX = 5;
    public static final int CRYPTO_REMARKS_INDEX = 6;

    public static void addCryptoToList(String[] textSegment, InstrumentManager instrumentManager) {
        decodeGeneralAttributes(textSegment);
        // todo: abstract out to decode instrument attributes for the different decoders
        LocalDate decodedExpiry = LocalDate.parse(textSegment[CRYPTO_EXPIRY_INDEX]);
        String decodedRemarks = textSegment[CRYPTO_REMARKS_INDEX];
        Instrument crypto = new Crypto(decodedName, decodedCurrPrice, decodedSentiment,
                decodedExpiry, decodedRemarks);
        setDoneStatus(decodedIsDone, crypto);
        instrumentManager.addInstrument(crypto);
    }

}
