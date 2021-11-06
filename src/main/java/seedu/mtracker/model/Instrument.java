package seedu.mtracker.model;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Represents an instrument in the InstrumentManager.
 * Contains common instrument parameters.
 */
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
    protected static final char FILE_SEPARATOR = (char) ASCII_CODE;
    protected static final String DONE_SYMBOL = "[X]";
    protected static final String NOT_DONE_SYMBOL = "[ ]";
    protected static HashSet<String> validAttribute;

    protected static final String NAME_ATTRIBUTE = "name";
    protected static final String CURRENT_PRICE_ATTRIBUTE = "current-price";
    protected static final String SENTIMENT_ATTRIBUTE = "sentiment";
    protected static final String REMARK_ATTRIBUTE = "remarks";
    protected static final String DONE_ATTRIBUTE = "done-status";
    protected static final String SEPARATOR = ", ";
    protected static final String DONE_INDICATOR = "done";
    protected static final String UNDONE_INDICATOR = "undone";
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

    /**
     * Sets instrument as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Sets instrument as not done.
     */
    public void markAsNotDone() {
        isDone = false;
    }

    /**
     * Gets the icon representing the done status of the instrument.
     *
     * @return DONE_SYMBOL if instrument is marked as done and NOT_DONE_SYMBOL if instrument is not marked as done.
     */
    public String getStatusIcon() {
        return (isDone ? DONE_SYMBOL : NOT_DONE_SYMBOL);
    }

    public String getName() {
        return name;
    }

    //@@author kum-wh
    public void setName(String inputName) {
        name = inputName;
    }

    public void setCurrentPrice(double inputCurrentPrice) {
        currentPrice = inputCurrentPrice;
    }

    public void setSentiment(String inputSentiment) {
        sentiment = inputSentiment;
    }

    /**
     * Sets name parameter to the new name if name parameter is being edited.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editName(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(NAME_ATTRIBUTE)) {
            return;
        }
        setName(editedParameters.get(NAME_ATTRIBUTE));
    }

    /**
     * Sets done status parameter to the new status if done status parameter is being edited.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editDoneStatus(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(DONE_ATTRIBUTE)) {
            return;
        }
        if (editedParameters.get(DONE_ATTRIBUTE).equals(DONE_INDICATOR)) {
            markAsDone();
            return;
        }
        markAsNotDone();
        assert (editedParameters.get(DONE_ATTRIBUTE).equals(UNDONE_INDICATOR));
    }

    /**
     * Sets current price parameter to the new price if current price parameter is being edited.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editCurrentPrice(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(CURRENT_PRICE_ATTRIBUTE)) {
            return;
        }
        double updatedPrice = Double.parseDouble(editedParameters.get(CURRENT_PRICE_ATTRIBUTE));
        setCurrentPrice(updatedPrice);
    }

    /**
     * Sets sentiment parameter to the new sentiment if sentiment parameter is being edited.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editSentiment(HashMap<String, String> editedParameters) {
        if (!editedParameters.containsKey(SENTIMENT_ATTRIBUTE)) {
            return;
        }
        setSentiment(editedParameters.get(SENTIMENT_ATTRIBUTE));
    }

    /**
     * Sets name, current price, sentiment and done status to its respective new values, if parameters is being edited.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editGeneralParameter(HashMap<String, String> editedParameters) {
        editName(editedParameters);
        editCurrentPrice(editedParameters);
        editSentiment(editedParameters);
        editDoneStatus(editedParameters);
    }

    /**
     * Sets all the parameters being edited to its new values.
     *
     * @param editedParameters HashMap containing parameters to edit and the new values.
     */
    public void editParameter(HashMap<String, String> editedParameters) {
        editGeneralParameter(editedParameters);
    }

    //@@author
    public abstract String getType();

    /**
     * Formats all the parameters of the instrument to save to text file.
     *
     * @return A formatted string to save to text file.
     */
    public String textFileFormatting() {
        return getType().toLowerCase() + FILE_SEPARATOR + name + FILE_SEPARATOR
                + currentPrice + FILE_SEPARATOR + sentiment + FILE_SEPARATOR
                + isDone;
    }

    //@@ author kum-wh
    /**
     * Gets all the type of parameters in the instrument in one string.
     *
     * @return A string containing all the type of parameters of the instrument.
     */
    public String editParameterInstructions() {
        return DONE_ATTRIBUTE + SEPARATOR
                + NAME_ATTRIBUTE + SEPARATOR
                + CURRENT_PRICE_ATTRIBUTE + SEPARATOR
                + SENTIMENT_ATTRIBUTE;
    }

    //@@author
    public abstract String getTypeIcon();

    /**
     * Gets all the parameters of the instrument, with each parameter on a newline.
     *
     * @return A string containing all parameters of the instrument.
     */
    public String getAllParams() {
        return TYPE_FIELD + getType() + TAB + getStatusIcon() + System.lineSeparator()
                + NAME_FIELD + name + System.lineSeparator()
                + CURRENT_PRICE_FIELD + currentPrice + System.lineSeparator()
                + SENTIMENT_FIELD + sentiment + System.lineSeparator();
    }

    /**
     * Gets the done status, name, current price and sentiment parameters of the instrument.
     *
     * @return A string containing the general parameters of the instrument.
     */
    public String getGeneralParams() {
        return getTypeIcon() + getStatusIcon()
                + SPACE + name + SEMICOLON_SEP + currentPrice + SEMICOLON_SEP + sentiment;
    }

    //@@author kum-wh
    /**
     * Adds all the type of parameters in an instrument into a HashSet.
     *
     * @return HashSet containing the type of parameters of the instrument.
     */
    public HashSet<String> getValidAttribute() {
        validAttribute.add(NAME_ATTRIBUTE);
        validAttribute.add(CURRENT_PRICE_ATTRIBUTE);
        validAttribute.add(SENTIMENT_ATTRIBUTE);
        validAttribute.add(REMARK_ATTRIBUTE);
        validAttribute.add(DONE_ATTRIBUTE);
        return validAttribute;
    }
}
