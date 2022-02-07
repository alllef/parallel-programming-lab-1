package com.github.alllef;

import javax.swing.*;

public class Bounce {
    public static void main(String[] args) {
        BounceFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println("Thread name = " + Thread.currentThread().getName());

        SymbolPrint symbolPrint = new SymbolPrint();
        Thread dashThread = new Thread(() -> {
            for (int i = 0; i < 100; i++)
                symbolPrint.printDash();
        });

        Thread delimiterThread = new Thread(() -> {
            for (int i = 0; i < 100; i++)
                symbolPrint.printDelimiter();
        });

        dashThread.start();
        delimiterThread.start();
    }
}