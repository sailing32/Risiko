/**
  *
  * Implementierung eines W�rfels
  *
  * @version 1.0 vom 20.12.2017
  * @Stefan
  */

import java.util.Random;            //Zufallszahl (W�rfel)

public class Wuerfel {
  Random Wuerfel = new Random();
  
  // Anfang Attribute
  private int Augenzahl;
  // Ende Attribute
  
  // Anfang Methoden
  
  /**
  *Erwartet keinen Eingabewert
  Gibt einen Integer von 1 bis 6 zur�ck
  */
  public int getAugenzahl() {
    Augenzahl = 1 + Wuerfel.nextInt(6);
    return Augenzahl;
  }
  
  // Ende Methoden
} // end of Wuerfel
