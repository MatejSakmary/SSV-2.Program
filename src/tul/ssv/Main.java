package tul.ssv;

import sun.security.provider.Sun;
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

    public final int FPS = 30;
    public final PlanetHolder planetHolder = new PlanetHolder();
    public final Controls controls = new Controls(planetHolder);

    public static void main(String[] args) {
        new Main();
    }

    public Main() throws HeadlessException {

        this.setTitle("GUI aplikace");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.RED);
        this.setLayout(new BorderLayout());

        Container container = getContentPane();
        container.add(planetHolder, BorderLayout.CENTER);
        container.add(controls, BorderLayout.EAST);
        
        Planet earth = new Planet(59736*10e19, 3496*10e4, 200*10e5, 20, Color.blue);
        Planet sun = new Planet(1989*10e26, 200*10e5, 200*10e5, 100, Color.yellow);
        Planet moon = new Planet(7347*10e19, 349984*10e2, 200*10e5, 5, Color.black);
        Planet sun2 = new Planet(1989*10e26, 300*10e5, 200*10e5, 100, Color.yellow);
        Planet experimental = new Planet(7347*10e25, 200*10e5, 300*10e5, 20, Color.black);

        moon.setVy(-42000);
        earth.setVy(-900000);
        experimental.setVy(0);

        planetHolder.add(earth);
        planetHolder.add(moon);
        planetHolder.add(sun);
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