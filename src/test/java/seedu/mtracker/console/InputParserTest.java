package seedu.mtracker.console;

import org.junit.jupiter.api.Test;
import seedu.mtracker.commands.DeleteCommand;
import seedu.mtracker.error.InvalidIndexError;
import seedu.mtracker.error.InvalidNoIndexError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputParserTest {

    public static final String[] noIndexProvidedCommandComponents = { "delete" };
    public static final String[] invalidIndexProvidedCommandComponents = { "delete", "23r2fc" };
    public static final String[] validIndexProvidedCommandComponents = { "delete", "4" };

    public static int INDEX_OFFSET = 1;
    public static int validIndex = 4;

    @Test
    void getIndexNumber_validIndexProvided_expectSuccess() {
        InputParser parser = new InputParser();
        parser.getIndexNumber(validIndexProvidedCommandComponents);
        assertEquals(parser.getInstrumentNumber(), validIndex - INDEX_OFFSET);
    }

    @Test
    void getIndexNumber_noIndexProvided_expectException() throws InvalidNoIndexError {
        InputParser parser = new InputParser();
        assertThrows(InvalidNoIndexError.class,
                () -> parser.getIndexNumber(noIndexProvidedCommandComponents));
    }

    @Test
    void getIndexNumber_invalidIndexProvided_expectException() throws InvalidIndexError {
        InputParser parser = new InputParser();
        assertThrows(InvalidIndexError.class,
                () -> parser.getIndexNumber(invalidIndexProvidedCommandComponents));
    }

    @Test
    void getDeleteInstrumentCommand_noIndexProvided_expectException() throws InvalidNoIndexError {
        InputParser parser = new InputParser();
        assertThrows(InvalidNoIndexError.class,
                () -> parser.getDeleteInstrumentCommand(noIndexProvidedCommandComponents));
    }

    @Test
    void getDeleteInstrumentCommand_invalidIndexProvided_expectException() throws InvalidIndexError {
        InputParser parser = new InputParser();
        assertThrows(InvalidIndexError.class,
                () -> parser.getDeleteInstrumentCommand(invalidIndexProvidedCommandComponents));
    }

    @Test
    void getDeleteInstrumentCommand_validIndexProvided_expectSuccess() {
        InputParser parser = new InputParser();
        DeleteCommand command = parser.getDeleteInstrumentCommand(validIndexProvidedCommandComponents);
        assertEquals(command.getIndex(), validIndex - INDEX_OFFSET);
    }
}
