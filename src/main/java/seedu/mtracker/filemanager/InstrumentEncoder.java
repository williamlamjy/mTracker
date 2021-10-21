package seedu.mtracker.filemanager;

import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.model.Instrument;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InstrumentEncoder {

    public static void writeFile(ArrayList<Instrument> instruments, FileWriter writeToFile) throws IOException {
        instruments.stream()
                .forEach(instrument -> {
                    try {
                        writeToFile.write(instrument.textFileFormatting() + System.lineSeparator());
                    } catch (IOException e) {
                        ErrorMessage.displayWriteToFileError();
                    }
                });
        writeToFile.close();
    }
}
