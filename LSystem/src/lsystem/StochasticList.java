/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lsystem;

import java.util.*;

/**
 *
 * @author tux
 */
public class StochasticList implements RuleList {

    private Set<Character> premises;
    private Map<Character, Map<String, Float>> weightedRules;

    public StochasticList() {
        premises = new HashSet<Character>();
        //   rules = new HashMap<Character, String>();
        weightedRules = new HashMap<Character, Map<String, Float>>();
    }

    public void addRule(char pre, String rule) throws RuntimeException {
        addRule(pre, rule, 1.0f);
    }

    public void addRule(char pre, String rule, float weight) throws RuntimeException {
        Map<String, Float> temp;
        if (premises.contains(pre)) // we store muliple rules in existing map
        {
            temp = weightedRules.get(pre);
            temp.put(rule, weight);
        } else { // we need a new rule/weight map
            Map<String, Float> temp2 = new HashMap<String, Float>();
            temp2.put(rule, weight);
            weightedRules.put(pre, temp2);
        }
        premises.add(pre);
    }

    private String getStochasticRule(Map<String, Float> weightedRules) {
        String result = null;
        Map<String, Float> temp = weightedRules;
        Collection<Float> values = temp.values();
        Iterator<Float> it = values.iterator();
        float total = 0;
        double p = Math.random();
        while (it.hasNext()) {
            total += it.next();
        }
        for (Iterator iterator = temp.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if (p < (Float) entry.getValue() / total) {
                result = (String) entry.getKey();
                break;
            } else {
                p -= (Float) entry.getValue() / total;
            }
        }
        return result;
    }

    public String getRule(char pre) {
        Map<String, Float> temp = weightedRules.get(pre);
        if (temp.size() == 1) {
            Object[] result = temp.keySet().toArray();
            return (String) result[0];
        } else {
            return getStochasticRule(temp);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Rules:\n");
        Character ch = ' ';
        for (Iterator it = weightedRules.entrySet().iterator(); it.hasNext();) {
            Map.Entry entrySet = (Map.Entry) it.next();
            ch = (Character) entrySet.getKey();
            sb.append(ch);
            sb.append("=>\n");
            Map rules = (Map) entrySet.getValue();
            for (Iterator iterator = rules.entrySet().iterator(); iterator.hasNext();) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String rule = (String) entry.getKey();
                sb.append("    ");
                sb.append(rule);
                Float weight = (Float) entry.getValue();
                sb.append(" [");
                sb.append(weight);
                sb.append("]");
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void dispose() {
        premises.clear();
        weightedRules.clear();
    }

    public boolean hasRule(char pre) {
        return premises.contains(pre);
    }
}


