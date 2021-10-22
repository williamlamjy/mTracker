package seedu.mtracker.console;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCryptoParserTest {

    public static final int PARAMETER_SIZE = 5;
    private static final String SEPARATOR_SPECIFIERS = "%1$s";

    public static final String USER_INPUT_NO_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIERS + "23.4"
            + SEPARATOR_SPECIFIERS + "positive"
            + SEPARATOR_SPECIFIERS + "28 Oct"
            + SEPARATOR_SPECIFIERS + " ";

    public static final String USER_INPUT_WITH_REMARKS_AND_EXPIRY = "TTTXXX"
            + SEPARATOR_SPECIFIERS + "23.4"
            + SEPARATOR_SPECIFIERS + "positive"
            + SEPARATOR_SPECIFIERS + "28 Oct"
            + SEPARATOR_SPECIFIERS + "fooRemarks";

    public static final String[] EXPECTED_PARAMS_NO_REMARKS = {
            "TTTXXX",
            "23.4",
            "positive",
            "28 Oct",
            "",
    };

    public static final String[] EXPECTED_PARAMS_WITH_REMARKS_AND_EXPIRY = {
            "TTTXXX",
            "23.4",
            "positive",
            "28 Oct",
            "fooRemarks"
    };

    public static final String USER_INPUT_TRY_INVALID_NAME = SEPARATOR_SPECIFIERS.repeat(2) + "TTTXXX"
            + SEPARATOR_SPECIFIERS + "23.4"
            + SEPARATOR_SPECIFIERS + "positive"
            + SEPARATOR_SPECIFIERS + "28 Oct"
            + SEPARATOR_SPECIFIERS + " ";


    public static final String USER_INPUT_TRY_INVALID_PRICE = SEPARATOR_SPECIFIERS + "TTTXXX"
            + SEPARATOR_SPECIFIERS + "2sd3.4"
            + SEPARATOR_SPECIFIERS + "23.4"
            + SEPARATOR_SPECIFIERS + "positive"
            + SEPARATOR_SPECIFIERS + "28 Oct"
            + SEPARATOR_SPECIFIERS + "fooRemarks";

    public static final String USER_INPUT_TRY_INVALID_SENTIMENT = SEPARATOR_SPECIFIERS + "TTTXXX"
            + SEPARATOR_SPECIFIERS + "23.4"
            + SEPARATOR_SPECIFIERS + "foobar"
            + SEPARATOR_SPECIFIERS.repeat(2) + "positive"
            + SEPARATOR_SPECIFIERS + "28 Oct"
            + SEPARATOR_SPECIFIERS + "fooRemarks";

    public static final String USER_INPUT_TRY_EMPTY_EXPIRY = SEPARATOR_SPECIFIERS + "TTTXXX"
            + SEPARATOR_SPECIFIERS + "23.4"
            + SEPARATOR_SPECIFIERS + "positive"
            + SEPARATOR_SPECIFIERS.repeat(2) + "28 Oct"
            + SEPARATOR_SPECIFIERS + "fooRemarks";

    String formatConsoleInput(String input) {
        return String.format(input, System.lineSeparator());
    }

    void simulateConsoleInput(String input) {
        String formattedInput = formatConsoleInput(input);
        ByteArrayInputStream inputStreamBytes = new ByteArrayInputStream(formattedInput.getBytes());
        System.setIn(inputStreamBytes);
    }

    void checkParameters(AddCryptoParser testCryptoParser, String[] expectedParameters) {
        for (int i = 0; i < PARAMETER_SIZE; i++) {
            assertEquals(testCryptoParser.getParameters().get(i), expectedParameters[i]);
        }
    }

    void testCryptoParameters(String input, String[] expectedParameters) {
        simulateConsoleInput(input);
        AddCryptoParser testCryptoParser = new AddCryptoParser();
        testCryptoParser.initParameters();
        testCryptoParser.getInstrumentParameters();
        checkParameters(testCryptoParser, expectedParameters);

    }

    @Test
    void addCryptoParams_noRemarks_expectSuccess() {
        testCryptoParameters(USER_INPUT_NO_REMARKS, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addCryptoParams_allValidParametersWithRemarksAndExpiry_expectSuccess() {
        testCryptoParameters(USER_INPUT_WITH_REMARKS_AND_EXPIRY,
                EXPECTED_PARAMS_WITH_REMARKS_AND_EXPIRY);
    }

    @Test
    void addCryptoParams_tryInvalidNameMultipleTimes_expectSuccess() {
        testCryptoParameters(USER_INPUT_TRY_INVALID_NAME, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addCryptoParams_tryInvalidPriceMultipleTimes_expectSuccess() {
        testCryptoParameters(USER_INPUT_TRY_INVALID_PRICE,
                EXPECTED_PARAMS_WITH_REMARKS_AND_EXPIRY);
    }

    @Test
    void addCryptoParams_tryInvalidSentimentMultipleTimes_expectSuccess() {
        testCryptoParameters(USER_INPUT_TRY_INVALID_SENTIMENT,
                EXPECTED_PARAMS_WITH_REMARKS_AND_EXPIRY);
    }

    @Test
    void addCryptoParams_tryEmptyExpiryMultipleTimes_expectSuccess() {
        testCryptoParameters(USER_INPUT_TRY_EMPTY_EXPIRY,
                EXPECTED_PARAMS_WITH_REMARKS_AND_EXPIRY);
    }

}
