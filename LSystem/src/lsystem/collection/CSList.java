/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lsystem.collection;

/**
 * CSList.java a limited context sensitive implementation
 * Valid for 3 char context where ">" or "<" determine
 * context direction (accepts ignore list as String or char[])
 * @author Martin Prout
 */
import java.util.HashMap;
import java.util.Map;
import lsystem.collection.csrule.ContextRule;

public class CSList {

    char[] ignore = {};
    private Map<Character, ContextRule> cs_premises;
    private Map<Character, String> rules;
    private Map<String, String> csrules;

    public CSList() {
        cs_premises = new HashMap<Character, ContextRule>();
        rules = new HashMap<Character, String>();
        csrules = new HashMap<String, String>();
    }

    /**
     * Set the character ignore list
     * @param str ignore list as a String
     */
    public void setIgnoreList(String str) {
        this.ignore = str.toCharArray();
    }

    /**
     * Set the character ignore list
     * @param ignore list as char[]
     */
    public void setIgnoreList(char[] ignore) {
        this.ignore = ignore;
    }

    /**
     * Check the character ignore list
     * @param prod char
     * @return boolean true when prod in list
     */
    public boolean isIgnored(char prod) {
        boolean isIgnore = false;
        if (ignore.length > 0) {
            for (char c : ignore) {
                if (c == prod) {
                    isIgnore = true;
                    break; // then don't check any more
                }
            }
        }
        return isIgnore;
    }

    public void addRule(String pre, String rule) throws RuntimeException {
        ContextRule context = new ContextRule(pre);
        cs_premises.put(context.getPremis(), context);
        csrules.put(pre, rule);
    }

    public void addRule(char pre, String rule) throws RuntimeException {
        rules.put(pre, rule);
    }

    public void addRule(char pre, String rule, float weight) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private StringBuilder getRule(char pre) {
        StringBuilder rule = new StringBuilder();
        if (rules.containsKey(pre)) {
            rule.append(rules.get(pre));
        } else // this is a kind of failsafe since using
        {
            rule.append(pre);        // classes should use hasRule as a filter
        }
        return rule;
    }

    /**
     * This method controls access to the substitition rules, looks first for a context sensitive rule
     * returns that if context condition is met, else returns non context sensitive rule or prefix
     * @param pre char premis
     * @param production String
     * @param index int
     * @return StringBuilder rule
     */
    public StringBuilder getCSRule(char pre, String production, int index) {
        StringBuilder rule = new StringBuilder();
        if (cs_premises.containsKey(pre)) {
            ContextRule context = cs_premises.get(pre);
            int idx = context.getIndex();
            int count = index + idx;
            if ((count < 0) || count > production.length()) {
                count = 0; // ensure character index is not out of range
            }
            char contextChar = context.getContextChar();
            while (isIgnored(production.charAt(count))) {
                count += idx;
            }
            if (contextChar == production.charAt(count)) {
                rule.append(csrules.get(context.getKeyHash()));
            } else {
                rule.append(getRule(pre)); // NB: use getRule because no context
            }
        }
        else {
            rule.append(getRule(pre)); // NB: use getRule because no context rule
        }
        return rule;
    }

    public boolean hasRule(char pre) {
        boolean has = (rules.containsKey(pre)) || (cs_premises.containsKey(pre));
        return has;
    }

    public void clear() {
        rules.clear();
        csrules.clear();
        cs_premises.clear();
    }

    public StringBuilder toStringBuilder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
