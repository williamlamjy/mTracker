package seedu.mtracker.asserthelpers;

public abstract class AssertCommandHelpers {

    public static final String INDEX_OUT_OF_BOUNDS = "Index is out of bounds when it should not be";

    public static void assertIndexWithinBounds(int size, int index) {
        assert index >= 0 && index < size : INDEX_OUT_OF_BOUNDS;
    }
}
