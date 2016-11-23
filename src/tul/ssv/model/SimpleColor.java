package tul.ssv.model;

import java.awt.Color;


public class SimpleColor {

    public SimpleColor(String name, Color color) {
        this.color = color;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
    public Color color;
    public String name;
    
}
