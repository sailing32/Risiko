/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.11.2017
  * @author 
  */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.ImageIO; 
import java.util.*;                 //ArrayList benutzen

public class Gebiet extends JLabel{
  
  // Attribute*************************************************************************
  // Anfang Attribute
  private String Name;
  private ArrayList<String> Nachbargebiete;
  private int AnzahlSoldaten;
  private String Besitzer;
  // Ende Attribute
  
  
  
  
  
  //Konstruktor************************************************************************
  public Gebiet(String Name, int xKoordinate, int yKoordinate) {
    this.Name = Name;
    this.AnzahlSoldaten = 1;
    this.setFont(this.getFont().deriveFont(25f));
    this.setBounds(xKoordinate, yKoordinate, 30, 30);
  }
  
  
  
  
  
  // Anfang Methoden*******************************************************************
  /**
  *Addiert die übergebene Anzahl an Soldaten zu "AnzahlSoldaten"
  */
  public void setSoldat(int Anzahl) {
    this.AnzahlSoldaten = this.AnzahlSoldaten + Anzahl;    
  }
  
  
  public ArrayList<String> getNachbargebiete() {
    return Nachbargebiete;
  }
  
  
  public int getAnzahlSoldaten() {
    return AnzahlSoldaten;
  }
  
  public String getName() {
    return this.Name;
  }
  
  public String getBesitzer() {
    return Besitzer;
  }
  
  public void setBesitzer(String Besitzer) {
    this.Besitzer = Besitzer;
  }
  
  public void setNachbargebiete(ArrayList<String> Nachbargebiete) {
    this.Nachbargebiete = Nachbargebiete;
  }
  
  // Ende Methoden
} // end of Gebiet
