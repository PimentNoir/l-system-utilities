package lsystem;

import processing.core.PApplet;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * StochasticGrammar class that provides convenience method for working with l-systems
 * @author tux
 */
public class StochasticGrammar implements Grammar {

    private String axiom;
    private RuleList rules;
    PApplet myParent;

    // preferred constructor?
    public StochasticGrammar(PApplet parent, String axiom) {
        this.myParent = parent;
        myParent.registerDispose(this);
        this.axiom = axiom;
        rules = new StochasticList();
    }

    // Default constructor for testing
    public StochasticGrammar(String axiom) {
        this.axiom = axiom;
        rules = new StochasticList();
    }

    public void addRule(char premise, String rule) {
        rules.addRule(premise, rule);
    }

    public void addRule(char premise, String rule, float weight) {
        rules.addRule(premise, rule, weight);
    }

    public String getRule(char premise) {
        return rules.getRule(premise);
    }

    public boolean hasKey(char premise) {
        return rules.hasRule(premise);
    }

    /**
     * Private parseRules helper function
     * @param prod String
     * @param rule Rule
     * @return production String
     */
    private String parseRules(String production) {
        StringBuilder newProduction = new StringBuilder("");
        CharacterIterator it = new StringCharacterIterator(production);
        for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
            newProduction.append((hasKey(ch)) ? getRule(ch) : ch);
        }
        return newProduction.toString();
    }

    public String createGrammar(int repeats) {
        String production = axiom;
        for (int i = 0; i < repeats; i++) {
            production = parseRules(production);
        }
        return production;
    }

    public String createGrammar() {
        return createGrammar(0);
    }

    public void dispose() {
        rules = null;
        axiom = null;
    }

    @Override
    public String toString(){
        StringBuilder description = new StringBuilder("Axiom: ");
        description.append(axiom);
        description.append("\n");
        description.append(rules.toString());
        return description.toString();
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
