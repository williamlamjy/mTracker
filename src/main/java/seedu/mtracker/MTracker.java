package seedu.mtracker;

import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.commands.InvalidCommand;
import seedu.mtracker.console.InputParser;
import seedu.mtracker.filemanager.Storage;
import seedu.mtracker.model.InstrumentManager;
import seedu.mtracker.ui.TextUi;

import java.util.logging.Level;

/**
 * Main class responsible for the running of the whole mTracker application.
 */
public class MTracker {
    private Storage storage;
    private InstrumentManager instrumentManager;
    private InputParser parser;
    private LogHelper logger;

    private static final String MAIN_WORKSPACE = "main";

    public MTracker() {
        try {
            logger = LogHelper.getInstance();
            storage = new Storage();
            instrumentManager = InstrumentManager.getInstance();
            parser = new InputParser();
            storage.loadFileData(instrumentManager);
        } catch (Exception e) {
            TextUi.showErrorMessage(e);
            System.exit(-1);
        }
    }

    // @@KVignesh122
    /**
     * Runs the overall logic of the program. Methods takes in user input command
     * and does the necessary execution, continuously until the user exits program.
     */
    public void run() {
        Command command;
        String userInput;
        String[] commandComponents;

        do {
            userInput = InputParser.getUserInput(MAIN_WORKSPACE);
            commandComponents = parser.getCommandComponents(userInput);
            try {
                command = parser.filterByCommandType(commandComponents, instrumentManager.getInstruments());
                command.setData(instrumentManager);
                command.execute();
                storage.updateFileData(instrumentManager.getInstruments());
            } catch (Exception e) {
                logger.getLogger().log(Level.WARNING, e.getMessage());
                TextUi.showErrorMessage(e);
                command = new InvalidCommand();
            }
        } while (!(command instanceof ExitCommand));
    }

    /**
     * Greets user at the start of program and runs the whole program.
     */
    public void executeProgram() {
        TextUi.greetAtStartUp();
        run();
    }

    /**
     * Constructs a new instance of MTracker and executes the program.
     * This method is the main entry-point for the mTracker application.
     */
    public static void main(String[] args) {
        new MTracker().executeProgram();
    }
}
