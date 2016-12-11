/*
    Aufgabe 3, 4, 5) Zweidimensionale Arrays -- Vier Gewinnt

    Fortsetzung des "Vier gewinnt" Spiels aus Aufgabenblatt 4. Kopieren Sie
    sich dazu die Methoden spielfeld(), spielstand(), zug(), und sieg() aus
    Aufgabenblatt 4, um die weiteren Funktionalitäten in diesem Aufgabenblatt
    zu lösen.

    Auch auf diese Aufgaben werden spätere Aufgabenblätter aufbauen, Sie sollten
    sie daher unbedingt lösen. In diesem Aufgabenblatt deckt das Spiel
    "Vier gewinnt" 3 Aufgaben ab. Bitte kreuzen Sie diese separat in TUWEL an.
    
    Hinweis: Sie können Hilfsmethoden implementieren.
    
    *****************************  Aufgabe 3  **********************************
    Für Aufgabe 3 schreiben Sie folgende statische Methoden:

    1) public static int wert1(int[][] f, int spieler)
    
    Diese Methode nimmt eine naive* Stellungsbewertung der Position von Spieler
    "spieler" vor: Es zählt die Zweier-Reihen, Dreier-Reihen, und Vierer-Reihen
    aus Steinen des Spielers "spieler". Der zurückgegebene Wert ist
    1*z+100*d+10000*v, wobei z die Zahl der Zweier-Reihen, d die Zahl der
    Dreier-Reihen, und v die Zahl der Vierer-Reihen ist.
    
    *) Eine einigermassen gute Stellungsbewertung würde den Rahmen der
    Übung sprengen.
    
    Für die Stellung
    
    |       |
    |       |
    |       |
    |  o    |
    |  xo   |
    |  oxoxx|
    +-------+
    
    ist die Bewertung für Spieler 1 (x) 1*2=2 und fuer Spieler 2 (o)
    1*3+100*1=103.  Eine Dreier-Reihe zählt also auch noch als
    zwei Zweier-Reihen.

    2) public static int wert(int[][] f, int spieler)
    
    Die Methode bezieht den wert1() des Gegners in die Bewertung mit ein: Vier
    gewinnt ist (wie die meisten Brettspiele) ein Null-Summen-Spiel
    (Spieler 1 gewinnt, wenn Spieler 2 verliert, und umgekehrt), daher
    soll wert() die Differenz von wert1() des Spielers und wert1() des
    Gegners zurückgeben, im obigen Beispiel also -101 für Spieler 1 (oder
    101 für Spieler 2).
    ****************************************************************************
    
    *****************************  Aufgabe 4  **********************************
    Für Aufgabe 4 schreiben Sie folgende statische Methoden:

    1) public static int negamax(int[][] f, int spieler, int tiefe)
    
    Eine bessere Stellungsbewertung kann man aus wert() ableiten, indem
    man einige Halbzüge vorausschaut. Bei einem Halbzug Vorausschau
    bewertet man die Stellung, die sich bei jedem der 7 möglichen Züge
    ergibt, wie folgt: Der Spieler, der am Zug ist, wird den für ihn
    besten Zug auswählen, der Wert der ursprünglichen Stellung ist also
    das Maximum der Werte der sieben möglichen Folgestellungen. Wenn man
    das für mehrere Halbzüge verallgemeinert, muss man nach jedem Halbzug
    die Seite wechseln, und für den Spieler, der dann am Zug ist, das
    Maximum berechnen. Um diesen Wert dann als Bewertung fuer den anderen
    (vorherigen) Spieler zu verwenden, muß man ihn negieren. Dieser
    Algorithmus heißt "Negamax".

    Diese rekursive Methode "negamax" führt eine Stellungsbewertung für Spieler
    "spieler" mit "tiefe" Zügen Vorausschau durch. Bei 0 Zügen Vorausschau soll
    die Bewertung wert() verwendet werden.
    
    Für diese Methode benötigen Sie eine Möglichkeit, Züge zu probieren,
    ohne sich darauf festzulegen, entweder indem Sie den alten Wert von f
    erhalten, oder indem Sie nach dem Probieren den Zug wieder
    zurücknehmen.  Wenn nötig, modifizieren Sie existierende Methoden
    und/oder implementieren Sie Hilfsmethoden, um das zu erreichen.

    2) public static int bester(int[][] f, int spieler, int tiefe)

    Diese Methode wählt den besten Zug aus. Alle 7 möglichen Züge
    werden durchprobiert, und die sich dadurch ergebende Stellung f1 wird mit
    Hilfe von negamax() bewertet (beachten Sie, welcher Spieler am Zug
    ist). Der Rückgabewert ist ein Zug mit maximaler Bewertung.
    
    Zusatzfragen:
    1. Was sind die Vor- und Nachteile der von Ihnen gewählten
       Art, nach dem Probieren wieder zum vorherigen Zug zu kommen?
    2. Ermitteln Sie durch Ausprobieren und ungefähre Zeitmessung, wie der
       Zeitaufwand von bester() mit der Tiefe zusammenhängt.
    3. Wieviele Aufrufe von wert() werden höchstens ausgeführt, wenn man
       bester() mit Tiefe 0, 1, 2, 8 und n aufruft?
    ****************************************************************************

    *****************************  Aufgabe 5  **********************************
    Für Aufgabe 5 schreiben Sie folgende statische Methode:

    1) public static void spiel1(int tiefe)

    Diese Methode führt ein Vier-Gewinnt-Spiel Spieler gegen Computer durch:
    Zunächst sucht sich der Spieler aus, ob er beginnt oder der Computer. Wenn
    der Computer am Zug ist ist, wählt er den nächsten Zug mit bester(...,
    tiefe) aus und führt ihn durch.  Abgesehen davon macht spiel1() das
    gleiche wie spiel(). Probieren Sie verschiedene Werte für tiefe aus,
    und wählen Sie einen, bei dem der Computer im Normalfall zwischen 0.1s
    und 1s zur Auswahl des besten Zugs braucht. Testen Sie die Methode,
    indem Sie gegen den Computer spielen.
    ****************************************************************************
*/
import java.util.Scanner;
public class Aufgabe3 {

