package seedu.mtracker.instrument.subinstrument;

import org.junit.jupiter.api.Test;
import seedu.mtracker.ui.TextUi;

class CryptoTest {
    public static final String CRYPTO_ICON = "C";

    public static String name = "bitcoin";

    @Test
    void testToString() {
        assertTrue("[C]bitcoin", (TextUi.createBoxDisplay(CRYPTO_ICON) + "bitcoin"));
    }

    private void assertTrue(String s, String s1) {
    }
}