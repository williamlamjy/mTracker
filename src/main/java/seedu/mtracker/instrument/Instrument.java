package seedu.mtracker.instrument;

public abstract class Instrument {

    protected String name;
    protected double currentPrice;
    protected String sentiment;

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
}
