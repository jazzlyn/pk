

public class Aufgabe3 {

    public static void main (String args[])
    {
        int dividend = 326243;
        int divisor = 10;

        int quotient = 0;

        while (divisor < dividend) {
            quotient = dividend / divisor;
            System.out.println(quotient);
            divisor = divisor * 2;
        }


    }

}