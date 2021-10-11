package seedu.mtracker.console;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCryptoParserTest {
    public static final int PARAMETER_SIZE = 5;

    public static final String USER_INPUT_NO_EXPIRY = "TestName%1$s23.4%1$spositive%1$s%1$sTestRemarks";
    public static final String[] EXPECTED_PARAMS_NO_EXPIRY = {"TestName", "23.4", "positive", "", "TestRemarks"};

    public static final String USER_INPUT_NO_REMARKS = "TestName%1$s23.4%1$spositive%1$s18 Oct%1$s ";
    public static final String[] EXPECTED_PARAMS_NO_REMARKS = {"TestName", "23.4", "positive", "18 Oct", ""};

    public static final String USER_INPUT_WITH_REMARKS_AND_EXPIRY = "TestName%1$s100.4%1$snegative"
            + "%1$s18 Oct%1$sTestRemarks";
    public static final String[] EXPECTED_PARAMS_WITH_REMARKS_AND_EXPIRY = {"TestName", "100.4", "negative",
        "18 Oct", "TestRemarks"};
    public static final String USER_INPUT_TRY_INVALID_NAME = "%1$s%1$s%1$sTestName%1$s23.4%1$spositive%1$s18 Oct%1$s ";
    public static final String USER_INPUT_TRY_INVALID_PRICE = "%1$sTestName%1$s2sd3.4%1$s100.4"
            + "%1$snegative%1$s18 Oct%1$sTestRemarks";
    public static final String USER_INPUT_TRY_INVALID_SENTIMENT = "%1$sTestName%1$s100.4"
            + "%1$swrong%1$s%1$snegative%1$s18 Oct%1$sTestRemarks";

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
    void addCryptoParams_noExpiry_expectSuccess() {
        testCryptoParameters(USER_INPUT_NO_EXPIRY, EXPECTED_PARAMS_NO_EXPIRY);
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
}
