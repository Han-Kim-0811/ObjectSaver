package model.primitives;

/**
 * Object with primitive type byte fields for testing.
 * This class has two types of byte fields: public, private.
 */
public class ByteObject {
    public byte pubByte;
    private byte priByte;

    /**
     * Constructor of this class.
     *
     * @param pubByte is the value for the public byte field.
     * @param priByte is the value for the private byte field.
     */
    public ByteObject(byte pubByte, byte priByte) {
        this.pubByte = pubByte;
        this.priByte = priByte;
    }

    // ---- Getters and Setters ---- //
    public byte getPriByte() {
        return this.priByte;
    }

    // ---- Overrides ---- //
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if(!(other instanceof ByteObject)) {
            return false;
        } else {
            ByteObject byteObj = (ByteObject) other;
            return this.pubByte == byteObj.pubByte && priByte == byteObj.priByte;
        }
    }
}
