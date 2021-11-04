package seedu.mtracker.asserthelpers;

/**
 * The helper class that contains all assertions related to the command classes.
 */
public abstract class AssertCommandHelpers {

    public static final String INDEX_OUT_OF_BOUNDS = "Index is out of bounds when it should not be";

    /**
     * Asserts whether that the index that is passed to the IndexedCommand class is not out of bounds.
     *
     * @param size The number of instruments in instrumentMananger instance.
     * @param index The index that is parsed by InputParser and passed into IndexCommand.
     */
    public static void assertIndexWithinBounds(int size, int index) {
        assert index >= 0 && index < size : INDEX_OUT_OF_BOUNDS;
    }
}
