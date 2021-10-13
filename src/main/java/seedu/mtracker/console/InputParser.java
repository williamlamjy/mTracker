package seedu.mtracker.console;

import seedu.mtracker.LogHelper;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.commands.ListCommand;
import seedu.mtracker.error.InvalidCommandError;
import seedu.mtracker.error.InvalidInstrumentError;
import seedu.mtracker.ui.TextUi;

import java.util.Scanner;
import java.util.logging.Logger;

public class InputParser {

    public static final String SEPARATOR = " ";

    public static final String POSITIVE_SENTIMENT = "positive";
    public static final String NEUTRAL_SENTIMENT = "neutral";
    public static final String NEGATIVE_SENTIMENT = "negative";

    protected static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static final int MAIN_COMMAND_INDEX = 0;

    protected static Scanner inputScanner;

    public InputParser() {
        inputScanner = new Scanner(System.in);
    }

    public static String getUserInput() {
        TextUi.displayPrompter();
        return inputScanner.nextLine().trim();
    }

    public AddInstrumentCommand getAddInstrumentParameters() throws InvalidInstrumentError {
        TextUi.displayAddInstrumentFirstInstruction();
        String addInstrumentType = getUserInput();
        return AddInstrumentParser.filterByInstrumentType(getCommandComponents(addInstrumentType));
    }

    public Command filterByCommandType(String[] commandComponents) throws Exception {
        Command command;
        switch (commandComponents[MAIN_COMMAND_INDEX]) {
        case ListCommand.COMMAND_WORD:
            command = new ListCommand();
            break;
        case AddInstrumentCommand.COMMAND_WORD:
            command = getAddInstrumentParameters();
            break;
        case ExitCommand.COMMAND_WORD:
            command = new ExitCommand();
            break;
        default:
            logger.info(LogHelper.LOG_INVALID_COMMAND);
            throw new InvalidCommandError();
        }
        return command;
    }

    public String[] getCommandComponents(String commandInput) {
        return commandInput.trim().split(SEPARATOR);
    }
}
