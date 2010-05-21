package lsystem;

import processing.core.PApplet;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * Implements Grammar interface
 * SimpleGrammar class that provides convenience method for working with l-systems
 * @author Martin Prout
 */
public class SimpleGrammar implements Grammar {

    private String axiom;
    private RuleList rules;
    private StringCharacterIterator lIterator;
    
    PApplet myParent;

    // preferred constructor?
    /**
     *
     * @param parent
     * @param axiom
     */
    public SimpleGrammar(PApplet parent, String axiom) {
        this.myParent = parent;
        myParent.registerDispose(this);
        this.axiom = axiom;
        rules = new SimpleRuleList();
        System.err.println("LSystem v" + version());
    }

    /**
     * Default constructor for testing
     * @param axiom
     */
    public SimpleGrammar(String axiom) {
        this.axiom = axiom;
        rules = new SimpleRuleList();
    }

    public void addRule(char premise, String rule) {
        rules.addRule(premise, rule);
    }

    public void addRule(char premise, String rule, float weight) {
        throw new RuntimeException("Use StochasticGrammar for weighted rules");
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
        CharacterIterator it = getIterator(production);
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

  /**
  * Makes the CharacterIterator available internally/externally
  * Create a new instance if none exists otherwise re-use existing instance
  * @param production String
  * @return lIterator the grammar CharacterIterator
  */


    public CharacterIterator getIterator(String production){
     if (lIterator == null)
     {
      return new StringCharacterIterator(production);
     }
     else {
      lIterator.setText(production);
      return lIterator;
     }
    }

    public void dispose() {
        rules.clear();
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
