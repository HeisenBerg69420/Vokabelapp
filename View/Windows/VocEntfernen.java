package View.Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import Structures.List;
import Objects.Vokabel;


import View.View;

public class VocEntfernen {
    JLabel labelHeader;
    JLabel listeHeader;
    JButton zurueckButton;
    JList listVokabel;
    JButton entfernenButton;

    private static int buttonZurueckCounter;
    private static int buttonEntfernenCounter;
    private static Vokabel[] vokabeln;

    public VocEntfernen() {
        buttonZurueckCounter = 0;
        buttonEntfernenCounter = 0;
        vokabeln = new Vokabel[10];
        for (int i = 0; i < 10; i++) {
            vokabeln[i] = new Vokabel("Hund", "dog");
        }
        objekteErstellen();

    }

    private void objekteErstellen() {

        //Stapelliste
        String[] front = new String[10];
        for (int i = 0; i < 10; i++) {
            front[i] = vokabeln[i].getFront();
        }
        listVokabel = new JList(front);
        listVokabel.setSelectedIndex(0);
        listVokabel.setBounds(120, 120, 160, 100);
        View.getFrame().add(listVokabel);
        listVokabel.setVisible(false);

        labelHeader = new JLabel("Entfernen");
        labelHeader.setBounds(100, 14, 200, 50);
        labelHeader.setHorizontalAlignment(JLabel.CENTER);
        labelHeader.setVerticalAlignment(JLabel.CENTER);
        View.getFrame().add(labelHeader);
        labelHeader.setVisible(false); //später in main

        listeHeader = new JLabel("Stapel: xxx");
        listeHeader.setBounds(100, 40, 200, 50);
        listeHeader.setHorizontalAlignment(JLabel.CENTER);
        listeHeader.setVerticalAlignment(JLabel.CENTER);
        View.getFrame().add(listeHeader);
        listeHeader.setVisible(false); //später in main

        zurueckButton = new JButton("zurück");
        zurueckButton.setBounds(10, 10, 100, 60);
        zurueckButton.setIcon(new ImageIcon("Objects/back.png")); //sieht scheiße aus am besten weg machen
        zurueckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonZurueckCounter++;
            }
        });
        
        View.getFrame().add(zurueckButton);
        zurueckButton.setVisible(false);

        entfernenButton = new JButton("Entfernen");
        entfernenButton.setBounds(180, 600, 100, 50);
        entfernenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonEntfernenCounter++;
            }
        });
        entfernenButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
              if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    buttonEntfernenCounter++;
                }
            }
            public void keyPressed(KeyEvent arg0) {}
            public void keyReleased(KeyEvent arg0) {}   
        });
        View.getFrame().add(entfernenButton);
        entfernenButton.setVisible(false);
    }

    public void isVisible(boolean isVisible) {
        labelHeader.setVisible(isVisible);
        listeHeader.setVisible(isVisible);
        zurueckButton.setVisible(isVisible);
        listVokabel.setVisible(isVisible);
        entfernenButton.setVisible(isVisible);
    }

    public static int getButtonZurueckCounter() {
        return buttonZurueckCounter;
    }

    public JLabel getListeHeader() {
        return listeHeader;
    }
}
