package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

import java.util.HashSet;

public class Crypto extends Instrument {

    protected String expiry;
    protected String remark;
    protected static final String CRYPTO_ICON = "[C]";
    protected static final String TYPE_INSTRUMENT = "Crypto";
    protected static final String EXPIRY_FIELD = "Expiry: ";
    protected static final String EXPIRY_ATTRIBUTE = "expiry";

    public Crypto(String name, double currentPrice, String sentiment, String expiry, String remark) {
        super(name, currentPrice, sentiment);
        this.expiry = expiry;
        this.remark = remark;
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
    public String textFileFormatting() {
        return String.format(super.textFileFormatting() + FILE_SEPARATOR + getExpiry()
                + FILE_SEPARATOR + getRemark());
    }

    @Override
    public String getTypeIcon() {
        return CRYPTO_ICON;
    }

    @Override
    public String getAllParams() {
        return super.getAllParams()
                + EXPIRY_FIELD + expiry + System.lineSeparator()
                + REMARKS_FIELD + remark;
    }

    @Override
    public HashSet<String> getValidAttribute() {
        super.getValidAttribute();
        validAttribute.add(EXPIRY_ATTRIBUTE);
        return validAttribute;
    }
}
