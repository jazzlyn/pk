/*
    Aufgabe2) Eingabe (Scanner)

    Erweitern Sie die main-Methode so, dass wiederholt Werte eingelesen werden,
    bis die Zahl 0 eingegeben wird. Dann wird das Programm beendet. Zuvor wird
    noch der Durchschnittswert aller eingelesenen Zahlen als ganzzahliger Wert
    ausgegeben (Nachkommastellen gehen verloren),  falls alle eingelesenen Werte
    ganze Zahlen waren. In allen anderen Fällen wird nichts ausgegeben.

    Zusatzfragen:
    1. Warum muss eine ungültige Eingabe (keine ganze Zahl) aus dem
    Input-Stream entfernt werden?
        Die Eingabe muss verarbeitet werden, sonst wird sie nicht gelöscht.

    2. Woran kann man erkennen, dass ein eingelesener Wert eine ganze Zahl ist?
        ich kann es mit hasnextint explizit abfragen.

    3. Woran kann man feststellen, ob eine frühere Eingabe ungültig war?
        ich setze meine variable intInput auf false.

*/
import java.util.Scanner;

public class Aufgabe2{

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier die Angabe
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int iteration = 0;          // counts input
        boolean input = true;       // sets input true
        boolean intInput = true;    // sets intInput true, is set to false when the input is not an integer

        // while input is true and scanner has input
        while (input && scanner.hasNext()) {
            // check if scanner has int input
            if (scanner.hasNextInt()) {
                // if so, assign to variable num
                int num = scanner.nextInt();
                // if input is not 0
                if (num != 0) {
                    // assign input to sum variable and sum inputs up
                    sum = sum + num;
                    // count iteration +1
                    iteration++;
                } else {
                    // if input is 0, set input boolean false and exit while loop
                    input = false;
                }
            } else {
                // get param from scanner, clear input and set intInput false
                scanner.next();
                intInput = false;
            }
        }
        // when there is input with integers, sum is not null and there was no input with something other than integers, get average value and print sum
        if (iteration > 0 && sum != 0 && intInput) {
            sum = sum / iteration;
            System.out.println(sum);
        }
    }
}

