/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.11.2017
  * @author 
  */
import java.util.*;
import javax.swing.JOptionPane;     //Dialogbox 

public class Verwaltung {
  
  // Anfang Attribute*****************************************************************
  private ArrayList<Spieler> spieler = new ArrayList<>();
  private ArrayList<Gebiet> Gebiete = new ArrayList<>();
  private Spieler AktuellerSpieler;
  private int SpielerIndex = 0;
  private int ErlaubteTruppenzahlInInitialisierungsphase = 10;
  // Ende Attribute
  
  
  
  
  
  //Konstruktor***********************************************************************
  public Verwaltung() {
    //this.spieler.addAll (spieler);
    //this.AktuellerSpieler = null;
  }
  
  
  
  
  
  
  // Anfang Methoden******************************************************************
  /**
  *Keine �bergabe- oder R�ckgabeparameter*/
  public void GebieteMischen() {
    Collections.shuffle(this.Gebiete);
  }
  
  
  public ArrayList<Spieler> SpielerErmitteln() {
    String s="Name";
    while (s!=null) { 
      s=JOptionPane.showInputDialog("Bitte Spielername eingeben. F�r Spielbeginn dr�cken Sie bitte auf Abbrechen");
      if (s!=null) {
        this.spieler.add (new Spieler(s));
      }
      
    }
    return spieler;
  }
  
  /**�bergibt ein Array vom Typ Gebiet
  Der Teilungsfaktor besagt, wie viele aller Gebiete abgegeben werden sollen.
  1=alle, 2=H�lfte, 3= 1/3 usw. aller Gebiete die sich in ihrem Speicher befinden.
  */
  public Gebiet[] GebieteUebergeben(int Teilungsfaktor) {
    
    return null;
  }
  
  public ArrayList<Spieler> getSpieler() {
    return this.spieler;
  }  
  
  
  
  public void WuerfelAugenzahlVergleichen() {
    
  }
  
  
  
  /**Erwartet ein Array mit Gebietsobjekten*/
  public void GebieteEinsammeln(ArrayList<Gebiet> Gebiete) {
    this.Gebiete.addAll(Gebiete);
  }
  
  
  //>>>>>>> ee344df410929aa7a0f159a1aada02aaabd3dbe8
  public void GebieteVerteilen() {
    
  }
  
  /**Bestimmt, wer als n�chstes dran ist*/
  public Spieler NaechstenSpielerBestimmen() {
    if (spieler.size() <= SpielerIndex) {
      SpielerIndex=0;
    } // end of if
    JOptionPane.showMessageDialog(null, spieler.get(SpielerIndex).getName()+"! Sie sind dran.");
    return spieler.get(SpielerIndex++);
    
  }
  
  
  public int getErlaubteTruppenzahlInInitialisierungsphase() {
    return ErlaubteTruppenzahlInInitialisierungsphase;
  }
  
  
  
  public void GebieteAnSpielerVerteilen() {
    JOptionPane.showMessageDialog(null, "Willkommen! Alle Gebiete werden nun an die Spieler verteilt.");
    ArrayList<Gebiet> tmpGebiet = new ArrayList<>();  //Zwischenvariable  
    int z = 0;
    for (ListIterator<Gebiet> li = Gebiete.listIterator(0); li.hasNext();){      
      tmpGebiet.add(li.next());
      if (spieler.size() <= z) {
        z=0;
      }
      spieler.get(z++).GebieteAnnehmen(tmpGebiet);
      tmpGebiet.remove(0); 
    }
  }
  
  
  public Spieler getBesitzer(String SpielerName) {  
    for (int i = 0;i<this.spieler.size();i++){
      if (SpielerName == this.spieler.get(i).getName()) { 
        return this.spieler.get(i);       
      }
    } 
    //    Wenn Methode hier angekommen ist, gibt es den Spieler nicht
    return null;
  }
  
  public void SpielerEntfernen(Spieler Verlierer) {
    JOptionPane.showMessageDialog(null,Verlierer.getName()+" hat leider verloren!");
    this.spieler.remove(Verlierer);
  }
  
  public boolean GewinnerErmitteln() {
    for (int i = 0;i<this.spieler.size();i++){
      if (this.Gebiete.size() == this.spieler.get(i).getMeineGebiete().size()) { 
        JOptionPane.showMessageDialog(null,this.spieler.get(i).getName()+" hat gewonnen!\n Das Spiel ist zu Ende");
        return true;      
      }
    } 
    return false;
  }
  
  public Gebiet getGebiet(String Gebietsname) {
    for (int i = 0;i<this.Gebiete.size();i++){
      if (Gebietsname == this.Gebiete.get(i).getName()) { 
        return this.Gebiete.get(i);       
      }
    } 
    //    Wenn Methode hier angekommen ist, gibt es das Gebiet nicht
    return null;
  }
  // Ende Methoden
} // end of Verwaltung
