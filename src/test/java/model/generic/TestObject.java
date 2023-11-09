package model.generic;

/**
 * Object with generic type T fields for testing.
 * This class has two types of T fields: public, private.
 */
@SuppressWarnings("FieldMayBeFinal")
public class TestObject<T> {
    public T pubField;
    private T priField;

    /**
     * Constructor of this class.
     *
     * @param pubField is the value for the public field.
     * @param priField is the value for the private field.
     */
    public TestObject(T pubField, T priField) {
        this.pubField = pubField;
        this.priField = priField;
    }

    // ---- Getters and Setters ---- //
    public T getPriField() {
        return this.priField;
    }

    // ---- Overrides ---- //
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if(!(other instanceof TestObject<?> testObj)) {
            return false;
        } else {
            return this.pubField.equals(testObj.pubField) && this.priField.equals(testObj.priField);
        }
    }
}
