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

        /*Planet a = new Planet("Země",   5.9736*10e23, 3496*10e4, 200*10e5, 20, Color.blue);
        Planet b = new Planet("Slunce", 1.9890*10e29, 200*10e5, 200*10e5, 100, Color.yellow);
        Planet c = new Planet("Měsíc",  7.3470*10e22, 349384*10e2, 200*10e5, 10, Color.black);
        //Planet c = new Planet("Měsíc",  7.3470*10e22, 0, 0, 10, Color.black);
        */

        Planet p;

        double c = 38;

        p = new Planet("Slunce", 2.9891e30, 0, 0, 50, Color.YELLOW);
        planetHolder.add(p);

        p = new Planet("Merkur", 3.3021e23, 57e6, 0, 10, Color.RED);
        p.setVy(47e3 * c);
        planetHolder.add(p);

        p = new Planet("Venuše", 4.868e24, 108e6, 0, 15, Color.ORANGE);
        p.setVy(35e3 * c);
        planetHolder.add(p);

        p = new Planet("Země", 5.9736*1e24, 149e6, 0, 20, Color.BLUE);
        p.setVy(30e3 * c);
        planetHolder.add(p);

        p = new Planet("Mars", 6.418*1e23, 227e6, 0, 18, Color.ORANGE);
        p.setVy(24e3 * c);
        planetHolder.add(p);


        p = new Planet("Jupiter", 1.899*1e27, 778e6, 0, 30, Color.YELLOW);
        p.setVy(13e3 * c);
        planetHolder.add(p);

        p = new Planet("Saturn", 5.684*1e26, 1426e6, 0, 25, Color.YELLOW);
        p.setVy(9.6e3 * c);
        planetHolder.add(p);

        p = new Planet("Uran", 8.680*1e25, 2870e6, 0, 6, Color.BLUE);
        p.setVy(6.795e3 * c);
        planetHolder.add(p);

        p = new Planet("Neptun", 1.0*1e26, 4452e6, 0, 8, Color.BLUE);
        p.setVy(5.43e3 * c);
        planetHolder.add(p);


        p = new Planet("Pluto", 1.3*1e22, 5893e6, 0, 5, Color.GREEN);
        p.setVy(4.6e3 * c*0.8);
        planetHolder.add(p);

        planetHolder.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                controls.updatePos(e);
            }

        });


        while (true) {
            long time = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                double[][] data = planetHolder.save();
                data = tul.ssv.math.Math.step(data);
                planetHolder.load(data);
            }
            controls.updateDebugArea();
            repaint();
            time = System.nanoTime()- time;

            try {
                Thread.currentThread().sleep(1000 / FPS);
            } catch (InterruptedException ex) {
            }

            controls.setFPS(time);
        }

    }

}