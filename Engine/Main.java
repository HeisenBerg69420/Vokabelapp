package Engine;

import java.util.ArrayList;
import Objects.Vokabel;
import Structures.*;
import Timeslice.Timeslice;
import View.View;

public class Main{

    private static ArrayList<List<Vokabel>> box;
    private static View view;
    private static Thread timeslice;

    public static void main(String[] args) {
        view = new View();
        timeslice = new Thread(new Timeslice());
        timeslice.start();
    }
}