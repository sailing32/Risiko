/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.12.2017
  * Stefan
  */
  
  //to do: siehe Konstruktor
  //       Array mit EigeneGebiete erstellen  

import javax.swing.JOptionPane;     //Dialogbox    
import java.util.*;                 //ArrayList benutzen

public class Spieler {
  
  // Anfang Attribute
  private String Name;
  private ArrayList<Gebiet> MeineGebiete;
  private Wuerfel Wuerfel;
  private Kriegserklaerung Kriegserklaerung;                        
  // Ende Attribute
  
  
  //Konstruktor um Anfrage an Spieler erweitern: Wie hei�t du?
  // -> neuer Konstruktor ohne �bergabeparameter erstellen
  public Spieler(String Name) {
    this.Name = Name;
    this.MeineGebiete = new ArrayList<>();
    this.Wuerfel = new Wuerfel();
    this.Kriegserklaerung = new Kriegserklaerung();
  }
  
  
  // Anfang Methoden
  public String getName() {
    return Name;
  }
  
  /**
  *Keine Eingabewerte
  Ein Objekt wird zur�ckgegeben: Kriegserklaerung und Augenzahl des W�rfels als Attribute
  Falls nicht angegriffen wird: Augenzahl == 0
  Kriegserklaerung == noone
  Zurzeit werden f�r Kriegserklaerung.Name Zahlen �bergeben
  */
  public Kriegserklaerung angreifen() {
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
      this.Kriegserklaerung.setAugenzahl(this.Wuerfel.getAugenzahl()); 
      //    Dialogbox: MeineGebiete Auw�hlen, von dem aus angegriffen wird
      Object[] EigeneGebiete = {"1", "2", "3"};
      String Angriffsgebiet = (String)JOptionPane.showInputDialog(
      null,
      "Von welchen MeineGebiete m�chten Sie angreifen?",
      "Angriff Starten",
      JOptionPane.PLAIN_MESSAGE,
      null,
      EigeneGebiete,
      "1");
      if (Angriffsgebiet == null) {
        //      Angriff abgebrochen  
        this.Kriegserklaerung.setAugenzahl(0);
        this.Kriegserklaerung.setName("noone");
        return null;
      } // end of if
      //    Dialogbox: Kriegserklaerung Ausw�hlen (Muss ein Nachbarland des Ausgew�hlten eigenen Gebiets sein) 
      Object[] MoeglicheKriegsgebiete = {"4", "5", "6"};
      String KriegsgebietName = (String)JOptionPane.showInputDialog(
      null,
      "Welches MeineGebiete m�chten Sie angreifen?",
      "Kriegserklaerung ausw�hlen",
      JOptionPane.PLAIN_MESSAGE,
      null,
      MoeglicheKriegsgebiete,
      "4");
      if (KriegsgebietName == null) {
        //      Angriff abgebrochen  
        this.Kriegserklaerung.setAugenzahl(0);
        this.Kriegserklaerung.setName("noone");
        return this.Kriegserklaerung;
      } // end of if
      this.Kriegserklaerung.setName(KriegsgebietName);
      return this.Kriegserklaerung;
    } // end of if
    else {
      //    Kein Angriff
      this.Kriegserklaerung.setAugenzahl(0);
      this.Kriegserklaerung.setName("noone");
      return this.Kriegserklaerung;
    } // end of if-else
    
  }

  /**
  *Gibt einen Ineteger von 1 bis 6 zur�ck (Augenzahl des W�rfels)
  */                                        
  public int verteidigen() {
    return this.Wuerfel.getAugenzahl();
  }
  
  /**
  *Erwartet eine Anzahl an Soldaten als Eingabewert,
  Kein Rueckgabewert.
  */
  public void TruppenSetzen(int Anzahl) {
    //Namen der Gebiete des Spielers in einer Liste speichern
    ArrayList<String> NamenDerAktuellBessenenGebiete = new ArrayList();
    for (int i = 0;i<this.MeineGebiete.size();i++){
      NamenDerAktuellBessenenGebiete.add(this.MeineGebiete.get(i).getName());
    }  
    //  Dialogbox: auf welchem Gebiet m�chten Sie Truppen setzen?
    Object[] EigeneGebiete = NamenDerAktuellBessenenGebiete.toArray();
    String GebietTruppenSetzen = (String)JOptionPane.showInputDialog(
    null,
    "Auf welches Gebiet m�chten Sie Soldaten setzen?",
    "Soldaten setzen",
    JOptionPane.PLAIN_MESSAGE,
    null,
    EigeneGebiete,
    "1"); 
    if (GebietTruppenSetzen == null) {
      //      TruppenSetzen abgebrochen  
    } // end of if 
    
    //    Anzahl der Soldaten auf dem MeineGebiete
    Object [] AnzahlSoldatenSetzen = new Object[Anzahl]; 
    for (int j = 0; j<AnzahlSoldatenSetzen.length ;j++ ) {
      AnzahlSoldatenSetzen[j] = j+1;                   //Java beginnt bei "0" an zu Z�hlen        
    } // end of for
    String AuswahlAnzahlSoldatenSetzen = (String)JOptionPane.showInputDialog(
    null,
    "Wieviele Soldaten m�chten Sie setzen?",
    "Soldaten setzen",
    JOptionPane.PLAIN_MESSAGE,
    null,
    AnzahlSoldatenSetzen,
    "1");  
    if (AuswahlAnzahlSoldatenSetzen == null) {
      //    Soldatensetzen abgebrochen      
    } // end of if
    int AuswahlAnzahlSoldatenSetzenInteger = Integer.parseInt(AuswahlAnzahlSoldatenSetzen);
    //Gebiet, auf dem die Soldaten gesetzt werden sollen aus "MeineGebiete" herraussuchen
    for (int i = 0;i<this.MeineGebiete.size();i++){
      //Wenn Gebiet gefunden, dann Soldatenanzahl im Gebiet erh�hen
      if (GebietTruppenSetzen == this.MeineGebiete.get(i).getName()) {
        int aktuelleAnzahlSoldaten = this.MeineGebiete.get(i).getAnzahlSoldaten();
        int neueAnzahlSoldaten = aktuelleAnzahlSoldaten + AuswahlAnzahlSoldatenSetzenInteger;
        Anzahl = Anzahl - AuswahlAnzahlSoldatenSetzenInteger;
      } // end of if
    }
    //Wenn keine Soldaten mehr
    if (Anzahl == 0) {
      //nothing (Methode wird beendet)
    } 
    else {
      this.TruppenSetzen(Anzahl);
    } // end of if-else   
  }
  
  
  
  
  /**
  *Gibt dem Spieler die M�glichkeit, Truppen von einem Gebiet zu einem Nachbargebiet zu
  bewegen, wenn dieses nicht feindlich besetzt ist.
  Ohne Eingabe-/R�ckgabewerte.
  */
  public void TruppenBewegen() {
    
  }
  /**
  *L�scht einen Soldaten auf der aktuellen "Kriegserklaerung"
  */
  public void SoldatLoeschen(int Anzahl) {
    
  }
  /**
  *Erwartet den Name des zur�ckzugebenden Gebiets als Eingabewert.
  Gibt ein Gebiet zur�ck und entfernt das �bergebene Gebiet aus "MeineGebiete".
  Wird ein Gebiet angefordert, das der Spieler nicht hat, wird null zur�ckgegeben
  */
  public Gebiet GebietAbgeben(String GebietName) {
    for (int i = 0;i<this.MeineGebiete.size();i++){
      //      Wenn das Gebiet, das abgegeben werden muss gefunden wurde
      if (GebietName == this.MeineGebiete.get(i).getName()) {
        Gebiet GebietZwischenspeichern = this.MeineGebiete.get(i);
        this.MeineGebiete.remove(i); 
        return GebietZwischenspeichern;        
      } // end of if
    } 
    //    Wenn Methode hier angekommen ist, besitzt Spieler das angeforderte Gebiet nicht
    return null;                  
  }
  
  
  /**
  *Erwartet eine ArrayList von Gebieten als �bergabewert, speichert 
  diese in "MeineGebiete". 
  */
  public void GebieteAnnehmen(ArrayList<Gebiet> GebieteAnSpieler) {
    this.MeineGebiete.addAll(GebieteAnSpieler);   
    //    for (int i = 0;i<this.MeineGebiete.size();i++){
    //      System.out.println(this.MeineGebiete.get(i).getName());
    //     
  }
  /**
  *Gibt die Gebiete des Spielers in einer ArrayList zur�ck.
  */
  public ArrayList getMeineGebiete() {
    return MeineGebiete;
  } 
  public boolean MoechtenSieAngreifen() {
    return false;
  }

  // Ende Methoden
} // end of Spieler
