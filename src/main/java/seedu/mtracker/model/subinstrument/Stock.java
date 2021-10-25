package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;
import java.util.HashMap;

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

    public void  editRemark(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(REMARK_ATTRIBUTE)) {
            return;
        }
        setRemark(editedParameters.get(REMARK_ATTRIBUTE));
    }

    @Override
    public void editParameter(HashMap<String, String> editedParameters) {
        editGeneralParameter(editedParameters);
        editRemark(editedParameters);
    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    @Override
    public String textFileFormatting() {
        return String.format(super.textFileFormatting()
                + FILE_SEPARATOR + getRemark());
    }

    @Override
    public String getTypeIcon() {
        return STOCK_ICON;
    }

    @Override
    public String getAllParams() {
        return super.getAllParams()
                + REMARKS_FIELD + remark;
    }
}
