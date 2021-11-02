package seedu.mtracker.filemanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Forex;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class StorageTest {
    public static final String TEST_NAME = "Test12";
    public static final double TEST_PRICE = 34.5;
    public static final String TEST_SENTIMENT = "negative";
    public static final double TEST_ENTRY_PRICE = 30.0;
    public static final double TEST_EXIT_PRICE = 31.0;
    public static final int DAYS_DIFFERENCE = 1;
    public static final LocalDate FUTURE_DATE = LocalDate.now().plusDays(DAYS_DIFFERENCE);
    public static final String TEST_REMARK = "";
    public static final Instrument TEST_FOREX = new Forex(TEST_NAME, TEST_PRICE, TEST_SENTIMENT,
            TEST_ENTRY_PRICE, TEST_EXIT_PRICE, FUTURE_DATE, TEST_REMARK);

    private InstrumentManager instrumentManager;
    private Storage storage;

    @BeforeEach
    void initialiseTestResources() {
        storage = new Storage();
        instrumentManager = InstrumentManager.getInstance();
        instrumentManager.addInstrument(TEST_FOREX);
    }

    @Test
    void writeFileData_validInstrument_expectSuccess() {
        assertDoesNotThrow(() -> storage.writeFileData(instrumentManager.getInstruments()));
    }

    @Test
    void loadFileData_validInstrument_expectSuccess() {
        assertDoesNotThrow(() -> storage.loadFileData(instrumentManager));
    }

}
