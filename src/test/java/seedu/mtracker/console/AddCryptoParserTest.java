package seedu.mtracker.console;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddCryptoParserTest {
    public static final int PARAMETER_SIZE = 5;

    public static String USER_INPUT_NO_EXPIRY = "TestName%1$s23.4%1$spositive%1$s%1$sTestRemarks";
    public static String[] EXPECTED_PARAMS_NO_EXPIRY = { "TestName", "23.4", "positive", "", "TestRemarks" };

    public static String USER_INPUT_NO_REMARKS = "TestName%1$s23.4%1$spositive%1$s18Oct%1$s ";
    public static String[] EXPECTED_PARAMS_NO_REMARKS = { "TestName", "23.4", "positive", "18Oct", "" };

    public static String USER_INPUT_WITH_REMARKS = "TestName%1$s100.4%1$snegative%1$s18Oct%1$sTestRemarks";
    public static String[] EXPECTED_PARAMS_WITH_REMARKS = { "TestName", "100.4", "negative", "18Oct", "TestRemarks" };

    public static String USER_INPUT_TRY_INVALID_NAME = "%1$s%1$s%1$sTestName%1$s23.4%1$spositive%1$s18Oct%1$s ";
    public static String USER_INPUT_TRY_INVALID_PRICE = "%1$sTestName%1$s2sd3.4%1$s100.4"
            + "%1$snegative%1$s18Oct%1$sTestRemarks";
    public static String USER_INPUT_TRY_INVALID_SENTIMENT = "%1$sTestName%1$s100.4"
            + "%1$swrong%1$s%1$snegative%1$s18Oct%1$sTestRemarks";

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
    void addCryptoParams_allValidParameters_expectSuccess() {
        testCryptoParameters(USER_INPUT_NO_REMARKS, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addCryptoParams_allValidParametersWithRemarks_expectSuccess() {
        testCryptoParameters(USER_INPUT_WITH_REMARKS, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addCryptoParams_tryInvalidNameMultipleTimes_expectSuccess() {
        testCryptoParameters(USER_INPUT_TRY_INVALID_NAME, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addCryptoParams_tryInvalidPriceMultipleTimes_expectSuccess() {
        testCryptoParameters(USER_INPUT_TRY_INVALID_PRICE, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addCryptoParams_tryInvalidSentimentMultipleTimes_expectSuccess() {
        testCryptoParameters(USER_INPUT_TRY_INVALID_SENTIMENT, EXPECTED_PARAMS_WITH_REMARKS);
    }
}
/*
    public static String emptyInput = "";
    public static String validRemark = "volatile prices";
    public static String validExpiry = "sell at 21st October";

    @Test
    void addCryptoExpiry_validExpiry_expectSuccess() {
        assertTrue(AddCryptoParser.isValidSpecificParameter(validExpiry));
    }

    @Test
    void addCryptoExpiry_emptyInput_expectFailure() {
        assertFalse(AddCryptoParser.isValidSpecificParameter(emptyInput));
    }

    @Test
    void addCryptoRemarks_validRemark_expectSuccess() {
        assertTrue(AddCryptoParser.isValidSpecificParameter(validRemark));
    }

    @Test
    void addCryptoRemarks_emptyInput_expectFailure() {
        assertFalse(AddCryptoParser.isValidSpecificParameter(emptyInput));
    }

    @Test
    void getInstrumentParameters() {
        // this one is the user input where each input line is separated by %s, notice the space at the end for empty remark
        String input = String.format("TestName%s23.4%spositive%s18 Oct%snil%s ",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());

        // these 2 lines below simulates the console input
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);

        // these 3 lines gets the console output if any like the "Sorry name must be provided those error messages"
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        // run the method
        AddCryptoParser testCryptoParser = new AddCryptoParser();
        testCryptoParser.getInstrumentParameters();

        // below is where you see output so feel free to use below to simulate like empty names, putting empty names multiple times
        // or check that parameters are recorded exactly
        String []lines = baos.toString().split(System.lineSeparator());
        System.out.println(lines);
        System.out.println(testCryptoParser.getParameters());
    }
*/

}