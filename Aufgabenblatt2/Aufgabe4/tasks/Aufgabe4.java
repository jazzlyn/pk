/*
    Aufgabe4) Vorgegebene versus berechnete Zahlen

    Stellen Sie fest, was die Methode 'longish' macht. Schreiben Sie eine
    Methode 'simpler', die genau dasselbe wie 'longish' macht (und denselben
    Parametertyp und Ergebnistyp hat), aber ohne bedingte Anweisung und ohne
    bedingten Ausdruck auskommt. In 'simpler' darf auch kein Literal mit einem
    Wert größer 10 vorkommen. Anders ausgedrückt: Die in 'longish' als Literale
    vorgegebenen Werte sollen in 'simpler' zur Laufzeit berechnet werden. Das
    geschieht in einer Schleife, sodass bedingte Anweisungen und Ausdrücke nicht
    nötig sind.

    Zusatzfragen:
    1. Was macht 'longish'?
        zählt an der dezimalwertigkeit der zahl +1 für jede zahl, die der wertigkeit entspricht. also 20 für zwei 1er (da 1, 0)

    2. Welche Art von Schleife kommt in 'simpler' am besten zum Einsatz?
        eine for schleife, da mit der bedingung bei jedem durchgang etwas passieren muss, nämlich / 10

    3. Ist es immer möglich, bedingte Anweisungen und Ausdrücke durch Schleifen
       zu ersetzen?
       nein.

    4. Warum ist 'simpler' wahrscheinlich kürzer als 'longish', obwohl zur
       Laufzeit mehr berechnet wird?
       weil es dynamisch ist.
*/
public class Aufgabe4{

    private static long longish(short n) {
        long result = 0L;
        while (n > 0) {
            switch (n % 10) {
                case 0:
                    result += 1L;
                    break;
                case 1:
                    result += 10L;
                    break;
                case 2:
                    result += 100L;
                    break;
                case 3:
                    result += 1000L;
                    break;
                case 4:
                    result += 10000L;
                    break;
                case 5:
                    result += 100000L;
                    break;
                case 6:
                    result += 1000000L;
                    break;
                case 7:
                    result += 10000000L;
                    break;
                case 8:
                    result += 100000000L;
                    break;
                case 9:
                    result += 1000000000L;
                    break;
            }
            n /= 10;
        }
        return result;
    }

    private static long simpler(short n) {
        // TODO: Implementieren Sie hier die Angabe
        int rest;
        long result = 0L;
        for (; n > 0; n /= 10) {
            int startVal = 1;
            rest = n % 10;
            while (rest > 0) {
                startVal = startVal * 10;
                rest--;
            }
            result = result + startVal;
        }
        return result;
    }

    public static void main(String[] args) {
        short var = 11;
        System.out.println(simpler(var));
    }
}

