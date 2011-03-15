package lsystem;

import lsystem.collection.StochasticList;
import lsystem.collection.RuleList;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import processing.core.PApplet;

/**
 * StochasticGrammar class that provides convenience method for working with l-systems
 * @author tux
 */
public class StochasticGrammar implements Grammar {

    private String axiom;
    private RuleList rules;
    private StringCharacterIterator lIterator;
    PApplet myParent;

    /**
     * Constructor for use with processing Applet
     * @param parent
     * @param axiom
     */
    public StochasticGrammar(PApplet parent, String axiom) {
        this.myParent = parent;
        myParent.registerDispose(this);
        this.axiom = axiom;
        rules = new StochasticList();
        System.err.println("StochasticGrammar LSystem v" + version());
    }

    /**
     * Default constructor for testing
     * @param axiom
     */
    public StochasticGrammar(String axiom) {
        this.axiom = axiom;
        rules = new StochasticList();
    }

    /**
     * add non weighted rule (or default weighting if more than on entry)
     * @param premise char
     * @param rule String
     */
    public void addRule(char premise, String rule) {
        rules.addRule(premise, rule);
    }

    /**
     * add weighted rule
     * @param premise char
     * @param rule String
     * @param weight float     
     */
    public void addRule(char premise, String rule, float weight) {
        rules.addRule(premise, rule, weight);
    }

    /**
     * get rule (NB: a weighted rule returned if multiple rules stored for a
     * given rule ie non-deterministic behaviour, be warned)
     * @param premise char
     * @return rule String   
     */
    public String getRule(char premise) {
        return rules.getRule(premise);
    }

    /**
     * @param premise char
     * @return true when present
     */
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

    /**
     * create production String from axiom, rules (and no. generations)
     * @return production String
     */
    public String createGrammar(int repeats) {
        String production = axiom;
        for (int i = 0; i < repeats; i++) {
            production = parseRules(production);
        }
        return production;
    }

    /**
     * default create production String from axiom, rules no generations
     * useful in testing, expect to return axiom
     * @return production String
     */
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

    /**
     * 
     * Empty collections on dispose
     */
    public void dispose() {
        rules.clear();
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder("Axiom: ");
        description.append(axiom);
        description.append('\n');
        description.append(rules.toStringBuilder());
        return description.toString();
    }

    /**
     * return the version of the library.
     *
     * @return String
     */
    public final String version() {
        return VERSION;
    }
}
