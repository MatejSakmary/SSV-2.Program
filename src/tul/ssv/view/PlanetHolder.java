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
        
        drawTool.setOrigin(getSize());
        for (Planet planet : items) {
            drawTool.drawHistory(g, planet);
        }
        
        for (Planet planet : items) {
            drawTool.draw(g, planet);
        }
        
    }

    public void add(Planet planet) {
        items.add(planet);
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
        
        for (Planet planet : items) {
            planet.saveHistory();
        }
    }
    

}
