package han.util;

// Object for testing.
import model.generic.TestObject;

// Library for file handling.
import java.io.IOException;

// Annotations and methods in JUnit framework, which are used for testing.
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for checking the following functionality of ObjectSaver.
 * Save and load public generic fields.
 * Save and load private generic fields.
 */
class GenericTest {
    public final String PATH = "./src/test/resources/generic";

    @Test
    @DisplayName("Test wrapper Byte fields")
    void ByteTest() throws IOException, ClassNotFoundException {
        TestObject<Byte> objA = new TestObject<>((byte) 1, Byte.MAX_VALUE);
        TestObject<Byte> objB = new TestObject<>((byte) -1, Byte.MIN_VALUE);

        ObjectSaver.save(objA, PATH + "/byteA.csv");
        ObjectSaver.load(objB, PATH + "/byteA.csv");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test wrapper Short fields")
    void ShortTest() throws IOException, ClassNotFoundException {
        TestObject<Short> objA = new TestObject<>((short) 1, Short.MAX_VALUE);
        TestObject<Short> objB = new TestObject<>((short) -1, Short.MIN_VALUE);

        ObjectSaver.save(objA, PATH + "/shortA.csv");
        ObjectSaver.load(objB, PATH + "/shortA.csv");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test wrapper Integer fields")
    void IntTest() throws IOException, ClassNotFoundException {
        TestObject<Integer> objA = new TestObject<>(1, Integer.MAX_VALUE);
        TestObject<Integer> objB = new TestObject<>(-1, Integer.MIN_VALUE);

        ObjectSaver.save(objA, PATH + "/intA.csv");
        ObjectSaver.load(objB, PATH + "/intA.csv");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test wrapper Long fields")
    void LongTest() throws IOException, ClassNotFoundException {
        TestObject<Long> objA = new TestObject<>(1L, Long.MAX_VALUE);
        TestObject<Long> objB = new TestObject<>(-1L, Long.MAX_VALUE);

        ObjectSaver.save(objA, PATH + "/longA.csv");
        ObjectSaver.load(objB, PATH + "/longA.csv");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test wrapper Float fields")
    void FloatTest() throws IOException, ClassNotFoundException {
        TestObject<Float> objA = new TestObject<>(0.1f, Float.MAX_VALUE);
        TestObject<Float> objB = new TestObject<>(-0.1f, Float.MIN_VALUE);

        ObjectSaver.save(objA, PATH + "/floatA.csv");
        ObjectSaver.load(objB, PATH + "/floatA.csv");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test wrapper Double fields")
    void DoubleTest() throws IOException, ClassNotFoundException {
        TestObject<Double> objA = new TestObject<>(0.1, Double.MAX_VALUE);
        TestObject<Double> objB = new TestObject<>(-0.1, Double.MIN_VALUE);

        ObjectSaver.save(objA, PATH + "/doubleA.csv");
        ObjectSaver.load(objB, PATH + "/doubleA.csv");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test wrapper Boolean fields")
    void BoolTest() throws IOException, ClassNotFoundException {
        TestObject<Boolean> objA = new TestObject<>(true, false);
        TestObject<Boolean> objB = new TestObject<>(false, true);

        ObjectSaver.save(objA, PATH + "/boolA.csv");
        ObjectSaver.load(objB, PATH + "/boolA.csv");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test wrapper Character fields")
    void CharTest() throws IOException, ClassNotFoundException {
        TestObject<Character> objA = new TestObject<>('A', 'Z');
        TestObject<Character> objB = new TestObject<>('a', 'b');

        ObjectSaver.save(objA, PATH + "/charA.csv");
        ObjectSaver.load(objB, PATH + "/charA.csv");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test String fields")
    void StrTest() throws IOException, ClassNotFoundException {
        TestObject<String> objA = new TestObject<>("Hello", "World!");
        TestObject<String> objB = new TestObject<>("Hallo", "Welt!");

        ObjectSaver.save(objA, PATH + "/strA.csv");
        ObjectSaver.load(objB, PATH + "/strA.csv");

        assertEquals(objA, objB);
    }
}