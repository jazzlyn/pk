class Helicopter implements Aircraft {
    String name;
    int maxNumberOfPassengers = 0;
    int weight = 0;
    final int length = 40;
    boolean isAllowedToLand;

    public Helicopter (String name, int maxNumberOfPassengers, int weight) {
        this.name = name;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.weight = weight;
    }

    @Override
    public boolean isAllowedToLand() {
        return this.isAllowedToLand;
    }

    public boolean isAllowedForMaintenance(int airstrip) {
        if (this.length <= airstrip) {
            return isAllowedToLand = true;
        }
        return isAllowedToLand = false;
    }

    @Override
    public String toString() {
        return "Helicopter: " + this.name + ", " + this.maxNumberOfPassengers + " Passagiere, Gewicht: " + this.weight + "t, Helicopterlänge: " + this.length;
    }
}
