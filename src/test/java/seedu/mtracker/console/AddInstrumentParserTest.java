package seedu.mtracker.console;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AddInstrumentParserTest {

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

    public static String validTestInstrument = "testInstrument";

    @Test
    void addName_validName_expectSuccess() {
        assertTrue(AddInstrumentParser.isValidName(VALID_TEST_NAME, validTestInstrument));
    }

    @Test
    void addName_emptyName_expectFailure() {
        assertFalse(AddInstrumentParser.isValidName(EMPTY_INPUT, validTestInstrument));
    }

    @Test
    void addCurrentPrice_validNumber_expectSuccess() {
        assertTrue(AddInstrumentParser.isValidPrice(VALID_PRICE));
    }

    @Test
    void addCurrentPrice_invalidNumber_expectFailure() {
        assertFalse(AddInstrumentParser.isValidPrice(INVALID_PRICE));
    }

    @Test
    void addCurrentPrice_emptyNumber_expectFailure() {
        assertFalse(AddInstrumentParser.isValidPrice(EMPTY_INPUT));
    }

    @Test
    void addSentiment_validSentiment_expectSuccess() {
        Arrays.stream(VALID_SENTIMENTS)
                .forEach((sentiment) -> assertTrue(AddInstrumentParser.isValidSentiment(sentiment)));
    }

    @Test
    void addSentiment_invalidSentiment_expectFailure() {
        assertFalse(AddInstrumentParser.isValidSentiment(INVALID_SENTIMENT));
    }

    @Test
    void addSentiment_emptySentiment_expectFailure() {
        assertFalse(AddInstrumentParser.isValidSentiment(EMPTY_INPUT));
    }

    @Test
    void addExpiry_validExpiryInFutre_expectSuccess() {
        assertTrue(AddInstrumentParser.isValidExpiry(FUTURE_DATE.toString()));
    }

    @Test
    void addExpiry_emptyExpiry_expectFailure() {
        assertFalse(AddInstrumentParser.isValidExpiry(EMPTY_INPUT));
    }

    @Test
    void addExpiry_invalidExpiry_expectFailure() {
        assertFalse(AddInstrumentParser.isValidExpiry(INVALID_EXPIRY));
    }

    @Test
    void addExpiry_validExpiryButIsInPast_expectFailure() {
        assertFalse(AddInstrumentParser.isValidExpiry(PAST_DATE.toString()));
    }
}
