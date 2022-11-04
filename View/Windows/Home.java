package View.Windows;

import javax.swing.*;

import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

    private static JLabel labelHello;
    private static JLabel labelStapelAuswaehlen;

    private static JButton buttonVocLernen;
    private static JButton buttonVocAdden;
    private static JButton buttonVocEntfernen;

    private static int buttonVocLernenCounter;
    private static int buttonVocAddenCounter;
    private static int buttonVocEntfernenCounter;

    private static JList listStapel;

    public Home() {
        objekteErstellen();
    }

    private void objekteErstellen() {
        labelHello = new JLabel("HOME");
        labelHello.setBounds(100,14,200,50);
        labelHello.setHorizontalAlignment(JLabel.CENTER);
        View.getFrame().add(labelHello);
        labelHello.setVisible(true); //später in main

        labelStapelAuswaehlen = new JLabel("Stapel auswählen:");
        labelStapelAuswaehlen.setBounds(100,70,200,50);
        labelStapelAuswaehlen.setHorizontalAlignment(JLabel.CENTER);
        View.getFrame().add(labelStapelAuswaehlen);
        labelStapelAuswaehlen.setVisible(true); //später in main

        buttonVocLernen = new JButton("Lernen");
        buttonVocLernen.setBounds(120, 450, 160, 60);
        buttonVocLernen.setHorizontalAlignment(JLabel.CENTER);
        buttonVocLernen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonVocLernenCounter++;
            }
        });
        View.getFrame().add(buttonVocLernen);
        buttonVocLernen.setVisible(true);

        //Vokabeln adden
        buttonVocAdden = new JButton("Vokabeln hinzufügen");
        buttonVocAdden.setBounds(20,600,160,60);
        buttonVocAdden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonVocAddenCounter++;
            }
        });
        View.getFrame().add(buttonVocAdden);
        buttonVocAdden.setVisible(true);


        //Vokabeln entfernen
        buttonVocEntfernen = new JButton("Vokabeln entfernen");
        buttonVocEntfernen.setBounds(210,600,160,60);
        buttonVocEntfernen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonVocEntfernenCounter++;
            }
        });
        View.getFrame().add(buttonVocEntfernen);
        buttonVocEntfernen.setVisible(true);



        //Stapelliste
        String[] stapel = { "Englisch", "Französisch", "Spanisch", "Altgriechisch" };
        listStapel = new JList(stapel);
        listStapel.setSelectedIndex(0);
        listStapel.setBounds(120,120,160,100);
        View.getFrame().add(listStapel);
        listStapel.setVisible(true);
        
    }
    

    public void isVisible(boolean isVisible) {
        labelHello.setVisible(isVisible);
        buttonVocLernen.setVisible(isVisible);
        buttonVocEntfernen.setVisible(isVisible);
        buttonVocAdden.setVisible(isVisible);
        listStapel.setVisible(isVisible);
        labelStapelAuswaehlen.setVisible(isVisible);
    }

    public static int getButtonVocLernenCounter() {
        return buttonVocLernenCounter;
    }

    public static int getButtonVocAddenCounter() {
        return buttonVocAddenCounter;
    }

    public static int getButtonVocEntfernenCounter() {
        return buttonVocEntfernenCounter;
    }

    
    public static String getSprache() {
        return listStapel.getSelectedValue().toString();
    }

    
}
