package seedu.mtracker.commons;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ValidateTest {

    public static final String EMPTY_INPUT = "";
    public static final String VALID_TEST_NAME = "testName";
    public static final String VALID_PRICE = "123.43";
    public static final String INVALID_PRICE = "32fvr";
    public static final String[] VALID_SENTIMENTS = {"positive", "neutral", "negative"};
    public static final String INVALID_SENTIMENT = "invalid";

    public static final String VALID_TEST_INSTRUMENT = "testInstrument";

    @Test
    void validateName_validName_expectSuccess() {
        assertTrue(Validate.isValidName(VALID_TEST_NAME, VALID_TEST_INSTRUMENT));
    }

    @Test
    void validateName_emptyName_expectFailure() {
        assertFalse(Validate.isValidName(EMPTY_INPUT, VALID_TEST_INSTRUMENT));
    }

    @Test
    void validateCurrentPrice_validNumber_expectSuccess() {
        assertTrue(Validate.isValidPrice(VALID_PRICE));
    }

    @Test
    void validateCurrentPrice_invalidNumber_expectFailure() {
        assertFalse(Validate.isValidPrice(INVALID_PRICE));
    }

    @Test
    void validateCurrentPrice_emptyNumber_expectFailure() {
        assertFalse(Validate.isValidPrice(EMPTY_INPUT));
    }

    @Test
    void validateSentiment_validSentiment_expectSuccess() {
        Arrays.stream(VALID_SENTIMENTS)
                .forEach((sentiment) -> assertTrue(Validate.isValidSentiment(sentiment)));
    }

    @Test
    void validateSentiment_invalidSentiment_expectFailure() {
        assertFalse(Validate.isValidSentiment(INVALID_SENTIMENT));
    }

    @Test
    void validateSentiment_emptySentiment_expectFailure() {
        assertFalse(Validate.isValidSentiment(EMPTY_INPUT));
    }

}
