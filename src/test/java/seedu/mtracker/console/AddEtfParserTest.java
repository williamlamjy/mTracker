package seedu.mtracker.console;

import org.junit.jupiter.api.Test;
import seedu.mtracker.error.OperationAbortedError;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddEtfParserTest extends GeneralInstrumentParserTest {
    public static final int PARAMETER_SIZE = 5;

    public static final String USER_INPUT_NO_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "50.0"
            + SEPARATOR_SPECIFIER + " ";

    public static final String USER_INPUT_All_PARAM = "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "50.0"
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String[] EXPECTED_PARAMS_NO_REMARKS = {
        "TTTXXX",
        "23.4",
        "positive",
        "50.0",
        "",
    };

    public static final String[] EXPECTED_PARAMS_ALL_PARAM = {
        "TTTXXX",
        "23.4",
        "positive",
        "50.0",
        "fooRemarks"
    };

    public static final String[] EXPECTED_PARAMS_INVALID_RETURNS = {
        "TTTXXX",
        "23.4",
        "positive",
        "-101.0",
        "fooRemarks"
    };

    public static final String USER_INPUT_TRY_INVALID_NAME = SEPARATOR_SPECIFIER.repeat(2) + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "50.0"
            + SEPARATOR_SPECIFIER + "fooRemarks";


    public static final String USER_INPUT_TRY_INVALID_PRICE = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "2sd3.4"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "50.0"
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_INVALID_SENTIMENT = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "foobar"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER.repeat(2) + "positive"
            + SEPARATOR_SPECIFIER + "50.0"
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_EMPTY_RETURNS = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + ""
            + SEPARATOR_SPECIFIER + "fooRemarks";

    //@@KVignesh122
    public static final String USER_INPUT_TRY_ABORT_AT_NAME = SEPARATOR_SPECIFIER.repeat(2) + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_PRICE = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "2sd3.4"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_SENTIMENT = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + DONT_ABORT
            + SEPARATOR_SPECIFIER.repeat(2) + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_RETURNS = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + ABORT;

    public static final String USER_INPUT_TRY_ABORT_AT_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIER + "23.4"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "50.0"
            + SEPARATOR_SPECIFIER + ABORT;

    void testEtfParameters(String input, String[] expectedEtfParameters) throws OperationAbortedError {
        simulateConsoleInput(input);
        AddEtfParser testEtfParser = new AddEtfParser();
        verifyInstrumentParameters(testEtfParser, expectedEtfParameters);
    }
    //@@author

    @Override
    public int getParameterSize() {
        return PARAMETER_SIZE;
    }

    @Test
    void addEtfParams_noRemarks_expectSuccess() throws OperationAbortedError {
        testEtfParameters(USER_INPUT_NO_REMARKS, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addEtfParams_noPastReturn_expectSuccess() throws OperationAbortedError {
        testEtfParameters(USER_INPUT_TRY_EMPTY_RETURNS, EXPECTED_PARAMS_INVALID_RETURNS);
    }

    @Test
    void addEtfParams_allParameters_expectSuccess() throws OperationAbortedError {
        testEtfParameters(USER_INPUT_All_PARAM, EXPECTED_PARAMS_ALL_PARAM);
    }

    @Test
    void addEftParams_InvalidName_expectSuccess() throws OperationAbortedError {
        testEtfParameters(USER_INPUT_TRY_INVALID_NAME, EXPECTED_PARAMS_ALL_PARAM);
    }

    @Test
    void addEftParams_InvalidPrice_expectSuccess() throws OperationAbortedError {
        testEtfParameters(USER_INPUT_TRY_INVALID_PRICE, EXPECTED_PARAMS_ALL_PARAM);
    }

    @Test
    void addEtfParams_InvalidSentiment_expectSuccess() throws OperationAbortedError {
        testEtfParameters(USER_INPUT_TRY_INVALID_SENTIMENT, EXPECTED_PARAMS_ALL_PARAM);
    }

    //@@KVignesh122
    @Test
    void addEtfParams_abortAtName_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testEtfParameters(USER_INPUT_TRY_ABORT_AT_NAME, NO_PARAMS_EXPECTED));
    }

    @Test
    void addEtfParams_abortAtPrice_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testEtfParameters(USER_INPUT_TRY_ABORT_AT_PRICE, NO_PARAMS_EXPECTED));
    }

    @Test
    void addEtfParams_abortAtSentiment_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testEtfParameters(USER_INPUT_TRY_ABORT_AT_SENTIMENT, NO_PARAMS_EXPECTED));
    }

    @Test
    void addEtfParams_abortAtReturns_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testEtfParameters(USER_INPUT_TRY_ABORT_AT_RETURNS, NO_PARAMS_EXPECTED));
    }

    @Test
    void addEtfParams_abortAtRemark_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> testEtfParameters(USER_INPUT_TRY_ABORT_AT_REMARKS, NO_PARAMS_EXPECTED));
    }
    //@@author
}
