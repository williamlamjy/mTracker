package seedu.mtracker.instrument.subinstrument;

import seedu.mtracker.instrument.Instrument;

public class Crypto extends Instrument {

    protected String expiry;
    protected String remark;
    protected static final char INSTRUMENT_ICON = 'C';

    public Crypto(String name, double currentPrice, String sentiment, String expiry, String remark) {
        super(name, currentPrice, sentiment);
        this.expiry = expiry;
        this.remark = remark;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getRemarks() {
        return remark;
    }

    @Override
    public String toString() {
        return "[" + INSTRUMENT_ICON + "]" + getName();
    }
}
