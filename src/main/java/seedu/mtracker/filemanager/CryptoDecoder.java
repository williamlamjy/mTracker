package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.fileerror.InvalidEmptyExpiryInFileError;
import seedu.mtracker.error.fileerror.InvalidExpirySavedInFileError;
import seedu.mtracker.error.fileerror.InvalidRemarksInFileError;
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

    public static String getExpiryFromFile(String[] textSegment) throws InvalidEmptyExpiryInFileError {
        String expiry;
        try {
            expiry = textSegment[CRYPTO_EXPIRY_INDEX];
        } catch (IllegalArgumentException e) {
            throw new InvalidEmptyExpiryInFileError();
        }
        return expiry;
    }

    public static String getRemarksFromFile(String[] textSegment) throws InvalidRemarksInFileError {
        String remarks;
        try {
            remarks = textSegment[CRYPTO_REMARKS_INDEX];
        } catch (IllegalArgumentException e) {
            throw new InvalidRemarksInFileError();
        }
        return remarks;
    }

    public static void validateAndDecodeSpecificAttributes(String[] textSegment) throws InvalidEmptyExpiryInFileError,
            InvalidRemarksInFileError, InvalidExpirySavedInFileError {
        String expiry = getExpiryFromFile(textSegment);
        String remarks = getRemarksFromFile(textSegment);
        if (!isValidExpiry(textSegment)) {
            throw new InvalidExpirySavedInFileError();
        }
        decodeSpecificAttributes(expiry, remarks);
    }

    public static void tryValidateAndDecodeSpecificAttributes(String[] textSegment) {
        try {
            validateAndDecodeSpecificAttributes(textSegment);
        } catch (Exception e) {
            TextUi.showErrorMessage(e);
        }
    }

    private static void decodeSpecificAttributes(String expiry, String remarks) {
        decodedExpiry = LocalDate.parse(expiry);
        decodedRemarks = remarks;
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
