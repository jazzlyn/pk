import java.util.Scanner;

/*
    Aufgabe 3) Datenrepräsentation -- Vier Gewinnt

    Fortsetzung des "Vier gewinnt" Spiels aus Aufgabenblatt 6.
     
    Auch auf diese Aufgaben werden spätere Aufgabenblätter aufbauen, Sie sollten
    sie daher unbedingt lösen.
    
    Hinweis: Sie können Hilfsmethoden implementieren.
    
    Kopieren Sie die Klassen Spielfeld und Viergewinnt, und ersetzen Sie die
    Repräsentation des Spielfeldes in der Klasse Spielfeld durch folgende:
    Das Spielfeld wird durch zwei longs repräsentiert: Im ersten long sind die
    Bits gesetzt, die den Steinen des ersten Spielers entsprechen, im zweiten
    die, die den Steinen des zweiten Spielers entsprechen. Die Nummerierung der
    Bits im Spielfeld ist wie folgt:
    
    |40 41 42 43 44 45 46|47
    |32 33 34 35 36 37 38|39
    |24 25 26 27 28 29 30|31
    |16 17 18 19 20 21 22|23
    | 8  9 10 11 12 13 14|15
    | 0  1  2  3  4  5  6| 7
    +--------------------+
    
    Wobei die bits 7, 15, 23, 31, 39, 47 keinen Feldern des Spielfelds
    entsprechen und immer auf 0 bleiben müssen.
    
    Durch diese Repräsentation kann die Überprüfung für sieg() und wert1()
    wesentlich schneller durchgeführt werden: Beachten Sie, dass der rechte
    Nachbar eine um 1 höhere Nummer hat, der Nachbar links oben eine um 7 höhere
    Nummer, der Nachbar oben eine um 8 höhere Nummer, und der Nachbar rechts
    oben eine um 9 höhere Nummer.  Wenn wir also z.B.
    
    (x>>(0*9)) & (x>>(1*9)) & (x>>(2*9)) & (x>>(3*9))
    
    berechnen, und im Resultat z.B. an Stelle 3 ein Bit gesetzt ist, heisst das,
    dass in x an Stelle 3, 12, 21, 30 ein Bit gesetzt ist und damit vier in
    einer Diagonale nach rechts oben gesetzt sind. Allgemeiner, wenn irgendein
    Bit im Resultat gesetzt ist (das Resultat also ungleich 0 ist), hat man
    irgendwo vier in einer Diagonale nach rechts oben; die achte, leere Spalte,
    sorgt dafuer, dass horizontal und diagonal keine Reihen jenseits des Randes
    fortgesetzt werden. Durch Verwenden von shifts um n*1, n*7, und n*8
    überprüfen Sie entsprechend auch horizontale Reihen, Reihen nach links oben,
    und Reihen nach oben.
    
    Für wert1() verwendet man entsprechend Ausdrücke auch mit drei und nur zwei
    Termen. Um dann für die Berechnung des Wertes die Anzahl der Reihen
    (also bits) zu zählen, kann man die Methode java.lang.Long.bitCount()
    verwenden.

    Probieren Sie für den Aufruf von spiel1() verschiedene Werte für
    tiefe aus, und wählen Sie einen, bei dem der Computer im
    Normalfall zwischen 0.1s und 1s zur Auswahl des besten Zugs
    braucht.

    Zusatzfragen:

    1) Ist spiel1() bei gleicher Tiefe durch diese Änderung schneller
    oder langsamer geworden? Um wieviel?

    2) Welche Methoden mussten Sie für diese Änderung ändern und
    welche sind gleichgeblieben?  Hätten Sie einige der geänderten
    Methoden anders schreiben können, um die Notwendigkeit von
    Änderungen zu vermeiden?  Gibt es neben den Kosten der Veränderung
    bei manchen Methoden auch Vorteile durch die Änderung?  Welche?
*/
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

    }
}
