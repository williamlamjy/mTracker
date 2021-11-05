package seedu.mtracker.commons;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateTest {

    public static final String EMPTY_INPUT = "";
    public static final String VALID_TEST_NAME = "testName";
    public static final String VALID_PRICE = "123.43";
    public static final String INVALID_PRICE = "32fvr";
    public static final String[] VALID_SENTIMENTS = {"positive", "neutral", "negative"};
    public static final String INVALID_SENTIMENT = "invalid";
    public static final String INVALID_EXPIRY = "18 Oct";
    public static final int DAYS_DIFFERENCE = 1;
    public static final LocalDate FUTURE_DATE = LocalDate.now().plusDays(DAYS_DIFFERENCE);
    public static final LocalDate PAST_DATE = LocalDate.now().minusDays(DAYS_DIFFERENCE);

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

    //@@author theodorekwok
    @Test
    void addExpiry_validExpiryInFuture_expectSuccess() {
        assertTrue(Validate.isValidExpiry(FUTURE_DATE.toString()));
    }

    @Test
    void addExpiry_emptyExpiry_expectFailure() {
        assertFalse(Validate.isValidExpiry(EMPTY_INPUT));
    }

    @Test
    void addExpiry_invalidExpiry_expectFailure() {
        assertFalse(Validate.isValidExpiry(INVALID_EXPIRY));
    }

    @Test
    void addExpiry_validExpiryButIsInPast_expectFailure() {
        assertFalse(Validate.isValidExpiry(PAST_DATE.toString()));
    }
}
