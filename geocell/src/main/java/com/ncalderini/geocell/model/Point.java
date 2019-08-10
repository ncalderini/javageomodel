/*
Copyright 2010 Alexandre Gellibert

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.apache.org/licenses/
LICENSE-2.0 Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an "AS IS"
BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
implied. See the License for the specific language governing permissions
and limitations under the License.
*/

package com.ncalderini.geocell.model;

import org.apache.commons.lang.Validate;

import java.io.Serializable;

/**
 *
 * @author Alexandre Gellibert
 *
 */
public class Point implements Serializable, Comparable<Point> {
    public static final long serialVersionUID = 349808987517153697L;

    private double latitude;
    private double longitude;

    public Point() {
    	
    }

    public Point(double latitude, double longitude) {
    	Validate.isTrue(!(latitude > 90.0 || latitude < -90.0), "Latitude must be in [-90, 90]  but was ", latitude);
    	Validate.isTrue(!(longitude > 180.0 || longitude < -180.0), "Longitude must be in [-180, 180] but was ", longitude);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int compareTo(Point o) {
        int latResult = Double.compare(this.latitude, o.latitude);
        return latResult != 0 ? latResult : Double.compare(this.longitude, o.longitude);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Point point = (Point)o;
            if (Double.compare(point.latitude, this.latitude) != 0) {
                return false;
            } else {
                return Double.compare(point.longitude, this.longitude) == 0;
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.latitude != 0.0F ? Float.floatToIntBits((float)this.latitude) : 0;
        result = 31 * result + (this.longitude != 0.0F ? Float.floatToIntBits((float)this.longitude) : 0);
        return result;
    }

    public String toString() {
        return String.format("%f,%f", this.latitude, this.longitude);
    }

    static double distance(Point p1, Point p2) {
        double latitude = Math.toRadians((double)p1.getLatitude());
        double longitude = Math.toRadians((double)p1.getLongitude());
        double otherLatitude = Math.toRadians((double)p2.getLatitude());
        double otherLongitude = Math.toRadians((double)p2.getLongitude());
        double deltaLat = latitude - otherLatitude;
        double deltaLong = longitude - otherLongitude;
        double a1 = haversin(deltaLat);
        double a2 = Math.cos(latitude) * Math.cos(otherLatitude) * haversin(deltaLong);
        return 1.274202E7D * Math.asin(Math.sqrt(a1 + a2));
    }

    private static double haversin(double delta) {
        double x = Math.sin(delta / 2.0D);
        return x * x;
    }
}
