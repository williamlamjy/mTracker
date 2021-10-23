package seedu.mtracker.model;

public abstract class Instrument {
    protected String name;
    protected double currentPrice;
    protected String sentiment;

    protected static final String EMPTY_STRING = "";
    protected static final String FILE_SEPARATOR = ";";

    private static final String TYPE_FIELD = "Type: ";
    private static final String NAME_FIELD = "Name: ";
    private static final String CURRENT_PRICE_FIELD = "Current Price: ";
    private static final String SENTIMENT_FIELD = "Sentiment: ";
    protected static final String REMARKS_FIELD = "Remarks: ";


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

    public abstract String getType();

    public String textFileFormatting() {
        return String.format(getType() + FILE_SEPARATOR + getName() + FILE_SEPARATOR
                + getCurrentPrice() + FILE_SEPARATOR + getSentiment());
    }

    public abstract String getIcon();

    public String getAllParams() {

    }
}
