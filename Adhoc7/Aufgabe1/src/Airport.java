import java.util.LinkedList;

public class Airport {
    String name = null;
    int runwayLength;

    LinkedList<Aircraft> aircraft = new LinkedList<>();

    public void land(Aircraft a) {
        aircraft.add(a);
    }

    public void landForMaintenance(Aircraft a) {

    }

    public void takeOff(Aircraft a) {

    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < aircraft.size(); i++) {
            s += aircraft.get(i) + "\n";
        }
        return s;
    }
}

