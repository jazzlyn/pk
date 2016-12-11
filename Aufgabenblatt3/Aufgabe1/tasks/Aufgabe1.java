/*******************************************************************************

 AUFGABENBLATT 3 - Allgemeine Informationen

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
 bis spätestens Montag 07.11.2016 08:00 Uhr in TUWEL hoch. Zusätzlich
 müssen Sie in TUWEL ankreuzen welche Aufgaben Sie gelöst haben und während
 der Übung präsentieren können.

 ******************************************************************************/

/*
    Aufgabe 1) Schleifenanalyse

    Erweitern Sie die Klasse 'Aufgabe1' um eine statische Methode namens
    "drawNumDiamond(int h)", die einen Diamanten (Raute) mit Zahlen ausgibt.
    Der übergebene Parameter "h" entspricht der Höhe des Diamanten (Raute).
    Ein h=9 führt zu folgender Ausgabe:

        1
       222
      33333
     4444444
    555555555
     4444444
      33333
       222
        1

    Wird eine gerade Zahl dem Parameter "h" übergeben so wird "NO VALID INPUT"
    ausgegeben. Bei h=0 wird nichts ausgegeben und die Methode sofort verlassen.
    Der Rückgabetyp der Methode ist "void".
    Es sollen für die Implmentierung der Methdoe nicht mehr als 3 for-Schleifen
    (keine while- oder do/while-Schleife) verwendet werden. Überlegen
    Sie wie man eventuell weitere for-Schleifen einsparen könnte.
    (Die Methode soll für h <= 17 funktionieren.)

    Zusatzfragen:
    1. Wie ist die Vorgangsweise abzuändern, wenn statt jedem Wert 1 der
    Buchstabe A, statt jedem Wert 2 der Buchstabe B, ... und statt jedem Wert 5
    der Buchstabe E ausgegeben werden soll ?
        Für jeden Char existiert in Java im Hintergrund ein integer, A-E ist hintereinander codiert, mit char cast
        auf die int werte kann man den zugehörigen char bekommen. siehe unten

*/
public class Aufgabe1 {
    
    // TODO: Implementieren Sie hier die Angabe

    /**
     * draws a diamond with system print out
     * @param h max lines of whole diamond
     */
    public static void drawNumDiamond(int h) {
        // if input is 0, end function
        if (h == 0) {
            return;
        }
        if (h % 2 == 0) {
            // if input is even, give output and end function
            System.out.println("NO VALID INPUT");
            return;
        }
        // get middle of the diamond
        int middle = (h / 2) + 1;
        // print diamond
        for (int i = 1; i <= h; i++) {
            // print line 0 - middle, widest line of diamond
            if (i <= middle) {
                System.out.println(drawLine(i, h));
            // print from middle reverse to end of diamond
            } else if (middle <= i) {
                // increment is now max height - increment + 1
                System.out.println(drawLine((h-i)+1, h));
            }
        }
    }

    /**
     * dynamic line draw for diamond
     * @param increment current line to draw
     * @param h max lines of whole diamond
     * @return returns the whole line with whitespaces as string
     */
    private static String drawLine(int increment, int h) {
        String line = "";
        // get needed number of whitespaces. (max height - current line * 2 - 1)
        int countWhitespaces = (h - (increment * 2 - 1)) / 2;
        for (int i = 0; i < increment * 2 - 1; i++) {
            //line += (char) (64 + increment);
            line += increment;
        }
        String whitespaces = whitespace(countWhitespaces);
        return whitespaces + line + whitespaces;
    }

    /**
     * dynamic whitespace creation for drawLine function
     * @param count needed number of whitespaces for one side of current line
     * @return returns a string with whitespaces
     */
    private static String whitespace(int count) {
        String whitespaces = "";
        for (int i = 0; i < count; i++) {
            whitespaces += " ";
        }
        return whitespaces;
    }
    
    public static void main(String[] args) {
        drawNumDiamond(9);
    }
}
