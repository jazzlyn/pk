/*
    Aufgabe 4) while-Schleife

    Erweitern Sie die main-Methode um folgende Funktionalität:
    - Schreiben Sie eine while-Schleife, die die Quersumme der gegebenen
      Variable "value" berechnet. (z.B. Quersumme der Zahl 37489 ist gleich 31)
    - Nachdem Sie die Quersumme berechnet haben geben Sie das Ergebnis mit
      "System.out.println()" aus.

    Zusatzfragen:
    1) Welcher Wert (postitiv und ganzzahlig) muss der Varibalen "value"
       zugewiesen werden damit die höchstmögliche Quersumme berechnet wird?

       weil 32 bit integer (max wert 2 147 483 647), somit max value für höchstmögliche quersumme 1 999 999 999
*/
public class Aufgabe4{

    public static void main(String[] args) {
        int value = 8487304;
        int sum = 0;

        while (value > 0) {
            // dividiert durch 10 und gibt die letzte stelle, die nicht durch 10 teilbar ist, zurück
            sum += value % 10;
            // dividiert nochmals durch 10, verschiebt also die kommastelle und gibt die ganze zahl zurück
            value = value / 10;
        }
        System.out.println(sum);

    }
}

