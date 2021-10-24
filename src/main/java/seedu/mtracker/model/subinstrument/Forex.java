package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

import java.util.HashMap;
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

    protected static final String ENTRY_PRICE_ATTRIBUTE = "entry-price";
    protected static final String EXIT_PRICE_ATTRIBUTE = "exit-price";
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

    @Override
    public String editParameterInstructions() {
        return super.editParameterInstructions() + SEPARATOR + ENTRY_PRICE_ATTRIBUTE + SEPARATOR
                + EXIT_PRICE_ATTRIBUTE + SEPARATOR
                + EXPIRY_ATTRIBUTE + SEPARATOR
                + REMARK_ATTRIBUTE;
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

    public void setRemark(String inputRemark) {
        remark = inputRemark;
    }

    public void setEntryPrice(Double inputEntryPrice) {
        entryPrice = inputEntryPrice;
    }

    public void setExitPrice(Double inputExitPrice) {
        exitPrice = inputExitPrice;
    }

    public void setExpiry(String inputExpiry) {
        expiry = inputExpiry;
    }

    @Override
    public void editParameter(HashMap<String,String> editedParameters) {
        super.editParameter(editedParameters);
        if (editedParameters.containsKey(EXPIRY_ATTRIBUTE)) {
            setExpiry(editedParameters.get(EXPIRY_ATTRIBUTE));
        }
        if (editedParameters.containsKey(ENTRY_PRICE_ATTRIBUTE)) {
            Double updateEntryPrice = Double.parseDouble(editedParameters.get(ENTRY_PRICE_ATTRIBUTE));
            setEntryPrice(updateEntryPrice);
        }
        if (editedParameters.containsKey(EXIT_PRICE_FIELD)) {
            Double updateExitPrice = Double.parseDouble(editedParameters.get(EXIT_PRICE_FIELD));
            setExitPrice(updateExitPrice);
        }
        if (editedParameters.containsKey(REMARK_ATTRIBUTE)) {
            setRemark(editedParameters.get(REMARK_ATTRIBUTE));
        }
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
