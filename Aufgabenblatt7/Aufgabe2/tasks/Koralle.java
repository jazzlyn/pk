// TODO: Implementieren Sie hier die Klasse Koralle.
class Koralle implements Meerestier {
    String name;
    int regal = 0;
    final int gewicht = 1000;

    public Koralle (String name, int regal, int gewicht) {
        this.name = name;
        this.regal = regal;
    }

    @Override
    public void einordnen(int regal) {
        this.regal = regal;
    }

    @Override
    public void ausraeumen() {
        this.regal = 0;
    }

    @Override
    public void abwiegen(int gewicht) {
    }

    @Override
    public String toString() {
        return this.name + ", Regal " + this.regal + ", Gewicht " + this.gewicht + "g";
    }
}