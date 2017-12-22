/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.12.2017
  * Stefan
  */
  
  //to do: siehe Konstruktor

import javax.swing.JOptionPane;     //Dialogbox

public class Spieler {
  
  // Anfang Attribute
  private String Name;
  private Gebiet Gebiet;
  private Wuerfel Wuerfel;
  private Kriegsgebiet Kriegsgebiet;                         
  private int Augenzahl1;
  private int Augenzahl2;
  private int Augenzahl3;
  // Ende Attribute
  
  //Konstruktor um Anfrage an Spieler erweitern: Wie hei�t du
  // -> neuer Konstruktor ohne �bergabeparameter erstellen
  public Spieler(String Name) {
    this.Name = Name;
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
  Ein Objekt wird zur�ckgegeben: Kriegsgebiet und Augenzahl des W�rfels als Attribute
  Falls nicht angegriffen wird: Augenzahl == 0
  Kriegsgebiet == noone
  Zurzeit werden f�r Kriegsgebiet.Name Zahlen �bergeben
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
    //System.out.print(angriff);
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
      if (Angriffsgebiet == null) {
        //      Angriff abgebrochen  
        this.Kriegsgebiet.setAugenzahl(0);
        this.Kriegsgebiet.setName("noone");
        return this.Kriegsgebiet;
      } // end of if
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
      if (KriegsgebietName == null) {
        //      Angriff abgebrochen  
        this.Kriegsgebiet.setAugenzahl(0);
        this.Kriegsgebiet.setName("noone");
        return this.Kriegsgebiet;
      } // end of if
      this.Kriegsgebiet.setName(KriegsgebietName);
      return this.Kriegsgebiet;
    } // end of if
    else {
      //    Kein Angriff
      this.Kriegsgebiet.setAugenzahl(0);
      this.Kriegsgebiet.setName("noone");
      return this.Kriegsgebiet;
    } // end of if-else
    
  }
  
  
  /**
  *Gibt einen Ineteger von 1 bis 6 zur�ck (Augenzahl des W�rfels)
  */                                        
  public int verteidigen() {
    return this.Wuerfel.getAugenzahl();
  }
  
  /**
  *Erwartet ein Array von Soldaten als Eingabewert
  Kein Rueckgabewert
  */
  public void TruppenSetzen(int Anzahl) {
    
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
