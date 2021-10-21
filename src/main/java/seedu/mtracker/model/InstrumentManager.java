package seedu.mtracker.model;

import java.util.ArrayList;

public class InstrumentManager {

    private final ArrayList<Instrument> instruments;

    private static InstrumentManager instrumentManager;

    private InstrumentManager() {
        instruments = new ArrayList<>();
    }

    public static InstrumentManager getInstance() {
        if (instrumentManager == null) {
            instrumentManager = new InstrumentManager();
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
