package seedu.mtracker.filemanager;

import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.instrument.Instrument;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InstrumentEncoder {

    public static void writeFile(ArrayList<Instrument> instruments, FileWriter writeToFile) throws IOException {
        instruments.stream()
                .forEach(instrument -> {
                    try {
                        writeToFile.write(instrument.textFileFormatting() + "\n");
                    } catch (IOException e) {
                        ErrorMessage.displayFileError();
                    }
                });
        writeToFile.close();
    }
}
