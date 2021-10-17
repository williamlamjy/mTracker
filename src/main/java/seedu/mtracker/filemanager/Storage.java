package seedu.mtracker.filemanager;

import seedu.mtracker.instrument.InstrumentManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {
    private File file;

    public Storage(String filePath) throws Exception {
        this.file = new File(filePath);
        if (!this.file.exists()) {
            File dir = new File("data");
            dir.mkdir();
            this.file = new File("data/mTracker.txt");
            file.createNewFile();
        }
    }

    public void writeFile(InstrumentManager instrumentManager) throws IOException {
        FileWriter writeToFile = new FileWriter(this.file);
        for (int i = 0; i < instrumentManager.getSize(); i++) {
            writeToFile.write(instrumentManager.getInstrumentWithFileFormat(i) + "\n");
        }
        writeToFile.close();
    }
}
