package lsystem;

/**
 * Grammar interface for Lindenmayer Systems
 * @author Martin Prout
 */
public interface Grammar {

    /**
     * 
     */
    public final String VERSION = "0.5.1";

    /**
     * add unweighted rule
     * @param premise
     * @param rule
     */
    void addRule(char premise, String rule);

    /**
     * add weighted rule for stochastic L-System
     * @param premise
     * @param rule
     * @param weight
     */
    void addRule(char premise, String rule, float weight);

    /**
     * Creates production from axiom, rules and no of
     * generations
     * @param repeats
     * @return production String
     */
    String createGrammar(int repeats);

    /**
     * Useful for testing no generations
     * @return production String (axiom)
     */
    String createGrammar();

    /**
     *
     */
    void dispose();

    /**
     *
     * @param premise
     * @return rule
     */
    String getRule(char premise);

    /**
     *
     * @param premise
     * @return true
     */
    boolean hasKey(char premise);

    /**
     * return the version of the library.
     *
     * @return String
     */
    String version();
}
