/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 22.11.2017
  * @author 
  */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.ImageIO;
import java.util.*;

public class Weltkarte extends JFrame{
  
  // Anfang Attribute***************************************************************
  private ArrayList<Gebiet> Gebiete = new ArrayList<>();
  // Ende Attribute
  
  
  
  
  //Konstruktor*********************************************************************
  public Weltkarte() {
    
    //Einstellungen f�r das Fenster
    setBounds(100,100,900,600);
    //setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setContentPane(new BackGroundPane("Weltkarte.JPG"));
    
    //Panel, um Labels anzeigen zu k�nnen
    JPanel panel = (JPanel) getContentPane();
    panel.setLayout(null);
    
    //Anlegen aller Gebiete in einer Arraylist
    this.Gebiete.add (new Gebiet("Russland","Polen",670,100));
    this.Gebiete.add (new Gebiet("Deutschland","Frankreich",440,180));
    this.Gebiete.add (new Gebiet("Amerika","Brasilien",120,180));
    this.Gebiete.add (new Gebiet("Polen","Deutschland",520,150));   
    
    //Gebiete auf der Karte anzeigen
    for (ListIterator<Gebiet> li = Gebiete.listIterator(0); li.hasNext();){
      panel.add (li.next());
    }
    
    //Farbeinstellungen f�r die Gebiete
    Gebiete.get(0).setForeground(Color.green);
    Gebiete.get(1).setForeground(Color.red);
    Gebiete.get(2).setForeground(Color.red);
    Gebiete.get(3).setForeground(Color.green);
    
    
    Gebiete.get(0).setText("15");
    Gebiete.get(1).setText("8");
    Gebiete.get(2).setText("12");
    Gebiete.get(3).setText("10");
    
    
    setVisible(true);
  }
  
  
  
  
  
  
  // Anfang Methoden*******************************************************************
  public ArrayList<Gebiet> getGebiete() {
    return this.Gebiete;
  }
  
  
  // Ende Methoden
} // end of Weltkarte
