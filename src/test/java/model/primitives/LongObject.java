package model.primitives;

/**
 * Object with primitive type long fields for testing.
 * This class has two types of long fields: public, private.
 */
public class LongObject {
    public long pubLong;
    private long priLong;

    /**
     * Constructor of this class.
     *
     * @param pubLong is the value for the public long field.
     * @param priLong is the value for the private long field.
     */
    public LongObject(long pubLong, long priLong) {
        this.pubLong = pubLong;
        this.priLong = priLong;
    }

    // ---- Getters and Setters ---- //
    public long getPriLong() {
        return this.priLong;
    }

    // ---- Overrides ---- //
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if(!(other instanceof LongObject)) {
            return false;
        } else {
            LongObject longObj = (LongObject) other;
            return this.pubLong == longObj.pubLong && priLong == longObj.priLong;
        }
    }
}
