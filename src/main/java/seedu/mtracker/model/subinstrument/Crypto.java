package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.time.LocalDate;

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

    public LocalDate getExpiry() {
        return expiry;
    }

    public String formatExpiry() {
        return expiry.format(DateTimeFormatter.ofPattern(DATE_REGEX));
    }

    public String getRemark() {
        return remark;
    }

    public void setExpiry(LocalDate inputExpiry) {
        expiry = inputExpiry;
    }

    public void setRemark(String inputRemark) {
        remark = inputRemark;
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

    public void editSpecificParameter(HashMap<String, String> editedParameters) {
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
    public String textFileFormatting() {
        return String.format(super.textFileFormatting() + FILE_SEPARATOR + getExpiry()
                + FILE_SEPARATOR + getRemark());
    }

    @Override
    public String editParameterInstructions() {
        return super.editParameterInstructions() + SEPARATOR + EXPIRY_ATTRIBUTE + SEPARATOR
                + REMARK_ATTRIBUTE;
    }

    @Override
    public String getTypeIcon() {
        return CRYPTO_ICON;
    }

    @Override
    public String getAllParams() {
        return super.getAllParams()
                + EXPIRY_FIELD + formatExpiry() + System.lineSeparator()
                + REMARKS_FIELD + remark;
    }

    @Override
    public HashSet<String> getValidAttribute() {
        super.getValidAttribute();
        validAttribute.add(EXPIRY_ATTRIBUTE);
        return validAttribute;
    }
}
