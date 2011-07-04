package lsystem.util;

/**
 * Very restricted lookup table for fast sine & cosine computations. The table 
 * currently has a fixed precision of 1.0 degrees. Thus should be as accurate as Math.sin 
 * when using integer input. However with a float input, values are cast to integer, 
 * and there will be errors. Note reduced lookup up table, is restricted to the
 * first quadrant of sine.
 * Based on ideas from http://en.wikipedia.org/wiki/Lookup_table
 */
public class LUT {

    /**
     * LUT for sine values
     */
    public static double[] sinLUT = new double[91];

    // init sin table with values
    public static void initialize() {
        for (int i = 0; i <= 90; i++) {
            sinLUT[i] = Math.sin(Math.toRadians(i));
        }
    }

    /**
     * Look up sine for the passed angle in degrees.
     * 
     * @param theta degrees(int)
     * @return sine value for theta
     */
    public static float sin(int thet) {
        while (thet < 0){
            thet += 360; // Needed because negative modulus plays badly in java
        }
        int theta = thet % 360;
        int y = theta % 90;
        float result = (theta < 90) ? (float) sinLUT[y] : (theta < 180) ? (float) sinLUT[90 - y]
                : (theta < 270)
                ? (float) -sinLUT[y] : (float) -sinLUT[90 - y];
        return result;
    }

    /**
     * Look up sine for the passed angle in degrees.
     * 
     * @param theta degrees (float)
     * @return sine value for theta
     */
    public static float sin(float thet) {
        return sin((int) thet);
    }
    
    /**
     * Look up cos for the passed angle in degrees.
     * 
     * @param theta degrees (float)
     * @return sine value for theta
     */


    public static float cos(int thet) {
        while (thet < 0){
            thet += 360; // Needed because negative modulus plays badly in java
        }
        int theta = thet % 360;
        int y = theta % 90;
        float result = (theta < 90) ? (float) sinLUT[90 - y] : (theta < 180) ? (float) -sinLUT[y]
                : (theta < 270)
                ? (float) -sinLUT[90 - y] : (float) sinLUT[y];
        return result;
    }
    

    public static float cos(float thet) {
        return cos((int) thet);
    }
}
