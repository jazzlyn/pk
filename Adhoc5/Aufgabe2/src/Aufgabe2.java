class Disco2 {

    String name;
    String[] holdOn = new String[50];
    int capacity;
    int count = 0;

    Disco2(String discoName, int maxPersons) {
        name = discoName;
        capacity = maxPersons;
    }

    boolean enter (String guest) {
        if (count < capacity) {
            count++;
            System.out.println("Hallo " + guest);
            return true;
        }
        holdOn(guest);
        System.out.println(guest + " ist in der Warteschlange von " + name);
        return false;
    }


    void holdOn (String guest) {
        for (int i = 0; i < holdOn.length; i++) {
            if (holdOn[i] == null) {
                holdOn[i] = guest;
                break;
            }
        }
    }

    String enterfromHold (String[] holdOn) {
        return holdOn[0];
    }

    void leave (String guest) {
        if (count >= 1) {
            count--;
            System.out.println("Ciao " + guest);
        }
        if (count == 0) {
            System.out.println("Die Disco ist bereits leer!");
        }
        if (count < capacity && holdOn.length != 0 && holdOn[0] != null) {
            String holdOnGuest = enterfromHold(holdOn);
            System.out.println("Hallo " + holdOnGuest + ". Du kannst " + name + " nun betreten.");
        }
    }



}

public class Aufgabe2 {

    public static void main (String args[])
    {
        Disco2 discoOne = new Disco2("Club", 2);
        discoOne.enter("Maria");
        discoOne.enter("Karl");
        discoOne.leave("Karl");
        discoOne.enter("Britta");
        discoOne.enter("Klaus");
        discoOne.leave("Maria");
    }

}
