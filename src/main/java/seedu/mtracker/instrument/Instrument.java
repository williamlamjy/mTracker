package seedu.mtracker.instrument;

public abstract class Instrument {

    protected String name;
    protected double currentPrice;
    protected String sentiment;

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

    public String toList() {
        return TYPE_HEADER + getType() + System.lineSeparator()
                + NAME_HEADER + getName() + System.lineSeparator()
                + CURRENT_PRICE_HEADER + getCurrentPrice() + System.lineSeparator()
                + SENTIMENT_HEADER + getSentiment();
    }
}
