package han.util;

// Object for testing.
import model.generic.TestObject;

// Library for file handling.
import java.io.IOException;

// Annotations and methods in JUnit framework, which are used for testing.
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Unit test for checking the following functionality of ObjectSaver.
 * Save and load public array fields.
 * Save and load private array fields.
 */
class ArrayTest {
    public final String PATH = "./src/test/resources/array";

    @Test
    @DisplayName("Test byte array fields")
    void ByteTest() throws IOException {
        byte[] arrA = {1, 2, 3};
        byte[] arrB = {Byte.MAX_VALUE, Byte.MAX_VALUE - 1, Byte.MAX_VALUE - 2};

        byte[] arrC = {-1, -2, -3};
        byte[] arrD = {Byte.MIN_VALUE, Byte.MIN_VALUE + 1, Byte.MIN_VALUE + 2};

        TestObject<byte[]> objA = new TestObject<>(arrA, arrB);
        TestObject<byte[]> objB = new TestObject<>(arrC, arrD);

        ObjectSaver.save(objA, PATH + "/byteA.csv");
        ObjectSaver.load(objB, PATH + "/byteA.csv");

        assertArrayEquals(objA.pubField, objB.pubField);
        assertArrayEquals(objA.getPriField(), objB.getPriField());
    }

    @Test
    @DisplayName("Test short array fields")
    void ShortTest() throws IOException {
        short[] arrA = {1, 2, 3};
        short[] arrB = {Short.MAX_VALUE, Short.MAX_VALUE - 1, Short.MAX_VALUE - 2};

        short[] arrC = {-1, -2, -3};
        short[] arrD = {Short.MIN_VALUE, Short.MIN_VALUE + 1, Short.MIN_VALUE + 2};

        TestObject<short[]> objA = new TestObject<>(arrA, arrB);
        TestObject<short[]> objB = new TestObject<>(arrC, arrD);

        ObjectSaver.save(objA, PATH + "/shortA.csv");
        ObjectSaver.load(objB, PATH + "/shortA.csv");

        assertArrayEquals(objA.pubField, objB.pubField);
        assertArrayEquals(objA.getPriField(), objB.getPriField());
    }

    @Test
    @DisplayName("Test int array fields")
    void IntTest() throws IOException {
        int[] arrA = {1, 2, 3};
        int[] arrB = {Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2};

        int[] arrC = {-1, -2, -3};
        int[] arrD = {Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 2};

        TestObject<int[]> objA = new TestObject<>(arrA, arrB);
        TestObject<int[]> objB = new TestObject<>(arrC, arrD);

        ObjectSaver.save(objA, PATH + "/intA.csv");
        ObjectSaver.load(objB, PATH + "/intA.csv");

        assertArrayEquals(objA.pubField, objB.pubField);
        assertArrayEquals(objA.getPriField(), objB.getPriField());
    }

    @Test
    @DisplayName("Test long array fields")
    void LongTest() throws IOException {
        long[] arrA = {1, 2, 3};
        long[] arrB = {Long.MAX_VALUE, Long.MAX_VALUE - 1, Long.MAX_VALUE - 2};

        long[] arrC = {-1, -2, -3};
        long[] arrD = {Long.MIN_VALUE, Long.MIN_VALUE + 1, Long.MIN_VALUE + 2};

        TestObject<long[]> objA = new TestObject<>(arrA, arrB);
        TestObject<long[]> objB = new TestObject<>(arrC, arrD);

        ObjectSaver.save(objA, PATH + "/longA.csv");
        ObjectSaver.load(objB, PATH + "/longA.csv");

        assertArrayEquals(objA.pubField, objB.pubField);
        assertArrayEquals(objA.getPriField(), objB.getPriField());
    }

