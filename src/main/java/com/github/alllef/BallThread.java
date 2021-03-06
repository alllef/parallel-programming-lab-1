package com.github.alllef;

public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball) {
        b = ball;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 10000; i++) {
                b.move();
                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                System.out.println("Priority is "+Thread.currentThread().getPriority());
                Thread.sleep(5);
                if (b.isInsidePocket())
                    break;
            }
        } catch (InterruptedException ex) {

        }
    }

    public Ball getB() {
        return b;
    }
}