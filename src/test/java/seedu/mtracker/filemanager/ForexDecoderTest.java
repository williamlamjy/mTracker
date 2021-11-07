package seedu.mtracker.filemanager;

import org.junit.jupiter.api.Test;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyEntryPriceInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyExitPriceInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEmptyExpiryInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidEntryPriceSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidExitPriceSavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidExpirySavedInFileError;
import seedu.mtracker.commons.error.fileerror.InvalidRemarksInFileError;

import static org.junit.jupiter.api.Assertions.assertThrows;

//@@author williamlamjy
class ForexDecoderTest extends InstrumentDecoderTest {

    public static final String[] INVALID_FOREX_EXPIRY_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_INVALID_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_FOREX_EMPTY_EXPIRY_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING
    };

    public static final String[] INVALID_FOREX_ENTRY_PRICE_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_INVALID_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_FOREX_EMPTY_ENTRY_PRICE_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING
    };

    public static final String[] INVALID_FOREX_EXIT_PRICE_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_INVALID_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_FOREX_EMPTY_EXIT_PRICE_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING
    };

    public static final String[] INVALID_FOREX_REMARKS_WRONG_FORMAT_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING
    };


    @Test
    void decodeSpecificAttributes_invalidExpiry_expectException() {
        assertThrows(InvalidExpirySavedInFileError.class,
            () -> ForexDecoder
                        .validateAndDecodeSpecificAttributes(INVALID_FOREX_EXPIRY_TEXT_SEGMENT));
    }

    @Test
    void decodeSpecificAttributes_emptyExpiry_expectException() {
        assertThrows(InvalidEmptyExpiryInFileError.class,
            () -> ForexDecoder
                        .validateAndDecodeSpecificAttributes(INVALID_FOREX_EMPTY_EXPIRY_TEXT_SEGMENT));
    }

    @Test
    void decodeSpecificAttributes_invalidEntryPrice_expectException() {
        assertThrows(InvalidEntryPriceSavedInFileError.class,
            () -> ForexDecoder
                        .validateAndDecodeSpecificAttributes(INVALID_FOREX_ENTRY_PRICE_TEXT_SEGMENT));
    }

    @Test
    void decodeSpecificAttributes_emptyEntryPrice_expectException() {
        assertThrows(InvalidEmptyEntryPriceInFileError.class,
            () -> ForexDecoder
                        .validateAndDecodeSpecificAttributes(INVALID_FOREX_EMPTY_ENTRY_PRICE_TEXT_SEGMENT));
    }

    @Test
    void decodeSpecificAttributes_invalidExitPrice_expectException() {
        assertThrows(InvalidExitPriceSavedInFileError.class,
            () -> ForexDecoder
                        .validateAndDecodeSpecificAttributes(INVALID_FOREX_EXIT_PRICE_TEXT_SEGMENT));
    }

    @Test
    void decodeSpecificAttributes_emptyExitPrice_expectException() {
        assertThrows(InvalidEmptyExitPriceInFileError.class,
            () -> ForexDecoder
                        .validateAndDecodeSpecificAttributes(INVALID_FOREX_EMPTY_EXIT_PRICE_TEXT_SEGMENT));
    }

    @Test
    void decodeSpecificAttributes_remarksFormatNotCorrect_expectException() {
        assertThrows(InvalidRemarksInFileError.class,
            () -> ForexDecoder
                        .validateAndDecodeSpecificAttributes(INVALID_FOREX_REMARKS_WRONG_FORMAT_TEXT_SEGMENT));
    }
}
