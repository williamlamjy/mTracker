package seedu.mtracker.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Responsible for storing and managing of all the different types of instruments.
 */
public class InstrumentManager {

    private final ArrayList<Instrument> instruments;
    private static InstrumentManager instrumentManager;

    private InstrumentManager() {
        instruments = new ArrayList<>();
    }

    /**
     * Allow other class to get the only instance of this class instead of creating a new instance,
     * creating a singleton pattern.
     * @return The only instance of this class.
     */
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

    /**
     * Responsible for scanning through the list and
     * filtering instruments with name contains a keyword entered by user,
     * to find instruments with a specific name.
     * @param keyword The word input by user to find.
     * @return A list containing instruments containing keyword in its name.
     */
    public ArrayList<Instrument> findInstruments(String keyword) {
        return (ArrayList<Instrument>) instruments.stream()
                .filter((instrument) -> instrument.getName().contains(keyword))
                .collect(Collectors.toList());
    }

    public void deleteInstrument(int index) {
        instruments.remove(index);
    }

    /**
     * Responsible for editing of the parameters of the instruments.
     * @param index The index of the instrument to edit.
     * @param editedParameters The parameters to be edited and its new values.
     */
    public void editInstrument(int index, HashMap<String, String> editedParameters) {
        Instrument instrument = instruments.get(index);
        instrument.editParameter(editedParameters);
    }
}
