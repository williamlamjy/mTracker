package seedu.mtracker.console;

import org.junit.jupiter.api.Test;
import seedu.mtracker.commons.Validate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AddInstrumentParserTest {

    public static String emptyInput = "";
    public static String validTestName = "testName";
    public static String validPrice = "123.43";
    public static String invalidPrice = "32fvr";
    public static String[] validSentiments = {"positive", "neutral", "negative"};
    public static String invalidSentiment = "invalid";

    public static String validTestInstrument = "testInstrument";

    @Test
    void addName_validName_expectSuccess() {
        assertTrue(Validate.isValidName(validTestName, validTestInstrument));
    }

    @Test
    void addName_emptyName_expectFailure() {
        assertFalse(Validate.isValidName(emptyInput, validTestInstrument));
    }

    @Test
    void addCurrentPrice_validNumber_expectSuccess() {
        assertTrue(Validate.isValidPrice(validPrice));
    }

    @Test
    void addCurrentPrice_invalidNumber_expectFailure() {
        assertFalse(Validate.isValidPrice(invalidPrice));
    }

    @Test
    void addCurrentPrice_emptyNumber_expectFailure() {
        assertFalse(Validate.isValidPrice(emptyInput));
    }

    @Test
    void addSentiment_validSentiment_expectSuccess() {
        Arrays.stream(validSentiments)
                .forEach((sentiment) -> assertTrue(Validate.isValidSentiment(sentiment)));
    }

    @Test
    void addSentiment_invalidSentiment_expectFailure() {
        assertFalse(Validate.isValidSentiment(invalidSentiment));
    }

    @Test
    void addSentiment_emptySentiment_expectFailure() {
        assertFalse(Validate.isValidSentiment(emptyInput));
    }
}
