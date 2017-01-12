// TODO: Implementieren Sie hier die Klasse Schildkröte.
class Schildkroete implements Meerestier {
    String name;
    int regal = 0;
    int gewicht = 0;

    public Schildkroete (String name, int regal, int gewicht) {
        this.name = name;
        this.regal = regal;
        this.gewicht = gewicht;
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
        this.gewicht = (int)(((float)gewicht/100) * 90);
    }

    @Override
    public String toString() {
        return this.name + ", Regal " + this.regal + ", Gewichtsklasse " + this.gewicht + "kg";
    }
}