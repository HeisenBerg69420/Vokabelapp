package View.Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.management.openmbean.KeyAlreadyExistsException;
import javax.swing.*;

import Objects.Vokabel;
import View.View;

public class VocHinzufuegen {
    JLabel labelHeader;
    JLabel listeHeader;
    JButton zurueckButton;
    JLabel labelVorderseite;
    JLabel labelRueckseite;
    JTextField tfVorderseite;
    JTextField tfRueckseite;

    JButton hinzufuegenButton;
    

    private static int buttonHinzufuegenCounter;
    private static Vokabel vokabel;
    private static int buttonZurueckCounter;

    public VocHinzufuegen() {
        buttonZurueckCounter = 0;
        buttonHinzufuegenCounter = 0;
        objekteErstellen();
    }

    private void objekteErstellen() {
        
        labelHeader = new JLabel("Hinzufügen");
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
        zurueckButton.setBounds(10,10,100,60); 
        zurueckButton.setIcon(new ImageIcon("Objects/back.png")); //sieht scheiße aus am besten weg machen
        zurueckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonZurueckCounter++;
            }
        });
        View.getFrame().add(zurueckButton);
        zurueckButton.setVisible(false);

        labelVorderseite = new JLabel("Vorderseite: ");
        labelVorderseite.setBounds(-20,100,200,50);
        labelVorderseite.setHorizontalAlignment(JLabel.CENTER);
        labelVorderseite.setVerticalAlignment(JLabel.CENTER);
        View.getFrame().add(labelVorderseite);
        labelVorderseite.setVisible(false); //später in main

        tfVorderseite = new JTextField("Vorne");
        tfVorderseite.setBounds(40, 140, 310, 150);
        tfVorderseite.setHorizontalAlignment(JLabel.CENTER);
        View.getFrame().add(tfVorderseite);
        tfVorderseite.setVisible(false);

        labelRueckseite = new JLabel("Rückseite: ");
        labelRueckseite.setBounds(40,300,200,50);
        View.getFrame().add(labelRueckseite);
        labelRueckseite.setVisible(false); //später in main

        tfRueckseite = new JTextField("Hinten");
        tfRueckseite.setBounds(40, 340, 310, 150);
        tfRueckseite.setHorizontalAlignment(JLabel.CENTER);
        View.getFrame().add(tfRueckseite);
        tfRueckseite.setVisible(false);
        
        hinzufuegenButton = new JButton("Hinzufügen");
        hinzufuegenButton.setBounds(150, 550, 100, 50);
        hinzufuegenButton.setHorizontalAlignment(JLabel.CENTER);
        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                vokabel = new Vokabel(tfVorderseite.getText(), tfRueckseite.getText());
                tfVorderseite.setText("Vorne");
                tfRueckseite.setText("Hinten");
            }
        });
        hinzufuegenButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
              if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    vokabel = new Vokabel(tfVorderseite.getText(), tfRueckseite.getText());
                    tfVorderseite.setText("Vorne");
                    tfRueckseite.setText("Hinten");
                }
            }
            public void keyPressed(KeyEvent arg0) {}
            public void keyReleased(KeyEvent arg0) {}   
        });
        View.getFrame().add(hinzufuegenButton);
        hinzufuegenButton.setVisible(false);

        
    }

    public void isVisible(boolean isVisible) {
        labelHeader.setVisible(isVisible);
        listeHeader.setVisible(isVisible);
        zurueckButton.setVisible(isVisible);
        labelVorderseite.setVisible(isVisible);
        labelRueckseite.setVisible(isVisible);
        tfVorderseite.setVisible(isVisible);
        tfRueckseite.setVisible(isVisible);
        hinzufuegenButton.setVisible(isVisible);
    }

    public static int getButtonZurueckCounter() {
        return buttonZurueckCounter;
    }

    public JLabel getListeHeader() {
        return listeHeader;
    }

    public Vokabel getVokabel() {
        return vokabel;
    }
}
