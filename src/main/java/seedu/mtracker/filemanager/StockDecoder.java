package seedu.mtracker.filemanager;

import seedu.mtracker.error.fileerror.InvalidRemarksInFileError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.model.subinstrument.Stock;
import seedu.mtracker.ui.TextUi;

public class StockDecoder extends InstrumentDecoder {

    public static final int STOCK_REMARKS_INDEX = 5;
    protected static String decodedRemarks;

    public static String getRemarksFromFile(String[] textSegment) throws InvalidRemarksInFileError {
        String remarks;
        try {
            remarks = textSegment[STOCK_REMARKS_INDEX];
        } catch (IllegalArgumentException e) {
            throw new InvalidRemarksInFileError();
        }
        return remarks;
    }

    public static void validateAndDecodeSpecificAttributes(String[] textSegment) throws InvalidRemarksInFileError {
        String remarks = getRemarksFromFile(textSegment);
        decodeSpecificAttributes(remarks);
    }

    private static void decodeSpecificAttributes(String remarks) {
        decodedRemarks = remarks;
    }

    public static void tryValidateAndDecodeSpecificAttributes(String[] textSegment) {
        try {
            validateAndDecodeSpecificAttributes(textSegment);
        } catch (Exception e) {
            TextUi.showErrorMessage(e);
        }
    }

    public static void addStockToList(String[] textSegment, InstrumentManager instrumentManager) {
        tryValidateAndDecodeGeneralAttributes(textSegment);
        tryValidateAndDecodeSpecificAttributes(textSegment);
        Instrument stock = createDecodedInstrument();
        setDoneStatus(decodedIsDone, stock);
        instrumentManager.addInstrument(stock);
    }

    private static Instrument createDecodedInstrument() {
        Instrument stock = new Stock(decodedName, decodedCurrPrice, decodedSentiment, decodedRemarks);
        return stock;
    }

}
