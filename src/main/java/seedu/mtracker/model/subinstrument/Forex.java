package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;

//@@author KVignesh122
/**
 * Represents a Forex type instrument.
 */
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

    //@@author kum-wh
    /**
     * Gets all the type of Forex parameters in one string.
     *
     * @return A string containing all the type of Forex parameters.
     */
    @Override
    public String editParameterInstructions() {
        return super.editParameterInstructions() + SEPARATOR + ENTRY_PRICE_ATTRIBUTE + SEPARATOR
                + EXIT_PRICE_ATTRIBUTE + SEPARATOR
                + EXPIRY_ATTRIBUTE + SEPARATOR
                + REMARK_ATTRIBUTE;
    }

    //@@author theodorekwok
    /**
     * Formats date into String.
     *
     * @return Expiry date formatted into string.
     */
    public String formatExpiry() {
        return expiry.format(DateTimeFormatter.ofPattern(DATE_REGEX));
    }

    //@@author kum-wh
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

    /**
     * Sets remarks parameter to the new remarks if remarks parameter is being edited.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editRemark(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(REMARK_ATTRIBUTE)) {
            return;
        }
        setRemark(editedParameters.get(REMARK_ATTRIBUTE));
    }

    /**
     * Sets expiry parameter to the new expiry if expiry parameter is being edited.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editExpiry(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(EXPIRY_ATTRIBUTE)) {
            return;
        }
        LocalDate updateExpiry = LocalDate.parse(editedParameters.get(EXPIRY_ATTRIBUTE));
        setExpiry(updateExpiry);
    }

    /**
     * Sets entry price parameter to the new price if entry price parameter is being edited.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editEntryPrice(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(ENTRY_PRICE_ATTRIBUTE)) {
            return;
        }
        Double updateEntryPrice = Double.parseDouble(editedParameters.get(ENTRY_PRICE_ATTRIBUTE));
        setEntryPrice(updateEntryPrice);
    }

    /**
     * Sets exit price parameter to the new price if exit price parameter is being edited.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editExitPrice(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(EXIT_PRICE_FIELD)) {
            return;
        }
        Double updateExitPrice = Double.parseDouble(editedParameters.get(EXIT_PRICE_FIELD));
        setExitPrice(updateExitPrice);
    }

    /**
     * Sets all instrument specific parameters being edited to its new values.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editSpecificParameter(HashMap<String, String> editedParameters) {
        editEntryPrice(editedParameters);
        editExitPrice(editedParameters);
        editExpiry(editedParameters);
        editRemark(editedParameters);
    }

    /**
     * Sets all the Forex parameters being edited to its new values.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    @Override
    public void editParameter(HashMap<String, String> editedParameters) {
        editGeneralParameter(editedParameters);
        editSpecificParameter(editedParameters);
    }

    //@@author
    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    @Override
    public String getTypeIcon() {
        return FOREX_ICON;
    }

    //@@author williamlamjy
    /**
     * Formats all Forex parameters to save to text file.
     *
     * @return A formatted string to save to text file.
     */
    @Override
    public String textFileFormatting() {
        return super.textFileFormatting() + FILE_SEPARATOR + entryPrice
                + FILE_SEPARATOR + exitPrice + FILE_SEPARATOR + expiry
                + FILE_SEPARATOR + remark;
    }
    //@@author

    /**
     * Gets all the Forex parameters, with each parameter on a newline.
     *
     * @return A string containing all the Forex parameters.
     */
    @Override
    public String getAllParams() {
        return super.getAllParams()
                + ENTRY_PRICE_FIELD + entryPrice + System.lineSeparator()
                + EXIT_PRICE_FIELD + exitPrice + System.lineSeparator()
                + EXPIRY_FIELD + formatExpiry() + System.lineSeparator()
                + REMARKS_FIELD + remark;
    }

    //@@author kum-wh
    /**
     * Adds all the type of Forex parameters into a HashSet.
     *
     * @return HashSet containing the type of Forex parameters.
     */
    @Override
    public HashSet<String> getValidAttribute() {
        super.getValidAttribute();
        validAttribute.add(ENTRY_PRICE_ATTRIBUTE);
        validAttribute.add(EXIT_PRICE_ATTRIBUTE);
        validAttribute.add(EXPIRY_ATTRIBUTE);
        return validAttribute;
    }
}
