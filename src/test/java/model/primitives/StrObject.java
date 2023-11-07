package model.primitives;

/**
 * Object with String fields for testing.
 * Added to be primitives package, because String is used as much as primitive types.
 * This class has two types of String fields: public, private.
 */
public class StrObject {
    public String pubStr;
    private String priStr;

    /**
     * Constructor of this class.
     *
     * @param pubStr is the value for the public String field.
     * @param priStr is the value for the private String field.
     */
    public StrObject(String pubStr, String priStr) {
        this.pubStr = pubStr;
        this.priStr = priStr;
    }

    // ---- Getters and Setters ---- //
    public String getPriStr() {
        return this.priStr;
    }

    // ---- Overrides ---- //
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if(!(other instanceof StrObject)) {
            return false;
        } else {
            StrObject strObj = (StrObject) other;
            return this.pubStr.equals(strObj.pubStr) && this.priStr.equals(strObj.priStr);
        }
    }
}
