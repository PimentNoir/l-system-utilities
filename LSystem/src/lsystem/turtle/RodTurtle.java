    /* 
 * Copyright (c) 2011 Martin Prout
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

import lsystem.util.*;
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

    @Override
    public void pitch(float angle) {
        parent.rotateY(angle);
    }

    @Override
    public void roll(float angle) {
        parent.rotateZ(angle);
    }

    @Override
    public void yaw(float angle) {
        parent.rotateX(angle);
    }

    /**
     * Draw a smooth cylinder capped at one end with a sphere uses
     * a look up table for sin and cos (NB: degree not radians)
     * @param distance 
     * @distance the length of the cylinder
     */
    public void drawRod(float distance) {
        int sides = detail[3]; // ensure 360 % sides is zero
        float r = distance / 7;
        int angle = 0;
        int angleIncrement = 360 / sides;
        firstCap(distance / 7, sides);
        parent.translate(0, 0, distance / 2);
        parent.beginShape(PApplet.QUAD_STRIP);
        for (int i = 0; i <= (sides + 1); i++) {
            parent.normal(LUT.cos(angle), LUT.sin(angle), 0);
            parent.vertex(r * LUT.cos(angle), r * LUT.sin(angle), distance / 2);
            parent.vertex(r * LUT.cos(angle), r * LUT.sin(angle), -distance / 2);
            angle += angleIncrement;
        }
        // add hemisphere cap to cylinder
        nextCap(distance / 7, distance / 2, sides);
        parent.endShape();
        parent.translate(0, 0, distance / 2);

    }

    /**
     * Draws a hemisphere cap, saves drawing spheres detail is number 
     * of lat & long divisions of the sphere
     * @param r 
     * @param dist 
     * @param detail 
     * @r radius float
     * @dist is distance to cap from 'centre origin' float
     * @detail latitude division int
     */
    public void nextCap(float r, float dist, int detail) {
        int halfLat = detail / 2;
        for (int i = 0; i <= halfLat; i++) {
            float lat0 = -85 + 180 * (i - 1) / detail;
            float z0 = LUT.sin(lat0) * r;
            float zr0 = -LUT.cos(lat0) * r;

            float lat1 = -85 + 180 * i / detail;
            float z1 = LUT.sin(lat1) * r;
            float zr1 = -LUT.cos(lat1) * r;
            for (int j = 0; j <= detail; j++) {
                float lng = 360 * (j - 1) / detail;
                float x = LUT.cos(lng);
                float y = -LUT.sin(lng);
                parent.normal(x * zr0, y * zr0, -z0);
                parent.vertex(x * zr0, y * zr0, -z0 + dist);
                parent.normal(x * zr1, y * zr1, -z1);
                parent.vertex(x * zr1, y * zr1, -z1 + dist);
            }
        }
    }

    /**
     * Draws a sphere cap, as the first cap
     * @param r 
     * @dist is distance to cap from 'centre origin' float
     * @detail latitude division int
     */
    public void firstCap(float r, int detail) {
        parent.sphereDetail(detail);
        parent.sphere(r);
    }
}

