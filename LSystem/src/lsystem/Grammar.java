package lsystem;
import java.text.CharacterIterator;
/**
 * Grammar interface for Lindenmayer Systems
 * @author Martin Prout
 */
public interface Grammar {

    /**
     * 
     */
    public final String VERSION = "0.6.6";

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
  * Makes the CharacterIterator available internally/externally
  * Create a new instance if none exists otherwise re-use existing instance
  * @param production String
  * @return lIterator the grammar CharacterIterator
  */
    
    CharacterIterator getIterator(String production);

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