    //***************************  Aufgabe 3  **********************************

    public static int getHStones(int[][] f, int row, int column, int spieler) {
        if (column >= f[row].length) {
            return 0;
        }
        if (f[row][column] != spieler) {
            return 0;
        }
        return 1 + getHStones(f, row, column + 1, spieler);
    }

    public static int getVStones(int[][] f, int row, int column, int spieler) {
        if (row >= f.length) {
            return 0;
        }
        if (f[row][column] != spieler) {
            return 0;
        }
        return 1 + getVStones(f, row + 1, column, spieler);
    }

    public static int getDUpStones(int[][] f, int row, int column, int spieler) {
        if (row >= f.length || column >= f[row].length) {
            return 0;
        }
        if (f[row][column] != spieler) {
            return 0;
        }
        return 1 + getDUpStones(f, row + 1, column + 1, spieler);
    }

    public static int getDDownStones(int[][] f, int row, int column, int spieler) {
        if (row >= f.length || column < 0) {
            return 0;
        }
        if (f[row][column] != spieler) {
            return 0;
        }
        return 1 + getDDownStones(f, row + 1, column - 1, spieler);
    }

    public static int wert1(int[][] f, int spieler){
        // TODO: Implementieren Sie hier die Angabe
        int hCount = 0;
        int vCount = 0;
        int dUpCount = 0;
        int dDownCount = 0;

        int z = 0; // zweierreihe
        int d = 0; // dreierreihe
        int v = 0; // viererreihe

        for (int row = 0; row < f.length; row++) {
            for (int column = 0; column < f[row].length; column++) {
                hCount = getHStones(f, row, column, spieler);
                vCount = getVStones(f, row, column, spieler);
                dUpCount = getDUpStones(f, row, column, spieler);
                dDownCount = getDDownStones(f, row, column, spieler);

                if (hCount >= 4) {
                    z++;
                    d++;
                    v++;
                }
                if (vCount >= 4) {
                    z++;
                    d++;
                    v++;
                }
                if (dUpCount >= 4) {
                    z++;
                    d++;
                    v++;
                }
                if (dDownCount >= 4) {
                    z++;
                    d++;
                    v++;
                }

                if (hCount == 3) {
                    z++;
                    d++;
                }
                if (vCount == 3) {
                    z++;
                    d++;
                }
                if (dUpCount == 3) {
                    z++;
                    d++;
                }
                if (dDownCount == 3) {
                    z++;
                    d++;
                }

                if (hCount == 2) {
                    z++;
                }
                if (vCount == 2) {
                    z++;
                }
                if (dUpCount == 2) {
                    z++;
                }
                if (dDownCount == 2) {
                    z++;
                }
            }
        }
        return  z+100*d+10000*v;
    }
    
