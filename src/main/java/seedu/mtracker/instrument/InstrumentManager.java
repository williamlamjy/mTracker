package seedu.mtracker.instrument;

import java.util.ArrayList;

public class InstrumentManager {
    protected ArrayList<Instrument> instruments;

    public InstrumentManager(ArrayList<Instrument> instruments){
        this.instruments = instruments;
    }

    public void addInstrument(Instrument addedInstrument){
        instruments.add(addedInstrument);
    }
}
