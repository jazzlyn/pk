/*
    Aufgabe 5) Verzweigungen und while-Schleife

    Erweitern Sie die main-Methode um folgende Funktionalität:
    - Schreiben Sie eine while-Schleife, die alle Zahlen zwischen
      10-1000 (inklusive) aufsummiert, die sowohl durch 7 als auch und durch 13
      teilbar sind.
    - Geben Sie das Ergebnis mit "System.out.println()" aus.

*/
public class Aufgabe5{

    public static void main(String[] args) {
        int count = 10;
        int maxCount = 1000;
        int sum = 0;

        while (count <= maxCount) {
            if (count % 13 == 0 && count % 7 == 0) {
                sum += count;
            }
            count++;
        }
        System.out.println(sum);
    }
}

