
package lsystem;

/**
 * A rule holder class, when used by Parser
 * keys are replaced by the rule
 * @author tux
 */
public class Rule {
    private char key;
    private String rule;
    /**
     * Rule Constructor
     * @param key char
     * @param rule String
     */
    public Rule(char key, String rule){
        this.key = key;
        this.rule = rule;
    }
    /**
     * Returns the key char element
     * @return key String
     */
    public char key(){
    return this.key;
    }
    /**
     * Returns the rule String element
     * @return rule String
     */
    public String getRule(){
    return this.rule;
    }

    @Override
    public String toString(){
    String ruleS = this.key + "=>" + this.rule;
    return ruleS;
    }
}
