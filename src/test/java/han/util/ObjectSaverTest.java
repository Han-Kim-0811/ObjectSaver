package han.util;

import model.IntObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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

    @Test
    @DisplayName("General saveTest")
    void saveTest() throws IOException {
        IntObject objA = new IntObject(1,2);
        ObjectSaver.save(objA,PATH + "/intA.yaml");
    }
}