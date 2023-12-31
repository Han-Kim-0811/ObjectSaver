package model.primitives;

/**
 * Object with primitive type short fields for testing.
 * This class has two types of short fields: public, private.
 */
@SuppressWarnings("FieldMayBeFinal")
public class ShortObject {
    public short pubShort;
    private short priShort;

    /**
     * Constructor of this class.
     *
     * @param pubShort is the value for the public short field.
     * @param priShort is the value for the private short field.
     */
    public ShortObject(short pubShort, short priShort) {
        this.pubShort = pubShort;
        this.priShort = priShort;
    }

    // ---- Getters and Setters ---- //
    public short getPriShort() {
        return this.priShort;
    }

    // ---- Overrides ---- //
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if(!(other instanceof ShortObject shortObj)) {
            return false;
        } else {
            return this.pubShort == shortObj.pubShort && priShort == shortObj.priShort;
        }
    }
}
