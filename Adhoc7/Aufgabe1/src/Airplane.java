class Airplane implements Aircraft {
    String name;
    int maxNumberOfPassengers = 0;
    int weight = 0;
    int length = (weight*20)+(maxNumberOfPassengers*6);
    boolean isAllowedToLand;

    public Airplane(String name, int maxNumberOfPassengers, int weight) {
        this.name = name;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.weight = weight;
    }

    public boolean isAllowedForMaintenance(int airstrip) {
        if (this.length <= airstrip) {
            return isAllowedToLand = true;
        }
        return isAllowedToLand = false;
    }

    @Override
    public boolean isAllowedToLand() {
        return isAllowedToLand;
    }

    @Override
    public String toString() {
        return "Flugzeug: " + this.name + ", " + this.maxNumberOfPassengers + " Passagiere, Gewicht: " + this.weight + "t, Flugzeuglänge: " + this.length;
    }
}
