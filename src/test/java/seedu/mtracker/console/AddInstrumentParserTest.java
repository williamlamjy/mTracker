package seedu.mtracker.console;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AddInstrumentParserTest {
    protected static final String SEPARATOR_SPECIFIER = "%1$s";
    protected static final int DAYS_DIFFERENCE = 1;
    protected static final LocalDate FUTURE_DATE = LocalDate.now().plusDays(DAYS_DIFFERENCE);
    protected static final LocalDate PAST_DATE = LocalDate.now().minusDays(DAYS_DIFFERENCE);

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
