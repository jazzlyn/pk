// TODO: Implementieren Sie hier die Klasse Säugetier.
class Saeugetier implements Meerestier {
    String name;
    int regal = 0;
    int gewicht = 0;

    public Saeugetier (String name, int regal, int gewicht) {
        this.name = name;
        this.regal = regal;
        this.gewicht = gewicht;
    }

    @Override
    public void einordnen(int regal) {
        this.regal = regal + 100;
    }

    @Override
    public void ausraeumen() {
    }

    @Override
    public void abwiegen(int gewicht) {
        this.gewicht = gewicht * 1000;
    }

    @Override
    public String toString() {
        return this.name + ", SpezialRegal " + this.regal + ", Gewicht " + this.gewicht + "kg";
    }
}