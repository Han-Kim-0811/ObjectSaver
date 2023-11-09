package model.primitives;

/**
 * Object with primitive type int fields for testing.
 * This class has two types of int fields: public, private.
 */
public class IntObject {
    public int pubInt;
    private int priInt;

    /**
     * Constructor of this class.
     *
     * @param pubInt is the value for the public int field.
     * @param priInt is the value for the private int field.
     */
    public IntObject(int pubInt, int priInt) {
        this.pubInt = pubInt;
        this.priInt = priInt;
    }

    // ---- Getters and Setters ---- //
    public int getPriInt() {
        return this.priInt;
    }

    // ---- Overrides ---- //
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if(!(other instanceof IntObject intObj)) {
            return false;
        } else {
            return this.pubInt == intObj.pubInt && priInt == intObj.priInt;
        }
    }
}
