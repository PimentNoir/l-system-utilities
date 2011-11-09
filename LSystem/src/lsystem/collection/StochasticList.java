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

package lsystem.collection;

import java.util.*;

/**
 * A storage class for weighted rules
 * holds/implements the weighted selection logic
 * @author Martin Prout
 */
public class StochasticList implements RuleList {

    private Set<Character> premises;
    private Map<Character, Map<String, Float>> weightedRules;

    /**
     * Constructor
     */
    public StochasticList() {
        premises = new HashSet<Character>();
        weightedRules = new HashMap<Character, Map<String, Float>>();
    }

    public void addRule(char pre, String rule) throws RuntimeException {
        addRule(pre, rule, 1.0f);
    }

    public void addRule(char pre, String rule, float weight) throws RuntimeException {
        Map<String, Float> temp;
        if (premises.contains(pre)) // we store multiple rules in existing map
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
        for (Map.Entry entry : temp.entrySet()) {
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

    /**
     *
     * @return
     */
    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder("Rules:\n");
        for (Map.Entry entrySet : weightedRules.entrySet()) {
            Character ch = (Character) entrySet.getKey();
            sb.append(ch);
            sb.append("=>\n");
            Map rules = (Map) entrySet.getValue();
            for (Object entry : rules.entrySet()) {
                String rule = (String) ((Map.Entry) entry).getKey();
                sb.append("    ");
                sb.append(rule);
                Float weight = (Float) ((Map.Entry) entry).getValue();
                sb.append(" [");
                sb.append(weight);
                sb.append(']');
                sb.append('\n');
            }
        }
        return sb;
    }

    /**
     * 
     * Empty collections on dispose
     */
    public void clear() {
        premises.clear();
        weightedRules.clear();
    }

    public boolean hasRule(char pre) {
        return premises.contains(pre);
    }
}
