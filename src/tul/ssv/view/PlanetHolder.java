package tul.ssv.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import tul.ssv.DrawTool;
import tul.ssv.model.Planet;

public class PlanetHolder extends javax.swing.JPanel {

    List<Planet> items = new ArrayList<>();
    DrawTool drawTool = new DrawTool();

    public PlanetHolder() {
        this.setLayout(null);
        this.setBackground(Color.GRAY);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Planet planet : items) {
            drawTool.draw(g, planet);
        }
    }

    public void add(Planet planet) {
        items.add(planet);
    }

    public void add(double mass, double x, double y, double size, Color color) {
        this.add(new Planet(mass, x, y, size, color));
    }

    public Planet get(int i) {
        return items.get(i);
    }

    public double[][] save() {
        double[][] result = new double[items.size()][Planet.PLANET_DATA_SIZE];
        for (int i = 0; i < result.length; i++) {
            result[i] = get(i).save();
        }
        return result;
    }

    public void load(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            get(i).load(data[i]);
        }
    }

}
