public interface Aircraft {

    String name = null;
    int maxNumbersOfPassengers = 0;
    int weight = 0;
    int length = 0;
    boolean isAllowedToLand = false;

    boolean isAllowedToLand();
}

