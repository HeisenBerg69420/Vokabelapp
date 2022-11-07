package View.Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;

import View.View;

public class VocAbfragen {

    JLabel labelHeader;
    JLabel listeHeader;
    JButton zurueckButton;
    JLabel labelVorderseite;
    JLabel labelDeutsch;
    JLabel labelRueckseite;
    JTextField tfRueckseite;
    JButton buttonBestaetigen;
    JButton buttonNext;
    JButton buttonGeltenLassen;

    private static int buttonZurueckCounter;
    private static int buttonNextCounter;
    private static int buttonGeltenLassenCounter;
    private static int buttonBestaetigenCounter;

    public VocAbfragen() {
        buttonZurueckCounter = 0;
        buttonBestaetigenCounter = 0;
        buttonGeltenLassenCounter = 0;
        buttonBestaetigenCounter = 0;
        objekteErstellen();
    }

    private void objekteErstellen() {
        labelHeader = new JLabel("Lernen");
        labelHeader.setBounds(100,14,200,50);
        labelHeader.setHorizontalAlignment(JLabel.CENTER);
        labelHeader.setVerticalAlignment(JLabel.CENTER);
        View.getFrame().add(labelHeader);
        labelHeader.setVisible(false); //später in main

        listeHeader = new JLabel("Stapel: xxx");
        listeHeader.setBounds(100,40,200,50);
        listeHeader.setHorizontalAlignment(JLabel.CENTER);
        listeHeader.setVerticalAlignment(JLabel.CENTER);
        View.getFrame().add(listeHeader);
        listeHeader.setVisible(false); //später in main

        zurueckButton = new JButton("zurück");
        zurueckButton.setBounds(10,10,100,60); //sieht scheiße aus am besten weg machen
        zurueckButton.setIcon(new ImageIcon("Objects/back.png")); 
        zurueckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonZurueckCounter++;
            }
        });
        View.getFrame().add(zurueckButton);
        zurueckButton.setVisible(false);

        labelVorderseite = new JLabel("Deutsch: ");
        labelVorderseite.setBounds(100, 150, 200, 50);
        labelVorderseite.setHorizontalAlignment(JLabel.CENTER);
        labelVorderseite.setVerticalAlignment(JLabel.CENTER);
        View.getFrame().add(labelVorderseite);
        labelVorderseite.setVisible(false);

        labelRueckseite = new JLabel("Sprache xxx");
        labelRueckseite.setBounds(100, 250, 200, 50);
        labelRueckseite.setHorizontalAlignment(JLabel.CENTER);
        labelRueckseite.setVerticalAlignment(JLabel.CENTER);
        View.getFrame().add(labelRueckseite);
        labelRueckseite.setVisible(false);

        labelDeutsch= new JLabel("Hund");
        labelDeutsch.setBounds(100, 175, 200, 50);
        labelDeutsch.setHorizontalAlignment(JLabel.CENTER);
        labelDeutsch.setVerticalAlignment(JLabel.CENTER);
        View.getFrame().add(labelDeutsch);
        labelDeutsch.setVisible(false);
        
        tfRueckseite = new JTextField("Eingeben");
        tfRueckseite.setBounds(100, 300, 200, 50);
        tfRueckseite.setHorizontalAlignment(JLabel.CENTER);
        tfRueckseite.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                tfRueckseite.setText("");  //in View versuchen mit timeslice
            }
        });
        View.getFrame().add(tfRueckseite);
        tfRueckseite.setVisible(false);

        buttonBestaetigen = new JButton("Bestätigen");
        buttonBestaetigen.setBounds(125, 500, 150, 50);
        buttonBestaetigen.setHorizontalAlignment(JButton.CENTER);
        buttonBestaetigen.setVerticalAlignment(JButton.CENTER);
        buttonBestaetigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonBestaetigenCounter++;
            }
        });
        View.getFrame().add(buttonBestaetigen);
        buttonBestaetigen.setVisible(false);

        buttonNext = new JButton("Next");
        buttonNext.setBounds(125, 560, 150, 50);
        buttonNext.setHorizontalAlignment(JButton.CENTER);
        buttonNext.setVerticalAlignment(JButton.CENTER);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonNextCounter++;
            }
        });
        View.getFrame().add(buttonNext);
        buttonNext.setVisible(false);

        buttonGeltenLassen = new JButton("Gelten lassen");
        buttonGeltenLassen.setBounds(125, 620, 150, 50);
        buttonGeltenLassen.setHorizontalAlignment(JButton.CENTER);
        buttonGeltenLassen.setVerticalAlignment(JButton.CENTER);
        buttonGeltenLassen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonGeltenLassenCounter++;
            }
        });
        View.getFrame().add(buttonGeltenLassen);
        buttonGeltenLassen.setVisible(false);


        
    }

    public void isVisible(boolean isVisible) {
        labelHeader.setVisible(isVisible);
        listeHeader.setVisible(isVisible);
        zurueckButton.setVisible(isVisible);
        labelVorderseite.setVisible(isVisible);
        labelRueckseite.setVisible(isVisible);
        labelDeutsch.setVisible(isVisible);
        tfRueckseite.setVisible(isVisible);
        buttonBestaetigen.setVisible(isVisible);
        buttonGeltenLassen.setVisible(isVisible);
        buttonNext.setVisible(isVisible);
    }

    public static int getButtonZurueckCounter() {
        return buttonZurueckCounter;
    }

    public JLabel getListeHeader() {
        return listeHeader;
    }

    public JLabel getLabelHeader() {
        return labelHeader;
    }

    public JButton getZurueckButton() {
        return zurueckButton;
    }

    public JLabel getLabelVorderseite() {
        return labelVorderseite;
    }

    public JLabel getLabelDeutsch() {
        return labelDeutsch;
    }

    public JLabel getLabelRueckseite() {
        return labelRueckseite;
    }

    public JTextField getTfRueckseite() {
        return tfRueckseite;
    }

    public JButton getButtonBestaetigen() {
        return buttonBestaetigen;
    }
    public static int getButtonGeltenLassenCounter() {
        return buttonGeltenLassenCounter;
    }

    public static int getButtonBestaetigenCounter() {
        return buttonBestaetigenCounter;
    }

    public static int getButtonNextCounter(){

    return buttonNextCounter;
    }

   

    
}
