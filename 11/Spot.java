package jp.ac.ait.k21085;

import java.util.Objects;

public class Spot {
    private double latitude;//緯度
    private double longitude;//経度
    private double distance;
    private String spotname;

    public Spot(double longitude, double latitude, double distance, String spotname) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.distance = distance;
        this.spotname = spotname;
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getSpotname() {
        return spotname;
    }

    public void setSpotname(String spotname) {
        this.spotname = spotname;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        Spot other = (Spot) obj;
//        return Objects.equals(spotname, other.spotname);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(spotname);
//    }


    @Override
    public String toString() {
        return String.format("%s,%f,%f,%s",
                this.getLatitude(),
                this.getLongitude(),
                this.getDistance(),
                this.getSpotname());
    }
}
