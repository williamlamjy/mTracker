package seedu.mtracker.filemanager;

import seedu.mtracker.error.fileerror.FileWriteError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InstrumentEncoder {

    public static void editFile(String line, FileWriter writeToFile) throws FileWriteError {
        try {
            writeToFile.write(line);
        } catch (IOException e) {
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
