package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

import java.util.HashMap;
import java.util.HashSet;


public class Etf extends Instrument {

    protected String remark;
    protected double pastReturns;
    protected static final String ETF_ICON = "[E]";
    protected static final String TYPE_INSTRUMENT = "Etf";

    protected static final String RETURNS_FIELD = "Past Returns: ";
    protected static final String RETURNS_ATTRIBUTE = "returns";

    public Etf(String name, double currentPrice, String sentiment, double pastReturns, String remark) {
        super(name, currentPrice, sentiment);
        this.pastReturns = pastReturns;
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String inputRemark) {
        remark = inputRemark;
    }

    public void setPastReturns(Double inputPastReturn){
        pastReturns = inputPastReturn;
    }

    @Override
    public void editParameter(HashMap<String,String> editedParameters) {
        super.editParameter(editedParameters);
        if(editedParameters.containsKey(RETURNS_ATTRIBUTE)){
            Double updateReturn = Double.parseDouble(editedParameters.get(RETURNS_ATTRIBUTE));
            setPastReturns(updateReturn);
        }
        if(editedParameters.containsKey(REMARK_ATTRIBUTE)){
            setRemark(editedParameters.get(REMARK_ATTRIBUTE));
        }
    }

    public String getReturnsForFileFormat() {
        return String.valueOf(pastReturns);
    }

    @Override
    public String editParameterInstructions(){
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
                + FILE_SEPARATOR + getRemark());
    }

    @Override
    public String getTypeIcon() {
        return ETF_ICON;
    }

    @Override
    public String getAllParams() {
        return super.getAllParams()
                + RETURNS_FIELD + pastReturns + System.lineSeparator()
                + REMARKS_FIELD + remark;
    }

    @Override
    public HashSet<String> getValidAttribute() {
        super.getValidAttribute();
        validAttribute.add(RETURNS_ATTRIBUTE);
        return validAttribute;
    }
}
