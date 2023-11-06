package han.util;

// Reflection used to access object's field name and field value.
import java.lang.reflect.Field;

// Used for file handling.
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

// Used to utilize different parsing functions.
import java.util.function.Function;

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
        Field[] fields = obj.getClass().getDeclaredFields();

        writer.print(obj.getClass().getSimpleName());

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
    public static void load(Object obj, String path) throws IOException{
        File file = new File(path);
        Scanner scan = new Scanner(file);
        Field[] fields = obj.getClass().getDeclaredFields();

        if(!scan.nextLine().equals(obj.getClass().getSimpleName())) {
            throw new RuntimeException("Incompatible Save File: Different class name");
        }

        for (Field field : fields) {
            // values[0] = field's name (e.g. pubInt, priInt etc...).
            // values[1] = field's type (e.g. int, double etc...).
            // values[2] = field's value (e.g. 1, 4.5, "String" etc...).
            String[] values = scan.nextLine().split(",");

            try {
                field.set(obj, parseType(values[0]).apply(values[2]));
            } catch (IllegalAccessException e) {
                field.setAccessible(true);
                try {
                    field.set(obj, parseType(values[0]).apply(values[2]));
                } catch (IllegalAccessException ex) {
                    throw new AssertionError("Inaccessible field was accessed.");
                }
                field.setAccessible(false);
            }
        }
    }

    /**
     * Returns the proper function for parsing the given type.
     *
     * @param type is the name of the data type to parse from String.
     * @return the proper parse function for the given data type's name.
     */
    private static Function<String, ?> parseType(String type) {
        switch (type) {
            case "byte":
                return Byte::parseByte;
            case "short":
                return Short::parseShort;
            case "int":
                return Integer::parseInt;
            case "long":
                return Long::parseLong;
            case "float":
                return Float::parseFloat;
            case "double":
                return Double::parseDouble;
            case "boolean":
                return Boolean::parseBoolean;
            case "char":
                return (String ch) -> ch.charAt(0);
            default:
                //TODO: Implement other situations (e.g. Arrays, Objects etc...).
                throw new AssertionError("Not supported yet.");
        }
    }
}