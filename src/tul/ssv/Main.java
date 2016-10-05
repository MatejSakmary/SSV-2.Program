package tul.ssv;

import tul.ssv.model.Planet;
import tul.ssv.view.PlanetHolder;
import tul.ssv.view.PlanetDraw;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame{
    public java.util.List<Planet> items = new ArrayList<>();

    public final int FPS = 60;
    public final PlanetHolder planetHolder = new PlanetHolder();

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
        container.add(new JButton("foo bar"), BorderLayout.EAST);

        while (true) {
            repaint();

            try {
                Thread.currentThread().sleep(1000 / FPS);
            } catch (InterruptedException ex) {
            }
        }


    }



}