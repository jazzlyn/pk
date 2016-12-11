import java.util.Scanner;

/*
    Aufgabe 3) Klassen und Objekte -- Vier Gewinnt

    Fortsetzung des "Vier gewinnt" Spiels aus Aufgabenblatt 5.
     
    Auch auf diese Aufgabe werden spätere Aufgabenblätter aufbauen, Sie sollten
    sie daher unbedingt lösen.
    
    Definieren Sie eine Klasse Spielfeld mit einem Konstruktor, der ein leeres
    Spielfeld erzeugt, und folgenden (nicht-statischen) Methoden:

    - int feld(int reihe, int spalte) gibt 0, 1, oder 2 zurück, je nachdem, ob
      das Feld besetzt ist und von wem.

    Folgende Methoden sind nicht-statische Varianten für Spielfeld der früher
    definierten statischen Methoden:

    - void spielstand()
    - Spielfeld zug(int spieler, int Spalte)
    - boolean sieg(int spieler)
    - int wert1(int spieler)
    - int wert(int spieler)
    - int negamax(int spieler, int tiefe)
    - int bester(int spieler, int tiefe)

    Das Spielfeld wird dabei noch immer so repräsentiert wie zuvor.

    Schreiben Sie eine Klasse Viergewinnt mit den Methoden

    - public static void spiel()
    - public static void spiel1(int tiefe)

    die für das Spielfeld und die Methoden dazu die Klasse Spielfeld benutzen.

    Zusatzfrage: Ist spiel1() bei gleicher Tiefe durch diese Änderung
    schneller oder langsamer geworden? Um wieviel?
    ****************************************************************************
*/
// TODO: Implementieren Sie hier die Klasse "Spielfeld"
class Spielfeld {

    int[][] f;

    Spielfeld() {
        this.f = new int[6][7];
    }

    int feld(int reihe, int spalte) {
        return this.f[reihe][spalte];
    }

