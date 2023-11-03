package han.util;

import model.IntObj;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectSaverTest {
    public final String PATH = "./test/resources";
    @Test
    @DisplayName("Test int fields")
    void IntObjTest() {
        IntObj objA = new IntObj(1,2);
        IntObj objB = new IntObj(-1,-2);

        ObjectSaver.save(objA, PATH + "/intA.yaml");
        ObjectSaver.load(objB, PATH + "/intA.yaml");

        assertEquals(objA, objB);
    }
}