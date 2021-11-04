package seedu.mtracker.console;

import seedu.mtracker.commons.error.OperationAbortedError;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class GeneralInstrumentParserTest {
    protected static final String SEPARATOR_SPECIFIER = "%1$s";
    protected static final int DAYS_DIFFERENCE = 1;
    protected static final LocalDate FUTURE_DATE = LocalDate.now().plusDays(DAYS_DIFFERENCE);
    protected static final LocalDate PAST_DATE = LocalDate.now().minusDays(DAYS_DIFFERENCE);

    public static final String ABORT = "abort";
    public static final String DONT_ABORT = "don't abort";

    public static final String[] NO_PARAMS_EXPECTED = {};

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

    void verifyInstrumentParameters(AddInstrumentParser testInstrumentParser, String[] expectedParameters)
            throws OperationAbortedError {
        testInstrumentParser.initParameters();
        testInstrumentParser.getInstrumentParameters();
        checkParameters(testInstrumentParser, expectedParameters);
    }

    public abstract int getParameterSize();
}