    /**
     * prints spielfeld for 'connect four'.
     */
    void spielstand() {
        // iterate through rows of array from last to first (display inverted)
        for (int row = this.f.length - 1; row >= 0; row--) {
            // lines on the left of spielfeld
            System.out.print("|");
            // iterate through every column (spalte) of array and set output string for 1, 2 and default 0
            for (int column = 0; column < this.f[row].length; column++) {
                // alternative: if else, array with all 3 signs
                switch (this.f[row][column]) {
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
     * @param spieler current player
     * @param spalte chosen column (current move)
     * @return updated spielfeld
     */
    Spielfeld zug(int spieler, int spalte) {
        // control flow
        boolean valid = false;

        // if player is not valid or spalte is not in range, return null
        if (spieler > 2 || spieler < 1 || spalte > 6 || spalte < 0) {
            return null;
        }
        // iterate through every row of array until an empty field is found
        for (int row = 0; row < 6 && !valid; row++) {
            // if current row is empty, set int to player and valid true
            if (this.f[row][spalte] == 0) {
                this.f[row][spalte] = spieler;
                valid = true;
            }
        }
        // if move is not valid, return null
        if (!valid) {
            return null;
        }
        // return updated spielfeld
        return this;
    }

    /**
     * check if there are 'Four Connected'
     * @param spieler current player
     * @return true if there are 4 gems in a row horizontal, vertical, diagonal up and diagonal down
     */
    boolean sieg(int spieler) {
        // horizontal, iterate through rows of array
        for (int row = 0; row < this.f.length; row++) {
            // iterate through columns (spalte), length -3 for last 4 stones in a row
            for (int column = 0; column < this.f[row].length-3; column++) {
                if (this.f[row][column] == spieler
                        && this.f[row][column +1] == spieler
                        && this.f[row][column +2] == spieler
                        && this.f[row][column +3] == spieler) {
                    return true;
                }
            }
        }
        // vertical
        // iterate through rows, length -3 for last 4 stones in a column
        for (int row = 0; row < this.f.length-3; row++) {
            // iterate through columns (spalte)
            for (int column = 0; column < this.f[row].length; column++) {
                if (this.f[row][column] == spieler
                        && this.f[row +1][column] == spieler
                        && this.f[row +2][column] == spieler
                        && this.f[row +3][column] == spieler) {
                    return true;
                }
            }
        }
        // diagonal up
        for (int row = 0; row < this.f.length-3; row++) {
            // length -3 for last 4 stones in a row
            for (int column = 0; column < this.f[row].length-3; column++) {
                if (this.f[row][column] == spieler
                        && this.f[row +1][column+1] == spieler
                        && this.f[row +2][column+2] == spieler
                        && this.f[row +3][column+3] == spieler) {
                    return true;
                }
            }
        }
        // diagonal down
        for (int row = 0; row < this.f.length-3; row++) {
            // column 3 for first 4 stones in a row
            for (int column = 3; column < this.f[row].length; column++) {
                if (this.f[row][column] == spieler
                        && this.f[row +1][column-1] == spieler
                        && this.f[row +2][column-2] == spieler
                        && this.f[row +3][column-3] == spieler) {
                    return true;
                }
            }
        }
        // return false if there is no current winner
        return false;
    }
    
    private int getHStones(int row, int column, int spieler) {
        if (column >= this.f[row].length) {
            return 0;
        }
        if (this.f[row][column] != spieler) {
            return 0;
        }
        return 1 + getHStones(row, column + 1, spieler);
    }

    private int getVStones(int row, int column, int spieler) {
        if (row >= this.f.length) {
            return 0;
        }
        if (this.f[row][column] != spieler) {
            return 0;
        }
        return 1 + getVStones(row + 1, column, spieler);
    }

    private int getDUpStones(int row, int column, int spieler) {
        if (row >= this.f.length || column >= this.f[row].length) {
            return 0;
        }
        if (this.f[row][column] != spieler) {
            return 0;
        }
        return 1 + getDUpStones(row + 1, column + 1, spieler);
    }

    private int getDDownStones(int row, int column, int spieler) {
        if (row >= this.f.length || column < 0) {
            return 0;
        }
        if (this.f[row][column] != spieler) {
            return 0;
        }
        return 1 + getDDownStones(row + 1, column - 1, spieler);
    }

    int wert1(int spieler) {
        int hCount = 0;
        int vCount = 0;
        int dUpCount = 0;
        int dDownCount = 0;

        int z = 0; // zweierreihe
        int d = 0; // dreierreihe
        int v = 0; // viererreihe

        for (int row = 0; row < this.f.length; row++) {
            for (int column = 0; column < this.f[row].length; column++) {
                hCount = getHStones(row, column, spieler);
                vCount = getVStones(row, column, spieler);
                dUpCount = getDUpStones(row, column, spieler);
                dDownCount = getDDownStones(row, column, spieler);

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

    int wert(int spieler) {
        int valCurrent = wert1(spieler);

        if (spieler == 1) {
            spieler = 2;
        } else {
            spieler = 1;
        }

        int valOpposite = wert1(spieler);
        return valCurrent - valOpposite;
    }

    int negamax(int spieler, int tiefe) {
        if (tiefe == 0) {
            return wert(spieler);
        }
        int bestValue = Integer.MIN_VALUE;
        int score;
        for (int i = 0; i < this.f[0].length; i++) {
            if (zug(spieler, i) != null) {
                score = -negamax((spieler == 1 ? 2 : 1), tiefe - 1);
                bestValue = Math.max(bestValue, score);
                undoZug(i);
            }
        }
        return bestValue;
    }

    int bester(int spieler, int tiefe) {
        long startTime = System.currentTimeMillis();
        int bestValue = Integer.MIN_VALUE;
        int score;
        int column = -1;
        for (int i = 0; i < this.f[0].length; i++) {
            if (zug(spieler, i) != null) {
                score = -negamax((spieler == 1 ? 2 : 1), tiefe);
                if (score > bestValue) {
                    column = i;
                    bestValue = score;
                }
                undoZug(i);
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
        return column;
    }

    private void undoZug(int column) {
        for (int row = f.length-1; row >= 0; row--) {
            if (this.f[row][column] != 0) {
                this.f[row][column] = 0;
                return;
            }

        }
    }
}

// TODO: Implementieren Sie hier die Klasse "Viergewinnt"
class Viergewinnt {
    public static void spiel() {
        Spielfeld spielfeld = new Spielfeld();
        // initialize scanner
        Scanner scanner = new Scanner(System.in);

        // control flow variable
        boolean input = true;
        int spieler = 1;

        // show spielfeld and show Player x begin message
        spielfeld.spielstand();
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
                    if (spielfeld.zug(spieler, spalte) == null) {
                        System.out.println("Die Spalte ist voll! Wähle eine andere Spalte.");
                    } else {
                        // show spielfeld
                        spielfeld.spielstand();
                        // check if player has won. if so, exit loop
                        if (spielfeld.sieg(spieler)) {
                            System.out.println(spielfeld.wert(spieler));
                            System.out.println("Spieler " + spieler + " hat gewonnen! GZ!");
                            input = false;
                        } else {
                            // else flip player
                            if (spieler == 1) {
                                spieler = 2;
                            } else {
                                spieler = 1;
                            }
                            // show message to continue
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

    public static void spiel1(int tiefe) {
        Spielfeld spielfeld = new Spielfeld();
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

        // show spielfeld and show Player x begin message
        spielfeld.spielstand();

        if (humanUser == 2) {
            System.out.println("KI beginnt und wählt ihren Zug.");
            spielfeld.zug(spieler, spielfeld.bester(humanUser, tiefe));
            spielfeld.spielstand();
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
                    if (spielfeld.zug(spieler, spalte) == null) {
                        System.out.println("Die Spalte ist voll! Wähle eine andere Spalte.");
                    } else {
                        // show spielfeld
                        spielfeld.spielstand();
                        // check if player has won. if so, exit loop
                        if (spielfeld.sieg(spieler)) {
                            System.out.println(spielfeld.wert(spieler));
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
                            spielfeld.zug(spieler, spielfeld.bester((spieler == 1 ? 2 : 1), tiefe));
                            spielfeld.spielstand();
                            if (spielfeld.sieg(spieler)) {
                                System.out.println(spielfeld.wert(spieler));
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
}

public class Aufgabe3 {
    
    public static void main(String[] args) {
        Viergewinnt.spiel1(6);
    }
}

