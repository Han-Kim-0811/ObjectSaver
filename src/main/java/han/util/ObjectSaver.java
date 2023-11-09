package han.util;

// Reflection used to access object's field name and field value.
import java.lang.reflect.Field;
import java.lang.reflect.Array;

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
 * @version 2023-11-07
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
            // Access field's value.
            Object value;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                field.setAccessible(true);
                try {
                    value = field.get(obj);
                } catch (IllegalAccessException ex) {
                    throw new AssertionError("Inaccessible field was accessed.");
                }
            }

            // Write field's info to save file.
            String typeName = value.getClass().getTypeName();

            writer.println();
            writer.print(typeName + ",");
            writer.print(field.getName() + ",");

            // Write field's value to save file.
            StringBuilder sb = new StringBuilder();

            if (typeName.endsWith("[]")) {
                int length = Array.getLength(value);

                sb.append("{");
                for (int i = 0; i < length; i++) {
                    sb.append(Array.get(value, i));
                    sb.append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("}");
            } else {
                sb.append(value);
            }
            writer.print(sb);
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
            // values[2] = field's value (e.g. 1, 4.5, "String", {1, 2, 3} etc...).
            String[] values = scan.nextLine().split(",", 3);

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
        return switch (type) {
            // Type is primitives, wrapper classes, or String.
            case "byte", "java.lang.Byte" -> Byte::parseByte;
            case "short", "java.lang.Short" -> Short::parseShort;
            case "int", "java.lang.Integer" -> Integer::parseInt;
            case "long", "java.lang.Long" -> Long::parseLong;
            case "float", "java.lang.Float" -> Float::parseFloat;
            case "double", "java.lang.Double" -> Double::parseDouble;
            case "boolean", "java.lang.Boolean" -> Boolean::parseBoolean;
            case "char", "java.lang.Character" -> (String ch) -> ch.charAt(0);
            case "java.lang.String" -> (String str) -> str;

            // TODO: Implement other situations (e.g. Arrays, Objects etc...).
            default -> throw new AssertionError("Not supported yet.");
        };
    }
}