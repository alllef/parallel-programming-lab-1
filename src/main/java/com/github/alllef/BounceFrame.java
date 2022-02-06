package com.github.alllef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new BallCanvas();

        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());

        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");
        JButton redBallButton = new JButton("Start red ball");
        JButton blueBallButton = new JButton("Start blue ball");
        JButton allBallButton = new JButton("Start all balls");

        buttonStart.addActionListener(e -> {
            Ball b = new Ball(canvas);
            canvas.add(b);
            BallThread thread = new BallThread(b);
            thread.start();
            System.out.println("Thread name =" + thread.getName());
        });

        redBallButton.addActionListener(e -> startRedBall());
        blueBallButton.addActionListener(e -> startBlueBall());
        allBallButton.addActionListener(e -> {
            for (int i = 0; i < 2; i++)
                startBlueBall();
            startRedBall();
        });

        buttonStop.addActionListener(e -> System.exit(0));
        List.of(buttonStart, buttonStop, redBallButton, blueBallButton, allBallButton)
                .forEach(buttonPanel::add);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void startRedBall() {
        Ball b = new Ball(canvas, 200, 200, Color.RED);
        canvas.add(b);
        BallThread thread = new BallThread(b);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        try {
            thread.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread name =" + thread.getName());
    }

    private void startBlueBall() {
        Ball b = new Ball(canvas, 200, 200, Color.BLUE);
        canvas.add(b);
        BallThread thread = new BallThread(b);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        System.out.println("Thread name =" + thread.getName());
    }
}