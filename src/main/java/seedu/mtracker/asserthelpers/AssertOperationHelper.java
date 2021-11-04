package seedu.mtracker.asserthelpers;

public abstract class AssertOperationHelper {
    private static final String EDIT_PROCESS = "edit";
    private static final String ADD_PROCESS = "add";

    public static final String NOT_IN_ADD_OR_EDIT = "Program is currently neither in ADD "
            + "nor EDIT workspaces.";

    public static final String NOT_IN_ADD = "Program is not in ADD workspace when it should be.";

    public static void assertAddEditOperation(String workspace) {
        assert workspace.equals(ADD_PROCESS) || workspace.equals(EDIT_PROCESS) : NOT_IN_ADD_OR_EDIT;
    }

    public static void assertIsAddOperation(String workspace) {
        assert workspace.equals(ADD_PROCESS) : NOT_IN_ADD;
    }
}
