class Disco1 {

    String name;
    int capacity;
    int count = 0;

    Disco1(String discoName, int maxPersons) {
        name = discoName;
        capacity = maxPersons;
    }

    boolean enter (String guest) {
        if (count < capacity) {
            count++;
            System.out.println("Hallo " + guest);
            return true;
        }
        System.out.println(guest + " wurde von " + name + " abgewiesen.");
        return false;
    }

    void leave (String guest) {
        if (count >= 1) {
            count--;
            System.out.println("Ciao " + guest);
        }
        if (count == 0) {
            System.out.println("Die Disco ist bereits leer!");
        }
    }



}

public class Aufgabe1 {

    public static void main (String args[]) {
        Disco1 discoOne = new Disco1("Club", 2);
        discoOne.enter("Maria");
        discoOne.enter("Karl");
        discoOne.leave("Karl");
        discoOne.enter("Britta");
        discoOne.enter("Klaus");

        Disco1 discoTwo = new Disco1("Bar", 3);
        discoTwo.enter("Mia");
        discoTwo.enter("Mario");
        discoTwo.enter("Maria");
        discoTwo.leave("Mario");
        discoTwo.leave("Maria");
        discoTwo.leave("Mia");
        discoTwo.leave("Britta");
    }

}
