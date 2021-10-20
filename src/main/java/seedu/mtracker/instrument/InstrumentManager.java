package seedu.mtracker.instrument;

import java.util.ArrayList;

public class InstrumentManager {

    private final ArrayList<Instrument> instruments;

    public InstrumentManager(ArrayList<Instrument> instruments) {
        this.instruments = instruments;
    }

    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }

    public void addInstrument(Instrument addedInstrument) {
        instruments.add(addedInstrument);
    }
}
