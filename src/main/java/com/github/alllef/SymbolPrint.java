package com.github.alllef;

public class SymbolPrint {
    private boolean isDashPrinted = false;

    public synchronized void printDash() {
        while (isDashPrinted) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("-");
        isDashPrinted = true;
        notifyAll();
    }

    public synchronized void printDelimiter() {
        while (!isDashPrinted) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("|");
        isDashPrinted = false;
        notifyAll();
    }

}
