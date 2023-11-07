package model.generic;

/**
 * Object with generic type TTT fields for testing.
 * This class has two types of TTT fields: public, private.
 */
public class TestObject<TTT> {
    public TTT pubField;
    private TTT priField;

    /**
     * Constructor of this class.
     *
     * @param pubField is the value for the public field.
     * @param priField is the value for the private field.
     */
    public TestObject(TTT pubField, TTT priField) {
        this.pubField = pubField;
        this.priField = priField;
    }

    // ---- Getters and Setters ---- //
    public TTT getPriField() {
        return this.priField;
    }

    // ---- Overrides ---- //
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if(!(other instanceof TestObject)) {
            return false;
        } else {
            TestObject testObj = (TestObject) other;
            return this.pubField.equals(testObj.pubField) && this.priField.equals(testObj.priField);
        }
    }
}
