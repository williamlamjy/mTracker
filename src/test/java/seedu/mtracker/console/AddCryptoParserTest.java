package seedu.mtracker.console;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void getInstrumentParameters() {
        // this one is the user input where each input line is separated by %s, notice the space at the end for empty remark
        String input = String.format("TestName%s23.4%spositive%s18 Oct%snil%s ",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());

        // these 2 lines below simulates the console input
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);

        // these 3 lines gets the console output if any like the "Sorry name must be provided those error messages"
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        // run the method
        AddCryptoParser testCryptoParser = new AddCryptoParser();
        testCryptoParser.getInstrumentParameters();

        // below is where you see output so feel free to use below to simulate like empty names, putting empty names multiple times
        // or check that parameters are recorded exactly
        String []lines = baos.toString().split(System.lineSeparator());
        System.out.println(lines);
        System.out.println(testCryptoParser.getParameters());
    }

}