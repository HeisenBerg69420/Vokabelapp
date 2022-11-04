package View.Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private static int buttonZurueckCounter;
    private static Vokabel[] vokabeln;

    public VocEntfernen() {
        buttonZurueckCounter = 0;
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
        listVokabel.setBounds(120,120,160,250);
        listVokabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int index = listVokabel.locationToIndex(e.getPoint());
          if (index >= 0) {
            Object o = listVokabel.getModel().getElementAt(index);
            front[index] = null;
            }
    }});
        View.getFrame().add(listVokabel);
        listVokabel.setVisible(false);

        labelHeader = new JLabel("Entfernen");
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
        
    }

    public void isVisible(boolean isVisible) {
        labelHeader.setVisible(isVisible);
        listeHeader.setVisible(isVisible);
        zurueckButton.setVisible(isVisible);
        listVokabel.setVisible(isVisible);
    }

    public static int getButtonZurueckCounter() {
        return buttonZurueckCounter;
    }

    public JLabel getListeHeader() {
        return listeHeader;
    }
}
