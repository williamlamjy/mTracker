package seedu.mtracker.model;

import java.util.ArrayList;

public class InstrumentManager {

    private static InstrumentManager instrumentManager;
    private final ArrayList<Instrument> instruments;

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

    public Instrument getInstrument(int instrumentIndex) {
        return instruments.get(instrumentIndex);
    }

    public int getSize() {
        return instruments.size();
    }

    public void addInstrument(Instrument addedInstrument) {
        instruments.add(addedInstrument);
    }

    public void checkOffInstrument(int completedInstrumentIndex) {
        instruments.get(completedInstrumentIndex).markAsDone();
    }
}
