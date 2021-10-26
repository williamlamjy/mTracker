package seedu.mtracker.console;

import org.junit.jupiter.api.Test;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.subinstrument.Stock;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditParserTest {

    public static final String SEPARATOR_SPECIFIER = "%1$s";

    public static final String USER_INPUT = "TTTXXX" + SEPARATOR_SPECIFIER + "Test Remark";
    public static final String EXPECTED_OUTPUT = "name=TTTXXX,remark=Test Remark,";
    public static final HashSet<String> PARAM_INPUT = new HashSet<>(Arrays.asList("name", "remark"));

    public static final String USER_INPUT2 = "100" + SEPARATOR_SPECIFIER + "neutral";
    public static final String EXPECTED_OUTPUT2 = "current-price=100,sentiment=neutral,";
    public static final HashSet<String> PARAM_INPUT2 = new HashSet<>(Arrays.asList("current-price", "sentiment"));

    public static final String USER_INPUT3 = "10" + SEPARATOR_SPECIFIER + "100";
    public static final String EXPECTED_OUTPUT3 = "entry-price=10,exit-price=100,";
    public static final HashSet<String> PARAM_INPUT3 = new HashSet<>(Arrays.asList("entry-price", "exit-price"));

    String formatConsoleInput(String input) {
        return String.format(input, System.lineSeparator());
    }

    void simulateConsoleInput(String input) {
        String formattedInput = formatConsoleInput(input);
        ByteArrayInputStream inputStreamBytes = new ByteArrayInputStream(formattedInput.getBytes());
        System.setIn(inputStreamBytes);
    }

    void testEditInstrumentParameters(String input, String output, HashSet<String> expectedParameters) {
        simulateConsoleInput(input);
        Instrument dummyInstrument = new Stock("test-1",1,"positive","test-remark");
        EditInstrumentParser editInstrumentParser = new EditInstrumentParser();
        editInstrumentParser.getParametersToEdit(expectedParameters, dummyInstrument, 0);
        assertEquals(editInstrumentParser.getEditedParametersHashMap(), output);
    }


    @Test
    void editInstrumentParam_nameAndRemark_expectSuccess() {
        testEditInstrumentParameters(USER_INPUT, EXPECTED_OUTPUT, PARAM_INPUT);
    }

    @Test
    void editInstrumentParam_currentPriceAndSentiment_expectSuccess() {
        testEditInstrumentParameters(USER_INPUT2, EXPECTED_OUTPUT2, PARAM_INPUT2);
    }

    @Test
    void editInstrumentParam_entryAndExitPrice_expectSuccess() {
        testEditInstrumentParameters(USER_INPUT3, EXPECTED_OUTPUT3, PARAM_INPUT3);
    }
}
