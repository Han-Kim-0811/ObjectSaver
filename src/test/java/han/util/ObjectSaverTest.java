package han.util;

// Objects for testing.
import model.IntObject;

// Library for file handling.
import java.io.IOException;

// Annotations and methods in JUnit framework, which are used for testing.
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectSaverTest {
    public final String PATH = "./src/test/resources";
    @Test
    @DisplayName("Test int fields")
    void IntObjTest() throws IOException {
        IntObject objA = new IntObject(1,2);
        IntObject objB = new IntObject(-1,-2);

        ObjectSaver.save(objA, PATH + "/intA.yaml");
        ObjectSaver.load(objB, PATH + "/intA.yaml");

        assertEquals(objA, objB);
    }
}