package seedu.mtracker.console;

import org.junit.jupiter.api.Test;
import seedu.mtracker.commons.error.OperationAbortedError;

import static org.junit.jupiter.api.Assertions.assertThrows;

//@@author theodorekwok
class AddStockParserTest extends GeneralInstrumentParserTest {
    public static final int PARAMETER_SIZE = 4;

    public static final String USER_INPUT_NO_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + " ";

    public static final String USER_INPUT_WITH_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "fooRemarks";


    public static final String[] EXPECTED_PARAMS_NO_REMARKS = {
        "TTTXXX",
        "23.4",
        "positive",
        "",
    };

    public static final String[] EXPECTED_PARAMS_WITH_REMARKS = {
        "TTTXXX",
        "23.4",
        "positive",
        "fooRemarks"
    };

    public static final String USER_INPUT_TRY_INVALID_NAME = SEPARATOR_SPECIFIER.repeat(2) + " "
            + SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + " ";

    public static final String USER_INPUT_TRY_INVALID_PRICE = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "2sd3.4"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_INVALID_SENTIMENT = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "foobar"
            + SEPARATOR_SPECIFIER.repeat(2) + DONT_ABORT
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "fooRemarks";

    // @@KVignesh122
    public static final String USER_INPUT_TRY_ABORT_AT_NAME = ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_PRICE = "TTTXXX"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_SENTIMENT = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "foobar"
            + SEPARATOR_SPECIFIER.repeat(2) + DONT_ABORT
            + SEPARATOR_SPECIFIER + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_REMARK = "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + ABORT;

    //@@author theodorekwok
    void testStockParameters(String input, String[] expectedStockParameters) throws OperationAbortedError {
        simulateConsoleInput(input);
        AddStockParser testStockParser = new AddStockParser();
        verifyInstrumentParameters(testStockParser, expectedStockParameters);
    }

    @Override
    public int getParameterSize() {
        return PARAMETER_SIZE;
    }

    @Test
    void addStockParams_allValidParameters_expectSuccess() throws OperationAbortedError {
        testStockParameters(USER_INPUT_NO_REMARKS, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addStockParams_allValidParametersWithRemarks_expectSuccess() throws OperationAbortedError {
        testStockParameters(USER_INPUT_WITH_REMARKS, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addStockParams_tryInvalidNameMultipleTimes_expectSuccess() throws OperationAbortedError {
        testStockParameters(USER_INPUT_TRY_INVALID_NAME, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addStockParams_tryInvalidPriceMultipleTimes_expectSuccess() throws OperationAbortedError {
        testStockParameters(USER_INPUT_TRY_INVALID_PRICE, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addStockParams_tryInvalidSentimentMultipleTimes_expectSuccess() throws OperationAbortedError {
        testStockParameters(USER_INPUT_TRY_INVALID_SENTIMENT, EXPECTED_PARAMS_WITH_REMARKS);
    }

    //@@KVignesh122
    @Test
    void addStockParams_abortAtName_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testStockParameters(USER_INPUT_TRY_ABORT_AT_NAME, NO_PARAMS_EXPECTED));
    }

    @Test
    void addStockParams_abortAtPrice_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testStockParameters(USER_INPUT_TRY_ABORT_AT_PRICE, NO_PARAMS_EXPECTED));
    }

    @Test
    void addStockParams_abortAtSentiment_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testStockParameters(USER_INPUT_TRY_ABORT_AT_SENTIMENT, NO_PARAMS_EXPECTED));
    }

    @Test
    void addStockParams_abortAtRemark_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testStockParameters(USER_INPUT_TRY_ABORT_AT_REMARK, NO_PARAMS_EXPECTED));
    }
}
