/*
    Aufgabe 3, 4, 5,) Zweidimensionale Arrays -- Vier Gewinnt

    Beim Spiel "Vier gewinnt" gewinnt der Spieler, der als erstes vier Steine
    in eine Reihe bringt (horizontal, vertikal, oder diagonal). Das Spielfeld
    steht senkrecht und ist 7 Spalten breit und 6 Reihen hoch. Steine können nur
    im untersten Feld einer Spalte platziert werden, das noch nicht von einem
    anderen Stein besetzt ist.

    "Vier gewinnt" wird in mehreren, aufeinander aufbauenden Aufgaben in
    mehreren Aufgabenblättern verwendet, Sie sollten daher diese Aufgaben
    unbedingt lösen. In diesem Aufgabenblatt deckt das Spiel "Vier gewinnt"
    3 Aufgaben ab. Bitte kreuzen Sie diese separat in TUWEL an.
    
    Hinweis: Sie können Hilfsmethoden implementieren, dürfen aber vorgegebene
             Methoden und deren Signaturen nicht verändern.
    
    *****************************  Aufgabe 3  **********************************
    Für Aufgabe 3 schreiben Sie folgende statische Methoden:

    1) public static int[][] spielfeld()
    
    Diese Methode erzeugt ein leeres Vier-Gewinnt-Spielfeld. Das Spielfeld soll
    als zweidimensionales Array von int-Werten dargestellt werden, wobei auf
    ein Feld in Reihe r und Spalte s im Feld f mit f[r][s] zugegriffen werden
    soll. Ein leeres Feld wird mit 0 repraesentiert, ein Stein auf einem Feld
    durch 1 für einen Stein des Spielers 1 bzw. 2 für einen Stein des
    Spielers 2.

    2) public static void spielstand(int[][] f)
    
    Diese Methode gibt den Spielstand f in folgender Form aus:
    
    |       |
    |       |
    |       |   Definition: Die linke unterste Ecke ist als Koordinate [0][0]
    |       |               definiert und stellt den Ausgangspunkt des
    |  xo   |               Spielbrettes dar.
    |  ox   |
    +-------+
    
    wobei für ein leeres Feld ein Leerzeichen ausgegeben wird, für einen Stein
    von Spieler 1 ein x, und für einen Stein von Spieler 2 ein o.
    
    Zusatzfragen:
    1. Welche anderen Möglichkeiten neben der von Ihnen gewählten gibt es, um
    von der Spielernummer auf x bzw. o zu kommen?
    ****************************************************************************
    
    *****************************  Aufgabe 4  **********************************
    Für Aufgabe 4 schreiben Sie folgende statische Methoden:

    1) public static int[][] zug(int[][] f, int spieler, int spalte)

    Diese Methode führt einen Zug des Spielers "spieler" in Spalte
    "spalte" (0-6 für legale Züge) durch und gibt die neue Stellung
    (das Spielfeld nach dem Zug) zurück.  Wenn in Spalte "spalte" kein
    Zug möglich ist (weil die Spalte voll ist oder nicht im erlaubten
    Bereich), soll zug() null zurückgeben.  Das vom Parameter f
    referenzierte Feld darf verändert werden oder unverändert bleiben.

    2) public static boolean sieg(int[][] f, int spieler)

    Diese Methode liefert true, wenn "spieler" vier Steine in einer Reihe hat,
    sonst false.

    Zusatzfragen:
    1. Welche Vor- und Nachteile hat es für dieses Beispiel und in
    Hinblick auf Aufgabe 5, den Parameter f von zug() zu verändern.
    ****************************************************************************

    *****************************  Aufgabe 5  **********************************
    Für Aufgabe 5 schreiben Sie folgende statische Methode:

    1) public static void spiel()

    Diese Methode führt ein Vier-Gewinnt-Spiel zwischen zwei Spielern durch:
    Beginnend mit einem leeren Spielfeld werden abwechselnd Spieler 1 und
    Spieler 2 zur Eingabe eines Spielzuges aufgefordert, der Spielzug
    durchgeführt, und der aktuelle Spielstand ausgegeben, solange bis ein
    Spieler gewonnen hat oder das Spielfeld voll ist. Überlegen Sie sich
    eine sinnvolle Behandlung von ungültigen Eingaben. In "main" wird am Ende
    nur noch die Methode spiel() aufgerufen. Testen Sie spiel() selbst, auch
    den Fall, dass das Spielfeld voll wird, ohne dass ein Spieler gewonnen hat.

    Zusatzfragen:
    1. Was machen Sie bei ungültigen Eingaben?
    ****************************************************************************
*/
import java.util.Scanner;
public class Aufgabe3 {

    //***************************  Aufgabe 3  **********************************

    /**
     * creates array for spielfeld of 'Connect Four'
     * @return new two-dimensional array
     */
    public static int[][] spielfeld(){
        // TODO: Implementieren Sie hier die Angabe
        return new int[6][7];
    }

    /**
     * prints spielfeld for 'connect four'.
     * @param f two-dimensional array
     */
    public static void spielstand(int[][] f){
        // TODO: Implementieren Sie hier die Angabe
        // iterate through rows of array from last to first (display inverted)
        for (int row = f.length - 1; row >= 0; row--) {
            // lines on the left of spielfeld
            System.out.print("|");
            // iterate through every column (spalte) of array and set output string for 1, 2 and default 0
            for (int column = 0; column < f[row].length; column++) {
                // alternative: if else, array with all 3 signs
                switch (f[row][column]) {
                    case 1:
                        System.out.print("x");
                        break;
                    case 2:
                        System.out.print("o");
                        break;
                    default:
                        System.out.print(" ");
                        break;
                }
            }
            // lines on the right of spielfeld
            System.out.println("|");
        }
        // bottom line of spielfeld
        System.out.println("+-------+");
    }
    //**************************************************************************
    
    
    //***************************  Aufgabe 4  **********************************

