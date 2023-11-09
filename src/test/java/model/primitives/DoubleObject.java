package model.primitives;

/**
 * Object with primitive type double fields for testing.
 * This class has two types of double fields: public, private.
 */
public class DoubleObject {
    public double pubDouble;
    private double priDouble;

    /**
     * Constructor of this class.
     *
     * @param pubDouble is the value for the public double field.
     * @param priDouble is the value for the private double field.
     */
    public DoubleObject(double pubDouble, double priDouble) {
        this.pubDouble = pubDouble;
        this.priDouble = priDouble;
    }

    // ---- Getters and Setters ---- //
    public double getPriDouble() {
        return this.priDouble;
    }

    // ---- Overrides ---- //
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if(!(other instanceof DoubleObject doubleObj)) {
            return false;
        } else {
            return this.pubDouble == doubleObj.pubDouble && priDouble == doubleObj.priDouble;
        }
    }
}
