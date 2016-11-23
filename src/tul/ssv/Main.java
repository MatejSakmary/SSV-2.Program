package tul.ssv;

import tul.ssv.model.Planet;
import tul.ssv.view.PlanetHolder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import tul.ssv.view.Controls;

public class Main extends JFrame {

    public java.util.List<Planet> items = new ArrayList<>();

    public final int FPS = 60;
    public final PlanetHolder planetHolder = new PlanetHolder();
    public final Controls controls = new Controls(planetHolder);

    public static void main(String[] args) {
        new Main();
    }

    public Main() throws HeadlessException {

        this.setTitle("GUI aplikace");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.RED);
        this.setLayout(new BorderLayout());

        Container container = getContentPane();
        container.add(planetHolder, BorderLayout.CENTER);
        container.add(controls, BorderLayout.EAST);
        
        Planet a = new Planet(1e12, 300, 300, 20, Color.green);
        Planet b = new Planet(1e12, 150, 150, 10, Color.red);
        
        b.setVx(.5);
        b.setVy(.3);
        
        a.setVx(-.3);
        a.setVy(.3);
        
        planetHolder.add(a);
        planetHolder.add(b);
        planetHolder.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                controls.updatePos(e);
            }
            
        });

        while (true) {
            double[][] data = planetHolder.save();
            data = tul.ssv.math.Math.step(data);
            planetHolder.load(data);
            
            controls.updateDebugArea();
            repaint();

            try {
                Thread.currentThread().sleep(1000 / FPS);
            } catch (InterruptedException ex) {
            }
        }

    }

}
