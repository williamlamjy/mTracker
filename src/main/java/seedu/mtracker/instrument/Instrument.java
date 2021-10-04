package seedu.mtracker.instrument;

public abstract class Instrument {
    protected String description;
    protected double currentPrice;
    protected String sentiment;
    public Instrument(String description, double currentPrice, String sentiment){
        this.description = description;
        this.currentPrice = currentPrice;
        this.sentiment = sentiment;
    }

    public String getDescription() {
        return description;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public abstract String toString();
}
