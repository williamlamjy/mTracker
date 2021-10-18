package seedu.mtracker.instrument;

import seedu.mtracker.error.InvalidBoundsError;

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

    public Instrument getInstrument(int index) throws InvalidBoundsError {
        Instrument instrument;
        try {
            instrument = instruments.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidBoundsError();
        }
        return instrument;
    }

    public void addInstrument(Instrument addedInstrument) {
        instruments.add(addedInstrument);
    }

    public void deleteInstrument(int index) {
        instruments.remove(index);
    }
}
