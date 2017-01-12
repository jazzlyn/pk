

public class Aufgabe3 {

    public static void main (String args[])
    {
        int start = 10;
        int end = 100;
        int count = 0;

        while (start <= end) {
            if (start % 7 == 3) {
                count += 1;
            }
            start++;
        }

        System.out.println(count);
    }

}
