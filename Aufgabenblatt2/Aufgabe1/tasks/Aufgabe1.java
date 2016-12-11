/*******************************************************************************

 AUFGABENBLATT 2 - Allgemeine Informationen

 Achten Sie bei der Implementierung auf folgende Punkte:

 - Ihr Programm sollte den dazugehörenden Test (z.B. enthält Aufgabe1Test den
 Test zu Aufgabe1) bestehen.

 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich
 thematisch auf das erstellte Programm.  Sie müssen diese Zusatzfragen in der
 Übung beantworten können.

 - Verwenden Sie bei allen Ausgaben immer System.out.println().

 - Verwenden Sie für die Lösung der Aufgaben keine speziellen Aufrufe aus der
 Java-API, die die Aufgaben verkürzen würden.

 Abgabe: Die Abgabe erfolgt in TUWEL. Bitte laden Sie Ihr IntelliJ-Projekt
 bis spätestens Montag 24.10.2016 08:00 Uhr in TUWEL hoch. Zusätzlich
 müssen Sie in TUWEL ankreuzen welche Aufgaben Sie gelöst haben und während
 der Übung präsentieren können.

 ******************************************************************************/

/*
    Aufgabe1) Typen und Typumwandlungen

    Erweitern Sie die main-Methode um folgende Funktionalität:
    - Deklarieren und initialisieren Sie je eine lokale Variable mit den Werten
          'F', 0xf, 070, 70L, 77e-1f, 7.7f, 7.77e1, 77.7
      und sorgen Sie dafür, dass die Variablen dieselben Typen haben wie diese
      Literale.
    - Erzeugen Sie durch Verwendung des Operators + einen String, der die Werte
      in den Variablen in der oben gegebenen
      Reihenfolge enthält, jeweils getrennt durch ", ". Geben Sie den String
      mittels System.out.println(...) aus.
    - Berechnen Sie das ganzzahlige Produkt aller Werte in diesen Variablen,
      wobei Nachkommastellen so früh wie möglich abgeschnitten werden.
      Vermeiden Sie einen Überlauf des Ergebnisses. Geben Sie das Produkt
      mittels System.out.println(...) aus.
    - Berechnen Sie die Summe aller Werte in diesen Variablen und wandeln Sie
      das Ergebnis am Ende der Berechnung in eine ganze Zahl um. Geben Sie die
      ganzzahlige Summe mittels System.out.println(...) aus.
    - Wandeln Sie jeden Wert in den Variablen in einen Wert vom Typ byte um und
      berechnen Sie die Summe der umgewandelten Werte. Geben Sie die Summe
      mittels System.out.println(...) aus.

    Zusatzfragen:

    1. Wodurch erklären sich die Unterschiede zwischen den beiden berechneten
    Summen?
        Bei der Umwandlung in Byte entsteht ein Rundungsfehler, da Nachkommastellen abgeschnitten werden

    2. Warum ist der aus den Variablen erzeugte String nicht gleich der oben
    vorgegebenen Zeile mit Literalen?


    3. Von welchem Typ ist der zuletzt ausgegebene Wert?


    4. Wann wird ein Wert automatisch in einen Wert eines anderen Typs
    umgewandelt, wann benötigt man einen Cast?
        Implizierte Typumwandlung erfolgt nur von kleineren in größere Werte, damit Information nicht verloren gehen kann.
        Diese Umwandlung nimmt der Compiler vor. Typenumwandlungen von größeren in kleinere Werte können von ihm aber nicht vorgenommen werden, weil
        die kleinere Zahl vielleicht nicht dargestellt werden kann. Dafür gibt es explizite Typenumwandlungen.

    5. Wieviel Speicher belegt ein Wert eines elementaren Typs mindestens (je
    nach Typ)?


    6. Welchen Wertebereich kann ein elementarer Typ abdecken (je nach Typ)?

*/
public class Aufgabe1{

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier die Angabe

        // initialize variables
        char var1 = 'F';
        int var2 = 0xf;
        int var3 = 070;
        long var4 = 70L;
        float var5 = 77e-1f;
        float var6 = 7.7f;
        double var7 = 7.77e1;
        double var8 = 77.7;

        // add all variables to a string and print out
        String varString = var1 + ", " + var2 + ", " + var3 + ", " + var4 + ", " + var5 + ", " + var6 + ", " + var7 + ", " + var8;
        System.out.println(varString);

        // adds variables to product and keep long format of var4 to prevent from overload, prints product
        long product = (int) var1 * var2 * var3 * var4 * (int) var5 * (int) var6 * (int) var7 * (int) var8;
        System.out.println(product);

        // adds vars to sumPre, casts to int and prints out the sum
        double sumPre = var1 + var2 + var3 + var4 + var5 + var6 + var7 + var8;
        int sum = (int) sumPre;
        System.out.println(sum);

        // casts vars to byte and adds them to sumByte, then prints sum
        int sumByte = (byte) var1 + (byte) var2 + (byte) var3 + (byte) var4 + (byte) var5 + (byte) var6 + (byte) var7 + (byte) var8;
        System.out.println(sumByte);

    }

}


