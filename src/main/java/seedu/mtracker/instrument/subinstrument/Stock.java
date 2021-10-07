package seedu.mtracker.instrument.subinstrument;

import seedu.mtracker.instrument.Instrument;
import seedu.mtracker.ui.TextUi;

public class Stock extends Instrument {

    protected String remark;
    protected static final String STOCK_ICON = "S";

    public Stock(String name, double currentPrice, String sentiment, String remark) {
        super(name, currentPrice, sentiment);
        this.remark = remark;
    }

    @Override
    public String toString() {
        return TextUi.createBoxDisplay(STOCK_ICON) + getName();
    }
}
