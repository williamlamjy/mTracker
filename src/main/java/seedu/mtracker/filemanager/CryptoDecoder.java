package seedu.mtracker.filemanager;

import seedu.mtracker.commons.Validate;
import seedu.mtracker.commons.error.fileerror.InvalidCurrPriceSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyCurrPriceInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyExpiryInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyNameInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptySentimentInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyStatusInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidExpirySavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidNameSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidRemarksInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidSentimentSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidStatusSavedInFileError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Crypto;

import java.time.LocalDate;

//@@author williamlamjy
/**
 * Decodes and adds crypto instruments into the InstrumentManager.
 */
public class CryptoDecoder extends InstrumentDecoder {

    public static final int CRYPTO_EXPIRY_INDEX = 5;
    public static final int CRYPTO_REMARKS_INDEX = 6;
    protected static LocalDate decodedExpiry;
    protected static String decodedRemarks;

    /**
     * Gets expiry from the mTracker file.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @return Expiry of the crypto.
     * @throws InvalidEmptyExpiryInFileError When the expiry parameter is empty in the file.
     */
    public static String getExpiryFromFile(String[] textSegment) throws InvalidEmptyExpiryInFileError {
        String expiry;
        try {
            expiry = textSegment[CRYPTO_EXPIRY_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidEmptyExpiryInFileError();
        }
        return expiry;
    }

    /**
     * Gets remarks from the mTracker file.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @return Remarks of the instrument.
     * @throws InvalidRemarksInFileError When the remarks parameter is of invalid format.
     */
    public static String getRemarksFromFile(String[] textSegment) throws InvalidRemarksInFileError {
        String remarks;
        try {
            remarks = textSegment[CRYPTO_REMARKS_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidRemarksInFileError();
        }
        return remarks;
    }

    /**
     * Validates that specific crypto attributes are of the right format.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @throws InvalidExpirySavedInFileError When the expiry parameter is of invalid format.
     */
    private static void validateSpecificAttributes(String[] textSegment) throws InvalidExpirySavedInFileError {
        if (!Validate.isValidExpiry(textSegment[CRYPTO_EXPIRY_INDEX])) {
            throw new InvalidExpirySavedInFileError();
        }
    }

    private static void decodeSpecificAttributes(String expiry, String remarks) {
        decodedExpiry = LocalDate.parse(expiry);
        decodedRemarks = remarks;
    }

    /**
     * Validates and decodes the specific attributes of the crypto.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @throws InvalidEmptyExpiryInFileError When the expiry parameter is empty in the file.
     * @throws InvalidRemarksInFileError When the remarks parameter is of invalid format.
     * @throws InvalidExpirySavedInFileError When the expiry parameter is of invalid format.
     */
    public static void validateAndDecodeSpecificAttributes(String[] textSegment) throws InvalidEmptyExpiryInFileError,
            InvalidRemarksInFileError, InvalidExpirySavedInFileError {
        String expiry = getExpiryFromFile(textSegment);
        String remarks = getRemarksFromFile(textSegment);
        validateSpecificAttributes(textSegment);
        decodeSpecificAttributes(expiry, remarks);
    }

    /**
     * Adds the validated and decoded crypto to the InstrumentManager.
     *
     * @param textSegment Array containing the parameters of an instrument.
     * @param instrumentManager Current InstrumentManager.
     * @throws InvalidNameSavedInFileError When the name parameter is of invalid format.
     * @throws InvalidSentimentSavedInFileError When the sentiment parameter is of invalid format.
     * @throws InvalidCurrPriceSavedInFileError When the current price parameter is of invalid format.
     * @throws InvalidEmptyNameInFileError When the name parameter is empty in the file.
     * @throws InvalidEmptyCurrPriceInFileError When the current price parameter is empty in the file.
     * @throws InvalidEmptySentimentInFileError When the sentiment parameter is empty in the file.
     * @throws InvalidEmptyStatusInFileError When the done status parameter is empty in the file.
     * @throws InvalidStatusSavedInFileError When the done status parameter is of invalid format.
     * @throws InvalidEmptyExpiryInFileError When the expiry parameter is empty in the file.
     * @throws InvalidRemarksInFileError When the remarks parameter is of invalid format.
     * @throws InvalidExpirySavedInFileError When the expiry parameter is of invalid format.
     */
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
