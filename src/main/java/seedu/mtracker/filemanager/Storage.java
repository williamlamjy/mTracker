package seedu.mtracker.filemanager;

import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.error.FileLoadError;
import seedu.mtracker.error.FileTamperedError;
import seedu.mtracker.error.FileWriteError;
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

public class Storage {
    public static final String FILE_PATH = "data/mTracker.txt";
    private final File file;
    private final Path path;

    public Storage() {
        file = new File(FILE_PATH);
        path = Paths.get(FILE_PATH);
    }

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
            throw new FileLoadError();
        }
    }

    public void writeFileData(ArrayList<Instrument> instruments) throws FileWriteError {
        try {
            FileWriter writeToFile = new FileWriter(file);
            InstrumentEncoder.writeFile(instruments, writeToFile);
        } catch (IOException e) {
            throw new FileWriteError();
        }
    }

    public void updateFileData(ArrayList<Instrument> instruments) {
        try {
            writeFileData(instruments);
        } catch (FileWriteError e) {
            TextUi.showErrorMessage(e);
        }
    }
}
