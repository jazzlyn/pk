/*
    Aufgabe 2) Verzweigungen und while-Schleife

    Erweitern Sie die main-Methode um folgende Funktionalität:
    - Schreiben Sie eine while-Schleife, die alle ungeraden, durch 7 teilbaren
      Zahlen von 0-100 (inklusive) aufsummiert.
    - Geben Sie das Ergebnis mit "System.out.println()" aus.

    Zusatzfragen:
    1) Die Schleife summiert Werte zwischen 0 und 100 (inklusive). Wie könnten
       Sie das Programm umbauen damit die Schleife beliebige Intervalle
       aufsummiert?

       Schon erledigt...


*/
public class Aufgabe2{

    public static void main(String[] args) {
        int count = 0;
        int maxCount = 100;
        int sum = 0;

        while (count <= maxCount) {
            if (count % 2 != 0 && count % 7 == 0) {
                sum += count;
            }
            count++;
        }
        System.out.println(sum);
    }
}

