package seedu.mtracker.filemanager;

import seedu.mtracker.instrument.Instrument;
import seedu.mtracker.instrument.InstrumentManager;
import seedu.mtracker.instrument.subinstrument.Crypto;
import seedu.mtracker.instrument.subinstrument.Etf;
import seedu.mtracker.instrument.subinstrument.Forex;
import seedu.mtracker.instrument.subinstrument.Stock;

import java.util.List;

public class InstrumentDecoder {
    public static void readFile(InstrumentManager instrumentManager, List<String> fileData) {
        fileData.stream()
                .forEach((line) -> {
                    String[] textSegment = line.split(";", -1);
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
                });
    }

    public static void addCryptoToList(String[] textSegment, InstrumentManager instrumentManager) {
        String name = textSegment[1];
        double currentPrice = Double.parseDouble(textSegment[2]);
        String sentiment = textSegment[3];
        String expiry = textSegment[4];
        String remarks = textSegment[5];
        Instrument crypto = new Crypto(name, currentPrice, sentiment, expiry, remarks);
        instrumentManager.addInstrument(crypto);
    }

    public static void addForexToList(String[] textSegment, InstrumentManager instrumentManager) {
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

    public static void addStockToList(String[] textSegment, InstrumentManager instrumentManager) {
        String name = textSegment[1];
        double currentPrice = Double.parseDouble(textSegment[2]);
        String sentiment = textSegment[3];
        String remarks = textSegment[4];
        Instrument stock = new Stock(name, currentPrice, sentiment, remarks);
        instrumentManager.addInstrument(stock);
    }

    public static void addEtfToList(String[] textSegment, InstrumentManager instrumentManager) {
        String name = textSegment[1];
        double currentPrice = Double.parseDouble(textSegment[2]);
        String sentiment = textSegment[3];
        double pastReturns = Double.parseDouble(textSegment[4]);
        String remarks = textSegment[5];
        Instrument etf = new Etf(name, currentPrice, sentiment, pastReturns, remarks);
        instrumentManager.addInstrument(etf);
    }
}
