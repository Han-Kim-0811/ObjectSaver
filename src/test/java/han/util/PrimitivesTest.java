package han.util;

// Objects for testing.
import model.primitives.*;

// Library for file handling.
import java.io.IOException;

// Annotations and methods in JUnit framework, which are used for testing.
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for checking the following functionality of ObjectSaver.
 * Save and load public primitive and String fields.
 * Save and load private primitive and String fields.
 */
class PrimitivesTest {
    public final String PATH = "./src/test/resources/primitives";

    @Test
    @DisplayName("Test byte fields")
    void ByteTest() throws IOException {
        ByteObject objA = new ByteObject((byte) 1, Byte.MAX_VALUE);
        ByteObject objB = new ByteObject((byte) -1, Byte.MIN_VALUE);

        ObjectSaver.save(objA, PATH + "/byteA.yaml");
        ObjectSaver.load(objB, PATH + "/byteA.yaml");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test short fields")
    void ShortTest() throws IOException {
        ShortObject objA = new ShortObject((short) 1, Short.MAX_VALUE);
        ShortObject objB = new ShortObject((short) -1, Short.MIN_VALUE);

        ObjectSaver.save(objA, PATH + "/shortA.yaml");
        ObjectSaver.load(objB, PATH + "/shortA.yaml");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test int fields")
    void IntTest() throws IOException {
        IntObject objA = new IntObject(1, Integer.MAX_VALUE);
        IntObject objB = new IntObject(-1, Integer.MIN_VALUE);

        ObjectSaver.save(objA, PATH + "/intA.yaml");
        ObjectSaver.load(objB, PATH + "/intA.yaml");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test long fields")
    void LongTest() throws IOException {
        LongObject objA = new LongObject(1L, Long.MAX_VALUE);
        LongObject objB = new LongObject(-1L, Long.MAX_VALUE);

        ObjectSaver.save(objA, PATH + "/longA.yaml");
        ObjectSaver.load(objB, PATH + "/longA.yaml");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test float fields")
    void FloatTest() throws IOException {
        FloatObject objA = new FloatObject(0.1f, Float.MAX_VALUE);
        FloatObject objB = new FloatObject(-0.1f, Float.MIN_VALUE);

        ObjectSaver.save(objA, PATH + "/floatA.yaml");
        ObjectSaver.load(objB, PATH + "/floatA.yaml");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test double fields")
    void DoubleTest() throws IOException {
        DoubleObject objA = new DoubleObject(0.1, Double.MAX_VALUE);
        DoubleObject objB = new DoubleObject(-0.1, Double.MIN_VALUE);

        ObjectSaver.save(objA, PATH + "/doubleA.yaml");
        ObjectSaver.load(objB, PATH + "/doubleA.yaml");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test boolean fields")
    void BoolTest() throws IOException {
        BoolObject objA = new BoolObject(true, false);
        BoolObject objB = new BoolObject(false, true);

        ObjectSaver.save(objA, PATH + "/boolA.yaml");
        ObjectSaver.load(objB, PATH + "/boolA.yaml");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test char fields")
    void CharTest() throws IOException {
        CharObject objA = new CharObject('A', 'Z');
        CharObject objB = new CharObject('a', 'b');

        ObjectSaver.save(objA, PATH + "/charA.yaml");
        ObjectSaver.load(objB, PATH + "/charA.yaml");

        assertEquals(objA, objB);
    }

    @Test
    @DisplayName("Test String fields")
    void StrTest() throws IOException {
        StrObject objA = new StrObject("Hello", "World!");
        StrObject objB = new StrObject("Hallo", "Welt!");

        ObjectSaver.save(objA, PATH + "/stringA.yaml");
        ObjectSaver.load(objB, PATH + "/stringA.yaml");

        assertEquals(objA, objB);
    }
}