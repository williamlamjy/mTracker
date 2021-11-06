package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

import java.util.HashMap;

/**
 * Represents a Stock type instrument.
 */
public class Stock extends Instrument {

    protected String remark;
    protected static final String STOCK_ICON = "[S]";
    protected static final String TYPE_INSTRUMENT = "Stock";

    public Stock(String name, double currentPrice, String sentiment, String remark) {
        super(name, currentPrice, sentiment);
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
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
     * Sets all the Stock parameters being edited to its new values.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    @Override
    public void editParameter(HashMap<String, String> editedParameters) {
        editGeneralParameter(editedParameters);
        editRemark(editedParameters);
    }

    /**
     * Gets all the type of Stock parameters in one string.
     *
     * @return A string containing all the type of Stock parameters.
     */
    @Override
    public String editParameterInstructions() {
        return super.editParameterInstructions() + SEPARATOR + REMARK_ATTRIBUTE;
    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    /**
     * Formats all Stock parameters to save to text file.
     *
     * @return A formatted string to save to text file.
     */
    @Override
    public String textFileFormatting() {
        return super.textFileFormatting()
                + FILE_SEPARATOR + getRemark();
    }

    @Override
    public String getTypeIcon() {
        return STOCK_ICON;
    }

    /**
     * Adds all the type of Stock parameters into a HashSet.
     *
     * @return HashSet containing the type of Stock parameters.
     */
    @Override
    public String getAllParams() {
        return super.getAllParams()
                + REMARKS_FIELD + remark;
    }
}
