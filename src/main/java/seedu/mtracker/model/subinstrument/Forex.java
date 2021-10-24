package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

import java.util.HashSet;

public class Forex extends Instrument {
    protected double entryPrice;
    protected double exitPrice;
    protected String expiry;
    protected String remark;

    private static final String FOREX_ICON = "[F]";
    protected static final String TYPE_INSTRUMENT = "Forex";

    protected static final String ENTRY_PRICE_FIELD = "Entry Price: ";
    protected static final String EXIT_PRICE_FIELD = "Exit Price: ";
    protected static final String EXPIRY_FIELD = "Expiry: ";

    protected static final String ENTRY_PRICE_ATTRIBUTE = "entry price";
    protected static final String EXIT_PRICE_ATTRIBUTE = "exit price";
    protected static final String EXPIRY_ATTRIBUTE = "expiry";

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

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String inputRemark) {
        remark = inputRemark;
    }

    @Override
    public String getSpecificParameter(int index) {
        return null;
    }

    @Override
    public void setSpecificParameter(Double inputReturns, int index) {

    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    @Override
    public String getTypeIcon() {
        return FOREX_ICON;
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
                + ENTRY_PRICE_FIELD + entryPrice + System.lineSeparator()
                + EXIT_PRICE_FIELD + exitPrice + System.lineSeparator()
                + EXPIRY_FIELD + expiry + System.lineSeparator()
                + REMARKS_FIELD + remark;
    }

    @Override
    public HashSet<String> getValidAttribute() {
        super.getValidAttribute();
        validAttribute.add(ENTRY_PRICE_ATTRIBUTE);
        validAttribute.add(EXIT_PRICE_ATTRIBUTE);
        validAttribute.add(EXPIRY_ATTRIBUTE);
        return validAttribute;
    }
}
