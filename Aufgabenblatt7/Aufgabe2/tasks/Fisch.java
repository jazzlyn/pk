// TODO: Implementieren Sie hier die Klasse Fisch.
class Fisch implements Meerestier {
    String name;
    int regal = 0;
    int gewicht = 0;

    public Fisch (String name, int regal, int gewicht) {
        this.name = name;
        this.regal = regal;
        this.gewicht = gewicht;
    }

    @Override
    public void einordnen(int regal) {
        this.regal = regal + 200;
    }

    @Override
    public void ausraeumen() {
        this.regal = 0;
    }

    @Override
    public void abwiegen(int gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        return this.name + ", Regal " + this.regal + ", Gewicht " + this.gewicht + "kg";
    }
}