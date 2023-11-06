package model.primitives;

/**
 * Object with primitive type double fields for testing.
 * This class has two types of double fields: public, private.
 */
public class DoubleObject {
    public double pubByte;
    private double priByte;

    /**
     * Constructor of this class.
     *
     * @param pubByte is the value for the public double field.
     * @param priByte is the value for the private double field.
     */
    public DoubleObject(double pubByte, double priByte) {
        this.pubByte = pubByte;
        this.priByte = priByte;
    }

    // ---- Getters and Setters ---- //
    public double getPriByte() {
        return this.priByte;
    }

    // ---- Overrides ---- //
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if(!(other instanceof DoubleObject)) {
            return false;
        } else {
            DoubleObject doubleObj = (DoubleObject) other;
            return this.pubByte == doubleObj.pubByte && priByte == doubleObj.priByte;
        }
    }
}
