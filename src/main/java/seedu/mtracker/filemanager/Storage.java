package seedu.mtracker.filemanager;

import seedu.mtracker.commons.error.fileerror.FileLoadError;
import seedu.mtracker.commons.error.fileerror.FileWriteError;
import seedu.mtracker.LogHelper;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.ui.TextUi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Stores data of pre-existing instruments and loads pre-existing data when the program runs.
 */
public class Storage {
    public static final String FILE_PATH = "data/mTracker.txt";
    protected static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final File file;
    private final Path path;

    /**
     * Initializes the Storage class with a file object.
     */
    public Storage() {
        file = new File(FILE_PATH);
        path = Paths.get(FILE_PATH);
    }

    /**
     * Loads pre-existing data into the instrument manager.
     * If the file does not exist, a new file and directory will be created.
     *
     * @param instrumentManager The instrument manager to be updated.
     * @throws FileLoadError When there is an error loading the file.
     */
    public void loadFileData(InstrumentManager instrumentManager) throws FileLoadError {
        try {
            if (!Files.exists(path) || !Files.isRegularFile(path)) {
                TextUi.displayCreateFile();
                file.getParentFile().mkdir();
                file.createNewFile();
                return;
            }
            TextUi.displayLoadingFile();
            InstrumentDecoder.readFile(instrumentManager, Files.readAllLines(path));
        } catch (IOException e) {
            logger.severe(LogHelper.LOG_DATA_FILE_LOAD_ERROR);
            throw new FileLoadError();
        }
    }

    /**
     * Creates a file writer to write to the mTracker file.
     * Writes to the mTracker file with the saved instruments.
     *
     * @param instruments Instruments to be saved from the current session.
     * @throws FileWriteError When there is an error writing to the file.
     */
    public void writeFileData(ArrayList<Instrument> instruments) throws FileWriteError {
        try {
            FileWriter writeToFile = new FileWriter(file);
            InstrumentEncoder.writeFile(instruments, writeToFile);
        } catch (IOException e) {
            logger.severe(LogHelper.LOG_DATA_FILE_WRITE_ERROR);
            throw new FileWriteError();
        }
    }

    /**
     * Updates the mTracker file with added instruments.
     *
     * @param instruments Instruments to be saved from the current session.
     */
    public void updateFileData(ArrayList<Instrument> instruments) {
        try {
            writeFileData(instruments);
        } catch (FileWriteError e) {
            TextUi.showErrorMessage(e);
        }
    }
}
