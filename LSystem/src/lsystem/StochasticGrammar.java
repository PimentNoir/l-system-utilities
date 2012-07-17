/* 
 * Copyright (c) 2011/12 Martin Prout
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
import lsystem.collection.StochasticList;
import processing.core.PApplet;

/**
 * StochasticGrammar class that provides convenience method for working with
 * l-systems
 *
 * @author tux
 */
public class StochasticGrammar implements Grammar {

    private String axiom;
    private String production;
    private RuleList rules;
    private StringCharacterIterator lIterator;
    PApplet myParent;

    /**
     * Constructor for use with processing Applet
     *
     * @param parent
     * @param axiom
     */
    public StochasticGrammar(PApplet parent, String axiom) {
        this.myParent = parent;
        myParent.registerDispose(this);
        this.axiom = axiom;
        rules = new StochasticList();
        //System.err.println("StochasticGrammar LSystem v" + version());
    }

    /**
     * Default constructor for testing
     *
     * @param axiom
     */
    public StochasticGrammar(String axiom) {
        this.axiom = axiom;
        rules = new StochasticList();
    }

    /**
     * add non weighted rule (or default weighting if more than on entry)
     *
     * @param premise char
     * @param rule String
     */
    @Override
    public void addRule(char premise, String rule) {
        rules.addRule(premise, rule);
    }

    /**
     * add weighted rule
     *
     * @param premise char
     * @param rule String
     * @param weight float
     */
    @Override
    public void addRule(char premise, String rule, float weight) {
        rules.addRule(premise, rule, weight);
    }

    /**
     * get rule (NB: a weighted rule returned if multiple rules stored for a
     * given rule ie non-deterministic behaviour, be warned)
     *
     * @param premise char
     * @return rule String
     */
    @Override
    public String getRule(char premise) {
        return rules.getRule(premise);
    }

    /**
     * @param premise char
     * @return true when present
     */
    @Override
    public boolean hasKey(char premise) {
        return rules.hasRule(premise);
    }

    /**
     * Private parseRules helper function
     *
     * @param production Rule
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

    public void generateGrammar(int repeats) {
        String prod = axiom;
        for (int i = 0; i < repeats; i++) {
            prod = parseRules(prod);
        }
        this.production = prod;
    }

    public void generateGrammar() {
        generateGrammar(0);
    }

    public CharacterIterator getIterator() {
        if (lIterator == null) {
            lIterator = new StringCharacterIterator(production);
        } else {
            lIterator.setText(production);
        }
        return lIterator;
    }


    @Override
    @Deprecated public String createGrammar(int repeats) {
        String prod = axiom;
        for (int i = 0; i < repeats; i++) {
            prod = parseRules(prod);
        }
        return prod;
    }

    @Override
    @Deprecated public String createGrammar() {
        return createGrammar(0);
    }

    /**
     * Makes the CharacterIterator available internally/externally Create a new
     * instance if none exists otherwise re-use existing instance
     *
     * @param production String
     * @return lIterator the grammar CharacterIterator
     */
    @Override
    public CharacterIterator getIterator(String production) {
        if (lIterator == null) {
            lIterator = new StringCharacterIterator(production);
        } else {
            lIterator.setText(production);
        }
        return lIterator;
    }

    /**
     *
     * Empty collections on dispose
     */
    @Override
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
    @Override
    public final String version() {
        return VERSION;
    }
}
