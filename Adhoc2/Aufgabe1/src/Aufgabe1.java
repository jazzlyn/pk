import java.util.Scanner;

public class Aufgabe1 {

    public static void main (String args[])
    {
        Scanner scanner = new Scanner(System.in);

        int min = 1;
        int max = 99;

        int sum = 0;
        int iteration = 0;          // counts input
        boolean input = true;       // sets input true
        boolean intInput = true;    // sets intInput true, is set to false when the input is not an integer

        int randomNumber = (int) Math.round(Math.random() * (max - min + 1) + min);

        // while input is true and scanner has input
        while (input && scanner.hasNext()) {
            // if scanner has wrong input, systemprintout and next input
            if (!scanner.hasNextInt()) {
                System.out.println("Ungültige Eingabe!");
                scanner.next();
            }
            // check if scanner has int input
            if (scanner.hasNextInt()) {
                // if so, assign to variable num
                int num = scanner.nextInt();

                // check if int is between min and max, if not next input
                if (num > max | num < min) {
                    System.out.println("Ungültige Eingabe!");
                    scanner.next();
                }

                if (num < randomNumber) {
                    System.out.println("Die Zahl ist kleiner als die gesuchte Zahl!");
                } else if (num > randomNumber) {
                    System.out.println("Die Zahl ist größer als die gesuchte Zahl!");
                } else if (num == randomNumber) {
                    System.out.println("Nice one! Again!");
                    input = false;
                }
                // if input is not 0
                /*if (num != 0) {
                    // assign input to sum variable and sum inputs up
                    sum = sum + num;
                    // count iteration +1
                    iteration++;
                } else {
                    // if input is 0, set input boolean false and exit while loop
                    input = false;
                }*/
            } else {
                // set input false
                input = false;
            }
        }
    }

    private static boolean inRangeAndOrdered(int x, int y) {
        boolean isTrue = false;
        if ((x > 1 | x < 20) && x > y) {
            isTrue = true;
        }
        return isTrue;
    }

    private static int wiredLogic(boolean a, boolean b) {
        int number = 0;
        return ((a && b) ? (number = 1) : 0) + ((a || b) ? (number = 0) : 0) + (!(a && b) ? (number = -1) : 0);
        /*if (a && b) {
            number = 1;
        } else if (a || b) {
            number = 0;
        } else if (!(a && b) {
            number = -1;
        }*/
    }

    private static boolean useSwitch(int i) {
        switch(i * i + 1) {
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                return false;
            default:
                return false;
        }
    }
}
