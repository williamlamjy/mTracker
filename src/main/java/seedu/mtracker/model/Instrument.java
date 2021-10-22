package seedu.mtracker.model;

public abstract class Instrument {

    public static final String DATE_REGEX = "MMM dd yyyy";

    protected String name;
    protected double currentPrice;
    protected String sentiment;

    protected static final String FILE_SEPARATOR = ";";

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
}
