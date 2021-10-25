package seedu.mtracker.model;

import seedu.mtracker.error.InvalidBoundsError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public int getSize() {
        return instruments.size();
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

    public void doneInstrument(int completedInstrumentIndex) {
        instruments.get(completedInstrumentIndex).markAsDone();
    }

    public void deleteInstrument(int index) {
        instruments.remove(index);
    }

    public void editInstrument(int index, HashMap<String, String> editedParameters) {
        Instrument instrument = instruments.get(index);
        instrument.editParameter(editedParameters);
    }
}
