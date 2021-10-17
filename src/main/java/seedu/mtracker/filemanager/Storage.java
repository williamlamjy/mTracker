package seedu.mtracker.filemanager;

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
import java.util.ArrayList;
import java.util.Scanner;

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

    public ArrayList<Instrument> readFile() throws FileNotFoundException {
        ArrayList<Instrument> instruments = new ArrayList<>();
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
            String[] textSegment = s.nextLine().split(";", -1);
            switch (textSegment[0]) {
            case ("Crypto"):
                addCryptoToList(textSegment, instruments);
                break;
            case ("Stock"):
                addStockToList(textSegment, instruments);
                break;
            case ("Forex"):
                addForexToList(textSegment, instruments);
                break;
            default:
                addEtfToList(textSegment, instruments);
            }
        }
        return instruments;
    }

    public String emptyRemarksFormatter(String textSegment){
        String parameter;
        if(textSegment == null){
            parameter = " ";
        }
        else{
            parameter = textSegment;
        }
        return parameter;
    }

    public void addCryptoToList(String [] textSegment, ArrayList<Instrument> instruments){
        String name = textSegment[1];
        double currentPrice = Double.parseDouble(textSegment[2]);
        String sentiment = textSegment[3];
        String expiry = textSegment[4];
        String remarks = emptyRemarksFormatter(textSegment[5]);
        Instrument crypto = new Crypto(name, currentPrice, sentiment, expiry, remarks);
        instruments.add(crypto);
    }

    public void addForexToList(String [] textSegment, ArrayList<Instrument> instruments){
        String name = textSegment[1];
        double currentPrice = Double.parseDouble(textSegment[2]);
        String sentiment = textSegment[3];
        double entryPrice = Double.parseDouble(textSegment[4]);
        double exitPrice = Double.parseDouble(textSegment[5]);
        String expiry = textSegment[6];
        String remarks = emptyRemarksFormatter(textSegment[7]);
        Instrument forex = new Forex(name, currentPrice, sentiment,
                entryPrice, exitPrice, expiry, remarks);
        instruments.add(forex);
    }

    public void addStockToList(String [] textSegment, ArrayList<Instrument> instruments){
        String name = textSegment[1];
        double currentPrice = Double.parseDouble(textSegment[2]);
        String sentiment = textSegment[3];
        String remarks = emptyRemarksFormatter(textSegment[4]);
        Instrument stock = new Stock(name, currentPrice, sentiment, remarks);
        instruments.add(stock);
    }

    public void addEtfToList(String [] textSegment, ArrayList<Instrument> instruments){
        String name = textSegment[1];
        double currentPrice = Double.parseDouble(textSegment[2]);
        String sentiment = textSegment[3];
        double pastReturns = Double.parseDouble(textSegment[4]);
        String remarks = emptyRemarksFormatter(textSegment[5]);
        Instrument etf = new Etf(name, currentPrice, sentiment, pastReturns, remarks);
        instruments.add(etf);
    }
}
