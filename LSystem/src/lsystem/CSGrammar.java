/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lsystem;

import processing.core.PApplet;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import lsystem.collection.CSList;

public class CSGrammar implements Grammar {

    private PApplet parent;
    private String axiom;
    private CSList rules;
    private StringCharacterIterator lIterator;

     /**
     * Preferred constructor for processing
     * @param parent
     * @param axiom
     */
    public CSGrammar(PApplet parent, String axiom) {
        this.parent = parent;
        this.parent.registerDispose(this);
        this.axiom = axiom;
        rules = new CSList();
        System.err.println("CSGrammar LSystem v" + version());
    }

    /**
     * Default constructor for testing
     * @param axiom
     */
    public CSGrammar(String axiom) {
        this.axiom = axiom;
        rules = new CSList();
    }

    public void addRule(char premise, String rule) {
        rules.addRule(premise, rule);
    }

    public void addRule(String premise, String rule) {
        rules.addRule(premise, rule);
    }

    public void addRule(char premise, String rule, float weight) {
        throw new RuntimeException("Use StochasticGrammar for weighted rules");
    }

    public StringBuilder getRule(char premise, String production, int count) {
        return rules.getCSRule(premise, production, count);
    }

    public boolean hasKey(char premise) {
        return rules.hasRule(premise);
    }

    /**
     * Set the character ignore list
     * @param str ignore list as a String
     */
    public void setIgnoreList(String str) {
        rules.setIgnoreList(str);
    }

    /**
     * Set the character ignore list
     * @param str ignore list as a char[]
     */
    public void setIgnoreList(char[] str) {
        rules.setIgnoreList(str);
    }

    /**
     * Private parseRules helper function
     * @param prod String
     * @return production String
     */

    private String parseRules(String production) {
        StringBuilder newProduction = new StringBuilder("");
        int count = -1;
        CharacterIterator it = getIterator(production);
        for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
            newProduction.append((hasKey(ch)) ? getRule(ch, production, ++count) : ch);
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
    public CharacterIterator getIterator(String production) {
        if (lIterator == null) {
            return new StringCharacterIterator(production);
        } else {
            lIterator.setText(production);
            return lIterator;
        }
    }

    public void dispose() {
        rules.clear();
        axiom = null;
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder("Axiom: ");
        description.append(axiom);
        description.append("\n");
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

    public String getRule(char premise) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
