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
import java.awt.event.*;

public class VocHinzufuegen {
    static JLabel labelHeader;
    static JLabel listeHeader;
    static JButton zurueckButton;
    static JLabel labelVorderseite;
    static JLabel labelRueckseite;
    static JTextField tfVorderseite;
    static JTextField tfRueckseite;

    static JButton hinzufuegenButton;

    private static int buttonHinzufuegenCounter;
    private static Vokabel vokabel;
    private static int buttonZurueckCounter;
    private static int buttonVorderseiteCounter;
    private static int buttonRueckseiteCounter;

    public VocHinzufuegen() {
        buttonZurueckCounter = 0;
        buttonHinzufuegenCounter = 0;
        buttonVorderseiteCounter = 0;
        buttonRueckseiteCounter = 0;

        objekteErstellen();
    }

    private void objekteErstellen() {

        labelHeader = new JLabel("Hinzufügen");
        labelHeader.setBounds(100, 14, 200, 50);
        labelHeader.setHorizontalAlignment(JLabel.CENTER);
        labelHeader.setVerticalAlignment(JLabel.CENTER);
        View.getFrame().add(labelHeader);
        labelHeader.setVisible(false); // später in main

        listeHeader = new JLabel("Stapel: xxx");
        listeHeader.setBounds(100, 40, 200, 50);
        listeHeader.setHorizontalAlignment(JLabel.CENTER);
        listeHeader.setVerticalAlignment(JLabel.CENTER);
        View.getFrame().add(listeHeader);
        listeHeader.setVisible(false); // später in main

        zurueckButton = new JButton("zurück");
        zurueckButton.setBounds(10, 10, 100, 60);
        zurueckButton.setIcon(new ImageIcon("Objects/back.png")); // sieht scheiße aus am besten weg machen
        zurueckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonZurueckCounter++;
            }
        });
        View.getFrame().add(zurueckButton);
        zurueckButton.setVisible(false);

        labelVorderseite = new JLabel("Vorderseite: ");
        labelVorderseite.setBounds(-20, 100, 200, 50);
        labelVorderseite.setHorizontalAlignment(JLabel.CENTER);
        labelVorderseite.setVerticalAlignment(JLabel.CENTER);
        View.getFrame().add(labelVorderseite);
        labelVorderseite.setVisible(false); // später in main

        tfVorderseite = new JTextField("Vorne");
        tfVorderseite.setBounds(40, 140, 310, 150);
        tfVorderseite.setHorizontalAlignment(JLabel.CENTER);
        tfVorderseite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonVorderseiteCounter++;
            }
        });
        tfVorderseite.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                tfVorderseite.setText("");  //in View versuchen mit timeslice
            }
        });
        View.getFrame().add(tfVorderseite);
        tfVorderseite.setVisible(false);

        labelRueckseite = new JLabel("Rückseite: ");
        labelRueckseite.setBounds(40, 300, 200, 50);
        View.getFrame().add(labelRueckseite);
        labelRueckseite.setVisible(false); // später in main

        tfRueckseite = new JTextField("Hinten");
        tfRueckseite.setBounds(40, 340, 310, 150);
        tfRueckseite.setHorizontalAlignment(JLabel.CENTER);
        tfRueckseite.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                tfRueckseite.setText("");  //in View versuchen mit timeslice
            }
        });
        View.getFrame().add(tfRueckseite);
        tfRueckseite.setVisible(false);

        hinzufuegenButton = new JButton("Hinzufügen");
        hinzufuegenButton.setBounds(110, 550, 180, 70);
        hinzufuegenButton.setHorizontalAlignment(JLabel.CENTER);
        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonHinzufuegenCounter++;
            }
        });
        hinzufuegenButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    buttonHinzufuegenCounter++;
                }
            }

            public void keyPressed(KeyEvent arg0) {
            }

            public void keyReleased(KeyEvent arg0) {
            }
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

    public JLabel getLabelHeader() {
        return labelHeader;
    }

    public JButton getZurueckButton() {
        return zurueckButton;
    }

    public JLabel getLabelVorderseite() {
        return labelVorderseite;
    }

    public JLabel getLabelRueckseite() {
        return labelRueckseite;
    }

    public static JTextField getTfVorderseite() {
        return tfVorderseite;
    }

    public static JTextField getTfRueckseite() {
        return tfRueckseite;
    }

    public static JButton getHinzufuegenButton() {
        return hinzufuegenButton;
    }

    public static int getButtonHinzufuegenCounter() {
        return buttonHinzufuegenCounter;
    }

    public static int getButtonVorderseiteCounter() {
        return buttonVorderseiteCounter;
    }

    public static int getButtonRueckseiteCounter() {
        return buttonRueckseiteCounter;
    }

    
    
}
