package seedu.mtracker.instrument.subinstrument;

import seedu.mtracker.instrument.Instrument;
import seedu.mtracker.ui.TextUi;

public class Forex extends Instrument {
    protected double entryPrice;
    protected double exitPrice;
    protected String expiry;
    protected String remark;

    private static final String FX_ICON = "F";

    public Forex(
            String name,
            double currentPrice,
            String sentiment,
            double entryPrice,
            double exitPrice,
            String expiry,
            String remark
    ) {
        super(name, currentPrice, sentiment);
        this.entryPrice = entryPrice;
        this.exitPrice = exitPrice;
        this.expiry = expiry;
        this.remark = remark;

    }

    @Override
    public String toString() {
        return TextUi.createBoxDisplay(FX_ICON) + getName();
    }
}
