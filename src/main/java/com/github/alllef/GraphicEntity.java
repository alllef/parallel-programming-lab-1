package com.github.alllef;

import java.awt.*;

public abstract class GraphicEntity {
    protected int xSIZE;
    protected int ySIZE;
    protected int x;
    protected int y;

    public GraphicEntity(int XSIZE, int YSIZE, int x, int y) {
        this.xSIZE = XSIZE;
        this.ySIZE = YSIZE;
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics2D g2);

    public boolean isInside(GraphicEntity entity) {
        return x >= entity.x && x + xSIZE <= entity.x + entity.xSIZE
                && y >= entity.y && y + ySIZE <= entity.y + entity.ySIZE;
    }

    public int getxSIZE() {
        return xSIZE;
    }

    public int getySIZE() {
        return ySIZE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
