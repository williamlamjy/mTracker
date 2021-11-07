package seedu.mtracker.console;

import org.junit.jupiter.api.Test;
import seedu.mtracker.commons.error.OperationAbortedError;

import static org.junit.jupiter.api.Assertions.assertThrows;

//@@author williamlamjy
class AddCryptoParserTest extends GeneralInstrumentParserTest {
    public static final int PARAMETER_SIZE = 5;

    public static final String USER_INPUT_NO_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + " ";

    public static final String USER_INPUT_WITH_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String[] EXPECTED_PARAMS_NO_REMARKS = {
        "TTTXXX",
        "23.4",
        "positive",
        String.valueOf(FUTURE_DATE),
        "",
    };

    public static final String[] EXPECTED_PARAMS_WITH_REMARKS = {
        "TTTXXX",
        "23.4",
        "positive",
        String.valueOf(FUTURE_DATE),
        "fooRemarks"
    };

    public static final String USER_INPUT_TRY_INVALID_NAME = SEPARATOR_SPECIFIER.repeat(2) + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + " ";

    public static final String USER_INPUT_TRY_INVALID_PRICE = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "2sd3.4"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_INVALID_SENTIMENT = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "foobar"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER.repeat(2) + "positive"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_EMPTY_EXPIRY = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER.repeat(2) + FUTURE_DATE
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_INVALID_EXPIRY = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "2021/11/1"
            + SEPARATOR_SPECIFIER + "1 January 2021"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_PAST_EXPIRY = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + PAST_DATE
            + SEPARATOR_SPECIFIER + PAST_DATE
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + "fooRemarks";

    //@@KVignesh122
    public static final String USER_INPUT_TRY_ABORT_AT_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + FUTURE_DATE
            + SEPARATOR_SPECIFIER + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_NAME = SEPARATOR_SPECIFIER + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_PRICE = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "2sd3.4"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_SENTIMENT = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "foobar"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER.repeat(2) + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_EXPIRY = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER.repeat(2) + ABORT;

    //@@author williamlamjy
    void testCryptoParameters(String input, String[] expectedParameters) throws OperationAbortedError {
        simulateConsoleInput(input);
        AddCryptoParser testCryptoParser = new AddCryptoParser();
        verifyInstrumentParameters(testCryptoParser, expectedParameters);
    }

    @Override
    public int getParameterSize() {
        return PARAMETER_SIZE;
    }

    @Test
    void addCryptoParams_noRemarks_expectSuccess() throws OperationAbortedError {
        testCryptoParameters(USER_INPUT_NO_REMARKS, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addCryptoParams_allValidParametersWithRemarks_expectSuccess() throws OperationAbortedError {
        testCryptoParameters(USER_INPUT_WITH_REMARKS,
                EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addCryptoParams_tryInvalidNameMultipleTimes_expectSuccess() throws OperationAbortedError {
        testCryptoParameters(USER_INPUT_TRY_INVALID_NAME, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addCryptoParams_tryInvalidPriceMultipleTimes_expectSuccess() throws OperationAbortedError {
        testCryptoParameters(USER_INPUT_TRY_INVALID_PRICE,
                EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addCryptoParams_tryInvalidSentimentMultipleTimes_expectSuccess() throws OperationAbortedError {
        testCryptoParameters(USER_INPUT_TRY_INVALID_SENTIMENT,
                EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addCryptoParams_tryEmptyExpiryMultipleTimes_expectSuccess() throws OperationAbortedError {
        testCryptoParameters(USER_INPUT_TRY_EMPTY_EXPIRY,
                EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addForexParams_tryInvalidDateMultipleTimes_expectSuccess() throws OperationAbortedError {
        testCryptoParameters(USER_INPUT_TRY_INVALID_EXPIRY, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addForexParams_tryPastDateMultipleTimes_expectSuccess() throws OperationAbortedError {
        testCryptoParameters(USER_INPUT_TRY_PAST_EXPIRY, EXPECTED_PARAMS_WITH_REMARKS);
    }

    //@@KVignesh122
    @Test
    void addCryptoParams_abortAtName_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testCryptoParameters(USER_INPUT_TRY_ABORT_AT_NAME, NO_PARAMS_EXPECTED));
    }

    @Test
    void addCryptoParams_abortAtPrice_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testCryptoParameters(USER_INPUT_TRY_ABORT_AT_PRICE, NO_PARAMS_EXPECTED));
    }

    @Test
    void addCryptoParams_abortAtSentiment_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testCryptoParameters(USER_INPUT_TRY_ABORT_AT_SENTIMENT, NO_PARAMS_EXPECTED));
    }

    @Test
    void addCryptoParams_abortAtExpiry_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testCryptoParameters(USER_INPUT_TRY_ABORT_AT_EXPIRY, NO_PARAMS_EXPECTED));
    }

    @Test
    void addCryptoParams_abortAtRemark_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testCryptoParameters(USER_INPUT_TRY_ABORT_AT_REMARKS, NO_PARAMS_EXPECTED));
    }
}
