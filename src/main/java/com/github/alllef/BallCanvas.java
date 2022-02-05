package com.github.alllef;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    Pocket pocket = new Pocket();

    public void add(Ball b) {
        this.balls.add(b);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {

            if (b.isInside(pocket)) {
                balls.remove(b);
                b.setInsidePocket(true);
            } else
                b.draw(g2);

            pocket.draw(g2);
        }
    }


}