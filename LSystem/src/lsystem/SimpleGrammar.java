/* 
 * Copyright (c) 2011 Martin Prout
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * http://creativecommons.org/licenses/LGPL/2.1/
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package lsystem;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import lsystem.collection.RuleList;
import lsystem.collection.SimpleRuleList;
import processing.core.PApplet;

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
        //System.err.println("SimpleGrammar LSystem v" + version());
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
     * @return production String
     */
    private String parseRules(String production) {
        StringBuilder newProduction = new StringBuilder(production.length() * 4);
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
    public CharacterIterator getIterator(String production) {
        if (lIterator == null) {
            lIterator = new StringCharacterIterator(production);
        } else {
            lIterator.setText(production);
        }
        return lIterator;
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
}
