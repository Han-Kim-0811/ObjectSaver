package han.util;

// Reflection used to access object's field name and field value.
import java.io.File;
import java.lang.reflect.Field;

// Java IO api for file handling.
import java.io.PrintWriter;
import java.io.IOException;

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
    public static void save(Object obj, String path) throws IOException {
        PrintWriter writer = new PrintWriter(path);
        Class objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();

        writer.println("class_name: " + objClass.getName());
        writer.println("simple_name: " + objClass.getSimpleName());
        writer.println("Fields: ");

        for (Field field : fields) {
            writer.println("\t" + field.getName() + ":");
            writer.println("\t\ttype: " + field.getType().getName());
            try {
                writer.println("\t\tvalue: " + field.get(obj));
            } catch (IllegalAccessException e) {
                field.setAccessible(true);
                try {
                    writer.println("\t\tvalue: " + field.get(obj));
                } catch (IllegalAccessException ex) {
                    throw new AssertionError("Private field was accessed.");
                }
                field.setAccessible(false);
            }
        }
        writer.close();
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