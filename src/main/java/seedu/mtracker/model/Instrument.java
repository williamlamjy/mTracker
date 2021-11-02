package seedu.mtracker.model;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Instrument {

    public static final String DATE_REGEX = "MMM dd yyyy";
    public static final String SEMICOLON_SEP = "; ";
    public static final String SPACE = " ";

    protected String name;
    protected double currentPrice;
    protected String sentiment;
    protected boolean isDone;

    protected static final String TAB = "\t";
    protected static final int ASCII_CODE = 127;
    protected static final char FILE_SEPARATOR = (char)ASCII_CODE;
    protected static final String DONE_SYMBOL = "[X]";
    protected static final String NOT_DONE_SYMBOL = "[ ]";
    protected static HashSet<String> validAttribute;

    protected static final String NAME_ATTRIBUTE = "name";
    protected static final String CURRENT_PRICE_ATTRIBUTE = "current-price";
    protected static final String SENTIMENT_ATTRIBUTE = "sentiment";
    protected static final String REMARK_ATTRIBUTE = "remarks";
    protected static final String DONE_ATTRIBUTE = "undone";
    protected static final String SEPARATOR = ", ";
    protected static final String REMARKS_FIELD = "Remarks: ";

    private static final String TYPE_FIELD = "Type: ";
    private static final String NAME_FIELD = "Name: ";
    private static final String CURRENT_PRICE_FIELD = "Current Price: ";
    private static final String SENTIMENT_FIELD = "Sentiment: ";


    public Instrument(String name, double currentPrice, String sentiment) {
        this.name = name;
        this.currentPrice = currentPrice;
        this.sentiment = sentiment;
        this.isDone = false;
        validAttribute = new HashSet<>();
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsNotDone() {
        isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? DONE_SYMBOL : NOT_DONE_SYMBOL);
    }

    public String getName() {
        return name;
    }

    public void setName(String inputName) {
        name = inputName;
    }

    public void setCurrentPrice(double inputCurrentPrice) {
        currentPrice = inputCurrentPrice;
    }

    public void setSentiment(String inputSentiment) {
        sentiment = inputSentiment;
    }

    public void editName(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(NAME_ATTRIBUTE)) {
            return;
        }
        setName(editedParameters.get(NAME_ATTRIBUTE));
    }

    public void editDoneStatus(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(DONE_ATTRIBUTE)) {
            return;
        }
        markAsNotDone();
    }

    public void editCurrentPrice(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(CURRENT_PRICE_ATTRIBUTE)) {
            return;
        }
        double updatedPrice = Double.parseDouble(editedParameters.get(CURRENT_PRICE_ATTRIBUTE));
        setCurrentPrice(updatedPrice);
    }

    public void editSentiment(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(SENTIMENT_ATTRIBUTE)) {
            return;
        }
        setSentiment(editedParameters.get(SENTIMENT_ATTRIBUTE));
    }

    public void editGeneralParameter(HashMap<String, String> editedParameters) {
        editName(editedParameters);
        editCurrentPrice(editedParameters);
        editSentiment(editedParameters);
        editDoneStatus(editedParameters);
    }

    public void editParameter(HashMap<String, String> editedParameters) {
        editGeneralParameter(editedParameters);
    }

    public abstract String getType();

    public String textFileFormatting() {
        return getType() + FILE_SEPARATOR + name + FILE_SEPARATOR
                + currentPrice + FILE_SEPARATOR + sentiment + FILE_SEPARATOR
                + isDone;
    }

    public String editParameterInstructions() {
        return DONE_ATTRIBUTE + SEPARATOR
                + NAME_ATTRIBUTE + SEPARATOR
                + CURRENT_PRICE_ATTRIBUTE + SEPARATOR
                + SENTIMENT_ATTRIBUTE;
    }

    public abstract String getTypeIcon();

    public String getAllParams() {
        return TYPE_FIELD + getType() + TAB + getStatusIcon() + System.lineSeparator()
                + NAME_FIELD + name + System.lineSeparator()
                + CURRENT_PRICE_FIELD + currentPrice + System.lineSeparator()
                + SENTIMENT_FIELD + sentiment + System.lineSeparator();
    }

    public String getGeneralParams() {
        return getTypeIcon() + getStatusIcon()
                + SPACE + name + SEMICOLON_SEP + currentPrice + SEMICOLON_SEP + sentiment;
    }
    
    public HashSet<String> getValidAttribute() {
        validAttribute.add(NAME_ATTRIBUTE);
        validAttribute.add(CURRENT_PRICE_ATTRIBUTE);
        validAttribute.add(SENTIMENT_ATTRIBUTE);
        validAttribute.add(REMARK_ATTRIBUTE);
        validAttribute.add(DONE_ATTRIBUTE);
        return validAttribute;
    }
}
