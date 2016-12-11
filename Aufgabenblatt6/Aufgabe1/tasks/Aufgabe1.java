/*******************************************************************************

 AUFGABENBLATT 6 - Allgemeine Informationen

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
 bis spätestens Montag 12.12.2016 08:00 Uhr in TUWEL hoch. Zusätzlich
 müssen Sie in TUWEL ankreuzen welche Aufgaben Sie gelöst haben und während
 der Übung präsentieren können.

 ******************************************************************************/
/*
    Aufgabe 1) Sortieren & Suchen

    Implementieren Sie in dieser Aufgabe in der gegebenen Klasse Aufgabe1
    folgende statische Methoden:

    - sort:       Diese Methode soll den Sortieralgorihtmus "QuickSort"
                  implementieren. Sie müssen den Sortieralgorithmus selbst
                  ausimplementieren und dürfen keinen entsprechenden Aufruf aus
                  der Java-API verwenden.

    - binSearch:  Dieser Methode wird ein sortiertes Array übergeben.
                  Zusätzlich erhält die Methode einen Wert nach dem gesucht
                  werden soll. Es soll eine binäre Suche implementiert werden,
                  die true zurückliefert falls das Element enthalten ist,
                  ansonsten false.
                  
    Hinweis: Sie dürfen zusätzliche Hilfsmethoden implementieren und verwenden!

    Zusatzfragen:
    1. Welche API-Aufrufe bietet Java für das Sortieren von Arrays an?
    2. Welcher Sortieralgorithmus wird in der Java (1.8) für das Sortieren von
       Arrays verwendet?
    3. Warum ist die Wahl des Pivot-Elements entscheidend für die Performance
       des Quicksort Algorithmus?
    4. Warum muss das Array für die binäre Suche sortiert sein?
    5. Wie geht man vor wenn man in einem absteigend sortierten Array die
       Binärsuche anwenden will?
*/
public class Aufgabe1 {
    
    public static void sort(int[] array) {
        //TODO Implementieren Sie hier die Methode "sort"
        quickSort(array, 0, array.length-1);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int divisor = divide(array, left, right);
            quickSort(array, left, divisor-1);
            quickSort(array, divisor+1, right);
        }
    }

    public static int divide(int[] array, int left, int right) {
        int i = left;
        int j = right-1;
        int pivot = array[right];
        int currValue;
        do {
            while (array[i] <= pivot && i < right) {
                i++;
            }
            while (array[j] >= pivot && j > left) {
                j--;
            }
            if (i <j) {
                currValue = array[i];
                array[i] = array[j];
                array[j] = currValue;
            }
        } while (i < j);
        if (array[i] > pivot) {
            array[right] = array[i];
            array[i] = pivot;
        }
        return i;

    }
    
    
    public static boolean binSearch(int[] array, int elem) {
        //TODO Implementieren Sie hier die Methode "binSearch"
        if (binSearchRec(array, elem, 0, array.length-1) != -1) {
            return true;
        }
        return false;
    }

    public static int binSearchRec(int[] array, int elem, int left, int right) {
        if (right < left) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == elem) {
            return middle;
        } else if (array[middle] < elem) {
            return binSearchRec(array, elem, middle+1, right);
        } else {
            return binSearchRec(array, elem, left, middle-1);
        }
    }
    
    
    public static void main(String[] args) {
    }
}



