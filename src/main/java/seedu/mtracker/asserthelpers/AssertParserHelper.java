package seedu.mtracker.asserthelpers;

import java.util.ArrayList;

public abstract class AssertParserHelper {

    public static final int NUM_GENERAL_PARAMETERS = 3;
    public static final String MISSING_GENERAL_PARAMETERS = "There are missing general parameters";
    public static final int NUM_STOCK_PARAMETERS = 4;
    public static final String MISSING_STOCK_PARAMETERS = "There are missing stock parameters";

    public static final int MINIMUM_PRICE = 0;
    public static final String NEGATIVE_PRICE = "Price recorded is negative";

    public static final String EMPTY_STRING_INPUT = "Parameter is found to be empty when it shouldn't";

    public static void assertPriceNonNegative(String price) {
        assert Double.parseDouble(price) >= MINIMUM_PRICE : NEGATIVE_PRICE;
    }

    public static void assertNoMissingGeneralParameters(ArrayList<String> parameters) {
        assert parameters.size() == NUM_GENERAL_PARAMETERS : MISSING_GENERAL_PARAMETERS;
    }

    public static void assertNoMissingStockParameters(ArrayList<String> stockParameters) {
        assert stockParameters.size() == NUM_STOCK_PARAMETERS : MISSING_STOCK_PARAMETERS;
    }

    public static void assertInputNotEmpty(String param) {
        assert !param.isEmpty() : EMPTY_STRING_INPUT;
    }
}
