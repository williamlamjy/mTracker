package seedu.mtracker.filemanager;

import seedu.mtracker.LogHelper;
import seedu.mtracker.commons.error.fileerror.FileWriteError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class InstrumentEncoder {

    protected static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void editFile(String line, FileWriter writeToFile) throws FileWriteError {
        try {
            writeToFile.write(line);
        } catch (IOException e) {
            logger.severe(LogHelper.LOG_DATA_FILE_WRITE_ERROR);
            throw new FileWriteError();
        }
    }

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
