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
 * @version 2023-11-09
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
    public static void load(Object obj, String path) throws IOException, ClassNotFoundException {
        File file = new File(path);
        Scanner scan = new Scanner(file);
        Field[] fields = obj.getClass().getDeclaredFields();

        if(!scan.nextLine().equals(obj.getClass().getSimpleName())) {
            throw new RuntimeException("Incompatible Save File: Different class name");
        }

        for (Field field : fields) {
            String[] fieldInfo = scan.nextLine().split(",", 3);
            String fieldType = fieldInfo[0];
            // String fieldName = fieldInfo[1];
            String fieldValue = fieldInfo[2];

            Object toSet;

            if(fieldType.endsWith("[]")) {
                String arrayType = fieldType.substring(0, fieldType.length() - 2);
                String[] toParse = fieldValue.substring(1, fieldValue.length() - 1).split(",");
                toSet = makeNewArray(arrayType, toParse.length);

                Function<String, ?> parser = getParser(arrayType);
                for(int i = 0; i < toParse.length; i++) {
                    Array.set(toSet, i, parser.apply(toParse[i]));
                }
            } else {
                toSet = getParser(fieldType).apply(fieldValue);
            }

            try {
                field.set(obj, toSet);
            } catch (IllegalAccessException e) {
                field.setAccessible(true);
                try {
                    field.set(obj, toSet);
                } catch (IllegalAccessException ex) {
                    throw new AssertionError("Inaccessible field was accessed.");
                }
                field.setAccessible(false);
            }
        }
    }

    private static Object makeNewArray(String arrayType, int length) throws ClassNotFoundException {
        return switch (arrayType) {
            // Type is primitives, wrapper classes, or String.
            case "byte" -> new byte[length];
            case "short" -> new short[length];
            case "int" -> new int[length];
            case "long" -> new long[length];
            case "float" -> new float[length];
            case "double" -> new double[length];
            case "boolean" -> new boolean[length];
            case "char" -> new char[length];
            default -> Array.newInstance(Class.forName(arrayType), length);
        };
    }

    /**
     * Returns the proper function for parsing the given type.
     *
     * @param type is the name of the data type to parse from String.
     * @return the proper parse function for the given data type's name.
     */
    private static Function<String, ?> getParser(String type) {
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

            // TODO: Implement other situations (e.g. Objects, Inheritance etc...).
            default -> throw new AssertionError("Not supported yet.");
        };
    }
}