    public static int wert(int[][] f, int spieler){
        // TODO: Implementieren Sie hier die Angabe
        int valCurrent = wert1(f, spieler);

        if (spieler == 1) {
            spieler = 2;
        } else {
            spieler = 1;
        }

        int valOpposite = wert1(f, spieler);
        return valCurrent - valOpposite;
    }
    //**************************************************************************
    
    
    //***************************  Aufgabe 4  **********************************
    public static int negamax(int[][] f, int spieler, int tiefe){
        // TODO: Implementieren Sie hier die Angabe
        if (tiefe == 0) {
            return wert(f, spieler);
        }
        int bestValue = Integer.MIN_VALUE;
        int score;
        int[][] copyArray;
        for (int i = 0; i < f[0].length; i++) {
            copyArray = copySpielfeld(f);
            if (zug(copyArray, spieler, i) != null) {
                score = -negamax(copyArray, (spieler == 1 ? 2 : 1), tiefe - 1);
                bestValue = Math.max(bestValue, score);
            }
        }
        return bestValue;
    }

    public static int[][] copySpielfeld(int[][] f) {
        int[][] copyArray = new int[f.length][f[0].length];
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                copyArray[i][j] = f[i][j];
            }
        }
        return copyArray;
    }


    public static int bester(int[][] f, int spieler, int tiefe){
        // TODO: Implementieren Sie hier die Angabe
        long startTime = System.currentTimeMillis();
        int bestValue = Integer.MIN_VALUE;
        int score;
        int row = -1;
        int[][] copyArray;

        for (int i = 0; i < f[0].length; i++) {
            copyArray = copySpielfeld(f);
            if (zug(copyArray, spieler, i) != null) {
                score = -negamax(copyArray, (spieler == 1 ? 2 : 1), tiefe);
                if (score > bestValue) {
                    row = i;
                    bestValue = score;
                }
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
        return row;
    }
    //**************************************************************************
    
    
    //***************************  Aufgabe 5  **********************************

    public static void spiel1(int tiefe){
        // TODO: Implementieren Sie hier die Angabe
        // initialize scanner
        Scanner scanner = new Scanner(System.in);

        // control flow variable
        boolean userSelect = false;
        boolean input = true;
        int humanUser = 1;
        int spieler = 1;

        // user select
        System.out.println("Wähle, wer beginnt. Mögliche Eingaben: (1) für Spieler 1 und (2) für die KI.");
        while (!userSelect && scanner.hasNext()) {
            // check if scanner has int input
            if (scanner.hasNextInt()) {
                // if so, get player value
                int player = scanner.nextInt();
                // if input is not between 1 and 2, show error message
                if (player < 1 || player > 2) {
                    System.out.println("Keine gültige Eingabe. Nur 1 oder 2 erlaubt.");
                    scanner.next();
                } else {
                    // set default player
                    humanUser = player;
                    userSelect = true;
                }
            }
        }

        // initialize spielfeld
        int[][] f = spielfeld();

        // show spielfeld and show Player x begin message
        spielstand(f);
        if (humanUser == 2) {
            System.out.println("KI beginnt und wählt ihren Zug.");
            zug(f, spieler, bester(f, humanUser, tiefe));
            spielstand(f);
            spieler = humanUser;
            System.out.println("Spieler " + spieler + " ist am Zug. Wähle eine Spalte. (0-6)");
        } else {
            System.out.println("Spieler 1 beginnt. Wähle eine Spalte. (0-6)");
        }

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
                            System.out.println(wert(f, spieler));
                            System.out.println("Spieler " + spieler + " hat gewonnen! GZ!");
                            input = false;
                        } else {
                            // else flip player
                            if (spieler == 1) {
                                spieler = 2;
                            } else {
                                spieler = 1;
                            }
                            // KI
                            System.out.println("KI wählt ihren nächsten Zug. Bitte warten.");
                            zug(f, spieler, bester(f, (spieler == 1 ? 2 : 1), tiefe));
                            spielstand(f);
                            if (sieg(f, spieler)) {
                                System.out.println(wert(f, spieler));
                                System.out.println("Spieler " + spieler + " hat gewonnen! GZ!");
                                input = false;
                            } else {
                                // else flip player
                                if (spieler == 1) {
                                    spieler = 2;
                                } else {
                                    spieler = 1;
                                }
                                System.out.println("Spieler " + spieler + " ist am Zug. Wähle eine Spalte. (0-6)");
                            }
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
        spiel1(6);
    }
    
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
        for (int row = 0; row < f.length-3; row++) {
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
    /**
     * main method for playing 'Connect Four'
     */
    public static void spiel(){
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
                            System.out.println(wert(f, spieler));
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
}