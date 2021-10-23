package seedu.mtracker.commons;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ValidateTest {

    public static String emptyInput = "";
    public static String validTestName = "testName";
    public static String validPrice = "123.43";
    public static String invalidPrice = "32fvr";
    public static String[] validSentiments = {"positive", "neutral", "negative"};
    public static String invalidSentiment = "invalid";

    public static String validTestInstrument = "testInstrument";

    @Test
    void validateName_validName_expectSuccess() {
        assertTrue(Validate.isValidName(validTestName, validTestInstrument));
    }

    @Test
    void validateName_emptyName_expectFailure() {
        assertFalse(Validate.isValidName(emptyInput, validTestInstrument));
    }

    @Test
    void validateCurrentPrice_validNumber_expectSuccess() {
        assertTrue(Validate.isValidPrice(validPrice));
    }

    @Test
    void validateCurrentPrice_invalidNumber_expectFailure() {
        assertFalse(Validate.isValidPrice(invalidPrice));
    }

    @Test
    void validateCurrentPrice_emptyNumber_expectFailure() {
        assertFalse(Validate.isValidPrice(emptyInput));
    }

    @Test
    void validateSentiment_validSentiment_expectSuccess() {
        Arrays.stream(validSentiments)
                .forEach((sentiment) -> assertTrue(Validate.isValidSentiment(sentiment)));
    }

    @Test
    void validateSentiment_invalidSentiment_expectFailure() {
        assertFalse(Validate.isValidSentiment(invalidSentiment));
    }

    @Test
    void validateSentiment_emptySentiment_expectFailure() {
        assertFalse(Validate.isValidSentiment(emptyInput));
    }

}
