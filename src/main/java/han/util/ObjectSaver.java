package han.util;

// Reflection used to access object's field name and field value.
import java.lang.reflect.Field;

// Library for file handling.
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Utility class with the following functionality.
 * Save the field's state of a Java object to a CSV save file.
 * Load the field's state of a Java object from a CSV save file.
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
     * Save the field's state of a Java object to a CSV save file.
     *
     * @param obj is the Object to save.
     * @param path is the path of the CSV save file.
     */
    public static void save(Object obj, String path) throws IOException {
        PrintWriter writer = new PrintWriter(path);
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();

        writer.print(objClass.getSimpleName());

        for (Field field : fields) {
            writer.println();
            writer.print(field.getType().getName() + ",");
            writer.print(field.getName() + ",");
            try {
                writer.print(field.get(obj));
            } catch (IllegalAccessException e) {
                field.setAccessible(true);
                try {
                    writer.print(field.get(obj));
                } catch (IllegalAccessException ex) {
                    throw new AssertionError("Inaccessible field was accessed.");
                }
                field.setAccessible(false);
            }
        }
        writer.close();
    }

    /**
     * Load the field's state of a Java object from a CSV save file.
     *
     * @param obj is the Object to save.
     * @param path is the path of the CSV save file.
     */
    public static void load(Object obj, String path){
        //TODO: implement the load function for basic objects with primitive type fields.
    }
}