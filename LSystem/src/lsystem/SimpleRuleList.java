package lsystem;
import java.util.HashMap;
import java.util.Iterator;
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
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Rules:\n");
        Character ch = ' ';
        Iterator<Character> it = premises.iterator();
        while (it.hasNext()){
            ch = it.next();
            sb.append(ch);
            sb.append("=>");
            sb.append(this.getRule(ch));
            sb.append("\n");
        }
        return sb.toString();
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