    @Test
    @DisplayName("Test float array fields")
    void FloatTest() throws IOException {
        float[] arrA = {0.1f, 0.2f, 0.3f};
        float[] arrB = {Float.MAX_VALUE, Float.MAX_VALUE - 0.1f, Float.MAX_VALUE - 0.2f};

        float[] arrC = {-0.1f, -0.2f, -0.3f};
        float[] arrD = {Float.MIN_VALUE, Float.MIN_VALUE + 0.1f, Float.MIN_VALUE + 0.2f};

        TestObject<float[]> objA = new TestObject<>(arrA, arrB);
        TestObject<float[]> objB = new TestObject<>(arrC, arrD);

        ObjectSaver.save(objA, PATH + "/floatA.csv");
        ObjectSaver.load(objB, PATH + "/floatA.csv");

        assertArrayEquals(objA.pubField, objB.pubField);
        assertArrayEquals(objA.getPriField(), objB.getPriField());
    }

    @Test
    @DisplayName("Test double array fields")
    void DoubleTest() throws IOException {
        double[] arrA = {0.1, 0.2, 0.3};
        double[] arrB = {Double.MAX_VALUE, Double.MAX_VALUE - 0.1, Double.MAX_VALUE - 0.2};

        double[] arrC = {-0.1, -0.2, -0.3};
        double[] arrD = {Double.MIN_VALUE, Double.MIN_VALUE + 0.1, Double.MIN_VALUE + 0.2};

        TestObject<double[]> objA = new TestObject<>(arrA, arrB);
        TestObject<double[]> objB = new TestObject<>(arrC, arrD);

        ObjectSaver.save(objA, PATH + "/doubleA.csv");
        ObjectSaver.load(objB, PATH + "/doubleA.csv");

        assertArrayEquals(objA.pubField, objB.pubField);
        assertArrayEquals(objA.getPriField(), objB.getPriField());
    }

    @Test
    @DisplayName("Test boolean array fields")
    void BoolTest() throws IOException {
        boolean[] arrA = {true, false, true};
        boolean[] arrB = {false, true, false};

        boolean[] arrC = {false, false, false};
        boolean[] arrD = {true, true, true};

        TestObject<boolean[]> objA = new TestObject<>(arrA, arrB);
        TestObject<boolean[]> objB = new TestObject<>(arrC, arrD);

        ObjectSaver.save(objA, PATH + "/boolA.csv");
        ObjectSaver.load(objB, PATH + "/boolA.csv");

        assertArrayEquals(objA.pubField, objB.pubField);
        assertArrayEquals(objA.getPriField(), objB.getPriField());
    }

    @Test
    @DisplayName("Test char array fields")
    void CharTest() throws IOException {
        char[] arrA = {'a', 'b', 'c'};
        char[] arrB = {'x', 'y', 'z'};

        char[] arrC = {'A', 'B', 'C'};
        char[] arrD = {'X', 'Y', 'Z'};

        TestObject<char[]> objA = new TestObject<>(arrA, arrB);
        TestObject<char[]> objB = new TestObject<>(arrC, arrD);

        ObjectSaver.save(objA, PATH + "/charA.csv");
        ObjectSaver.load(objB, PATH + "/charA.csv");

        assertArrayEquals(objA.pubField, objB.pubField);
        assertArrayEquals(objA.getPriField(), objB.getPriField());
    }

    @Test
    @DisplayName("Test String array fields")
    void StrTest() throws IOException {
        String[] arrA = {"Hello", "Beautiful", "World!"};
        String[] arrB = {"Super", "Mario", "Wonders!"};

        String[] arrC = {"Hallo", "Schöne", "Welt!"};
        String[] arrD = {"New", "Super", "Mario!"};

        TestObject<String[]> objA = new TestObject<>(arrA, arrB);
        TestObject<String[]> objB = new TestObject<>(arrC, arrD);

        ObjectSaver.save(objA, PATH + "/strA.csv");
        ObjectSaver.load(objB, PATH + "/strA.csv");

        assertArrayEquals(objA.pubField, objB.pubField);
        assertArrayEquals(objA.getPriField(), objB.getPriField());
    }
}