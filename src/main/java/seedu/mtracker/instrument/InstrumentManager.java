package seedu.mtracker.instrument;

import seedu.mtracker.filemanager.Storage;

import java.util.ArrayList;

public class InstrumentManager {

    private final ArrayList<Instrument> instruments;

    private static InstrumentManager instrumentManager;

    private InstrumentManager(ArrayList<Instrument> instruments) {
        this.instruments = instruments;
    }

    public static InstrumentManager getInstance() {
        if (instrumentManager == null) {
            ArrayList<Instrument> instruments = Storage.readFile();
            instrumentManager = new InstrumentManager(instruments);
        }
        return instrumentManager;
    }

    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }

    public void addInstrument(Instrument addedInstrument) {
        instruments.add(addedInstrument);
    }
}
