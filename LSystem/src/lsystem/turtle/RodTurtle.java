    /* 
 * Copyright (c) 2011/12 Martin Prout
 * 
 * This demo & library is free software; you can redistribute it and/or
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
package lsystem.turtle;

import lsystem.util.LUT;
import processing.core.PApplet;

/**
 *
 * @author Martin Prout <martin_p@lineone.net>
 */
public class RodTurtle implements Turtle3D {

    private PApplet parent;
    int[] detail = {
        36, 24, 18, 15, 12
    };

    /**
     * initialise and instance of RodTurtle
     *
     * @param parent
     */
    public RodTurtle(PApplet parent) {
        this.parent = parent;
        LUT.initialize();
    }

    @Override
    public void draw(float distance) {
        drawRod(distance);
    }
    

    /**
     * 
     * @param distance
     * @param depth
     */
    public void draw(float distance, int depth) {
        drawRod(distance, depth);
    }

    @Override
    public void forward(float distance) {
        parent.translate(0, 0, distance);
    }

    @Override
    public void pitch(int angle) {
        parent.rotateY(angle * LUT.TO_RADIANS);
    }

    @Override
    public void roll(int angle) {
        parent.rotateZ(angle * LUT.TO_RADIANS);
    }

    @Override
    public void yaw(int angle) {
        parent.rotateX(angle * LUT.TO_RADIANS);
    }

    /**
     *
     * @param angle
     */
    @Override
    public void pitch(float angle) {
        parent.rotateY(angle);
    }

    /**
     *
     * @param angle
     */
    @Override
    public void roll(float angle) {
        parent.rotateZ(angle);
    }

    /**
     *
     * @param angle
     */
    @Override
    public void yaw(float angle) {
        parent.rotateX(angle);
    }

    /**
     * Draw a smooth cylinder capped at one end with a sphere uses a look up
     * table for sin and cos (NB: degree not radians)
     *
     * @param distance the length of the cylinder
     */
    public void drawRod(float distance) {
        drawRod(3);
    }

    /**
     * Draw a smooth cylinder capped at one end with a sphere uses a look up
     * table for sin and cos (NB: degree not radians)
     *
     * @param distance the length of the cylinder
     * @param level detail ie inverse of level 
     */
    public void drawRod(float distance, int level) {
        int sides = detail[level]; // ensure 360 % sides is zero
        float r = distance / 7;
        int angle = 0;
        int angleIncrement = 360 / sides;
        endCap(distance / 7, sides);
        parent.translate(0, 0, distance / 2);
        parent.beginShape(PApplet.QUAD_STRIP);
        for (int i = 0; i <= sides; i++) {
            parent.normal(LUT.cos(angle), LUT.sin(angle), 0);
            parent.vertex(r * LUT.cos(angle), r * LUT.sin(angle), distance / 2);
            parent.vertex(r * LUT.cos(angle), r * LUT.sin(angle), -distance / 2);
            angle += angleIncrement;
        }
        parent.endShape();
        parent.translate(0, 0, distance / 2);

    }

    /**
     * Draws a sphere cap
     *
     * @param r radius float
     * @param detail latitude division int
     */
    public void endCap(float r, int detail) {
        parent.sphereDetail(detail);
        parent.sphere(r);
    }
}
