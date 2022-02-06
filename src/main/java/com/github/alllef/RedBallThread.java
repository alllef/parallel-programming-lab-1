package com.github.alllef;

public class RedBallThread extends BallThread {
    public RedBallThread(Ball ball) {
        super(ball);
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 10000; i++) {
                getB().move();
                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                System.out.println("Priority is " + Thread.currentThread().getPriority());
                Thread.sleep(5);

                if (i % 50 == 0) this.join(500);
                if (getB().isInsidePocket())
                    break;
            }
        } catch (InterruptedException ex) {

        }
    }
}
