/*******************************************************************************

 AUFGABENBLATT 1 - Allgemeine Informationen

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
 bis spätestens Montag 17.10.2016 08:00 Uhr in TUWEL hoch. Zusätzlich
 müssen Sie in TUWEL ankreuzen welche Aufgaben Sie gelöst haben und während
 der Übung präsentieren können.

 ******************************************************************************/

/*
    Aufgabe 1) Variablen

    Erweitern Sie die main-Methode um folgende Funktionalität:
    - Deklarieren Sie eine ganzzahlige lokale Variable "var1" und initialisieren
      Sie diese mit dem Wert 5.
    - Deklarieren Sie eine ganzzahlige lokale Variable "var2" und initialisieren
      Sie diese mit dem dreifachen Wert von "var1".
    - Deklarieren Sie eine ganzzahlige lokale Variable "var3" und initialisieren
      Sie diese mit der Differenz von "var2-var1".
    - Geben Sie die Variable "var3" mit "System.out.println()" aus.
    - Weisen Sie der Variablen "var3" das Ergebnis der Division "var2 / var1"
      zu.
    - Geben Sie die Variable "var3" mit "System.out.println()" aus.
    - Erhöhen Sie die Variable "var2" um eins und weisen Sie erneut der
      Variablen "var3" das Ergebnis der Division "var2 / var1" zu.
    - Geben Sie die Variable "var3" mit "System.out.println()" aus.

    Zusatzfragen:
    1) Warum liefern die letzten beiden Ausgaben jeweils 3 zurück?
            weil int nur ganze zahlen berücksichtigt

    2) Warum verwendet man Variablen in einem Programm?
            vereinfachung, wiederverwendbarkeit

    3) Was ist der Unterschied zwischen Ausdruck und Anweisung?
            ein Ausdruck gibt nach Ende seiner Ausführung ein Ergebnis zurück, das weiterverwendet werden kann. Z.B. var 1 * 3.
            eine Anweisung endet mit Semikolon oder Klammern und
*/
public class Aufgabe1{

    public static void main(String[] args) {
        int var1 = 5;
        int var2 = var1 * 3;
        int var3 = var2 - var1;
        System.out.println(var3);

        var3 = var2 / var1;
        System.out.println(var3);

        var2++;
        var3 = var2 / var1;
        System.out.println(var3);
    }

    private static int bla() {
        int f = 1;
        return f;
    }

}


