package seedu.mtracker.filemanager;

import seedu.mtracker.error.ErrorMessage;
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
        setFileToReadOnly();
    }

    public void loadFileData(InstrumentManager instrumentManager) throws IOException {
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            TextUi.displayCreateFile();
            file.getParentFile().mkdir();
            file.createNewFile();
            return;
        }
        TextUi.displayLoadingFile();
        InstrumentDecoder.readFile(instrumentManager, Files.readAllLines(path));
    }

    public void updateFileData(ArrayList<Instrument> instruments) {
        try {
            setFileToWritable();
            FileWriter writeToFile = new FileWriter(this.file);
            InstrumentEncoder.writeFile(instruments, writeToFile);
            setFileToReadOnly();
        } catch (IOException e) {
            ErrorMessage.displayFileError();
        }
    }

    public void setFileToWritable() {
        file.setWritable(true);
    }

    public void setFileToReadOnly() {
        file.setReadOnly();
    }
}
