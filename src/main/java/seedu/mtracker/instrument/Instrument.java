package seedu.mtracker.instrument;

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
        return (getIsDone() ? "X" : " ");
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

    public String toString() {
        return TextUi.createBoxDisplay(getStatusIcon());
    }

    public abstract String getType();

    public String toList() {
        return TYPE_HEADER + TextUi.createBoxDisplay(getStatusIcon()) + getType()
                + System.lineSeparator() + NAME_HEADER + getName() + System.lineSeparator()
                + CURRENT_PRICE_HEADER + getCurrentPrice() + System.lineSeparator()
                + SENTIMENT_HEADER + getSentiment();
    }
}
