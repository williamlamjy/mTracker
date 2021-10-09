package seedu.mtracker.console;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddStockParserTest {

    public static final int PARAMETER_SIZE = 4;

    public static String USER_INPUT_NO_REMARKS = "TestName%1$s23.4%1$spositive%1$s ";
    public static String[] EXPECTED_PARAMS_NO_REMARKS = { "TestName", "23.4", "positive", "" };

    public static String USER_INPUT_WITH_REMARKS = "TestName%1$s100.4%1$snegative%1$sTestRemarks";
    public static String[] EXPECTED_PARAMS_WITH_REMARKS = { "TestName", "100.4", "negative", "TestRemarks" };

    public static String USER_INPUT_TRY_INVALID_NAME = "%1$s%1$s%1$sTestName%1$s23.4%1$spositive%1$s ";
    public static String USER_INPUT_TRY_INVALID_PRICE = "%1$sTestName%1$s2sd3.4%1$s100.4"
            + "%1$snegative%1$sTestRemarks";
    public static String USER_INPUT_TRY_INVALID_SENTIMENT = "%1$sTestName%1$s100.4"
            + "%1$swrong%1$s%1$snegative%1$sTestRemarks";

    String formatConsoleInput(String input) {
        return String.format(input, System.lineSeparator());
    }

    void simulateConsoleInput(String input) {
        String formattedInput = formatConsoleInput(input);
        ByteArrayInputStream inputStreamBytes = new ByteArrayInputStream(formattedInput.getBytes());
        System.setIn(inputStreamBytes);
    }

    void checkParameters(AddStockParser testStockParser, String[] expectedParameters) {
        for (int i = 0; i < PARAMETER_SIZE; i++) {
            assertEquals(testStockParser.getParameters().get(i), expectedParameters[i]);
        }
    }

    void testStockParameters(String input, String[] expectedParameters) {
        simulateConsoleInput(input);
        AddStockParser testStockParser = new AddStockParser();
        testStockParser.initParameters();
        testStockParser.getInstrumentParameters();
        checkParameters(testStockParser, expectedParameters);

    }

    @Test
    void addStockParams_allValidParameters_expectSuccess() {
        testStockParameters(USER_INPUT_NO_REMARKS, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addStockParams_allValidParametersWithRemarks_expectSuccess() {
        testStockParameters(USER_INPUT_WITH_REMARKS, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addStockParams_tryInvalidNameMultipleTimes_expectSuccess() {
        testStockParameters(USER_INPUT_TRY_INVALID_NAME, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addStockParams_tryInvalidPriceMultipleTimes_expectSuccess() {
        testStockParameters(USER_INPUT_TRY_INVALID_PRICE, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addStockParams_tryInvalidSentimentMultipleTimes_expectSuccess() {
        testStockParameters(USER_INPUT_TRY_INVALID_SENTIMENT, EXPECTED_PARAMS_WITH_REMARKS);
    }
}
