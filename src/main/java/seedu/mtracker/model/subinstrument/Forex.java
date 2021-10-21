package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Forex extends Instrument {
    protected double entryPrice;
    protected double exitPrice;
    protected LocalDate expiry;
    protected String remark;

    private static final String FX_ICON = "F";
    protected static final String TYPE_INSTRUMENT = "Forex";
    protected static final String ENTRY_PRICE_HEADER = "Entry Price: ";
    protected static final String EXIT_PRICE_HEADER = "Exit Price: ";

    public Forex(
            String name,
            double currentPrice,
            String sentiment,
            double entryPrice,
            double exitPrice,
            LocalDate expiry,
            String remark
    ) {
        super(name, currentPrice, sentiment);
        this.entryPrice = entryPrice;
        this.exitPrice = exitPrice;
        this.expiry = expiry;
        this.remark = remark;

    }

    public double getEntryPrice() {
        return entryPrice;
    }

    public double getExitPrice() {
        return exitPrice;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public String formatExpiry() {
        return expiry.format(DateTimeFormatter.ofPattern(DATE_REGEX));
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return TextUi.createBoxDisplay(FX_ICON) + getName();
    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    @Override
    public String textFileFormatting() {
        return String.format(super.textFileFormatting() + FILE_SEPARATOR + getEntryPrice()
                + FILE_SEPARATOR + getExitPrice() + FILE_SEPARATOR + getExpiry()
                + FILE_SEPARATOR + getRemark());
    }

    @Override
    public String toList() {
        return super.toList()
                + System.lineSeparator() + ENTRY_PRICE_HEADER + getEntryPrice()
                + System.lineSeparator() + EXIT_PRICE_HEADER + getExitPrice()
                + System.lineSeparator() + EXPIRY_HEADER + formatExpiry()
                + System.lineSeparator() + REMARKS_HEADER + getRemark();
    }
}
