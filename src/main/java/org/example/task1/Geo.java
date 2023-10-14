package org.example.task1;

public class Geo {
    private String lat;

    public Geo(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "lat='" + lat + '\'' +
                '}';
    }
}