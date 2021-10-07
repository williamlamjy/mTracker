package seedu.mtracker.console;

import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.commands.ListCommand;
import seedu.mtracker.ui.TextUi;

import java.util.Scanner;

public abstract class InputParser {

    public static final String SEPARATOR = " ";

    public static final String POSITIVE_SENTIMENT = "positive";
    public static final String NEUTRAL_SENTIMENT = "neutral";
    public static final String NEGATIVE_SENTIMENT = "negative";

    public static final int MAIN_COMMAND_INDEX = 0;

    protected static Scanner inputScanner = new Scanner(System.in);

    public static String getUserInput() {
        return inputScanner.nextLine().trim();
    }

    public static AddInstrumentCommand getAddInstrumentParameters() {
        TextUi.displayAddInstrumentFirstInstruction();
        String addInstrumentType = getUserInput();
        return AddInstrumentParser.filterByInstrumentType(getCommandComponents(addInstrumentType));
    }

    // Todo: Create a new command type to handle and unrecognised command type in default branch
    public static Command filterByCommandType(String[] commandComponents) {
        Command command;
        switch (commandComponents[MAIN_COMMAND_INDEX]) {
        case ListCommand.COMMAND_WORD:
            command = new ListCommand();
            break;
        case AddInstrumentCommand.COMMAND_WORD:
            command = getAddInstrumentParameters();
            break;
        default:
            command = new ExitCommand();
            break;
        }
        return command;
    }

    public static String[] getCommandComponents(String commandInput) {
        return commandInput.trim().split(SEPARATOR);
    }
}
