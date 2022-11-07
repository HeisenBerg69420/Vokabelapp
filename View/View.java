package View;

import javax.swing.*;
import View.Windows.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


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

    private static int buttonVocHinzufuegenButtonCounterOld;
    private static int buttonVocEntfernenButtonCounterOld;

    
    private static int buttonNextCounterOld;
    private static int buttonBestaetigenCounterOld;
    private static int buttonGeltenLassenCounterOld;
    private static int tfBearbeitenHintCounterOld;
    private static int tfBearbeitenVorCounterOld;
    private static int buttonbearbCounterOld;
    

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

            //hier überprüfen, ob die hinzufügen buttons gedrückt wurden etc und ob die entfernen button gedrückt wurden
            //wenn ja dann den text getten und in die Liste, die sich am besten in Engine befindet hinzufügen als neue Vokabel
            //danach immer den view aktualisieren und die aktuelle list anzeigen -> der View wird also dauerhaft geupdated
            //oder besser ist, der Viewe wird nur geupdated wenn wirklich etwas geändert wurde
            //also ähnlich wie bei den Windows

            switched = false;

          //hinzufügen button
          if(VocHinzufuegen.getButtonHinzufuegenCounter() != buttonVocHinzufuegenButtonCounterOld) {
            //hier neue Vokabel hinzufügen
            buttonVocHinzufuegenButtonCounterOld = VocHinzufuegen.getButtonHinzufuegenCounter();
        }

        //entfernen button
        if(VocEntfernen.getButtonEntfernenCounter() != buttonVocEntfernenButtonCounterOld) {
            //hier die aktuell ausgewählte Vokabel getten und dann aus dem Stapel entfernen
            buttonVocEntfernenButtonCounterOld = VocEntfernen.getButtonEntfernenCounter();
        }

        if(VocAbfragen.getButtonBestaetigenCounter()!= buttonBestaetigenCounterOld){

            buttonBestaetigenCounterOld = VocAbfragen.getButtonBestaetigenCounter();
        }
        if(VocAbfragen.getButtonNextCounter()!= buttonNextCounterOld){

            buttonNextCounterOld = VocAbfragen.getButtonNextCounter();
        }
        if(VocAbfragen.getButtonGeltenLassenCounter()!= buttonGeltenLassenCounterOld){

            buttonGeltenLassenCounterOld = VocAbfragen.getButtonGeltenLassenCounter();
        }

        if(VocEntfernen.getButtonbearbCounter()!= buttonbearbCounterOld){

            buttonGeltenLassenCounterOld = VocEntfernen.getButtonbearbCounter();
        }
        if(VocEntfernen.getTfBearbeitenHintCounter()!= tfBearbeitenHintCounterOld){

            tfBearbeitenHintCounterOld = VocEntfernen.getTfBearbeitenHintCounter();
        }
        if(vocEntfernen.getTfBearbeitenVorCounter()!= tfBearbeitenVorCounterOld){

            buttonGeltenLassenCounterOld = VocAbfragen.getButtonGeltenLassenCounter();
        }
       
        
        

            if(switched) {
                //methode zum Updaten der Liste in Voc Entfernen
            }

            //methode, die die buttons aus Voc Abfragen überprüft und dann immmer neue Vokabeln aus der Liste Anzeigt

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
