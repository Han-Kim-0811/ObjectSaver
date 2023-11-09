package model.primitives;

/**
 * Object with primitive type float fields for testing.
 * This class has two types of float fields: public, private.
 */
public class FloatObject {
    public float pubFloat;
    private float priFloat;

    /**
     * Constructor of this class.
     *
     * @param pubFloat is the value for the public float field.
     * @param priFloat is the value for the private float field.
     */
    public FloatObject(float pubFloat, float priFloat) {
        this.pubFloat = pubFloat;
        this.priFloat = priFloat;
    }

    // ---- Getters and Setters ---- //
    public float getPriFloat() {
        return this.priFloat;
    }

    // ---- Overrides ---- //
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if(!(other instanceof FloatObject floatObj)) {
            return false;
        } else {
            return this.pubFloat == floatObj.pubFloat && priFloat == floatObj.priFloat;
        }
    }
}
