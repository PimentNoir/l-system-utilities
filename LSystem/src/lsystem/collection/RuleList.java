package lsystem.collection;

/**
 * RuleList interface to a Collection of L-System rules
 * @author Martin Prout
 */
public interface RuleList {

    /**
     *
     */
    public final String VERSION = "0.6.7";
    /**
     * 
     * @param pre
     * @param rule
     * @throws RuntimeException
     */
    public void addRule(char pre, String rule) throws RuntimeException;
    /**
     *
     * @param pre
     * @param rule
     * @param weight
     * @throws RuntimeException
     */
    public void addRule(char pre, String rule, float weight) throws RuntimeException;
    /**
     *
     * @param pre
     * @return rule
     */
    public String getRule(char pre);
    /**
     *
     * @param pre
     * @return true
     */
    public boolean hasRule(char pre);

    /**
     *
     */
    public void clear();
}


