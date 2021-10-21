package seedu.mtracker.filemanager;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Storage {
    private final File file;
    public static final String FILE_PATH = "data/mTracker.txt";
    private final Path path;

    public Storage() {
        file = new File(FILE_PATH);
        path = Paths.get(FILE_PATH);
    }

    public void loadFileData(InstrumentManager instrumentManager) throws IOException {
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            file.getParentFile().mkdir();
            file.createNewFile();
            return;
        }
        InstrumentDecoder.readFile(instrumentManager, Files.readAllLines(path));
    }

    public void updateFileData(ArrayList<Instrument> instruments) throws IOException {
        FileWriter writeToFile = new FileWriter(this.file);
        InstrumentEncoder.writeFile(instruments, writeToFile);
    }

}
