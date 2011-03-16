package lsystem.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * A storage class for non-stochastic rules
 * @author Martin Prout
 */
public class SimpleRuleList implements RuleList{
    private Set<Character>premises;
    private Map<Character, String>rules;
    /**
     * 
     */
    public SimpleRuleList(){
        premises = new TreeSet<Character>();
        rules = new HashMap<Character, String>();
    }

    public void addRule(char pre, String rule) throws RuntimeException{
        if (this.hasRule(pre))
        {
          throw new RuntimeException("Use StochasticList to store multiple rules");
        }
        premises.add(pre);
        rules.put(pre, rule);
    }
    public void addRule(char pre, String rule, float weight) throws RuntimeException{
        throw new RuntimeException("Use StochasticList to store weighted rules");
    }
    public String getRule(char pre){
        return rules.get(pre);
    }

    /**
     *
     * @return sb representing LSystem axiom/rules
     */
    public StringBuilder toStringBuilder(){
        StringBuilder sb = new StringBuilder("Rules:\n");
        for (char ch : premises){
            sb.append(ch);
            sb.append("=>");
            sb.append(this.getRule(ch));
            sb.append("\n");
        }
        return sb;
    }

       /**
     *
     * Empty collections on dispose
     */
    public void clear() {
        premises.clear();
        rules.clear();
    }

    public boolean hasRule(char pre){return premises.contains(pre);}
}
