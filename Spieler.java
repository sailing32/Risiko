/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.12.2017
  * Stefan
  */

import javax.swing.JOptionPane;     //Dialogbox

public class Spieler {
  
  // Anfang Attribute
  private String Name;
  private Gebiet Gebiet;
  private Wuerfel Wuerfel;
  private Soldat Soldat;
                         
  private int Augenzahl1;
  private int Augenzahl2;
  private int Augenzahl3;
  // Ende Attribute
  
  public Spieler(String Name) {
    this.Name = Name;
    this.Soldat = null;
    this.Augenzahl1 = 0;
    this.Augenzahl2 = 0;
    this.Augenzahl3 = 0;
    this.Gebiet = null;
    this.Wuerfel = null;
  }

  
  // Anfang Methoden
  public String getName() {
    return Name;
  }
  
  public int angreifen() {
    //Dialog Box
    JOptionPane.showMessageDialog(null, "Ich m�chte angreifen.");
    //M�chten Sie angreifen?
    //Eigenes Gebiet ausw�hlen
    //Feindgebiet ausw�hlen
    //W�rfeln
    
    return 0;
  }

  
  public void verteidigen() {
    
  }
  
  public void TruppenSetzen(Soldat Soldat) {
    
  }
  
  public void TruppenBewegen() {
    
  }
  
  public Gebiet getGebiet() {
    return Gebiet;
  }
  
  public void setGebiet(Gebiet Gebiet) {
    this.Gebiet = Gebiet;
  }
  
  public void SoldatLoeschen(int Anzahl) {
    
  }
  
  public void GebietAnwaehlen() {
    
  }
  
  public void FeindgebietAnwaehlen() {
    
  }
  
  public void GebietAbgeben() {
    
  }
  
  public void GebietAnnehmen() {
    
  }
  
  public int AnzahlGebiete() {
    return 0;
  }
  
  private int Wuerfeln() {
    Augenzahl1 = Wuerfel.getAugenzahl();
    System.out.println(Augenzahl1);
    
    return 0;
  }
  
  
  public int getAugenzahl1() {
    return Augenzahl1;
  }
  
  public int getAugenzahl2() {
    return Augenzahl2;
  }
  
  public int getAugenzahl3() {
    return Augenzahl3;
  }
  
  // Ende Methoden
} // end of Spieler