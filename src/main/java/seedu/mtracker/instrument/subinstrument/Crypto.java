package seedu.mtracker.instrument.subinstrument;

import seedu.mtracker.instrument.Instrument;

public class Crypto extends Instrument {
    protected double enterPrice;
    protected double exitPrice;
    protected static final char INSTRUMENT_ICON = 'C';

    public Crypto(String description, double currentPrice, String sentiment, double enterPrice, double exitPrice){
        super(description, currentPrice, sentiment);
        this.enterPrice = enterPrice;
        this.exitPrice = exitPrice;
    }

    public double getEnterPrice() {
        return enterPrice;
    }

    public double getExitPrice() {
        return exitPrice;
    }

    public double getCurrentPrice() {
        return super.getCurrentPrice();
    }

    @Override
    public String toString(){
        return "[" + INSTRUMENT_ICON + "]" + getDescription();
    }
}
