package seedu.mtracker.instrument.subinstrument;

import seedu.mtracker.instrument.Instrument;
import seedu.mtracker.ui.TextUi;

public class Etf extends Instrument {

    protected String remark;
    protected double pastReturns;
    protected static final String ETF_ICON = "E";
    protected static final String TYPE_STOCK = "Etf";
    private static final String RETURNS_HEADER = "Past Returns: ";

    public Etf(String name, double currentPrice, String sentiment, double pastReturns, String remark) {
        super(name, currentPrice, sentiment);
        this.pastReturns = pastReturns;
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public String getReturns() {
        if (pastReturns == -101.0) {
            return EMPTY_STRING;
        }
        return String.valueOf(pastReturns);
    }

    @Override
    public String toString() {
        return TextUi.createBoxDisplay(ETF_ICON) + getName();
    }

    @Override
    public String getType() {
        return TYPE_STOCK;
    }

    @Override
    public String toList() {
        return super.toList()
                + System.lineSeparator() + RETURNS_HEADER + getReturns()
                + System.lineSeparator() + REMARKS_HEADER + getRemark();
    }
}
