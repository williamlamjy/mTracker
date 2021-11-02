package seedu.mtracker.console;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class GeneralInstrumentParserTest {
    public static final String SEPARATOR_SPECIFIER = "%1$s";

    String formatConsoleInput(String input) {
        return String.format(input, System.lineSeparator());
    }

    void simulateConsoleInput(String input) {
        String formattedInput = formatConsoleInput(input);
        ByteArrayInputStream inputStreamBytes = new ByteArrayInputStream(formattedInput.getBytes());
        System.setIn(inputStreamBytes);
    }

    void checkParameters(AddInstrumentParser testInstrumentParser, String[] expectedParameters) {
        for (int i = 0; i < getParameterSize(); i++) {
            assertEquals(testInstrumentParser.getParameters().get(i), expectedParameters[i]);
        }
    }

    void verifyInstrumentParameters(AddInstrumentParser testInstrumentParser, String[] expectedParameters) {
        testInstrumentParser.initParameters();
        testInstrumentParser.getInstrumentParameters();
        checkParameters(testInstrumentParser, expectedParameters);
    }

    public abstract int getParameterSize();
}
