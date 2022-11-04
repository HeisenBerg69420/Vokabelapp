package View;

import javax.swing.*;
import View.Windows.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View {

    private static JFrame frame;
    private static JLabel emptyLabel;

    private static WindowState windowState;

    private static Home home;
    private static VocAbfragen vocAbfragen;
    private static VocHinzufuegen vocHinzufuegen;
    private static VocEntfernen vocEntfernen;

    private static int buttonZurueckCounterOldHome;
    private static int buttonZurueckCounterOldVocHinzufuegen;
    private static int buttonVocLernenCounterOld;
    private static int buttonVocAddenCounterOld;
    private static int buttonVocEntfernenCounterOld;
    private static int buttonVocEntfernenZurueckCounterOld;

    public View() {
        objekteErstellen();
        buttonZurueckCounterOldHome = 0;
        buttonVocLernenCounterOld = 0;
        buttonZurueckCounterOldVocHinzufuegen = 0;
        buttonVocAddenCounterOld = 0;
        buttonVocEntfernenZurueckCounterOld = 0;
        buttonVocEntfernenCounterOld = 0;
        
        windowState = WindowState.HOME;
    }

    private void objekteErstellen() {
        frame = new JFrame();
        frame.setSize(400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        home = new Home();
        vocAbfragen = new VocAbfragen();
        vocHinzufuegen = new VocHinzufuegen();
        vocEntfernen = new VocEntfernen();

        emptyLabel = new JLabel("");
        frame.add(emptyLabel);
        emptyLabel.setVisible(true);

        frame.setVisible(true);
    }

    public static void checkWindowState() {
        boolean switched = false;
        if(VocAbfragen.getButtonZurueckCounter() != buttonZurueckCounterOldHome) {
            windowState = WindowState.HOME;
            buttonZurueckCounterOldHome = VocAbfragen.getButtonZurueckCounter();
            switched = true;
        }

        if(Home.getButtonVocAddenCounter() != buttonVocAddenCounterOld){
            windowState = WindowState.HINZUFUEGEN;
            buttonVocAddenCounterOld = Home.getButtonVocAddenCounter();
            switched = true;
        }

        if(Home.getButtonVocLernenCounter() != buttonVocLernenCounterOld) {
            windowState = WindowState.VOCABFRAGEN;
            buttonVocLernenCounterOld = Home.getButtonVocLernenCounter();
            switched = true;
        }

        if(Home.getButtonVocEntfernenCounter() != buttonVocEntfernenCounterOld) {
            windowState = WindowState.ENTFERNEN;
            buttonVocEntfernenCounterOld = Home.getButtonVocEntfernenCounter();
            switched = true;
        }

        if(VocHinzufuegen.getButtonZurueckCounter() != buttonZurueckCounterOldVocHinzufuegen) {
            windowState = WindowState.HOME;
            buttonZurueckCounterOldVocHinzufuegen = VocHinzufuegen.getButtonZurueckCounter();
            switched = true;
        }

        if(VocEntfernen.getButtonZurueckCounter() != buttonVocEntfernenZurueckCounterOld) {
            windowState = windowState.HOME;
            buttonVocEntfernenZurueckCounterOld = VocEntfernen.getButtonZurueckCounter();
            switched = true;
        }

        if(switched) {
            home.isVisible(false);
            vocAbfragen.isVisible(false);
            vocHinzufuegen.isVisible(false);
            vocEntfernen.isVisible(false);
            
            switch(windowState) {
                case HOME: 
                    home.isVisible(true); 
                    break;
                case VOCABFRAGEN: 
                    vocAbfragen.isVisible(true); 
                    vocAbfragen.getListeHeader().setText("Stapel: " + Home.getSprache());
                    vocAbfragen.getLabelRueckseite().setText(Home.getSprache());
                    break;
                case HINZUFUEGEN: 
                    vocHinzufuegen.isVisible(true); 
                    vocHinzufuegen.getListeHeader().setText("Stapel: " + Home.getSprache());
                    break;
                case ENTFERNEN: 
                    vocEntfernen.isVisible(true); 
                    vocEntfernen.getListeHeader().setText("Stapel: " + Home.getSprache());
                    break;
                default: break;
            }

            switched = false;
        }
            
            
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static Home getHome() {
        return home;
    }

    public static VocAbfragen getVocAbfragen() {
        return vocAbfragen;
    }

    

    
}
