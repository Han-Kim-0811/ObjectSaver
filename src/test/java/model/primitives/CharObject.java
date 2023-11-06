package model.primitives;

/**
 * Object with primitive type char fields for testing.
 * This class has two types of char fields: public, private.
 */
public class CharObject {
    public char pubChar;
    private char priChar;

    /**
     * Constructor of this class.
     *
     * @param pubChar is the value for the public char field.
     * @param priChar is the value for the private char field.
     */
    public CharObject(char pubChar, char priChar) {
        this.pubChar = pubChar;
        this.priChar = priChar;
    }

    // ---- Getters and Setters ---- //
    public char getPriChar() {
        return this.priChar;
    }

    // ---- Overrides ---- //
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if(!(other instanceof CharObject)) {
            return false;
        } else {
            CharObject charObj = (CharObject) other;
            return this.pubChar == charObj.pubChar && priChar == charObj.priChar;
        }
    }
}
