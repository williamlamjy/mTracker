package seedu.mtracker.filemanager;

import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.instrument.Instrument;
import seedu.mtracker.instrument.InstrumentManager;
import seedu.mtracker.instrument.subinstrument.Crypto;
import seedu.mtracker.instrument.subinstrument.Etf;
import seedu.mtracker.instrument.subinstrument.Forex;
import seedu.mtracker.instrument.subinstrument.Stock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

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
        readFile(instrumentManager);
    }

    public void writeFile(ArrayList<Instrument> instruments) throws IOException {
        FileWriter writeToFile = new FileWriter(this.file);
        instruments.stream().forEach(instrument -> {
            try {
                writeToFile.write(instrument.textFileFormatting() + "\n");
            } catch (IOException e) {
                ErrorMessage.displayFileError();
            }
        });
        writeToFile.close();
    }

    public void readFile(InstrumentManager instrumentManager) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
            String[] textSegment = s.nextLine().split(";", -1);
            switch (textSegment[0]) {
            case ("Crypto"):
                addCryptoToList(textSegment, instrumentManager);
                break;
            case ("Stock"):
                addStockToList(textSegment, instrumentManager);
                break;
            case ("Forex"):
                addForexToList(textSegment, instrumentManager);
                break;
            default:
                addEtfToList(textSegment, instrumentManager);
            }
        }
        //return instruments;
    }

    public void addCryptoToList(String [] textSegment, InstrumentManager instrumentManager){
        String name = textSegment[1];
        double currentPrice = Double.parseDouble(textSegment[2]);
        String sentiment = textSegment[3];
        String expiry = textSegment[4];
        String remarks = textSegment[5];
        Instrument crypto = new Crypto(name, currentPrice, sentiment, expiry, remarks);
        instrumentManager.addInstrument(crypto);
    }

    public void addForexToList(String [] textSegment, InstrumentManager instrumentManager){
        String name = textSegment[1];
        double currentPrice = Double.parseDouble(textSegment[2]);
        String sentiment = textSegment[3];
        double entryPrice = Double.parseDouble(textSegment[4]);
        double exitPrice = Double.parseDouble(textSegment[5]);
        String expiry = textSegment[6];
        String remarks = textSegment[7];
        Instrument forex = new Forex(name, currentPrice, sentiment,
                entryPrice, exitPrice, expiry, remarks);
        instrumentManager.addInstrument(forex);
    }

    public void addStockToList(String [] textSegment, InstrumentManager instrumentManager){
        String name = textSegment[1];
        double currentPrice = Double.parseDouble(textSegment[2]);
        String sentiment = textSegment[3];
        String remarks = textSegment[4];
        Instrument stock = new Stock(name, currentPrice, sentiment, remarks);
        instrumentManager.addInstrument(stock);
    }

    public void addEtfToList(String [] textSegment, InstrumentManager instrumentManager){
        String name = textSegment[1];
        double currentPrice = Double.parseDouble(textSegment[2]);
        String sentiment = textSegment[3];
        double pastReturns = Double.parseDouble(textSegment[4]);
        String remarks = textSegment[5];
        Instrument etf = new Etf(name, currentPrice, sentiment, pastReturns, remarks);
        instrumentManager.addInstrument(etf);
    }
}
