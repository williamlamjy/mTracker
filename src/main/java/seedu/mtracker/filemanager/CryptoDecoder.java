package seedu.mtracker.filemanager;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Crypto;

public class CryptoDecoder extends InstrumentDecoder {

    public static final int CRYPTO_EXPIRY_INDEX = 4;
    public static final int CRYPTO_REMARKS_INDEX = 5;

    public static void addCryptoToList(String[] textSegment, InstrumentManager instrumentManager) {
        String name = textSegment[NAME_INDEX];
        double currentPrice = Double.parseDouble(textSegment[CURR_PRICE_INDEX]);
        String sentiment = textSegment[SENTIMENT_INDEX];
        String expiry = textSegment[CRYPTO_EXPIRY_INDEX];
        String remarks = textSegment[CRYPTO_REMARKS_INDEX];
        Instrument crypto = new Crypto(name, currentPrice, sentiment, expiry, remarks);
        instrumentManager.addInstrument(crypto);
    }

}
