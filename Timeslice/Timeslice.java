package Timeslice;

import View.View;

public class Timeslice extends Thread {

    private static int timeslot;

    public void run() {
        System.out.println("start Thread Timeslice");
        while(true) {
            goOn();
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void goOn() {
        timeslot++;
        
        if(timeslot % 1 == 0) {
            View.checkWindowState();
            // System.out.println("1");
        }

        if(timeslot % 2 == 0) {
            // System.out.println("2");
        }

        if(timeslot % 4 == 0) {
            // System.out.println("4");
        }

        if(timeslot % 8 == 0) {
            // System.out.println("8");
        }

        if(timeslot % 16 == 0) {
            // System.out.println("16");
        }

        if(timeslot % 32 == 0) {
            // System.out.println("32");
        }

        if(timeslot % 64 == 0) {
            // System.out.println("64");
        }

        if(timeslot % 128 == 0) {
            // System.out.println("128");
        }
    }
}
