package seedu.mtracker.filemanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.mtracker.error.fileerror.InvalidCurrPriceSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyCurrPriceInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyNameInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptySentimentInFileError;
import seedu.mtracker.error.fileerror.InvalidEmptyStatusInFileError;
import seedu.mtracker.error.fileerror.InvalidInstrumentInFileError;
import seedu.mtracker.error.fileerror.InvalidNameSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidSentimentSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidStatusSavedInFileError;
import seedu.mtracker.model.InstrumentManager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InstrumentDecoderTest {

    public static final String TEST_TYPE = "forex";
    public static final String TEST_INVALID_TYPE = "nft";
    public static final String TEST_NAME = "USDSGD";
    public static final String TEST_INVALID_FOREX_NAME = "Test";
    public static final String TEST_PRICE_STRING = "34.5";
    public static final String TEST_INVALID_PRICE_STRING = "0";
    public static final String TEST_SENTIMENT = "negative";
    public static final String TEST_INVALID_SENTIMENT = "+";
    public static final String TEST_INVALID_STATUS = "not valid status";
    public static final String TEST_DONE_STRING = "false";
    public static final String TEST_ENTRY_PRICE_STRING = "30.0";
    public static final String TEST_INVALID_ENTRY_PRICE_STRING = "-1";
    public static final String TEST_EXIT_PRICE_STRING = "31.0";
    public static final String TEST_INVALID_EXIT_PRICE_STRING = "-1";
    public static final int DAYS_DIFFERENCE = 1;
    public static final LocalDate FUTURE_DATE = LocalDate.now().plusDays(DAYS_DIFFERENCE);
    public static final String FUTURE_DATE_STRING = FUTURE_DATE.toString();
    public static final String FUTURE_INVALID_DATE_STRING = "2 November";
    public static final String TEST_REMARK = "";

    public static final String[] INVALID_INSTRUMENT_TYPE_TEXT_SEGMENT = {
        TEST_INVALID_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_FOREX_NAME_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_INVALID_FOREX_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_FOREX_PRICE_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME,
        TEST_INVALID_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_FOREX_SENTIMENT_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_INVALID_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_EMPTY_NAME_TEXT_SEGMENT = {
        TEST_TYPE
    };

    public static final String[] INVALID_EMPTY_CURRENT_PRICE_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME
    };

    public static final String[] INVALID_EMPTY_SENTIMENT_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING
    };

    public static final String[] INVALID_EMPTY_STATUS_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT
    };

    public static final String[] INVALID_STATUS_TEXT_SEGMENT = {
        TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_INVALID_STATUS
    };

    private InstrumentManager instrumentManager;

    @BeforeEach
    void initialiseTestResources() {
        instrumentManager = InstrumentManager.getInstance();
    }

    @Test
    void decodeGeneralAttributes_invalidName_expectException() {
        assertThrows(InvalidNameSavedInFileError.class,
            () -> InstrumentDecoder
                    .validateAndDecodeGeneralAttributes(INVALID_FOREX_NAME_TEXT_SEGMENT));
    }

    @Test
    void decodeGeneralAttributes_invalidPrice_expectException() {
        assertThrows(InvalidCurrPriceSavedInFileError.class,
            () -> InstrumentDecoder
                    .validateAndDecodeGeneralAttributes(INVALID_FOREX_PRICE_TEXT_SEGMENT));
    }

    @Test
    void decodeGeneralAttributes_invalidSentiment_expectException() {
        assertThrows(InvalidSentimentSavedInFileError.class,
            () -> InstrumentDecoder
                    .validateAndDecodeGeneralAttributes(INVALID_FOREX_SENTIMENT_TEXT_SEGMENT));
    }

    @Test
    void addSavedInstrumentToList_invalidType_expectException() {
        assertThrows(InvalidInstrumentInFileError.class,
            () -> InstrumentDecoder
                    .addSavedInstrumentToList(instrumentManager, INVALID_INSTRUMENT_TYPE_TEXT_SEGMENT));
    }

    @Test
    void addSavedInstrumentToList_emptyName_expectException() {
        assertThrows(InvalidEmptyNameInFileError.class,
            () -> InstrumentDecoder
                        .addSavedInstrumentToList(instrumentManager, INVALID_EMPTY_NAME_TEXT_SEGMENT));
    }

    @Test
    void addSavedInstrumentToList_emptyPrice_expectException() {
        assertThrows(InvalidEmptyCurrPriceInFileError.class,
            () -> InstrumentDecoder
                        .addSavedInstrumentToList(instrumentManager, INVALID_EMPTY_CURRENT_PRICE_TEXT_SEGMENT));
    }

    @Test
    void addSavedInstrumentToList_emptySentiment_expectException() {
        assertThrows(InvalidEmptySentimentInFileError.class,
            () -> InstrumentDecoder
                        .addSavedInstrumentToList(instrumentManager, INVALID_EMPTY_SENTIMENT_TEXT_SEGMENT));
    }

    @Test
    void addSavedInstrumentToList_emptyStatus_expectException() {
        assertThrows(InvalidEmptyStatusInFileError.class,
            () -> InstrumentDecoder
                        .addSavedInstrumentToList(instrumentManager, INVALID_EMPTY_STATUS_TEXT_SEGMENT));
    }

    @Test
    void addSavedInstrumentToList_invalidStatus_expectException() {
        assertThrows(InvalidStatusSavedInFileError.class,
            () -> InstrumentDecoder
                        .addSavedInstrumentToList(instrumentManager, INVALID_STATUS_TEXT_SEGMENT));
    }
}
