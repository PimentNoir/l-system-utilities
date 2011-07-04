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
package lsystem.util;

/**
 * A very restricted lookup table for fast sine & cosine computations. The table 
 * currently has a fixed precision of 1.0 degrees. Thus should be as accurate as 
 * Math.sin when using integer input. However with a float input, values are 
 * cast to integer, and there will be errors. Note the reduced lookup up table, 
 * is restricted to the first quadrant of sine. Conditional rules are used to 
 * map to other quadrants and cos. Based on ideas from:-
 * http://en.wikipedia.org/wiki/Lookup_table
 * One annoyance of java is the behaviour of % wrt negative values cf python for 
 * example. A kludge is required to return the complement of 360, which would 
 * not otherwise be required.
 */
public class LUT {

    /**
     * LUT for sine values
     */
    public static double[] sinLUT = new double[91];


    /**
     * Initialise sin table with values (first quadrant only)
     */
    public static void initialize() {
        for (int i = 0; i <= 90; i++) {
            sinLUT[i] = Math.sin(Math.toRadians(i));
        }
    }

    /**
     * Look up sine for the passed angle in degrees.
     * 
     * @param thet degree int
     * @return sine value for theta
     */
    public static float sin(int thet) {
        while (thet < 0) {
            thet += 360; // Needed because negative modulus plays badly in java
        }
        int theta = thet % 360;
        int y = theta % 90;
        float result = (theta < 90) ? (float) sinLUT[y] : (theta < 180)
                ? (float) sinLUT[90 - y] : (theta < 270)
                ? (float) -sinLUT[y] : (float) -sinLUT[90 - y];
        return result;
    }

    /**
     * Look up sin for the passed angle in degrees. NB lacks precision unless
     * float is round number (needed to work with pen and turtle interface)
     * @param thet degree float
     * @return sin value for theta
     */
    public static float sin(float thet) {
        return sin((int) thet);
    }

    /**
     * Look up cos for the passed angle in degrees.
     * 
     * @param thet degree int
     * @return sine value for theta
     */
    public static float cos(int thet) {
        while (thet < 0) {
            thet += 360; // Needed because negative modulus plays badly in java
        }
        int theta = thet % 360;
        int y = theta % 90;
        float result = (theta < 90) ? (float) sinLUT[90 - y] : (theta < 180)
                ? (float) -sinLUT[y] : (theta < 270)
                ? (float) -sinLUT[90 - y] : (float) sinLUT[y];
        return result;
    }
    
    /**
     * Look up cos for the passed angle in degrees. NB lacks precision unless
     * float is round number (needed to work with pen and turtle interface)
     * @param thet degree float
     * @return sine value for theta
     */

    public static float cos(float thet) {
        return cos((int) thet);
    }
}
