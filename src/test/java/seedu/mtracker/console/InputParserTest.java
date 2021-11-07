package seedu.mtracker.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.mtracker.commands.DeleteCommand;
import seedu.mtracker.commands.DoneCommand;
import seedu.mtracker.commons.error.AlreadyDoneError;
import seedu.mtracker.commons.error.InvalidBoundsError;
import seedu.mtracker.commons.error.InvalidEmptyIndexError;
import seedu.mtracker.commons.error.InvalidIndexError;
import seedu.mtracker.commons.error.OperationAbortedError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.subinstrument.Stock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@@author theodorekwok
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

    public static final String ABORT = "abort";
    public static final String ADD_WORKSPACE = "add";
    public static final String EDIT_WORKSPACE = "edit";

    private InputParser parser;

    @BeforeEach
    void initialiseTestResources() {
        parser = new InputParser();
        INSTRUMENTS = new ArrayList<>();
        INSTRUMENTS.add(TEST_STOCK);
    }

    @Test
    void getIndexNumber_validIndexProvided_expectSuccess() throws InvalidEmptyIndexError, InvalidIndexError {
        parser.getIndexNumber(VALID_INDEX_DELETE_INPUT);
        assertEquals(parser.getInstrumentNumber(), VALID_INDEX - INDEX_OFFSET);
    }

    @Test
    void getIndexNumber_noIndexProvided_expectException() {
        assertThrows(InvalidEmptyIndexError.class,
            () -> parser.getIndexNumber(NO_INDEX_DELETE_INPUT));
    }

    @Test
    void getIndexNumber_invalidIndexProvided_expectException() {
        assertThrows(InvalidIndexError.class,
            () -> parser.getIndexNumber(INVALID_INDEX_DELETE_INPUT));
    }

    @Test
    void getDeleteInstrumentCommand_noIndexProvided_expectException() {
        assertThrows(InvalidEmptyIndexError.class,
            () -> parser
                    .getDeleteInstrumentCommand(NO_INDEX_DELETE_INPUT, INSTRUMENTS));
    }

    @Test
    void getDeleteInstrumentCommand_invalidIndexProvided_expectException() {
        assertThrows(InvalidIndexError.class,
            () -> parser
                    .getDeleteInstrumentCommand(INVALID_INDEX_DELETE_INPUT, INSTRUMENTS));
    }

    @Test
    void getDeleteInstrumentCommand_outOfBoundsIndexProvided_expectException() {
        assertThrows(InvalidBoundsError.class,
            () -> parser
                    .getDeleteInstrumentCommand(OUT_OF_BOUNDS_INDEX_DELETE_INPUT, INSTRUMENTS));
    }

    @Test
    void getDeleteInstrumentCommand_validIndexProvided_expectSuccess()
            throws InvalidEmptyIndexError, InvalidBoundsError, InvalidIndexError {
        DeleteCommand command = parser
                .getDeleteInstrumentCommand(VALID_INDEX_DELETE_INPUT, INSTRUMENTS);
        assertEquals(command.getIndex(), VALID_INDEX - INDEX_OFFSET);
    }

    //@@author
    @Test
    void getDoneInstrumentCommand_noIndexProvided_expectException() {
        assertThrows(InvalidEmptyIndexError.class,
            () -> parser
                    .getDoneInstrumentCommand(NO_INDEX_DONE_INPUT, INSTRUMENTS));
    }

    @Test
    void getDoneInstrumentCommand_invalidIndexProvided_expectException() {
        assertThrows(InvalidIndexError.class,
            () -> parser
                    .getDoneInstrumentCommand(INVALID_INDEX_DONE_INPUT, INSTRUMENTS));
    }

    @Test
    void getDoneInstrumentCommand_outOfBoundsIndexProvided_expectException() {
        assertThrows(InvalidBoundsError.class,
            () -> parser
                    .getDoneInstrumentCommand(OUT_OF_BOUNDS_INDEX_DONE_INPUT, INSTRUMENTS));
    }

    @Test
    void getDoneInstrumentCommand_validIndexProvided_expectSuccess()
            throws AlreadyDoneError, InvalidEmptyIndexError, InvalidBoundsError, InvalidIndexError {
        DoneCommand command = parser
                .getDoneInstrumentCommand(VALID_INDEX_DONE_INPUT, INSTRUMENTS);
        assertEquals(command.getIndex(), VALID_INDEX - INDEX_OFFSET);
    }

    //@@author KVignesh122
    @Test
    void abortOperation_validAbortInAdd_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> parser.checkIfAbort(ABORT, ADD_WORKSPACE));
    }

    @Test
    void abortOperation_validAbortInEdit_expectException() {
        assertThrows(OperationAbortedError.class,
            () -> parser.checkIfAbort(ABORT, EDIT_WORKSPACE));
    }
    //@@author
}
