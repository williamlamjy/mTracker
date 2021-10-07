package seedu.mtracker.instrument.subinstrument;

import seedu.mtracker.instrument.Instrument;

public class Crypto extends Instrument {

    protected String expiry;
    protected String remarks;
    protected static final char INSTRUMENT_ICON = 'C';

    public Crypto(String name, double currentPrice, String sentiment, String expiry, String remarks) {
        super(name, currentPrice, sentiment);
        this.expiry = expiry;
        this.remarks = remarks;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return "[" + INSTRUMENT_ICON + "]" + getName();
    }
}
