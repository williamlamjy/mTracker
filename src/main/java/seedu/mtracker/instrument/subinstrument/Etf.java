package seedu.mtracker.instrument.subinstrument;

import seedu.mtracker.instrument.Instrument;
import seedu.mtracker.ui.TextUi;

public class Etf extends Instrument {

    protected String remark;
    protected double pastReturns;
    protected static final String ETF_ICON = "E";

    public Etf(String name, double currentPrice, double pastReturns, String sentiment, String remark) {
        super(name, currentPrice, sentiment);
        this.pastReturns = pastReturns;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return TextUi.createBoxDisplay(ETF_ICON) + getName();
    }
}
