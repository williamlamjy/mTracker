package seedu.mtracker.console;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddForexParserTest {

    public static final int PARAMETER_SIZE = 7;
    private static final String SEPARATOR_SPECIFIER = "%1$s";

    public static final String[] EXPECTED_PARAMS_NO_REMARKS = {
        "TTTXXX",
        "1.11",
        "positive",
        "1.15",
        "1.30",
        "15 Oct",
        ""
    };

    public static final String[] EXPECTED_PARAMS_WITH_REMARKS = {
        "TTTXXX",
        "0.81",
        "negative",
        "0.79",
        "0.70",
        "20 Oct",
        "fooRemarks"
    };

    public static final String USER_INPUT_NO_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIER + "1.11"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "1.15"
            + SEPARATOR_SPECIFIER + "1.30"
            + SEPARATOR_SPECIFIER + "15 Oct"
            + SEPARATOR_SPECIFIER + " ";

    public static final String USER_INPUT_WITH_REMARKS = "TTTXXX"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + "negative"
            + SEPARATOR_SPECIFIER + "0.79"
            + SEPARATOR_SPECIFIER + "0.70"
            + SEPARATOR_SPECIFIER + "20 Oct"
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_INVALID_NAME = SEPARATOR_SPECIFIER.repeat(2) + "TTXX"
            + SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "1.11"
            + SEPARATOR_SPECIFIER + "positive"
            + SEPARATOR_SPECIFIER + "1.15"
            + SEPARATOR_SPECIFIER + "1.30"
            + SEPARATOR_SPECIFIER + "15 Oct"
            + SEPARATOR_SPECIFIER + " ";

    public static final String USER_INPUT_TRY_INVALID_PRICE = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "lol"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + "negative"
            + SEPARATOR_SPECIFIER + "foobar"
            + SEPARATOR_SPECIFIER + "0.79"
            + SEPARATOR_SPECIFIER.repeat(2) + "0.70"
            + SEPARATOR_SPECIFIER + "20 Oct"
            + SEPARATOR_SPECIFIER + "fooRemarks";

    public static final String USER_INPUT_TRY_INVALID_SENTIMENT = SEPARATOR_SPECIFIER + "TTTXXX"
            + SEPARATOR_SPECIFIER + "0.81"
            + SEPARATOR_SPECIFIER + "foobar"
            + SEPARATOR_SPECIFIER.repeat(2) + "negative"
            + SEPARATOR_SPECIFIER + "0.79"
            + SEPARATOR_SPECIFIER + "0.70"
            + SEPARATOR_SPECIFIER + "20 Oct"
            + SEPARATOR_SPECIFIER + "fooRemarks";

    String formatConsoleInput(String input) {
        return String.format(input, System.lineSeparator());
    }

    void simulateConsoleInput(String input) {
        String formattedInput = formatConsoleInput(input);
        ByteArrayInputStream inputStreamBytes = new ByteArrayInputStream(formattedInput.getBytes());
        System.setIn(inputStreamBytes);
    }

    void checkParameters(AddForexParser testForexParser, String[] expectedParameters) {
        for (int i = 0; i < PARAMETER_SIZE; i++) {
            assertEquals(testForexParser.getParameters().get(i), expectedParameters[i]);
        }
    }

    void testForexParameters(String input, String[] expectedParameters) {
        simulateConsoleInput(input);
        AddForexParser testForexParser = new AddForexParser();
        testForexParser.initParameters();
        testForexParser.getInstrumentParameters();
        checkParameters(testForexParser, expectedParameters);
    }

    @Test
    void addForexParams_allValidParameters_expectSuccess() {
        testForexParameters(USER_INPUT_NO_REMARKS, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addForexParams_allValidParametersWithRemarks_expectSuccess() {
        testForexParameters(USER_INPUT_WITH_REMARKS, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addForexParams_tryInvalidNameMultipleTimes_expectSuccess() {
        testForexParameters(USER_INPUT_TRY_INVALID_NAME, EXPECTED_PARAMS_NO_REMARKS);
    }

    @Test
    void addForexParams_tryInvalidPriceMultipleTimes_expectSuccess() {
        testForexParameters(USER_INPUT_TRY_INVALID_PRICE, EXPECTED_PARAMS_WITH_REMARKS);
    }

    @Test
    void addForexParams_tryInvalidSentimentMultipleTimes_expectSuccess() {
        testForexParameters(USER_INPUT_TRY_INVALID_SENTIMENT, EXPECTED_PARAMS_WITH_REMARKS);
    }
}
