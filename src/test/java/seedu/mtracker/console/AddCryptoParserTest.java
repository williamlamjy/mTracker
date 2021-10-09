package seedu.mtracker.console;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddCryptoParserTest {
    public static String emptyInput = "";
    public static String validRemark = "volatile prices";
    public static String validExpiry = "sell at 21st October";

    @Test
    void addCryptoExpiry_validExpiry_expectSuccess() {
        assertTrue(AddCryptoParser.isValidSpecificParameter(validExpiry));
    }

    @Test
    void addCryptoExpiry_emptyInput_expectFailure() {
        assertFalse(AddCryptoParser.isValidSpecificParameter(emptyInput));
    }

    @Test
    void addCryptoRemarks_validRemark_expectSuccess() {
        assertTrue(AddCryptoParser.isValidSpecificParameter(validRemark));
    }

    @Test
    void addCryptoRemarks_emptyInput_expectFailure() {
        assertFalse(AddCryptoParser.isValidSpecificParameter(emptyInput));
    }

}