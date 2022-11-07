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
import java.awt.event.*;

import View.View;

public class VocEntfernen {
    JLabel labelHeader;
    JLabel listeHeader;
    JButton zurueckButton;
    JList listVokabel;
    JButton entfernenButton;
    JTextField bearbeitenVor;
    JTextField bearbeitenHint;
    JButton bestaetigenButtonBearb;

    private static int buttonZurueckCounter;
    private static int buttonEntfernenCounter;
    private static int tfBearbeitenHintCounter;
    private static int tfBearbeitenVorCounter;
    private static int buttonbearbCounter;
    
    

    public VocEntfernen() {
        buttonZurueckCounter = 0;
        buttonEntfernenCounter = 0;
        
        objekteErstellen();

    }

    private void objekteErstellen() {

        // Stapelliste
        String[] front = new String[10];
        for(int i=0; i<10; i++){
            front[i] = "hund";
        }
        listVokabel = new JList(front);
        listVokabel.setSelectedIndex(0);
        listVokabel.setBounds(100, 120, 200, 100);
        listVokabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int index = listVokabel.locationToIndex(e.getPoint());
          if (index >= 0) {
            Object o = listVokabel.getModel().getElementAt(index);
            front[index] = "du schwanz";
            }
    }});
        View.getFrame().add(listVokabel);
        listVokabel.setVisible(false);

        labelHeader = new JLabel("Entfernen");
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

        entfernenButton = new JButton("Entfernen");
        entfernenButton.setBounds(110, 250, 180, 70);
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

            public void keyPressed(KeyEvent arg0) {
            }

            public void keyReleased(KeyEvent arg0) {
            }
        });
        View.getFrame().add(entfernenButton);
        entfernenButton.setVisible(false);

        bearbeitenHint = new JTextField("Vorne");
        bearbeitenHint.setBounds(75, 475, 250, 75);
        bearbeitenHint.setHorizontalAlignment(JLabel.CENTER);
    
        bearbeitenHint.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                bearbeitenHint.setText("");  //in View versuchen mit timeslice
            }
        });
        View.getFrame().add(bearbeitenHint);
        bearbeitenHint.setVisible(false);

        
        bearbeitenVor = new JTextField("Entfernen");
        bearbeitenVor.setBounds(75, 365, 250, 75);
        bearbeitenVor.setHorizontalAlignment(JLabel.CENTER);
        
        bearbeitenVor.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                bearbeitenVor.setText("");  //in View versuchen mit timeslice
            }
        });
        View.getFrame().add(bearbeitenVor);
        bearbeitenVor.setVisible(false);

        bestaetigenButtonBearb = new JButton("Bestätigen");
        bestaetigenButtonBearb.setBounds(110, 600, 180, 70);
        bestaetigenButtonBearb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buttonbearbCounter++;
            }
        });
        bestaetigenButtonBearb.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    buttonbearbCounter++;
                }
            }

            public void keyPressed(KeyEvent arg0) {
            }

            public void keyReleased(KeyEvent arg0) {
            }
        });
        View.getFrame().add(bestaetigenButtonBearb);
        bestaetigenButtonBearb.setVisible(false);



    }

    public void isVisible(boolean isVisible) {
        labelHeader.setVisible(isVisible);
        listeHeader.setVisible(isVisible);
        zurueckButton.setVisible(isVisible);
        listVokabel.setVisible(isVisible);
        entfernenButton.setVisible(isVisible);
        bearbeitenHint.setVisible(isVisible);
        bearbeitenVor.setVisible(isVisible);
        bestaetigenButtonBearb.setVisible(isVisible);
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

    public JList getListVokabel() {
        return listVokabel;
    }

    public JButton getEntfernenButton() {
        return entfernenButton;
    }

    public static int getButtonEntfernenCounter() {
        return buttonEntfernenCounter;
    }
    public JTextField getBearbeitenHint() {
        return bearbeitenHint;
    }
    public JTextField getBearbeitenVor() {
        return bearbeitenVor;
    }
    public static int getTfBearbeitenHintCounter() {
        return tfBearbeitenHintCounter;
    }
    public static int getTfBearbeitenVorCounter() {
        return tfBearbeitenVorCounter;
    }
    public static int getButtonbearbCounter() {
        return buttonbearbCounter;
    }

}
