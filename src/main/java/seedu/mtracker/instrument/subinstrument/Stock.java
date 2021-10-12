package seedu.mtracker.instrument.subinstrument;

import seedu.mtracker.instrument.Instrument;
import seedu.mtracker.ui.TextUi;

public class Stock extends Instrument {

    protected String remark;
    protected static final String STOCK_ICON = "S";
    protected static final String TYPE_STOCK = "Stock";

    public Stock(String name, double currentPrice, String sentiment, String remark) {
        super(name, currentPrice, sentiment);
        this.remark = remark;
    }

    public String getRemark(){
        return remark;
    }

    @Override
    public String toString() {
        return TextUi.createBoxDisplay(STOCK_ICON) + getName();
    }

    @Override
    public String getType(){
        return TYPE_STOCK;
    }

    @Override
    public String toList(){
        return super.toList()
                + System.lineSeparator() + REMARKS_HEADER + getRemark();
    }
}
