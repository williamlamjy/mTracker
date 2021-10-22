package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

public class Forex extends Instrument {
    protected double entryPrice;
    protected double exitPrice;
    protected String expiry;
    protected String remark;

    private static final String FX_ICON = "F";
    protected static final String TYPE_INSTRUMENT = "Forex";
    protected static final String ENTRY_PRICE_HEADER = "Entry Price: ";
    protected static final String EXIT_PRICE_HEADER = "Exit Price: ";

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
    public String toString() {
        return TextUi.createBoxDisplay(FX_ICON)
                + " " + getName()
                + TextUi.SEMICOLON_SEP + getCurrentPrice()
                + TextUi.SEMICOLON_SEP + getSentiment();
    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    @Override
    public String textFileFormatting() {
        return String.format(super.textFileFormatting() + FILE_SEPARATOR + getEntryPrice()
                + FILE_SEPARATOR + getExitPrice() + FILE_SEPARATOR + getExpiry()
                + FILE_SEPARATOR + getRemark());
    }

    @Override
    public String getAllParams() {
        return super.getAllParams()
                + System.lineSeparator() + ENTRY_PRICE_HEADER + getEntryPrice()
                + System.lineSeparator() + EXIT_PRICE_HEADER + getExitPrice()
                + System.lineSeparator() + EXPIRY_HEADER + getExpiry()
                + System.lineSeparator() + REMARKS_HEADER + getRemark();
    }
}
