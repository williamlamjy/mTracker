package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

import java.util.HashMap;
import java.util.HashSet;

//@@author kum-wh
/**
 * Represents an Etf type instrument.
 */
public class Etf extends Instrument {

    protected String remark;
    protected double pastReturn;
    protected static final String ETF_ICON = "[E]";
    protected static final String TYPE_INSTRUMENT = "Etf";
    protected static final String EMPTY_STRING = "";

    protected static final String PAST_RETURN_FIELD = "Past Returns: ";
    protected static final String PAST_RETURN_ATTRIBUTE = "past-returns";
    protected static final double UNDEFINED_PAST_RETURN_VALUE = -101.0;

    public Etf(String name, double currentPrice, String sentiment, double pastReturn, String remark) {
        super(name, currentPrice, sentiment);
        this.pastReturn = pastReturn;
        this.remark = remark;
    }

    public void setRemark(String inputRemark) {
        remark = inputRemark;
    }

    public void setPastReturn(Double inputPastReturn) {
        pastReturn = inputPastReturn;
    }

    /**
     * Sets past return parameter to the new past return if past return parameter is being edited.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editPastReturn(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(PAST_RETURN_ATTRIBUTE)) {
            return;
        }
        Double updateReturn = Double.parseDouble(editedParameters.get(PAST_RETURN_ATTRIBUTE));
        setPastReturn(updateReturn);
    }

    /**
     * Sets remark parameter to the new remark if remark parameter is being edited.
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
     * Sets all instrument specific parameters being edited to its new values.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editSpecificParameters(HashMap<String, String> editedParameters) {
        editPastReturn(editedParameters);
        editRemark(editedParameters);
    }

    /**
     * Sets all the Etf parameters being edited to its new values.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    @Override
    public void editParameter(HashMap<String, String> editedParameters) {
        editGeneralParameter(editedParameters);
        editSpecificParameters(editedParameters);
    }

    /**
     * Gets the value past return in string.
     *
     * @return Empty string if past return is undefined else the value of the past return in string.
     */
    public String getPastReturn() {
        if (pastReturn == UNDEFINED_PAST_RETURN_VALUE) {
            return EMPTY_STRING;
        }
        return String.valueOf(pastReturn);
    }

    /**
     * Gets all the type of Etf parameters in one string.
     *
     * @return A string containing all the type of Etf parameters.
     */
    @Override
    public String editParameterInstructions() {
        return super.editParameterInstructions() + SEPARATOR + PAST_RETURN_ATTRIBUTE + SEPARATOR
                + REMARK_ATTRIBUTE;
    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    //@@author williamlamjy
    /**
     * Formats all Etf parameters to save to text file.
     *
     * @return A formatted string to save to text file.
     */
    @Override
    public String textFileFormatting() {
        return super.textFileFormatting() + FILE_SEPARATOR + getPastReturn()
                + FILE_SEPARATOR + remark;
    }
    //@@author

    @Override
    public String getTypeIcon() {
        return ETF_ICON;
    }

    /**
     * Gets all the Etf parameters, with each parameter on a newline.
     *
     * @return A string containing all the Etf parameters.
     */
    @Override
    public String getAllParams() {
        return super.getAllParams()
                + PAST_RETURN_FIELD + getPastReturn() + System.lineSeparator()
                + REMARK_FIELD + remark;
    }

    /**
     * Adds all the type of Etf parameters into a HashSet.
     *
     * @return HashSet containing the type of Etf parameters.
     */
    @Override
    public HashSet<String> getValidAttribute() {
        super.getValidAttribute();
        validAttribute.add(PAST_RETURN_ATTRIBUTE);
        return validAttribute;
    }
}
