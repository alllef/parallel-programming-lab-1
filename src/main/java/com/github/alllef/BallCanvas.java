package com.github.alllef;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    Pocket pocket = new Pocket();
    int ballsInPocket = 0;
    JLabel jLabel = new JLabel("Number of balls in pocket = " + ballsInPocket);

    BallCanvas() {
        super();
        this.add(jLabel);
    }

    public void add(Ball b) {
        this.balls.add(b);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < balls.size(); i++) {
            Ball b = balls.get(i);
            if (b.isInside(pocket) && b.getColor().equals(Color.DARK_GRAY)) {
                balls.remove(b);
                b.setInsidePocket(true);
                jLabel.setText("Number of balls in pocket = " + ++ballsInPocket);
            } else
                b.draw(g2);

            pocket.draw(g2);
        }
    }


}