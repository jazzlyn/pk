import java.util.Arrays;

public class Aufgabe1 {

    public static void main (String args[]) {
        double[] myArray = createArray(5);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
        System.out.println();
        halveArray(myArray);

    }

    public static double[] createArray(int length){
        // TODO: Implementieren Sie hier die Angabe
        double[] doubleArray = new double[length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = (Math.random() * 100);
        }
        return doubleArray;
    }

    public static void halveArray (double doubleArray[]) {
        for (int i = 0; i < doubleArray.length; i++) {
            System.out.println(doubleArray[i] /= 2);
        }
    }

    public static void printArray(double doubleArray[], int n) {

    }
}
