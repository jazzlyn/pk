// programm, um die summe aller zahlen bis 100 auszurechnen

public class Aufgabe4 {

    public static void main(String[] args) {
        int sum = 0;
        int count = 0;

        while (count <= 100) {
            sum += count++;
        }

        System.out.println(sum);
    }

}
