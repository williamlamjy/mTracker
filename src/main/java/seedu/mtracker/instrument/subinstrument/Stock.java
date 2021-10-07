package seedu.mtracker.instrument.subinstrument;

import seedu.mtracker.instrument.Instrument;

public class Stock extends Instrument {

    protected String remark;

    public Stock(String name, double currentPrice, String sentiment, String remark) {
        super(name, currentPrice, sentiment);
        this.remark = remark;
    }

    @Override
    public String toString() {
        return null;
    }
}
