package seedu.mtracker.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.mtracker.commands.DeleteCommand;
import seedu.mtracker.commands.DoneCommand;
import seedu.mtracker.error.AlreadyDoneError;
import seedu.mtracker.error.InvalidBoundsError;
import seedu.mtracker.error.InvalidIndexError;
import seedu.mtracker.error.InvalidEmptyIndexError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.subinstrument.Stock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputParserTest {

    public static final int VALID_INDEX = 1;

    public static final String[] NO_INDEX_DELETE_INPUT = { "delete" };
    public static final String[] INVALID_INDEX_DELETE_INPUT = { "delete", "23r2fc" };
    public static final String[] OUT_OF_BOUNDS_INDEX_DELETE_INPUT = { "delete", "23" };
    public static final String[] VALID_INDEX_DELETE_INPUT = { "delete", String.valueOf(VALID_INDEX)};

    public static final String[] NO_INDEX_DONE_INPUT = { "done" };
    public static final String[] INVALID_INDEX_DONE_INPUT = { "done", "23r2fc" };
    public static final String[] OUT_OF_BOUNDS_INDEX_DONE_INPUT = { "done", "23" };
    public static final String[] VALID_INDEX_DONE_INPUT = { "done", String.valueOf(VALID_INDEX)};

    public static final String TEST_NAME = "Test";
    public static final double TEST_PRICE = 34.5;
    public static final String TEST_SENTIMENT = "negative";
    public static final String TEST_REMARK = "";
    public static final Instrument TEST_STOCK = new Stock(TEST_NAME, TEST_PRICE, TEST_SENTIMENT, TEST_REMARK);
    public static final int INDEX_OFFSET = 1;
    public static ArrayList<Instrument> INSTRUMENTS;

    private InputParser parser;

    @BeforeEach
    void initialiseTestResources() {
        parser = new InputParser();
        INSTRUMENTS = new ArrayList<>();
        INSTRUMENTS.add(TEST_STOCK);
    }

    @Test
    void getIndexNumber_validIndexProvided_expectSuccess() {
        parser.getIndexNumber(VALID_INDEX_DELETE_INPUT);
        assertEquals(parser.getInstrumentNumber(), VALID_INDEX - INDEX_OFFSET);
    }

    @Test
    void getIndexNumber_noIndexProvided_expectException() throws InvalidEmptyIndexError {
        assertThrows(InvalidEmptyIndexError.class,
            () -> parser.getIndexNumber(NO_INDEX_DELETE_INPUT));
    }

    @Test
    void getIndexNumber_invalidIndexProvided_expectException() throws InvalidIndexError {
        assertThrows(InvalidIndexError.class,
            () -> parser.getIndexNumber(INVALID_INDEX_DELETE_INPUT));
    }

    @Test
    void getDeleteInstrumentCommand_noIndexProvided_expectException() throws InvalidEmptyIndexError {
        assertThrows(InvalidEmptyIndexError.class,
            () -> parser
                    .getDeleteInstrumentCommand(NO_INDEX_DELETE_INPUT, INSTRUMENTS));
    }

    @Test
    void getDeleteInstrumentCommand_invalidIndexProvided_expectException() throws InvalidIndexError {
        assertThrows(InvalidIndexError.class,
            () -> parser
                    .getDeleteInstrumentCommand(INVALID_INDEX_DELETE_INPUT, INSTRUMENTS));
    }

    @Test
    void getDeleteInstrumentCommand_outOfBoundsIndexProvided_expectException() throws InvalidBoundsError {
        assertThrows(InvalidBoundsError.class,
            () -> parser
                    .getDeleteInstrumentCommand(OUT_OF_BOUNDS_INDEX_DELETE_INPUT, INSTRUMENTS));
    }

    @Test
    void getDeleteInstrumentCommand_validIndexProvided_expectSuccess() {
        DeleteCommand command = parser
                .getDeleteInstrumentCommand(VALID_INDEX_DELETE_INPUT, INSTRUMENTS);
        assertEquals(command.getIndex(), VALID_INDEX - INDEX_OFFSET);
    }

    @Test
    void getDoneInstrumentCommand_noIndexProvided_expectException() throws InvalidEmptyIndexError {
        assertThrows(InvalidEmptyIndexError.class,
            () -> parser
                    .getDoneInstrumentCommand(NO_INDEX_DONE_INPUT, INSTRUMENTS));
    }

    @Test
    void getDoneInstrumentCommand_invalidIndexProvided_expectException() throws InvalidIndexError {
        assertThrows(InvalidIndexError.class,
            () -> parser
                    .getDoneInstrumentCommand(INVALID_INDEX_DONE_INPUT, INSTRUMENTS));
    }

    @Test
    void getDoneInstrumentCommand_outOfBoundsIndexProvided_expectException() throws InvalidBoundsError {
        assertThrows(InvalidBoundsError.class,
            () -> parser
                    .getDoneInstrumentCommand(OUT_OF_BOUNDS_INDEX_DONE_INPUT, INSTRUMENTS));
    }

    @Test
    void getDoneInstrumentCommand_validIndexProvided_expectSuccess() throws AlreadyDoneError {
        DoneCommand command = parser
                .getDoneInstrumentCommand(VALID_INDEX_DONE_INPUT, INSTRUMENTS);
        assertEquals(command.getIndex(), VALID_INDEX - INDEX_OFFSET);
    }
}
