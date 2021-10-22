package seedu.mtracker.model;

public abstract class Instrument {

    protected String name;
    protected double currentPrice;
    protected String sentiment;
    protected boolean isDone;

    protected static final String EMPTY_STRING = "";
    protected static final String FILE_SEPARATOR = ";";
    protected static final String DONE_SYMBOL = "X";
    protected static final String NOT_DONE_SYMBOL = " ";
    protected static final String OPENING_BRACKET = "[";
    protected static final String CLOSING_BRACKET = "]";

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

    public abstract String getType();

    public String textFileFormatting() {
        return String.format(getType() + FILE_SEPARATOR + getName() + FILE_SEPARATOR
                + getCurrentPrice() + FILE_SEPARATOR + getSentiment() + FILE_SEPARATOR
                + getIsDone());
    }

    public abstract String getIcon();
}
