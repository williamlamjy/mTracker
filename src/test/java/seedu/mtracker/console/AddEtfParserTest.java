package seedu.mtracker.console;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddEtfParserTest {

    public static final int PARAMETER_SIZE = 5;

    public static final String USER_INPUT_NO_REMARKS = "TestName%1$s30.25%1$sneutral%1$s50.0%1$s ";
    public static final String[] EXPECTED_PARAMS_NO_REMARKS = { "TestName", "30.25", "neutral", "50.0", "" };

    public static final String USER_INPUT_All_PARAM = "TestName%1$s5.27%1$spositive%1$s3.0%1$sTestRemarks";
    public static final String[] EXPECTED_PARAMS_ALL_PARAM = { "TestName", "5.27", "positive", "3.0", "TestRemarks" };

    public static final String USER_INPUT_NO_RETURN = "TestName%1$s4.33%1$snegative%1$sNone%1$sTestRemarks";
    public static final String[] EXPECTED_PARAMS_NO_RETURN = { "TestName", "4.33", "negative", "-101.0", "TestRemarks" };

    public static final String USER_INPUT_INVALID_NAME = "%1$s%1$sTestName%1$s5.27%1$s"
            + "positive%1$s3.0%1$sTestRemarks";
    public static final String USER_INPUT_INVALID_PRICE = "%1$sTestName%1$sPrice%1$s5.27%1$s"
            + "positive%1$s3.0%1$sTestRemarks";
    public static final String USER_INPUT_INVALID_SENTIMENT = "%1$sTestName%1$s5.27%1$sSentiment%1$s"
            + "positive%1$s3.0%1$sTestRemarks";

    String formatConsoleInput(String input) {
        return String.format(input, System.lineSeparator());
    }

    void simulateConsoleInput(String input) {
        String formattedInput = formatConsoleInput(input);
        ByteArrayInputStream inputStreamBytes = new ByteArrayInputStream(formattedInput.getBytes());
        System.setIn(inputStreamBytes);
    }

    void checkParameters(AddEtfParser testEtfParser, String[] expectedParameters) {
        for (int i = 0; i < PARAMETER_SIZE; i++) {
            assertEquals(testEtfParser.getParameters().get(i), expectedParameters[i]);
        }
    }

    void testEtfParameters(String input, String[] expectedParameters) {
        simulateConsoleInput(input);
        AddEtfParser testEtfParser = new AddEtfParser();
        testEtfParser.initParameters();
        testEtfParser.getInstrumentParameters();
        checkParameters(testEtfParser, expectedParameters);
    }

    @Test
    void addEtfParams_noRemarks_expectSuccess() {
        testEtfParameters(USER_INPUT_NO_REMARKS, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addEtfParams_noPastReturn_expectSuccess() {
        testEtfParameters(USER_INPUT_NO_RETURN, EXPECTED_PARAMS_NO_RETURN);
    }

    @Test
    void addEtfParams_allParameters_expectSuccess() {
        testEtfParameters(USER_INPUT_All_PARAM, EXPECTED_PARAMS_ALL_PARAM);
    }

    @Test
    void addEftParams_InvalidName_expectSuccess() {
        testEtfParameters(USER_INPUT_INVALID_NAME, EXPECTED_PARAMS_ALL_PARAM);
    }

    @Test
    void addEftParams_InvalidPrice_expectSuccess() {
        testEtfParameters(USER_INPUT_INVALID_PRICE, EXPECTED_PARAMS_ALL_PARAM);
    }

    @Test
    void addEtfParams_InvalidSentiment_expectSuccess() {
        testEtfParameters(USER_INPUT_INVALID_SENTIMENT, EXPECTED_PARAMS_ALL_PARAM);
    }
}
