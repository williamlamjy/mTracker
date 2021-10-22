package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

public class Forex extends Instrument {
    protected double entryPrice;
    protected double exitPrice;
    protected String expiry;
    protected String remark;

    private static final String FOREX_ICON = "F";
    protected static final String TYPE_INSTRUMENT = "Forex";

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

    public double getEntryPrice() {
        return entryPrice;
    }

    public double getExitPrice() {
        return exitPrice;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    @Override
    public String getIcon() {
        return FOREX_ICON;
    }

    @Override
    public String textFileFormatting() {
        return String.format(super.textFileFormatting() + FILE_SEPARATOR + getEntryPrice()
                + FILE_SEPARATOR + getExitPrice() + FILE_SEPARATOR + getExpiry()
                + FILE_SEPARATOR + getRemark());
    }

}
