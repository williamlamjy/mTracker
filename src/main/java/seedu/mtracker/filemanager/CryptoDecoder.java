package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.fileerror.InvalidCurrPriceSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyCurrPriceInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyExpiryInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyNameInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptySentimentInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyStatusInFileError;
import seedu.mtracker.error.fileerror.InvalidExpirySavedInFileError;
import seedu.mtracker.error.fileerror.InvalidNameSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidRemarksInFileError;
import seedu.mtracker.error.fileerror.InvalidSentimentSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidStatusSavedInFileError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Crypto;

import java.time.LocalDate;

public class CryptoDecoder extends InstrumentDecoder {

    public static final int CRYPTO_EXPIRY_INDEX = 5;
    public static final int CRYPTO_REMARKS_INDEX = 6;
    protected static LocalDate decodedExpiry;
    protected static String decodedRemarks;

    public static String getExpiryFromFile(String[] textSegment) throws InvalidEmptyExpiryInFileError {
        String expiry;
        try {
            expiry = textSegment[CRYPTO_EXPIRY_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidEmptyExpiryInFileError();
        }
        return expiry;
    }

    public static String getRemarksFromFile(String[] textSegment) throws InvalidRemarksInFileError {
        String remarks;
        try {
            remarks = textSegment[CRYPTO_REMARKS_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidRemarksInFileError();
        }
        return remarks;
    }

    private static void validateSpecificAttributes(String[] textSegment) throws InvalidExpirySavedInFileError {
        if (!Validate.isValidExpiry(textSegment[CRYPTO_EXPIRY_INDEX])) {
            throw new InvalidExpirySavedInFileError();
        }
    }

    private static void decodeSpecificAttributes(String expiry, String remarks) {
        decodedExpiry = LocalDate.parse(expiry);
        decodedRemarks = remarks;
    }

    public static void validateAndDecodeSpecificAttributes(String[] textSegment) throws InvalidEmptyExpiryInFileError,
            InvalidRemarksInFileError, InvalidExpirySavedInFileError {
        String expiry = getExpiryFromFile(textSegment);
        String remarks = getRemarksFromFile(textSegment);
        validateSpecificAttributes(textSegment);
        decodeSpecificAttributes(expiry, remarks);
    }

    public static void addCryptoToList(String[] textSegment, InstrumentManager instrumentManager)
            throws InvalidNameSavedInFileError, InvalidSentimentSavedInFileError, InvalidCurrPriceSavedInFileError,
            InvalidEmptyNameInFileError, InvalidEmptySentimentInFileError, InvalidEmptyStatusInFileError,
            InvalidStatusSavedInFileError, InvalidEmptyCurrPriceInFileError, InvalidEmptyExpiryInFileError,
            InvalidRemarksInFileError, InvalidExpirySavedInFileError {
        validateAndDecodeGeneralAttributes(textSegment);
        validateAndDecodeSpecificAttributes(textSegment);
        Instrument crypto = createDecodedInstrument();
        setDoneStatus(decodedIsDone, crypto);
        instrumentManager.addInstrument(crypto);
    }

    private static Instrument createDecodedInstrument() {
        return new Crypto(decodedName, decodedCurrPrice, decodedSentiment,
                decodedExpiry, decodedRemarks);
    }

}
