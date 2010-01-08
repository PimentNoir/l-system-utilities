package lsystem;

/**
 *
 * @author tux
 */
public interface RuleList {
    public void addRule(char pre, String rule) throws RuntimeException;
    public void addRule(char pre, String rule, float weight) throws RuntimeException;
    public String getRule(char pre);
    public boolean hasRule(char pre);
}
