package lsystem.collection.csrule;

/**
 * A helper class for context sensitive LSystem rules
 * helps to decode the context elements and extracts the premis character
 *
 * @author Martin Prout
 */
public class ContextRule {

    private int idx = 0;       // direction of context -1 = before, 1 = after
    private String keyHash;   // hash to store rules by
    private char premis;   // character to replace by rule
    private char context;  // character that is context

    /**
    Constructor for ContextRule, holds all the logic so that only relevant data is
    stored
     * @param context
     */
    public ContextRule(String context) {
        this.keyHash = context;
        this.idx = ('<' == context.charAt(1)) ? -1 : ('>' == context.charAt(1)) ? 1 : 0;
        this.premis = context.charAt(2);
        this.context = context.charAt(0);
    }

    /**
     * Returns the value of context char.
     * character that determines context
     * @return this.context char
     */
    public char getContextChar() {
        return this.context;
    }

    /**
     * Returns the value of keyHash.
     *
     * @return string to use as key in cs rule hash table
     */
    public String getKeyHash() {
        return keyHash;
    }

    /**
     * Returns the value of premis.
     * @return premis char
     */
    public char getPremis() {
        return premis;
    }

    /**
     * Returns the value of context index.
     * determines the direction to search for context char
     * @return idx int
     */
    public int getIndex() {
        return idx;
    }
}
