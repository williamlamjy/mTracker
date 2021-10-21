package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

public class Crypto extends Instrument {

    protected String expiry;
    protected String remark;
    protected static final String CRYPTO_ICON = "C";
    protected static final String TYPE_INSTRUMENT = "Crypto";

    public Crypto(String name, double currentPrice, String sentiment, String expiry, String remark) {
        super(name, currentPrice, sentiment);
        this.expiry = expiry;
        this.remark = remark;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return TextUi.createBoxDisplay(CRYPTO_ICON) + getName();
    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    @Override
    public String textFileFormatting() {
        return String.format(super.textFileFormatting() + FILE_SEPARATOR + getExpiry()
                + FILE_SEPARATOR + getRemark());
    }

    @Override
    public String toList() {
        return super.toList()
                + System.lineSeparator() + EXPIRY_HEADER + getExpiry()
                + System.lineSeparator() + REMARKS_HEADER + getRemark();
    }
}
