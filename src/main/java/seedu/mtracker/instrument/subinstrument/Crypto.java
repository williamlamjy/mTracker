package seedu.mtracker.instrument.subinstrument;

import seedu.mtracker.instrument.Instrument;
import seedu.mtracker.ui.TextUi;

public class Crypto extends Instrument {

    protected String expiry;
    protected String remark;
    protected static final String CRYPTO_ICON = "C";

    public Crypto(String name, double currentPrice, String sentiment, String expiry, String remark) {
        super(name, currentPrice, sentiment);
        this.expiry = expiry;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return TextUi.createBoxDisplay(CRYPTO_ICON) + getName();
    }
}
