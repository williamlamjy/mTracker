package seedu.mtracker.filemanager;

import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.error.FileLoadError;
import seedu.mtracker.error.FileTamperedError;
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

    public void checkIfFileIsTampered() throws FileTamperedError {
        if (file.canWrite()) {
            throw new FileTamperedError();
        }
    }

    public void loadFileData(InstrumentManager instrumentManager) throws FileLoadError {
        try {
            if (!Files.exists(path) || !Files.isRegularFile(path)) {
                TextUi.displayCreateFile();
                setFileToReadOnly();
                file.getParentFile().mkdir();
                file.createNewFile();
                return;
            }
            TextUi.displayLoadingFile();
            checkIfFileIsTampered();
            InstrumentDecoder.readFile(instrumentManager, Files.readAllLines(path));
        } catch (IOException e) {
            throw new FileLoadError();
        } catch (FileTamperedError e) {
            TextUi.showErrorMessage(e);
        }
    }

    public void updateFileData(ArrayList<Instrument> instruments) {
        try {
            setFileToWritable();
            FileWriter writeToFile = new FileWriter(file);
            InstrumentEncoder.writeFile(instruments, writeToFile);
            setFileToReadOnly();
        } catch (IOException e) {
            ErrorMessage.displayWriteToFileError();
        }
    }

    public void setFileToWritable() {
        file.setWritable(true);
    }

    public void setFileToReadOnly() {
        file.setReadOnly();
    }
}
