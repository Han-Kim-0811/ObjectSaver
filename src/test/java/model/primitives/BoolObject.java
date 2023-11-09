package model.primitives;

/**
 * Object with primitive type boolean fields for testing.
 * This class has two types of boolean fields: public, private.
 */
public class BoolObject {
    public boolean pubBool;
    private boolean priBool;

    /**
     * Constructor of this class.
     *
     * @param pubBool is the value for the public boolean field.
     * @param priBool is the value for the private boolean field.
     */
    public BoolObject(boolean pubBool, boolean priBool) {
        this.pubBool = pubBool;
        this.priBool = priBool;
    }

    // ---- Getters and Setters ---- //
    public boolean getPriBool() {
        return this.priBool;
    }

    // ---- Overrides ---- //
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if(!(other instanceof BoolObject boolObj)) {
            return false;
        } else {
            return this.pubBool == boolObj.pubBool && priBool == boolObj.priBool;
        }
    }
}
