package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

import java.util.HashMap;
import java.util.HashSet;

public class Etf extends Instrument {

    protected String remark;
    protected double pastReturns;
    protected static final String ETF_ICON = "[E]";
    protected static final String TYPE_INSTRUMENT = "Etf";
    protected static final String EMPTY_STRING = "";

    protected static final String RETURNS_FIELD = "Past Returns: ";
    protected static final String RETURNS_ATTRIBUTE = "returns";
    protected static final double UNDEFINED_VALUE = -101.0;

    public Etf(String name, double currentPrice, String sentiment, double pastReturns, String remark) {
        super(name, currentPrice, sentiment);
        this.pastReturns = pastReturns;
        this.remark = remark;
    }

    public void setRemark(String inputRemark) {
        remark = inputRemark;
    }

    public void setPastReturns(Double inputPastReturn) {
        pastReturns = inputPastReturn;
    }

    public void editReturn(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(RETURNS_ATTRIBUTE)) {
            return;
        }
        Double updateReturn = Double.parseDouble(editedParameters.get(RETURNS_ATTRIBUTE));
        setPastReturns(updateReturn);
    }

    public void editRemark(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(REMARK_ATTRIBUTE)) {
            return;
        }
        setRemark(editedParameters.get(REMARK_ATTRIBUTE));
    }

    public void editSpecificParameters(HashMap<String, String> editedParameters) {
        editReturn(editedParameters);
        editRemark(editedParameters);
    }

    @Override
    public void editParameter(HashMap<String, String> editedParameters) {
        editGeneralParameter(editedParameters);
        editSpecificParameters(editedParameters);
    }

    public String getReturnsForFileFormat() {
        return String.valueOf(pastReturns);
    }

    public String getReturns() {
        if (pastReturns == UNDEFINED_VALUE) {
            return EMPTY_STRING;
        }
        return String.valueOf(pastReturns);
    }

    @Override
    public String editParameterInstructions() {
        return super.editParameterInstructions() + SEPARATOR + RETURNS_ATTRIBUTE + SEPARATOR
                + REMARK_ATTRIBUTE;
    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    @Override
    public String textFileFormatting() {
        return String.format(super.textFileFormatting() + FILE_SEPARATOR + getReturnsForFileFormat()
                + FILE_SEPARATOR + remark);
    }

    @Override
    public String getTypeIcon() {
        return ETF_ICON;
    }

    @Override
    public String getAllParams() {
        return super.getAllParams()
                + RETURNS_FIELD + getReturns() + System.lineSeparator()
                + REMARKS_FIELD + remark;
    }

    @Override
    public HashSet<String> getValidAttribute() {
        super.getValidAttribute();
        validAttribute.add(RETURNS_ATTRIBUTE);
        return validAttribute;
    }
}
