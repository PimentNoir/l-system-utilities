/** 
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
/**
 * A restricted lookup table for fast sine & cosine computations. The table 
 * currently has a fixed precision of 0.25 degrees. Thus might be adequate for 
 * many purposes. There will be errors. Note the reduced lookup up table, 
 * is restricted to the first quadrant of sine. Conditional rules are used to 
 * map to other quadrants and cos. Based on ideas from:-
 * http://en.wikipedia.org/wiki/Lookup_table
 * One annoyance of java is the behaviour of % wrt negative values cf python for 
 * example. A kludge is required to return the complement of 360, which would 
 * not otherwise be required.
 * Double precision will be impossible unless input values are doubles with no 
 * decimal part, so we cast to float for lookup table to save a bit of space
 */
package lsystem.util;

public class LUT2 {

    /**
     * LUT for sine values 0.25 degree increments of first quadrant
     */
    public static float[] sinLUT = new float[361];
    
    public static final String message = "Sine/Cosine lookup tables initialized"
          + " with a fixed\nprecision of ca. 0.25 degrees. NB: degree input.\n";


    /**
     * Initialise sin table with values (first quadrant only)
     * Save a bit of space by storing as float
     */
    public static void initialize() {
        for (int i = 0; i <= 360; i++) {
            sinLUT[i] = (float) Math.sin(Math.toRadians(i / 4));
        }
        System.out.print(message);
    }

    /**
     * Look up sine for the passed angle in degrees.
     * 
     * @param thet degree int
     * @return sine value for theta
     */
    public static float sin(float thet) {
        while (thet < 0) {
            thet += 360; // Needed because negative modulus plays badly in java
        }
        int theta = Math.round(thet * 4) % 1440;
        int y = theta % 360;
        float result = (theta < 360) ? sinLUT[y] : (theta < 720)
                ? sinLUT[(360 - y)] : (theta < 1080)
                ? -sinLUT[y] : -sinLUT[(360 - y)];
        return result;
    }

    /**
     * Look up cos for the passed angle in degrees, fixed precision, no better
     * than 0.25 degree with some scope for errors.
     * 
     * @param thet degree float
     * @return sine value for theta
     */
    public static float cos(float thet) {
        while (thet < 0) {
            thet += 360; // Needed because negative modulus plays badly in java
        }
        int theta = Math.round(thet * 4) % 1440;
        int y = theta % 360;
        float result = (theta < 360) ? sinLUT[360 - y] : (theta < 720)
                ? -sinLUT[y] : (theta < 1080)
                ? -sinLUT[360 - y] : sinLUT[y];
        return result;
    }
}
