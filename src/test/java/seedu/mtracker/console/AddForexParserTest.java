package seedu.mtracker.console;

import org.junit.jupiter.api.Test;
import seedu.mtracker.commons.error.OperationAbortedError;

import static org.junit.jupiter.api.Assertions.assertThrows;

// @@KVignesh122

class AddForexParserTest extends GeneralInstrumentParserTest {

    public static final int PARAMETER_SIZE = 7;

    public static final String[] EXPECTED_PARAMS_NO_REMARKS = {
        "TTTXXX",
        "1.11",
        "positive",
        "1.15",
        "1.30",
        FUTURE_DATE.toString(),
        ""
    };

    public static final String[] EXPECTED_PARAMS_WITH_REMARKS = {
        "TTTXXX",
        "0.81",
        "negative",
        "0.79",
        "0.70",
        FUTURE_DATE.toString(),
        "fooRemarks"
    };

    public static final String USER_INPUT_NO_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIER + "1.11"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "1.15"
            + SEPARATOR_SPECIFIER + "1.30"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + " ";

    public static final String USER_INPUT_TRY_ABORT_AT_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIER + "1.11"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "1.15"
            + SEPARATOR_SPECIFIER + "1.30"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + ABORT;

    public static final String USER_INPUT_WITH_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + "negative"
            + SEPARATOR_SPECIFIER + "0.79"
            + SEPARATOR_SPECIFIER + "0.70"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_INVALID_NAME = SEPARATOR_SPECIFIER.repeat(2) + "TTXX"
            + SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "1.11"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "1.15"
            + SEPARATOR_SPECIFIER + "1.30"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + " ";

    public static final String USER_INPUT_TRY_ABORT_AT_NAME = SEPARATOR_SPECIFIER.repeat(2) + DONT_ABORT
            + SEPARATOR_SPECIFIER + ABORT;

    public static final String USER_INPUT_TRY_INVALID_PRICE = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "lol"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + "negative"
            + SEPARATOR_SPECIFIER + "foobar"
            + SEPARATOR_SPECIFIER + "0.79"
            + SEPARATOR_SPECIFIER.repeat(2) + "0.70"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_ABORT_AT_CURRENT_PRICE = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "lol"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER + ABORT;

    public static final String USER_INPUT_TRY_INVALID_SENTIMENT = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + "foobar"
            + SEPARATOR_SPECIFIER.repeat(2) + "negative"
            + SEPARATOR_SPECIFIER + "0.79"
            + SEPARATOR_SPECIFIER + "0.70"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_INVALID_EXPIRY = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + "foobar"
            + SEPARATOR_SPECIFIER + "negative"
            + SEPARATOR_SPECIFIER + "0.79"
            + SEPARATOR_SPECIFIER + "0.70"
            + SEPARATOR_SPECIFIER.repeat(2) + "testDate"
            + SEPARATOR_SPECIFIER + "31/12/2021"
            + SEPARATOR_SPECIFIER + "2021.01.01"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_PAST_EXPIRY = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + "foobar"
            + SEPARATOR_SPECIFIER + "negative"
            + SEPARATOR_SPECIFIER + "0.79"
            + SEPARATOR_SPECIFIER + "0.70"
            + SEPARATOR_SPECIFIER + PAST_DATE
            + SEPARATOR_SPECIFIER + PAST_DATE
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_ABORT_AT_SENTIMENT = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER.repeat(2) + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_ENTRY_PRICE = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "lol"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + "negative"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_EXIT_PRICE = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "lol"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + "negative"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_EXPIRY = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + "foobar"
            + SEPARATOR_SPECIFIER.repeat(2) + "negative"
            + SEPARATOR_SPECIFIER + "0.79"
            + SEPARATOR_SPECIFIER + "0.70"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER + ABORT;

    void testForexParameters(String input, String[] expectedForexParameters) throws OperationAbortedError {
        simulateConsoleInput(input);
        AddForexParser testForexParser = new AddForexParser();
        verifyInstrumentParameters(testForexParser, expectedForexParameters);
    }

    @Override
    public int getParameterSize() {
        return PARAMETER_SIZE;
    }

    @Test
    void addForexParams_allValidParameters_expectSuccess() throws OperationAbortedError {
        testForexParameters(USER_INPUT_NO_REMARKS, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addForexParams_allValidParametersWithRemarks_expectSuccess() throws OperationAbortedError {
        testForexParameters(USER_INPUT_WITH_REMARKS, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addForexParams_tryInvalidNameMultipleTimes_expectSuccess() throws OperationAbortedError {
        testForexParameters(USER_INPUT_TRY_INVALID_NAME, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addForexParams_tryInvalidPriceMultipleTimes_expectSuccess() throws OperationAbortedError {
        testForexParameters(USER_INPUT_TRY_INVALID_PRICE, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addForexParams_tryInvalidSentimentMultipleTimes_expectSuccess() throws OperationAbortedError {
        testForexParameters(USER_INPUT_TRY_INVALID_SENTIMENT, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addForexParams_tryInvalidDateMultipleTimes_expectSuccess() throws OperationAbortedError {
        testForexParameters(USER_INPUT_TRY_INVALID_EXPIRY, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addForexParams_tryPastDateMultipleTimes_expectSuccess() throws OperationAbortedError {
        testForexParameters(USER_INPUT_TRY_PAST_EXPIRY, EXPECTED_PARAMS_WITH_REMARKS);
    }

    // @@KVignesh122
    @Test
    void addForexParams_abortAtName_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testForexParameters(USER_INPUT_TRY_ABORT_AT_NAME, NO_PARAMS_EXPECTED));
    }

    @Test
    void addForexParams_abortAtCurrentPrice_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testForexParameters(USER_INPUT_TRY_ABORT_AT_CURRENT_PRICE, NO_PARAMS_EXPECTED));
    }

    @Test
    void addForexParams_abortAtSentiment_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testForexParameters(USER_INPUT_TRY_ABORT_AT_SENTIMENT, NO_PARAMS_EXPECTED));
    }

    @Test
    void addForexParams_abortAtExpiry_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testForexParameters(USER_INPUT_TRY_ABORT_AT_EXPIRY, NO_PARAMS_EXPECTED));
    }

    @Test
    void addForexParams_abortAtRemark_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testForexParameters(USER_INPUT_TRY_ABORT_AT_REMARKS, NO_PARAMS_EXPECTED));
    }

    @Test
    void addForexParams_abortAtEntryPrice_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testForexParameters(USER_INPUT_TRY_ABORT_AT_ENTRY_PRICE, NO_PARAMS_EXPECTED));
    }

    @Test
    void addForexParams_abortAtExitPrice_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testForexParameters(USER_INPUT_TRY_ABORT_AT_EXIT_PRICE, EXPECTED_PARAMS_NO_REMARKS));
    }
}
