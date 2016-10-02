package tul.ssv.view;

import java.awt.*;

public class PlanetHolder extends javax.swing.JPanel {

    PlanetDraw planet = new PlanetDraw();

    public PlanetHolder() {
        this.add(planet);
        this.setBackground(Color.BLACK);
    }

}
