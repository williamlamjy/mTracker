package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

public class Stock extends Instrument {

    protected String remark;
    protected static final String STOCK_ICON = "S";
    protected static final String TYPE_INSTRUMENT = "Stock";

    public Stock(String name, double currentPrice, String sentiment, String remark) {
        super(name, currentPrice, sentiment);
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return TextUi.createBoxDisplay(STOCK_ICON)
                + TextUi.createBoxDisplay(getStatusIcon()) + getName();
    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    @Override
    public String textFileFormatting() {
        return String.format(super.textFileFormatting()
                + FILE_SEPARATOR + getRemark());
    }

    @Override
    public String toList() {
        return super.toList()
                + System.lineSeparator() + REMARKS_HEADER + getRemark();
    }
}
