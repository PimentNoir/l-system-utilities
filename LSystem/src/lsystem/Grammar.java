/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lsystem;

/**
 *
 * @author tux
 */
public interface Grammar {
    public final String VERSION = "0.2.0";

    void addRule(char premise, String rule);

    void addRule(char premise, String rule, float weight);

    String createGrammar(int repeats);

    String createGrammar();

    void dispose();

    String getRule(char premise);

    boolean hasKey(char premise);

    /**
     * return the version of the library.
     *
     * @return String
     */
    String version();

}
