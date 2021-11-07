package seedu.mtracker.asserthelpers;

//@@author KVignesh122
/**
 * The helper class that contains all assertions related abort operation.
 */
public abstract class AssertOperationHelper {
    public static final String NOT_IN_ADD_OR_EDIT = "Program is currently neither in ADD "
            + "nor EDIT workspaces.";
    public static final String NOT_IN_ADD = "Program is not in ADD workspace when it should be.";
    private static final String EDIT_PROCESS = "edit";
    private static final String ADD_PROCESS = "add";

    /**
     * Asserts that the current workspace user is in has to be either 'add' or 'edit'.
     *
     * @param workspace A string representing the workspace the user is in.
     */
    public static void assertAddEditOperation(String workspace) {
        assert workspace.equals(ADD_PROCESS) || workspace.equals(EDIT_PROCESS) : NOT_IN_ADD_OR_EDIT;
    }

    /**
     * Asserts that current workspace has to be in 'add'.
     *
     * @param workspace A string representing the workspace the user is in.
     */
    public static void assertIsAddOperation(String workspace) {
        assert workspace.equals(ADD_PROCESS) : NOT_IN_ADD;
    }
}
