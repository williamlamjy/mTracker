package seedu.mtracker.filemanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.mtracker.error.fileerror.InvalidCurrPriceSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidEntryPriceSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidExitPriceSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidExpirySavedInFileError;
import seedu.mtracker.error.fileerror.InvalidInstrumentInFileError;
import seedu.mtracker.error.fileerror.InvalidNameSavedInFileError;
import seedu.mtracker.error.fileerror.InvalidSentimentSavedInFileError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Forex;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InstrumentDecoderTest {

    public static final String TEST_TYPE = "forex";
    public static final String TEST_INVALID_TYPE = "nft";
    public static final String TEST_NAME = "USDSGD";
    public static final String TEST_INVALID_FOREX_NAME = "Test";
    public static final double TEST_PRICE = 34.5;
    public static final String TEST_PRICE_STRING = "34.5";
    public static final String TEST_INVALID_PRICE_STRING = "0";
    public static final String TEST_SENTIMENT = "negative";
    public static final String TEST_INVALID_SENTIMENT = "+";
    public static final String TEST_DONE_STRING = "false";
    public static final double TEST_ENTRY_PRICE = 30.0;
    public static final String TEST_ENTRY_PRICE_STRING = "30.0";
    public static final String TEST_INVALID_ENTRY_PRICE_STRING = "-1";
    public static final double TEST_EXIT_PRICE = 31.0;
    public static final String TEST_EXIT_PRICE_STRING = "31.0";
    public static final String TEST_INVALID_EXIT_PRICE_STRING = "-1";
    public static final int DAYS_DIFFERENCE = 1;
    public static final LocalDate FUTURE_DATE = LocalDate.now().plusDays(DAYS_DIFFERENCE);
    public static final String FUTURE_DATE_STRING = "2021-12-02";
    public static final String FUTURE_INVALID_DATE_STRING = "2 November";
    public static final String TEST_REMARK = "";
    public static final Instrument TEST_FOREX = new Forex(TEST_NAME, TEST_PRICE, TEST_SENTIMENT,
            TEST_ENTRY_PRICE, TEST_EXIT_PRICE, FUTURE_DATE, TEST_REMARK);

    public static final int NUMBER_OF_PARAMS = 8;
    public static final int LENGTH_OF_DATE = 10;
    public static final int LENGTH_OF_PRICES = 12;
    public static final int LENGTH_OF_DONE = 5;
    public static final int LENGTH_OF_INSTRUMENT = 5;

    public static final String[] INVALID_INSTRUMENT_TYPE_TEXT_SEGMENT = {TEST_INVALID_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_FOREX_NAME_TEXT_SEGMENT = {TEST_TYPE,
        TEST_INVALID_FOREX_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_FOREX_PRICE_TEXT_SEGMENT = {TEST_TYPE,
        TEST_NAME,
        TEST_INVALID_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_FOREX_SENTIMENT_TEXT_SEGMENT = {TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_INVALID_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_FOREX_EXPIRY_TEXT_SEGMENT = {TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_INVALID_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_FOREX_ENTRY_PRICE_TEXT_SEGMENT = {TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_INVALID_ENTRY_PRICE_STRING,
        TEST_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING,
        TEST_REMARK
    };

    public static final String[] INVALID_FOREX_EXIT_PRICE_TEXT_SEGMENT = {TEST_TYPE,
        TEST_NAME,
        TEST_PRICE_STRING,
        TEST_SENTIMENT,
        TEST_DONE_STRING,
        TEST_ENTRY_PRICE_STRING,
        TEST_INVALID_EXIT_PRICE_STRING,
        FUTURE_DATE_STRING,
        TEST_REMARK
    };

    private InstrumentManager instrumentManager;
    private Storage storage;

    @BeforeEach
    void initialiseTestResources() {
        storage = new Storage();
        instrumentManager = InstrumentManager.getInstance();
        instrumentManager.addInstrument(TEST_FOREX);
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
    void decodeSpecificAttributes_invalidExpiry_expectException() {
        assertThrows(InvalidExpirySavedInFileError.class,
            () -> ForexDecoder
                    .validateAndDecodeSpecificAttributes(INVALID_FOREX_EXPIRY_TEXT_SEGMENT));
    }

    @Test
    void decodeSpecificAttributes_invalidEntryPrice_expectException() {
        assertThrows(InvalidEntryPriceSavedInFileError.class,
            () -> ForexDecoder
                    .validateAndDecodeSpecificAttributes(INVALID_FOREX_ENTRY_PRICE_TEXT_SEGMENT));
    }

    @Test
    void decodeSpecificAttributes_invalidExitPrice_expectException() {
        assertThrows(InvalidExitPriceSavedInFileError.class,
            () -> ForexDecoder
                    .validateAndDecodeSpecificAttributes(INVALID_FOREX_EXIT_PRICE_TEXT_SEGMENT));
    }

    @Test
    void addSavedInstrumentToList_invalidType_expectException() {
        assertThrows(InvalidInstrumentInFileError.class,
            () -> InstrumentDecoder
                    .addSavedInstrumentToList(instrumentManager, INVALID_INSTRUMENT_TYPE_TEXT_SEGMENT));
    }
}
