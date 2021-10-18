package seedu.mtracker.console;

import org.junit.jupiter.api.Test;
import seedu.mtracker.commands.DeleteCommand;
import seedu.mtracker.error.InvalidIndexError;
import seedu.mtracker.error.InvalidNoIndexError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputParserTest {

    public static final String[] NO_INDEX_INPUT = { "delete" };
    public static final String[] INVALID_INDEX_INPUT = { "delete", "23r2fc" };
    public static final String[] VALID_INDEX_INPUT = { "delete", "4" };

    public static final int INDEX_OFFSET = 1;
    public static final int VALID_INDEX = 4;

    @Test
    void getIndexNumber_validIndexProvided_expectSuccess() {
        InputParser parser = new InputParser();
        parser.getIndexNumber(VALID_INDEX_INPUT);
        assertEquals(parser.getInstrumentNumber(), VALID_INDEX - INDEX_OFFSET);
    }

    @Test
    void getIndexNumber_noIndexProvided_expectException() throws InvalidNoIndexError {
        InputParser parser = new InputParser();
        assertThrows(InvalidNoIndexError.class,
                () -> parser.getIndexNumber(NO_INDEX_INPUT));
    }

    @Test
    void getIndexNumber_invalidIndexProvided_expectException() throws InvalidIndexError {
        InputParser parser = new InputParser();
        assertThrows(InvalidIndexError.class,
                () -> parser.getIndexNumber(INVALID_INDEX_INPUT));
    }

    @Test
    void getDeleteInstrumentCommand_noIndexProvided_expectException() throws InvalidNoIndexError {
        InputParser parser = new InputParser();
        assertThrows(InvalidNoIndexError.class,
                () -> parser.getDeleteInstrumentCommand(NO_INDEX_INPUT));
    }

    @Test
    void getDeleteInstrumentCommand_invalidIndexProvided_expectException() throws InvalidIndexError {
        InputParser parser = new InputParser();
        assertThrows(InvalidIndexError.class,
                () -> parser.getDeleteInstrumentCommand(INVALID_INDEX_INPUT));
    }

    @Test
    void getDeleteInstrumentCommand_validIndexProvided_expectSuccess() {
        InputParser parser = new InputParser();
        DeleteCommand command = parser.getDeleteInstrumentCommand(VALID_INDEX_INPUT);
        assertEquals(command.getIndex(), VALID_INDEX - INDEX_OFFSET);
    }
}
