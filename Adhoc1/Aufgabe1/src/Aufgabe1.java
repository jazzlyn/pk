

public class Aufgabe1 {

    public static void main (String args[]) {
        int chars = 0;
        int rows = 0;
        String h = "H";
        String hLine = "";

        while (rows < 20) {
            while (chars < 20) {
                hLine += h;
                int countMin = 9;
                int countMax = 11;
                while (rows > 1 && rows < 19) {
                    hLine = hLine.substring(0, countMin) + " " + hLine.substring(countMax);
                    countMin--;
                    countMax++;
                }
                chars++;
            }
            rows++;
        }
    }

}
