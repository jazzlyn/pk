

public class Aufgabe2 {

    public static void main (String args[])
    {
        int start = 1;
        int m = 100;
        int sum = 0;

        while (start < m) {
            if (start % 11 == 0) {
                sum += start;
                start++;
            } else   {
                start++;
            }
        }

        System.out.println(sum);

    }

}
