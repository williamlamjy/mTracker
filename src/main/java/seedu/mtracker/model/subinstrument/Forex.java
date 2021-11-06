package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.time.LocalDate;

//@@author KVignesh122
public class Forex extends Instrument {

    protected double entryPrice;
    protected double exitPrice;
    protected LocalDate expiry;
    protected String remark;

    protected static final String FOREX_ICON = "[F]";
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
            LocalDate expiry,
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

    public String formatExpiry() {
        return expiry.format(DateTimeFormatter.ofPattern(DATE_REGEX));
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

    public void setExpiry(LocalDate inputExpiry) {
        expiry = inputExpiry;
    }

    public void editRemark(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(REMARK_ATTRIBUTE)) {
            return;
        }
        setRemark(editedParameters.get(REMARK_ATTRIBUTE));
    }

    public void editExpiry(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(EXPIRY_ATTRIBUTE)) {
            return;
        }
        LocalDate updateExpiry = LocalDate.parse(editedParameters.get(EXPIRY_ATTRIBUTE));
        setExpiry(updateExpiry);
    }

    public void editEntryPrice(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(ENTRY_PRICE_ATTRIBUTE)) {
            return;
        }
        Double updateEntryPrice = Double.parseDouble(editedParameters.get(ENTRY_PRICE_ATTRIBUTE));
        setEntryPrice(updateEntryPrice);
    }

    public void editExitPrice(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(EXIT_PRICE_FIELD)) {
            return;
        }
        Double updateExitPrice = Double.parseDouble(editedParameters.get(EXIT_PRICE_FIELD));
        setExitPrice(updateExitPrice);
    }

    public void editSpecificParameter(HashMap<String, String> editedParameters) {
        editEntryPrice(editedParameters);
        editExitPrice(editedParameters);
        editExpiry(editedParameters);
        editRemark(editedParameters);
    }

    @Override
    public void editParameter(HashMap<String, String> editedParameters) {
        editGeneralParameter(editedParameters);
        editSpecificParameter(editedParameters);
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
        return super.textFileFormatting() + FILE_SEPARATOR + entryPrice
                + FILE_SEPARATOR + exitPrice + FILE_SEPARATOR + expiry
                + FILE_SEPARATOR + remark;
    }

    @Override
    public String getAllParams() {
        return super.getAllParams()
                + ENTRY_PRICE_FIELD + entryPrice + System.lineSeparator()
                + EXIT_PRICE_FIELD + exitPrice + System.lineSeparator()
                + EXPIRY_FIELD + formatExpiry() + System.lineSeparator()
                + REMARKS_FIELD + remark;
    }

    //@@author kum-wh
    @Override
    public HashSet<String> getValidAttribute() {
        super.getValidAttribute();
        validAttribute.add(ENTRY_PRICE_ATTRIBUTE);
        validAttribute.add(EXIT_PRICE_ATTRIBUTE);
        validAttribute.add(EXPIRY_ATTRIBUTE);
        return validAttribute;
    }
}
