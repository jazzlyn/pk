

public class Aufgabe1 {

    public static void main (String args[])
    {
        calcMultiTable(3, 9);
    }

    public static void calcMultiTable(int start, int end) {
        start = 3;
        end = 9;
        String whitespace = "   ";

        for (int i = 0; i < (end - start + 1); i++) {
            for (int j = start; j < end+1 ; j++) {
                System.out.print(whitespace + (start + i) * j);

            }
            System.out.println();


        }





    }

}
