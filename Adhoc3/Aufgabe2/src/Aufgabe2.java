

public class Aufgabe2 {

    public static void main (String args[])
    {
        System.out.println(calc(25, 5));
    }

    public static int calc(int a, int b) {

        if (a != b) {
            if (a > b) {
                return calc(a - b, b);
            } else {
                return calc(b - a, a);
            }
        }
        return a;
    }
}