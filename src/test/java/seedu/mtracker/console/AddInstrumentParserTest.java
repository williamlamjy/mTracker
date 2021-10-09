package seedu.mtracker.console;

import org.junit.jupiter.api.Test;

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
        assertTrue(AddInstrumentParser.isValidName(validTestName, validTestInstrument));
    }

    @Test
    void addName_emptyName_expectFailure() {
        assertFalse(AddInstrumentParser.isValidName(emptyInput, validTestInstrument));
    }

    @Test
    void addCurrentPrice_validNumber_expectSuccess() {
        assertTrue(AddInstrumentParser.isValidPrice(validPrice));
    }

    @Test
    void addCurrentPrice_invalidNumber_expectFailure() {
        assertFalse(AddInstrumentParser.isValidPrice(invalidPrice));
    }

    @Test
    void addCurrentPrice_emptyNumber_expectFailure() {
        assertFalse(AddInstrumentParser.isValidPrice(emptyInput));
    }

    @Test
    void addSentiment_validSentiment_expectSuccess() {
        Arrays.stream(validSentiments)
                .forEach((sentiment) -> assertTrue(AddInstrumentParser.isValidSentiment(sentiment)));
    }

    @Test
    void addSentiment_invalidSentiment_expectFailure() {
        assertFalse(AddInstrumentParser.isValidSentiment(invalidSentiment));
    }

    @Test
    void addSentiment_emptySentiment_expectFailure() {
        assertFalse(AddInstrumentParser.isValidSentiment(emptyInput));
    }
}
