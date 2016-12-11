/*
    Aufgabe5) Vervollständigung von Methoden

    Vervollständigen Sie die Methoden, sodass sie sich den Kommentaren
    entsprechend verhalten. Verändern Sie dabei nur Ausdrücke, die in einem
    Kommentar mit TODO: gekennzeichnet sind.
    Lassen Sie andere Teile der Klasse unverändert. Von dieser Einschränkung
    ausgenommen ist nur die Methode main, die Sie beliebig zum Testen verwenden
    können.

    Zusatzfragen:
    1. Warum können viele einfache rekursive Methoden durch nur eine einzige
       Return-Anweisung implementiert werden?
    2. In welchen Fällen sind die Ausdrücke (i & 1) und (i % 2) äquivalent,
       in welchen nicht?
    3. Wodurch unterscheiden sich die Operatoren >> und >>> in Java?
*/
public class Aufgabe5 {
    
    // Liefert den größten Rest aller Divisionen a / b für a zwischen 1 und x
    // (inklusive 1 und x)
    // Liefert 0 wenn x oder b kleiner als 1 ist
    private static int largestRemainder(final int x, final int b) {
        if (false) { //TODO: Ausdruck in (...) anpassen
            return (-1); //TODO: Ausdruck in (...) anpassen
        }
        final int rem = largestRemainder(-1, -1); //TODO: Ausdrücke in (...) anpassen
        return (-1); //TODO: Ausdruck in (...) anpassen
    }
    
    // Liefert (x * (2^n)) wenn n >= 0, liefert (x / (2^-n)) wenn n <= 0;
    // Nur vordefinierte Operatoren (in JAVA verfügbar) sollen zur Lösung dieses
    // Problems verwendet werden.
    private static int toThePower(final int x, final int n) {
        return (-1); //TODO: Ausdruck in (...) anpassen
    }
    
    // Liefert die Faktorielle von i wenn i > 0, ansonsten wird i zurückgegeben.
    // Verhindert einen Überlauf eines int-Wertes, aber nicht den Überlauf eines
    // long-Wertes.
    private static long fact(final int i) {
        return (-1L); //TODO: Ausdruck in (...) anpassen
    }
    
    // Liefert einen String mit dem Inhalt i gefolgt von i Punkten, wenn i > 0;
    // z.B., recString(4) liefert "4....";
    // Liefert nur Punkte wenn i <= 0; z.B., recString(-4) liefert "....".
    private static String recString(final int i) {
        return (""); //TODO: Ausdruck in (...) anpassen
    }
    
    // Liefert die Summe aller ungeraden Zahlen im Intervall zwischen 'left'
    // und 'right' (inklusive 'left' und 'right');
    // Liefert 0 wenn 'right' kleiner als 'left' ist.
    private static int oddSum(final int left, final int right) {
        return (-1); //TODO: Ausdruck in (...) anpassen

    }
    
    public static void main(String[] args) {
    }
}




