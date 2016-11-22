package tul.ssv.model;

import java.awt.Color;
import tul.ssv.utils.Point;
import tul.ssv.utils.PointBuffer;

public class Planet {
    
    public static final int PLANET_DATA_SIZE = 5;
    public static final int HISTORY_SIZE = 1000;
    

    private double mass;
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double size;
    private Color color;
    
    public final PointBuffer<Point> history = new PointBuffer<>(HISTORY_SIZE);
    
    public void saveHistory() {
        history.add(new Point(x, y));
    }

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
            y,
            vx,
            vy
        };
    }
    
    public void load (double[] data) {
        mass = data[0];
        x = data[1];
        y = data[2];
        vx = data[3];
        vy = data[4];
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

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    
    
}
