package seedu.mtracker.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

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

    public Instrument getInstrument(int index) {
        return instruments.get(index);
    }

    public void addInstrument(Instrument addedInstrument) {
        instruments.add(addedInstrument);
    }

    public ArrayList<Instrument> findInstruments(String keyword) {
        return (ArrayList<Instrument>) instruments.stream()
                .filter((instrument) -> instrument.getName().contains(keyword))
                .collect(Collectors.toList());
    }

    public void deleteInstrument(int index) {
        instruments.remove(index);
    }

    public void editInstrument(int index, HashMap<String, String> editedParameters) {
        Instrument instrument = instruments.get(index);
        instrument.editParameter(editedParameters);
    }
}