    /**
     * method for passing move to spielfeld
     * @param f current spielfeld
     * @param spieler current player
     * @param spalte chosen column (current move)
     * @return updated spielfeld
     */
    public static int[][] zug(int[][] f, int spieler, int spalte){
        // TODO: Implementieren Sie hier die Angabe
        // control flow variable
        boolean valid = false;

        // if player is not valid or spalte is not in range, return null
        if (spieler > 2 || spieler < 1 || spalte > 6 || spalte < 0) {
            return null;
        }
        // iterate through every row of array until an empty field is found
        for (int row = 0; row < 6 && !valid; row++) {
            // if current row is empty, set int to player and valid true
            if (f[row][spalte] == 0) {
                f[row][spalte] = spieler;
                valid = true;
            }
        }
        // if move is not valid, return null
        if (!valid) {
            return null;
        }
        // return updated spielfeld
        return f;
    }

    /**
     * check if there are 'Four Connected'
     * @param f current spielfeld
     * @param spieler current player
     * @return true if there are 4 gems in a row horizontal, vertical, diagonal up and diagonal down
     */
    public static boolean sieg(int[][] f, int spieler) {
        // TODO: Implementieren Sie hier die Angabe
        // horizontal, iterate through rows of array
        for (int row = 0; row < f.length; row++) {
            // iterate through columns (spalte), length -3 for last 4 stones in a row
            for (int column = 0; column < f[row].length-3; column++) {
                if (f[row][column] == spieler
                        && f[row][column +1] == spieler
                        && f[row][column +2] == spieler
                        && f[row][column +3] == spieler) {
                    return true;
                }
            }
        }
        // vertical
        // iterate through rows, length -3 for last 4 stones in a column
        for (int row = 0; row < f.length-3; row++) {
            // iterate through columns (spalte)
            for (int column = 0; column < f[row].length; column++) {
                if (f[row][column] == spieler
                        && f[row +1][column] == spieler
                        && f[row +2][column] == spieler
                        && f[row +3][column] == spieler) {
                    return true;
                }
            }
        }
        // diagonal up
        for (int row = 0; row < f.length; row++) {
            // length -3 for last 4 stones in a row
            for (int column = 0; column < f[row].length-3; column++) {
                if (f[row][column] == spieler
                        && f[row +1][column+1] == spieler
                        && f[row +2][column+2] == spieler
                        && f[row +3][column+3] == spieler) {
                    return true;
                }
            }
        }
        // diagonal down
        for (int row = 0; row < f.length; row++) {
            // column 3 for first 4 stones in a row
            for (int column = 3; column < f[row].length; column++) {
                if (f[row][column] == spieler
                        && f[row +1][column-1] == spieler
                        && f[row +2][column-2] == spieler
                        && f[row +3][column-3] == spieler) {
                    return true;
                }
            }
        }
        // return false if there is no current winner
        return false;
    }
    //**************************************************************************
    
    
    //***************************  Aufgabe 5  **********************************


    /**
     * main method for playing 'Connect Four'
     */
    public static void spiel() {
        // TODO: Implementieren Sie hier die Angabe
        // control flow variable
        boolean input = true;
        // initialize scanner
        Scanner scanner = new Scanner(System.in);
        // set default player to 1
        int spieler = 1;
        // initialize spielfeld
        int[][] f = spielfeld();

        // show spielfeld and show Player 1 begin message
        spielstand(f);
        System.out.println("Spieler 1 beginnt. Wähle eine Spalte. (0-6)");

        // while input is true and scanner has input
        while (input && scanner.hasNext()) {
            // check if scanner has int input
            if (scanner.hasNextInt()) {
                // if so, assign to variable spalte (column)
                int spalte = scanner.nextInt();
                // if input is not between 0 and 6, show error message
                if (spalte < 0 || spalte > 6) {
                    System.out.println("Keine gültige Eingabe. Nur Zahlen zwischen 0 und 6 erlaubt.");
                } else {
                    // if column is full, show error message
                    if (zug(f, spieler, spalte) == null) {
                        System.out.println("Die Spalte ist voll! Wähle eine andere Spalte.");
                    } else {
                        // show spielfeld
                        spielstand(f);
                        // check if player has won. if so, exit loop
                        if (sieg(f, spieler)) {
                            System.out.println("Spieler " + spieler + " hat gewonnen! GZ!");
                            input = false;
                        } else {
                            // else flip player
                            if (spieler == 1) {
                                spieler = 2;
                            } else {
                                spieler = 1;
                            }
                            // and show message to continue
                            System.out.println("Spieler " + spieler + " ist am Zug. Wähle eine Spalte. (0-6)");
                        }
                    }
                }
                // if scanner has no int input, show error message
            } else {
                System.out.println("Keine gütlige Eingabe. Nur Zahlen zwischen 0 und 6 erlaubt.");
                // and restart scanner
                scanner.next();
            }
        }
    }

    //**************************************************************************
    
    public static void main(String[] args) {
        spiel();
    }
}

