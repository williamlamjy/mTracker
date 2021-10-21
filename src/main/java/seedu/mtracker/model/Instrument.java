package seedu.mtracker.model;

import seedu.mtracker.ui.TextUi;

public abstract class Instrument {

    protected String name;
    protected double currentPrice;
    protected String sentiment;
    protected boolean isDone;

    private static final String TYPE_HEADER = "Type: ";
    private static final String NAME_HEADER = "Name: ";
    private static final String CURRENT_PRICE_HEADER = "Current Price: ";
    private static final String SENTIMENT_HEADER = "Sentiment: ";
    protected static final String EXPIRY_HEADER = "Expiry: ";
    protected static final String REMARKS_HEADER = "Remarks: ";
    protected static final String EMPTY_STRING = "";
    protected static final String FILE_SEPARATOR = ";";
    protected static final String DONE_SYMBOL = "X";
    protected static final String NOT_DONE_SYMBOL = " ";

    public Instrument(String name, double currentPrice, String sentiment) {
        this.name = name;
        this.currentPrice = currentPrice;
        this.sentiment = sentiment;
        this.isDone = false;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    public String getStatusIcon() {
        return (getIsDone() ? DONE_SYMBOL : NOT_DONE_SYMBOL);
    }

    public String getName() {
        return name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public String getSentiment() {
        return sentiment;
    }

    public abstract String toString();

    public abstract String getType();

    public String textFileFormatting() {
        return String.format(getType() + FILE_SEPARATOR + getName() + FILE_SEPARATOR
                + getCurrentPrice() + FILE_SEPARATOR + getSentiment() + FILE_SEPARATOR
                + getIsDone());
    }

    public String toList() {
        return TYPE_HEADER + getType() + TextUi.createBoxDisplay(getStatusIcon())
                + System.lineSeparator() + NAME_HEADER + getName() + System.lineSeparator()
                + CURRENT_PRICE_HEADER + getCurrentPrice() + System.lineSeparator()
                + SENTIMENT_HEADER + getSentiment();
    }
}
