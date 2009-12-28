package lsystem;

import processing.core.PApplet;
import java.util.TreeMap;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * Grammar class that provides convenience method for working with l-systems
 * @author tux
 */
public class Grammar {
    private String axiom;
    private TreeMap<Character, String>rules;

    public final String VERSION = "0.2.0";
    PApplet myParent;

    // preferred constructor?
    public Grammar(PApplet parent, String axiom) {
        this.myParent = parent;
        myParent.registerDispose(this);
        this.axiom = axiom;
        rules = new TreeMap<Character, String>();
    }

    // Default constructor for testing
    public Grammar(String axiom) {
        this.axiom = axiom;
        rules = new TreeMap<Character, String>();
    }

    public void addRule(char premise, String rule){
        rules.put(premise, rule);
    }

    public String getRule(char premise){
        return rules.get(premise);
    }

    public boolean hasKey(char premise){
        return rules.containsKey(premise);
    }

    public boolean notEmpty(){
        return !rules.isEmpty();
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
            if (notEmpty()) { // ignore empty Map
                newProduction.append((hasKey(ch)) ? getRule(ch) : ch);
            }
        }
        return newProduction.toString();
    }
    
    public String createGrammar(int repeats) {
      String production = axiom;
      for (int i = 0; i < repeats; i++){
        production = parseRules(production);
      }      
      return production;
    }
    
    public String createGrammar() {
      return createGrammar(0);
    }



    public void dispose() {
        rules.clear();
        rules = null;
        axiom = null;
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
