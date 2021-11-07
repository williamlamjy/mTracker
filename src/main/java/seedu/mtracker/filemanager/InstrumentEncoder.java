package seedu.mtracker.filemanager;

import seedu.mtracker.LogHelper;
import seedu.mtracker.commons.error.fileerror.FileWriteError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

//@@author williamlamjy
/**
 * Encodes the pre-existing instruments into a savable format to store into the mTracker file.
 */
public class InstrumentEncoder {

    protected static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Writes to the file with the formatted instrument.
     *
     * @param line String of the formatted instrument to be written into a line in the file.
     * @param writeToFile FileWriter that writes to the file.
     * @throws FileWriteError When there is an error writing to the file.
     */
    public static void editFile(String line, FileWriter writeToFile) throws FileWriteError {
        try {
            writeToFile.write(line);
        } catch (IOException e) {
            logger.severe(LogHelper.LOG_DATA_FILE_WRITE_ERROR);
            throw new FileWriteError();
        }
    }

    /**
     * Writes to the file the entire list of formatted instruments to be saved.
     *
     * @param instruments Instruments to be saved.
     * @param writeToFile FileWriter that writes to the file.
     * @throws IOException When there is an error writing to the file.
     */
    public static void writeFile(ArrayList<Instrument> instruments, FileWriter writeToFile) throws IOException {
        instruments.stream()
                .forEach(instrument -> {
                    try {
                        editFile(instrument.textFileFormatting() + System.lineSeparator(), writeToFile);
                    } catch (FileWriteError e) {
                        TextUi.showErrorMessage(e);
                    }
                });
        writeToFile.close();
    }
}
