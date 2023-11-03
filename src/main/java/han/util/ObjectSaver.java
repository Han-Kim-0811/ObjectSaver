package han.util;

/**
 * Utility class with the following functionality.
 * Save the field's state of a Java object to a YAML save file.
 * Load the field's state of a Java object from a YAML save file.
 *
 * @author Han Kim
 * @version 2023-11-02
 */
public final class ObjectSaver {
    /**
     * Constructor of this class.
     * Blocked from accessing.
     *
     * @throws AssertionError if it is ever called.
     */
    private ObjectSaver() {
        throw new AssertionError("Utility class \"ObjectSaver\" cannot be instantiated.");
    }

    /**
     * Save the field's state of a Java object to a YAML save file.
     *
     * @param obj is the Object to save.
     * @param path is the path of the YAML save file.
     */
    public static void save(Object obj, String path) {
        //TODO: implement the save function for basic objects with primitive type fields.
    }

    /**
     * Load the field's state of a Java object from a YAML save file.
     *
     * @param obj is the Object to save.
     * @param path is the path of the YAML save file.
     */
    public static void load(Object obj, String path) {
        //TODO: implement the load function for basic objects with primitive type fields.
    }
}