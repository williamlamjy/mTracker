package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Represents a Crypto type instrument.
 */
public class Crypto extends Instrument {

    protected LocalDate expiry;
    protected String remark;
    protected static final String CRYPTO_ICON = "[C]";
    protected static final String TYPE_INSTRUMENT = "Crypto";
    protected static final String EXPIRY_FIELD = "Expiry: ";
    protected static final String EXPIRY_ATTRIBUTE = "expiry";

    public Crypto(String name, double currentPrice, String sentiment, LocalDate expiry, String remark) {
        super(name, currentPrice, sentiment);
        this.expiry = expiry;
        this.remark = remark;
    }

    /**
     * Formats date into String.
     *
     * @return Expiry date formatted into string.
     */
    public String formatExpiry() {
        return expiry.format(DateTimeFormatter.ofPattern(DATE_REGEX));
    }

    public void setExpiry(LocalDate inputExpiry) {
        expiry = inputExpiry;
    }

    public void setRemark(String inputRemark) {
        remark = inputRemark;
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
     * Sets all instrument specific parameters being edited to its new values.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editSpecificParameter(HashMap<String, String> editedParameters) {
        editExpiry(editedParameters);
        editRemark(editedParameters);
    }

    /**
     * Sets all the Crypto parameters being edited to its new values.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    @Override
    public void editParameter(HashMap<String, String> editedParameters) {
        editGeneralParameter(editedParameters);
        editSpecificParameter(editedParameters);
    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    /**
     * Formats all Crypto parameters to save to text file.
     *
     * @return A formatted string to save to text file.
     */
    @Override
    public String textFileFormatting() {
        return super.textFileFormatting() + FILE_SEPARATOR + expiry
                + FILE_SEPARATOR + remark;
    }

    /**
     * Gets all the type of Crypto parameters in one string.
     *
     * @return A string containing all the type of Crypto parameters.
     */
    @Override
    public String editParameterInstructions() {
        return super.editParameterInstructions() + SEPARATOR + EXPIRY_ATTRIBUTE + SEPARATOR
                + REMARK_ATTRIBUTE;
    }

    @Override
    public String getTypeIcon() {
        return CRYPTO_ICON;
    }

    /**
     * Gets all the Crypto parameters, with each parameter on a newline.
     *
     * @return A string containing all the Crypto parameters.
     */
    @Override
    public String getAllParams() {
        return super.getAllParams()
                + EXPIRY_FIELD + formatExpiry() + System.lineSeparator()
                + REMARKS_FIELD + remark;
    }

    /**
     * Adds all the type of Crypto parameters into a HashSet.
     *
     * @return HashSet containing the type of Crypto parameters.
     */
    @Override
    public HashSet<String> getValidAttribute() {
        super.getValidAttribute();
        validAttribute.add(EXPIRY_ATTRIBUTE);
        return validAttribute;
    }
}
