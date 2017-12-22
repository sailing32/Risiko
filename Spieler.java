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
  private Kriegsgebiet Kriegsgebiet;
  // Ende Attribute
  
  public Spieler(String Name) {
    this.Name = Name;
    this.Soldat = null;
    this.Augenzahl1 = 0;
    this.Augenzahl2 = 0;
    this.Augenzahl3 = 0;
    this.Gebiet = null;
    this.Wuerfel = new Wuerfel();
    this.Kriegsgebiet = new Kriegsgebiet();
  }
  
  
  // Anfang Methoden
  public String getName() {
    return Name;
  }
  
  /**
  *Keine Eingabewerte
  Ein Objekt wird zur�ckgegeben: Kriegsgebiet und Augenzahl des W�rfels als Atribute
  Falls nicht angegriffen wird: Augenzahl == 0
  Kriegsgebiet == noone
  */
  public Kriegsgebiet angreifen() {
    //Dialog Box: "M�chten Sie angreifen"   
    Object[] options = {"Nein","Ja"};
    int angriff = JOptionPane.showOptionDialog(null,
    "M�chten Sie angreifen",
    "Anfrage: Angriff",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[1]);
    System.out.print(angriff);
    // Ja: angriff == 1, Nein:angriff == 0;
    if (angriff == 1) {
      //    W�rfeln
      this.Kriegsgebiet.setAugenzahl(this.Wuerfel.getAugenzahl()); 
      //    Dialogbox: Gebiet Auw�hlen, von dem aus angegriffen wird
      Object[] EigeneGebiete = {"1", "2", "3"};
      String Angriffsgebiet = (String)JOptionPane.showInputDialog(
      null,
      "Von welchen Gebiet m�chten Sie angreifen?",
      "Angriff Starten",
      JOptionPane.PLAIN_MESSAGE,
      null,
      EigeneGebiete,
      "1");
      //    Dialogbox: Kriegsgebiet Ausw�hlen (Muss ein Nachbarland des Ausgew�hlten eigenen Gebiets sein) 
      Object[] MoeglicheKriegsgebiete = {"4", "5", "6"};
      String KriegsgebietName = (String)JOptionPane.showInputDialog(
      null,
      "Welches Gebiet m�chten Sie angreifen?",
      "Kriegsgebiet ausw�hlen",
      JOptionPane.PLAIN_MESSAGE,
      null,
      MoeglicheKriegsgebiete,
      "4");
      this.Kriegsgebiet.setName(KriegsgebietName);
      
    } // end of if
    else {
      //    Kein Angriff
      this.Kriegsgebiet.setAugenzahl(0);
      this.Kriegsgebiet.setName("noone");
    } // end of if-else
    return this.Kriegsgebiet;
  }
  
  
  /**
  *Gibt einen Ineteger von 1 bis 6 zur�ck
  */                                        
  public int verteidigen() {
    Augenzahl1 = this.Wuerfel.getAugenzahl();
    return Augenzahl1; 
  }
  
  /**
  *Erwartet Soldaten als Eingabewert
  Kein Rueckgabewert
  */
  public void TruppenSetzen(Soldat[] Soldaten) {
    
  }

  
  public void TruppenBewegen() {
    
  }
  /**
  *Loescht einen Soldaten auf dem aktuellen Kriegsgebiet
  (Angreifer und Verteidiger)
  */
  public void SoldatLoeschen(int Anzahl) {
    
  }
  public void GebietAbgeben() {
    
  }
  public void GebieteAnnehmen(Gebiet[] Gebiete) {
    
  }
  public int AnzahlGebiete() {
    return 0;
  }  
  public Gebiet getGebiet() {
    return Gebiet;
  }
  // Ende Methoden
} // end of Spieler
