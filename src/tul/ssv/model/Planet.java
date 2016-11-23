package tul.ssv.model;

import java.awt.Color;

public class Planet {
    
    public static final int PLANET_DATA_SIZE = 3;

    private double mass;
    private double x;
    private double y;
    private double size;
    private Color color;


    public Planet(double mass, double x, double y, double size, Color color) {
        this.mass = mass;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public double[] save() {
        return new double[]{
            mass,
            x,
            y
        };
    }
    
    public void load (double[] data) {
        mass = data[0];
        x = data[1];
        y = data[2];
    }

    public Color getColor() {
        return color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSize() {
        return size;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getMass() {
        return mass;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
