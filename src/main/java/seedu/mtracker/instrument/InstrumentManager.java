package seedu.mtracker.instrument;

import java.util.ArrayList;

public class InstrumentManager {

    private static InstrumentManager instrumentManager;
    private final ArrayList<Instrument> INSTRUMENTS;

    private InstrumentManager() {
        INSTRUMENTS = new ArrayList<>();
    }

    public static InstrumentManager getInstance() {
        if (instrumentManager == null) {
            instrumentManager = new InstrumentManager();
        }
        return instrumentManager;
    }

    public ArrayList<Instrument> getInstruments() {
        return INSTRUMENTS;
    }

    public void addInstrument(Instrument addedInstrument) {
        INSTRUMENTS.add(addedInstrument);
    }
}
