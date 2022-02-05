package com.github.alllef;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

class Ball extends GraphicEntity{
    private Component canvas;
    private boolean isInsidePocket = false;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int dx = 2;
    private int dy = 2;

    public Ball(Component c) {
        super(XSIZE,YSIZE,0,0);
        this.canvas = c;
        if (Math.random() < 0.5) {
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        } else {
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }

    }

    public static void f() {
        int a = 0;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.darkGray);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }

    public void move() {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= this.canvas.getWidth()) {
            x = this.canvas.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= this.canvas.getHeight()) {
            y = this.canvas.getHeight() - YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }

    public boolean isInsidePocket() {
        return isInsidePocket;
    }

    public void setInsidePocket(boolean insidePocket) {
        isInsidePocket = insidePocket;
    }
}