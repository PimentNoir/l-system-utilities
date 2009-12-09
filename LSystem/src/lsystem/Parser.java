package lsystem;

import processing.core.PApplet;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * Parser class that provides convenience method for working with l-systems
 * @author tux
 */
public class Parser {

    public final String VERSION = "0.1.0";
    PApplet myParent;

    public Parser(PApplet myParent) {
        this.myParent = myParent;
    }

    /**
     * Private parser helper function
     * @param prod String
     * @param rule Rule
     * @return production String
     */
    private String parser(String prod, Rule rule) {
        StringBuilder newProduction = new StringBuilder("");
        CharacterIterator it = new StringCharacterIterator(prod);
        for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
            if (rule != null) { // ignore null array entry
                if (ch == rule.key()) {
                    newProduction = newProduction.append(rule.getRule());
                }
                if (ch != rule.key()) {
                    newProduction = newProduction.append(ch);
                }
            }
        }
        return newProduction.toString();
    }

    /**
     *
     * @param prod_ initially axiom then production String
     * @param rule_ an array of character substition rules (order is important)
     * @return the current production String
     */
    public String parseRule(String prod_, Rule[] rule_) {
        String production = prod_;
        for (int i = 0; i < rule_.length; i++) {
            if (rule_[i] != null) { // ignore null array entry
                production = parser(production, rule_[i]); // feed result back
            }
        }
        return production;
    }

    	/**
	 * return the version of the library.
	 *
	 * @return String
	 */
	public String version() {
		return VERSION;
	}
}
