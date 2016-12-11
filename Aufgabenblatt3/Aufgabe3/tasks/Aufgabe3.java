/*
    Aufgabe 3) Rekursion in Iteration ändern

    Stellen Sie fest, was die Methode 'rec' macht. Schreiben Sie eine statische
    Methode 'iter', die das Gleiche macht wie 'rec'
    (gleiches Input-Output-Verhalten), aber ohne Rekursion auskommt.

    Zusatzfragen:
    1. Warum ist es notwendig, negative Parameterwerte getrennt zu behandeln?
        beim ggt zählt der betrag der zahlen, bei einem negativwert würden andere rechenregeln zum tragen kommen
    2. Warum ist es notwendig, 0 als Sonderfall zu behandeln?
        geteilt durch 0 ist immer 0. wir hätten kein ergebnis
    3. Ist es immer vernünftig, sich an die Hinweise einer IDE zu halten?
        in diesem fall nicht.
    
*/
public class Aufgabe3 {
    
    //Was berechnet "rec"?
    public static int rec(int x, int y) {
        if (x < 0) {
            return rec(-x, y);
        }
        if (y < 0) {
            return rec(x, -y);
        }
        if (x == 0) {
            return 0;
        }
        if (x > y) {
            return rec(y, x);
        }
        if (x == y) {
            return x;
        }
        return rec(x, y - x);
    }
    
    // TODO: Implementieren Sie hier die Angabe
    public static int iter(int x, int y) {
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }
        // not a and not b = not (a or b)
        while (!(x == 0 || x == y)) {
            int a = x;
            int b = y;

            // change variables if x greater y
            if (x > y) {
                x = b;
                y = a;
            }
            y = y -x;

        }
        // return x, when x 0 or same as y
        return x;
    }


    public static void main(String[] args) {
        System.out.println(iter(33, 22));
    }
}





