package seedu.mtracker.instrument;

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

    public int getSize() {
        return instruments.size();
    }

    public String getInstrumentWithFileFormat(int instrumentIndex) {
        return instruments.get(instrumentIndex).textFileFormatting();
    }

    public void addInstrument(Instrument addedInstrument) {
        instruments.add(addedInstrument);
    }
}
