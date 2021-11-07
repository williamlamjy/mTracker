package seedu.mtracker.asserthelpers;

import java.time.LocalDate;
import java.util.ArrayList;

//@@author theodorekwok
/**
 * The helper class that contains all assertions related parser classes.
 */
public abstract class AssertParserHelper {

    public static final int NUM_GENERAL_PARAMETERS = 3;
    public static final String MISSING_GENERAL_PARAMETERS = "There are missing general parameters";

    public static final int NUM_STOCK_PARAMETERS = 4;
    public static final String MISSING_STOCK_PARAMETERS = "There are missing stock parameters";

    public static final int NUM_CRYPTO_PARAMETERS = 5;
    public static final String MISSING_CRYPTO_PARAMETERS = "There are missing crypto parameters";

    public static final int NUM_FX_PARAMETERS = 7;
    public static final String MISSING_FX_PARAMETERS = "There are missing forex parameters";

    public static final int NUM_ETF_PARAMETERS = 5;
    public static final String MISSING_ETF_PARAMETERS = "There are missing Etf parameters";

    public static final int MINIMUM_PRICE = 0;
    public static final String NEGATIVE_PRICE = "Price recorded is negative";

    public static final String EMPTY_STRING_INPUT = "Parameter is found to be empty when it should not be";

    public static final String INVALID_EXPIRY = "Expiry date is set to the past when it should not be";

    /**
     * Asserts that the price after parsing is not negative.
     *
     * @param price The price obtained after parsing the user price input.
     */
    public static void assertPriceNonNegative(String price) {
        assert Double.parseDouble(price) >= MINIMUM_PRICE : NEGATIVE_PRICE;
    }

    /**
     * Asserts that the number of general parameters that is collected after parsing is correct.
     *
     * @param parameters The arraylist that contains the general instrument parameters after parsing user inputs.
     */
    public static void assertNoMissingGeneralParameters(ArrayList<String> parameters) {
        assert parameters.size() == NUM_GENERAL_PARAMETERS : MISSING_GENERAL_PARAMETERS;
    }

    /**
     * Asserts that the number of stock parameters that is collected after parsing is correct.
     *
     * @param stockParameters The arraylist that contains the stock instrument parameters after parsing user inputs.
     */
    public static void assertNoMissingStockParameters(ArrayList<String> stockParameters) {
        assert stockParameters.size() == NUM_STOCK_PARAMETERS : MISSING_STOCK_PARAMETERS;
    }

    //@@author
    /**
     * Asserts that the number of crypto parameters that is collected after parsing is correct.
     *
     * @param cryptoParameters The arraylist that contains the crypto instrument parameters after parsing user inputs.
     */
    public static void assertNoMissingCryptoParameters(ArrayList<String> cryptoParameters) {
        assert cryptoParameters.size() == NUM_CRYPTO_PARAMETERS : MISSING_CRYPTO_PARAMETERS;
    }

    /**
     * Asserts that the number of forex parameters that is collected after parsing is correct.
     *
     * @param forexParameters The arraylist that contains the forex instrument parameters after parsing user inputs.
     */
    public static void assertNoMissingForexParameters(ArrayList<String> forexParameters) {
        assert forexParameters.size() == NUM_FX_PARAMETERS : MISSING_FX_PARAMETERS;
    }

    /**
     * Asserts that the number of etf parameters that is collected after parsing is correct.
     *
     * @param etfParameters The arraylist that contains the etf instrument parameters after parsing user inputs.
     */
    public static void assertNoMissingEtfParameters(ArrayList<String> etfParameters) {
        assert etfParameters.size() == NUM_ETF_PARAMETERS : MISSING_ETF_PARAMETERS;
    }

    //@@author theodorekwok
    /**
     * Asserts that the input parsed is not empty.
     *
     * @param param The parameter that has been parsed after user input.
     */
    public static void assertInputNotEmpty(String param) {
        assert !param.isEmpty() : EMPTY_STRING_INPUT;
    }

    /**
     * Asserts that the date parsed is in the future.
     *
     * @param dateParam The date parameter that is parsed after user input.
     */
    public static void assertExpiryInTheFuture(String dateParam) {
        LocalDate dateGiven = LocalDate.parse(dateParam);
        assert dateGiven.isAfter(LocalDate.now()) || dateGiven.isEqual(LocalDate.now()) : INVALID_EXPIRY;
    }
}
