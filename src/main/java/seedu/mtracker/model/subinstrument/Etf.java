package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;


public class Etf extends Instrument {

    protected String remark;
    protected double pastReturns;
    protected static final String ETF_ICON = "[E]";
    protected static final String TYPE_INSTRUMENT = "Etf";

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

    public String getReturnsForFileFormat() {
        return String.valueOf(pastReturns);
    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    @Override
    public String textFileFormatting() {
        return String.format(super.textFileFormatting() + FILE_SEPARATOR + getReturnsForFileFormat()
                + FILE_SEPARATOR + getRemark());
    }

    @Override
    public String getIcon() {
        return ETF_ICON;
    }
}
