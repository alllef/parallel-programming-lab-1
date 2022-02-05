package com.github.alllef;


import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pocket extends GraphicEntity{
    private static final int XSIZE = 40;
    private static final int YSIZE = 60;
    private static final int x = 200;
    private static final int y = 200;

    public Pocket() {
        super(XSIZE, YSIZE, x, y);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.darkGray);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }
}
